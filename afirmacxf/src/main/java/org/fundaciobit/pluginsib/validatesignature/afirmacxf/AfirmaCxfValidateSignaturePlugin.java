package org.fundaciobit.pluginsib.validatesignature.afirmacxf;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.BindingProvider;

import es.gob.afirma.transformers.TransformersFacade;
import freemarker.cache.ClassTemplateLoader;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.fundaciobit.pluginsib.core.v3.utils.CertificateUtils;
import org.fundaciobit.pluginsib.utils.cxf.ClientHandler;
import org.fundaciobit.pluginsib.utils.cxf.ClientHandlerCertificate;
import org.fundaciobit.pluginsib.utils.cxf.ClientHandlerUsernamePassword;
import org.fundaciobit.pluginsib.utils.signature.SignatureCommonUtils;
import org.fundaciobit.pluginsib.validatecertificate.InformacioCertificat;
import org.fundaciobit.pluginsib.validatecertificate.afirmacxf.InfoCertificatUtils;
import org.fundaciobit.pluginsib.validatesignature.afirmacxf.utils.XMLUtil;
import org.fundaciobit.pluginsib.validatesignature.afirmacxf.validarfirmaapi.DSSSignature;
import org.fundaciobit.pluginsib.validatesignature.afirmacxf.validarfirmaapi.DSSSignatureService;
import org.fundaciobit.pluginsib.validatesignature.api.AbstractValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureCheck;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureDetailInfo;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.TimeStampInfo;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.security.PdfPKCS7;

import es.gob.afirma.integraFacade.GenerateMessageResponse;
import es.gob.afirma.integraFacade.pojo.DataInfo;
import es.gob.afirma.integraFacade.pojo.Detail;
import es.gob.afirma.integraFacade.pojo.IndividualSignatureReport;
import es.gob.afirma.integraFacade.pojo.ProcessingDetail;
import es.gob.afirma.integraFacade.pojo.VerifySignatureResponse;
import es.gob.afirma.transformers.TransformersConstants;
import es.gob.afirma.utils.DSSConstants;
import es.gob.afirma.utils.GeneralConstants;
import es.gob.afirma.utils.DSSConstants.DSSTagsRequest;
import es.gob.afirma.utils.DSSConstants.ReportDetailLevel;
import freemarker.template.Configuration;

/**
 * 
 * @author anadal
 * @author areus
 */
public class AfirmaCxfValidateSignaturePlugin extends AbstractValidateSignaturePlugin {

    private static final Map<String, String> localSignProfile2PluginSignProfile = new HashMap<String, String>();
    private static final Map<String, String> localSignType2PluginSignType = new HashMap<String, String>();
    private static final Map<String, String> localAlgorithm2PluginAlgorithm = new HashMap<String, String>();
    private static final Map<String, String> localAlgorithmEnc2PluginAlgorithm = new HashMap<String, String>();
    private static final SignatureRequestedInformation supportedSignatureRequestedInformation = new SignatureRequestedInformation();

    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY;

    static {
        DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
        DOCUMENT_BUILDER_FACTORY.setNamespaceAware(true);

        supportedSignatureRequestedInformation.setReturnCertificateInfo(true);
        supportedSignatureRequestedInformation.setReturnCertificates(true);
        supportedSignatureRequestedInformation.setReturnSignatureTypeFormatProfile(true);
        supportedSignatureRequestedInformation.setReturnTimeStampInfo(true);
        supportedSignatureRequestedInformation.setReturnValidationChecks(true);
        supportedSignatureRequestedInformation.setValidateCertificateRevocation(true);

        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.XADES_V_1_3_2, SIGNTYPE_XAdES); // = "http://uri.etsi.org/01903/v1.3.2#";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.XADES_V_1_2_2, SIGNTYPE_XAdES); // = "http://uri.etsi.org/01903/v1.2.2#";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.XADES_V_1_1_1, SIGNTYPE_XAdES); // = "http://uri.etsi.org/01903/v1.1.1#";

        localSignType2PluginSignType.put("http://uri.etsi.org/01903/v1.4.1#", SIGNTYPE_XAdES); // = "http://uri.etsi.org/01903/v1.4.1#";

        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.CADES, SIGNTYPE_CAdES); // = "http://uri.etsi.org/01733/v1.7.3#";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.CMS, SIGNTYPE_CMS); // = "urn:ietf:rfc:3369";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.CMS_TST, SIGNTYPE_CMS); // = "urn:afirma:dss:1.0:profile:XSS:forms:CMSWithTST";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.ODF, SIGNTYPE_ODF); // = "urn:afirma:dss:1.0:profile:XSS:forms:ODF";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.PDF, SIGNTYPE_PDF); // = "urn:afirma:dss:1.0:profile:XSS:forms:PDF";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.PADES, SIGNTYPE_PAdES); // = "urn:afirma:dss:1.0:profile:XSS:forms:PAdES";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.XML_DSIG, SIGNTYPE_XML_DSIG); // = "urn:ietf:rfc:3275";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.PKCS7, SIGNTYPE_PKCS7); // = "urn:ietf:rfc:2315";
        localSignType2PluginSignType.put(DSSConstants.SignTypesURIs.XML_TST, SIGNTYPE_XML_TST); // = "urn:oasis:names:tc:dss:1.0:core:schema:XMLTimeStampToken";

        //  Attribute that represents identifier for CAdES Baseline.
        // Definit a DSSConstants.SignTypesURIs.CADES_BASELINE_2_2_1,
        localSignType2PluginSignType.put("http://uri.etsi.org/103173/v2.2.1#", SIGNTYPE_CAdES);

        // Attribute that represents identifier for PAdES Baseline.
        // Definit a DSSConstants.SignTypesURIs.PADES_BASELINE_2_1_1,
        localSignType2PluginSignType.put("http://uri.etsi.org/103172/v2.1.1#", SIGNTYPE_PAdES);

        // Attribute that represents identifier for XAdES Baseline.
        // Definit a DSSConstants.SignTypesURIs.XADES_BASELINE_2_1_1,
        localSignType2PluginSignType.put("http://uri.etsi.org/103171/v2.1.1#", SIGNTYPE_XAdES);

        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.BES, SIGNPROFILE_BES); //= "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:BES";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.EPES, SIGNPROFILE_EPES); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:EPES";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.T, SIGNPROFILE_T); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-T";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.C, SIGNPROFILE_C); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-C";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.X, SIGNPROFILE_X); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-X";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.X_1, SIGNPROFILE_X1); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-X-1";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.X_2, SIGNPROFILE_X2); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-X-2";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.X_L, SIGNPROFILE_XL); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-X-L";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.X_L_1, SIGNPROFILE_XL1); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-X-L-1";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.X_L_2, SIGNPROFILE_XL2); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-X-L-2";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.A, SIGNPROFILE_A); // = "urn:oasis:names:tc:dss:1.0:profiles:AdES:forms:ES-A";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.PADES_BASIC, SIGNPROFILE_PADES_BASIC); // = "urn:afirma:dss:1.0:profile:XSS:PAdES:1.2.1:forms:Basico";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.PADES_BES, SIGNPROFILE_BES); // = "urn:afirma:dss:1.0:profile:XSS:PAdES:1.1.2:forms:BES";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.PADES_EPES, SIGNPROFILE_EPES); // = "urn:afirma:dss:1.0:profile:XSS:PAdES:1.1.2:forms:EPES";
        localSignProfile2PluginSignProfile.put(DSSConstants.SignatureForm.PADES_LTV, SIGNPROFILE_PADES_LTV); // = "urn:afirma:dss:1.0:profile:XSS:PAdES:1.1.2:forms:LTV";

        /*
         * TODO Constant DSSConstants.SignatureForm.B_LEVEL
         *  Attribute that represents B_LEVEL identifier form.
         */
        localSignProfile2PluginSignProfile.put("urn:afirma:dss:1.0:profile:XSS:AdES:forms:B-Level", SIGNPROFILE_BES);

        /*
         * TODO Constant DSSConstants.SignatureForm.T_LEVEL
         *  Attribute that represents T_LEVEL identifier form.
         */
        localSignProfile2PluginSignProfile.put("urn:afirma:dss:1.0:profile:XSS:AdES:forms:T-Level", SIGNPROFILE_T);

        /*
         * TODO Constant DSSConstants.SignatureForm.LT_LEVEL
         *  Attribute that represents LT_LEVEL identifier form..
         */
        localSignProfile2PluginSignProfile.put("urn:afirma:dss:1.0:profile:XSS:AdES:forms:LT-Level", SIGNPROFILE_XL);

        /*
         * TODO Constant DSSConstants.SignatureForm.LTA_LEVEL
         *  Attribute that represents LT_LEVEL identifier form.
         */
        localSignProfile2PluginSignProfile.put("urn:afirma:dss:1.0:profile:XSS:AdES:forms:LTA-Level", SIGNPROFILE_A);

        localAlgorithm2PluginAlgorithm.put("http://www.w3.org/2000/09/xmldsig#sha1", SIGN_ALGORITHM_SHA1);
        localAlgorithm2PluginAlgorithm.put("http://www.w3.org/2000/09/xmldsig#sha256", SIGN_ALGORITHM_SHA256);
        localAlgorithm2PluginAlgorithm.put("http://www.w3.org/2000/09/xmldsig#sha384", SIGN_ALGORITHM_SHA384);
        localAlgorithm2PluginAlgorithm.put("http://www.w3.org/2000/09/xmldsig#sha512", SIGN_ALGORITHM_SHA512);

        localAlgorithmEnc2PluginAlgorithm.put("http://www.w3.org/2001/04/xmlenc#sha1", SIGN_ALGORITHM_SHA1);
        localAlgorithmEnc2PluginAlgorithm.put("http://www.w3.org/2001/04/xmlenc#sha256", SIGN_ALGORITHM_SHA256);
        localAlgorithmEnc2PluginAlgorithm.put("http://www.w3.org/2001/04/xmlenc#sha384", SIGN_ALGORITHM_SHA384);
        localAlgorithmEnc2PluginAlgorithm.put("http://www.w3.org/2001/04/xmlenc#sha512", SIGN_ALGORITHM_SHA512);
    }

    private static final String AFIRMACXF_BASE_PROPERTIES = VALIDATE_SIGNATURE_BASE_PROPERTY + "afirmacxf.";

    // TRANSFORMES XML

    private static final String APPLICATIONID_PROPERTY = AFIRMACXF_BASE_PROPERTIES + "applicationID";

    private static final String TRANSFORMERSTEMPLATESPATH_PROPERTY = AFIRMACXF_BASE_PROPERTIES
            + "TransformersTemplatesPath";

    // CRIDADA CXF
    private static final String ENDPOINT = AFIRMACXF_BASE_PROPERTIES + "endpoint";

    // UsernameToken
    private static final String AUTH_UP_USERNAME = AFIRMACXF_BASE_PROPERTIES + "authorization.username";
    private static final String AUTH_UP_PASSWORD = AFIRMACXF_BASE_PROPERTIES + "authorization.password";

    // CERTIFICATE Token
    private static final String AUTH_KS_PATH = AFIRMACXF_BASE_PROPERTIES + "authorization.ks.path";
    private static final String AUTH_KS_TYPE = AFIRMACXF_BASE_PROPERTIES + "authorization.ks.type";
    private static final String AUTH_KS_PASSWORD = AFIRMACXF_BASE_PROPERTIES + "authorization.ks.password";
    private static final String AUTH_KS_ALIAS = AFIRMACXF_BASE_PROPERTIES + "authorization.ks.cert.alias";
    private static final String AUTH_KS_CERT_PASSWORD = AFIRMACXF_BASE_PROPERTIES + "authorization.ks.cert.password";

    private static final String PRINT_XML = AFIRMACXF_BASE_PROPERTIES + "printxml";

    private static final String CONNECT_TIMEOUT = AFIRMACXF_BASE_PROPERTIES + "connectTimeout";

    private static final String READ_TIMEOUT = AFIRMACXF_BASE_PROPERTIES + "readTimeout";

    private static final ThreadLocal<SimpleDateFormat> dateFormatTimeStamp = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Locale("es"));
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return dateFormat;
        }
    };

    private static final Pattern TIMESTAMP_PATTERN = Pattern
            .compile("<vr:Properties>.+<vr:CreationTime>(.+?)</vr:CreationTime>"
                    + ".*</vr:TimeStampContent><vr:MessageHashAlg Type=\"urn:afirma:dss:1.0:profile:XSS:detail:MessageHashAlg\"><dss:Code>(.+?)</dss:Code></vr:MessageHashAlg>"
                    + ".+<vr:CertificateValidity><vr:CertificateIdentifier><ds:X509IssuerName>(.+?)</ds:X509IssuerName>"
                    + ".+<vr:Subject>(.+?)</vr:Subject>"
                    + ".+<vr:CertificateValue><!\\[CDATA\\[(.+?)\\]\\]></vr:CertificateValue>" + ".+</vr:Properties>");

    private static final Pattern algorithmDigestPattern = Pattern
            .compile("<vr:DigestAlgAndValue><ds:DigestMethod Algorithm=\"(.+?)\"></ds:DigestMethod>"
                    + "<ds:DigestValue><!\\[CDATA\\[(.+?)\\]\\]></ds:DigestValue>" + "</vr:DigestAlgAndValue>");

    public AfirmaCxfValidateSignaturePlugin() {
        super();
        init();
    }

    public AfirmaCxfValidateSignaturePlugin(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
        init();
    }

    public AfirmaCxfValidateSignaturePlugin(String propertyKeyBase) {
        super(propertyKeyBase);
        init();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    // Camps reutilitzables
    private Configuration configuration;
    private TransformersFacade transformersFacade;
    private DSSSignature api;

    /* inicialitzacions */
    private void init() {
        initConfiguration();
        initTransformersFacade();
        initApi();
    }

    private void initConfiguration() {
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/template_afirma_validation"));
    }

    private void initTransformersFacade() {
        try {
            System.setProperty("integra.config", getPropertyRequired(TRANSFORMERSTEMPLATESPATH_PROPERTY));

            transformersFacade = TransformersFacade.getInstance();

            Properties transfProp = (Properties) FieldUtils.readField(transformersFacade, "transformersProperties",
                    true);
            transfProp.put("TransformersTemplatesPath", getPropertyRequired(TRANSFORMERSTEMPLATESPATH_PROPERTY));

        } catch (Exception e) {
            throw new RuntimeException("Error inicialitzant TransformersFacade", e);
        }
    }

    private void initApi() {
        try {
            URL wsdlUrl = getClass().getResource("/wsdl/DSSAfirmaVerify.wsdl");
            DSSSignatureService service = new DSSSignatureService(wsdlUrl);

            api = service.getDSSAfirmaVerify();

            Map<String, Object> reqContext = ((BindingProvider) api).getRequestContext();
            reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, getEndpoint());

            getClientHandler().addSecureHeader(api);

            // Fixar timeout
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setConnectionTimeout(getConnectTimeout());
            httpClientPolicy.setReceiveTimeout(getReadTimeout());
            httpClientPolicy.setAllowChunking(false);

            Client client = ClientProxy.getClient(api);
            ((HTTPConduit) client.getConduit()).setClient(httpClientPolicy);

        } catch (Exception e) {
            throw new RuntimeException("Error inicialitzant API WS", e);
        }
    }

    private ClientHandler getClientHandler() throws Exception {
        final ClientHandler clientHandler;

        String username = getProperty(AUTH_UP_USERNAME);
        if (username != null && username.trim().length() != 0) {
            String password = getProperty(AUTH_UP_PASSWORD);
            clientHandler = new ClientHandlerUsernamePassword(username, password);
        } else {
            String keystoreLocation = getPropertyRequired(AUTH_KS_PATH);
            String keystoreType = getPropertyRequired(AUTH_KS_TYPE);
            String keystorePassword = getPropertyRequired(AUTH_KS_PASSWORD);
            String keystoreCertAlias = getPropertyRequired(AUTH_KS_ALIAS);
            String keystoreCertPassword = getPropertyRequired(AUTH_KS_CERT_PASSWORD);

            clientHandler = new ClientHandlerCertificate(keystoreLocation, keystoreType, keystorePassword,
                    keystoreCertAlias, keystoreCertPassword);
        }
        return clientHandler;
    }

    private String getEndpoint() throws Exception {
        return getPropertyRequired(ENDPOINT);
    }

    private long getConnectTimeout() {
        String connectTimeoutProperty = getProperty(CONNECT_TIMEOUT, "20000");
        return Long.parseLong(connectTimeoutProperty);

    }

    private long getReadTimeout() {
        String readTimeoutProperty = getProperty(READ_TIMEOUT, "20000");
        return Long.parseLong(readTimeoutProperty);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    private TimeStampInfo[] parseTimeStamp(String xml) {

        List<TimeStampInfo> list = new ArrayList<TimeStampInfo>();
        SimpleDateFormat dateFormat = dateFormatTimeStamp.get();

        Matcher m = TIMESTAMP_PATTERN.matcher(xml);
        while (m.find()) {

            TimeStampInfo tsi = new TimeStampInfo();
            try {
                tsi.setCreationTime(dateFormat.parse(m.group(1)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tsi.setAlgorithm(localAlgorithmEnc2PluginAlgorithm.get(m.group(2)));

            tsi.setCertificateIssuer(m.group(3));
            tsi.setCertificateSubject(m.group(4));

            String certB64 = m.group(5);
            if (certB64 != null && certB64.trim().length() != 0) {
                byte[] cert = Base64.getDecoder().decode(certB64);
                tsi.setCertificate(cert);
            }

            list.add(tsi);
        }

        if (list.size() == 0) {
            return null;
        }

        return list.toArray(new TimeStampInfo[0]);
    }

    private String[][] parseAlgorithDigest(String xml) {

        List<String> entriesAlg = new ArrayList<String>();
        List<String> entriesDig = new ArrayList<String>();

        Matcher m = algorithmDigestPattern.matcher(xml);
        while (m.find()) {
            entriesAlg.add(m.group(1));
            entriesDig.add(m.group(2));
        }

        if (entriesAlg.size() == 0) {
            return null;
        }

        String[] entriesAlgStr = entriesAlg.toArray(new String[0]);
        String[] entriesDigStr = entriesDig.toArray(new String[0]);

        return new String[][] { entriesAlgStr, entriesDigStr };
    }

    private String[][] parseXmlByIndexOfAndByGroup(String xml, String separator, String pre, String post) {

        String[] parts = xml.split(Pattern.quote(separator));

        List<String[]> certs = new ArrayList<String[]>();

        // hem de començar per 1, perquè el primer tros és el principi del document
        for (int i = 1, partsLength = parts.length; i < partsLength; i++) {
            String[] values = parseXmlByIndexOf(parts[i], pre, post);
            certs.add(values);
        }

        String[][] entriesStr;
        if (certs.size() == 0) {
            entriesStr = null;
        } else {
            entriesStr = certs.toArray(new String[certs.size()][]);
        }
        return entriesStr;
    }

    private String[] parseXmlByIndexOf(String xml, String pre, String post) {

        int fromIndex = 0;

        List<String> entries = new ArrayList<String>();
        while (true) {

            int preIndex = xml.indexOf(pre, fromIndex);
            int postIndex = xml.indexOf(post, fromIndex);

            if (preIndex == -1 || postIndex == -1) {
                break;
            }

            String value = xml.substring(preIndex + pre.length(), postIndex);

            entries.add(value);

            fromIndex = postIndex + post.length();
        }

        String[] entriesStr;
        if (entries.size() == 0) {
            entriesStr = null;
        } else {
            entriesStr = entries.toArray(new String[0]);
        }
        return entriesStr;
    }

    protected boolean isDebug() {
        return "true".equals(getProperty(AFIRMACXF_BASE_PROPERTIES + "debug"));
    }

    @Override
    public SignatureRequestedInformation getSupportedSignatureRequestedInformation() {
        return supportedSignatureRequestedInformation;
    }

    @Override
    public SignatureRequestedInformation getSupportedSignatureRequestedInformationBySignatureType(String signType) {
        return supportedSignatureRequestedInformation;
    }

    @Override
    public ValidateSignatureResponse validateSignature(ValidateSignatureRequest validationRequest) throws Exception {

        SignatureRequestedInformation sri = validationRequest.getSignatureRequestedInformation();

        if (sri == null) {
            sri = new SignatureRequestedInformation();
        }

        final boolean debug = isDebug();

        final String applicationID = getPropertyRequired(APPLICATIONID_PROPERTY);

        if (debug) {
            log.debug("applicationID = " + applicationID);
        }

        // Instanciamos un mapa con los paràmetros de entrada
        Map<String, Object> inParams = new HashMap<String, Object>();

        // OK
        // VerifySignatureRequest verSigReq = new VerifySignatureRequest();
        inParams.put(DSSTagsRequest.CLAIMED_IDENTITY, applicationID);

        // OK VerificationReport verRep = new VerificationReport();
        // OK verSigReq.setVerificationReport(verRep);
        // OK verSigReq.getVerificationReport().getIncludeCertificateValues()
        // Indicamos que queremos incluir la cadena de certificaci�n en la
        // respuesta
        // == Retorna els certificats de cada firma (requereix REPORT_DETAIL_LEVEL =
        // ALL_DETAILS)
        if (Boolean.TRUE.equals(sri.getReturnCertificates())) {
            inParams.put(DSSTagsRequest.INCLUDE_CERTIFICATE, Boolean.TRUE.toString());
        }

        // OK verSigReq.getVerificationReport().getIncludeRevocationValues(
        // Indicamos que queremos incluir informaci�n del estado de
        // revocaci�n de la cadena de certificaci�n en la respuesta
        // == NO FA RES
        // inParams.put(DSSTagsRequest.INCLUDE_REVOCATION,
        // Boolean.FALSE.toString());

        // OK verSigReq.getVerificationReport().getReportDetailLevel()
        // Indicamos que el nivel de detalle de la respuesta debe ser el
        // máximo
        // == ALL_DETAILS mostra més coses en l'XML però no en el Facades Pojos
        if (Boolean.TRUE.equals(sri.getReturnCertificates()) || Boolean.TRUE.equals(sri.getReturnTimeStampInfo())) {
            inParams.put(DSSTagsRequest.REPORT_DETAIL_LEVEL, ReportDetailLevel.ALL_DETAILS); // ALL_DETAILS);
        } else {
            inParams.put(DSSTagsRequest.REPORT_DETAIL_LEVEL, ReportDetailLevel.NO_DETAILS); // ALL_DETAILS);
        }

        // OK verSigReq.getVerificationReport().setCheckCertificateStatus(true);
        // Indicamos que queremos validar el estado de revocaci�n del
        // certificado
        // == Vull suposar que ho fa.
        if (Boolean.TRUE.equals(sri.getValidateCertificateRevocation())) {
            inParams.put(DSSTagsRequest.CHECK_CERTIFICATE_STATUS, "true");
        }

        /*
         * OK OptionalParameters optParam = new OptionalParameters();
         * verSigReq.setOptionalParameters(optParam);
         * optParam.setAdditionalReportOption(true);
         */
        // Indicamos que deseamos obtener en la respuesta informaci�n de los
        // sellos de tiempo contenidos
        // == retorna informacio del Segell de temp dins TimeStampInfo de DetailInfo
        if (Boolean.TRUE.equals(sri.getReturnTimeStampInfo())) {
            inParams.put(DSSTagsRequest.ADDICIONAL_REPORT_OPT_SIGNATURE_TIMESTAMP,
                    "urn:afirma:dss:1.0:profile:XSS:SignatureProperty:SignatureTimeStamp");
        }

        // OK optParam.setReturnProcessingDetails(true);
        // Indicamos que queremos devolver información acerca de los
        // procesos de validación llevados a cabo
        // == Retorna CODE/MESS/TYPE que es informacio especifica de les validacions
        // que s'han passat i quines són vàlides i quines invalides
        if (Boolean.TRUE.equals(sri.getReturnValidationChecks())) {
            inParams.put(DSSTagsRequest.RETURN_PROCESSING_DETAILS, "");
        }

        // OK optParam.setReturnReadableCertificateInfo(true);
        // Indicamos que queremos verificar el estado de cada uno de los
        // certificados de la cadena de certificación
        // == Controlat
        if (Boolean.TRUE.equals(sri.getReturnCertificateInfo())) {
            inParams.put(DSSTagsRequest.RETURN_READABLE_CERT_INFO, "");
        }

        // OK optParam.setReturnSignedDataInfo(true);
        // Indicamos que queremos obtener informaci�n sobre los datos firmados
        // == Això només retorna informació de DigestValue per cada firma
        // inParams.put(DSSTagsRequest.RETURN_SIGNED_DATA_INFO, "true");

        // OK verSigReq.setSignature(padesLtvSignature);
        // Indicamos la firma a validar
        // NOTA XYZ ZZZ Si es XML revisar mètode incorporateSignatureImplicit
        final byte[] signData = validationRequest.getSignatureData();
        if (signData == null) {
            // 
            throw new Exception("El valor de la signatura és null.");
        }

        int xadesFormat;
        boolean isXAdES = XMLUtil.isXml(signData);
        log.debug("\n\n ES XADES ?? " + isXAdES + " \n\n");
        if (isXAdES) {
            boolean inputParams = true;
            xadesFormat = SignatureCommonUtils.getXAdESMode(signData, inputParams);
            log.debug("  xadesFormat => " + xadesFormat);

            incorporateXMLSignature(inParams, signData, xadesFormat);

        } else {
            inParams.put(DSSTagsRequest.SIGNATURE_BASE64, Base64.getEncoder().encodeToString(signData));
        }

        // Ok verSigReq.setDocument(txtSignedFile);
        // Indicamos los datos firmados, codificados en Base64
        // ES XML => inParams.put(DSSTagsRequest.BASE64XML, new
        // String(Base64.encode(docXML)));
        // NO ES XML => inParams.put(DSSTagsRequest.BASE64DATA, new
        // String(Base64.encode(docNoXML)));
        final byte[] docData = validationRequest.getSignedDocumentData();
        if (docData != null) {
            // GenerateMessageRequest.generateVerifySignRequest(verSigReq);

            String encodedDoc = Base64.getMimeEncoder(76, new byte[] { '\n' }).encodeToString(docData);

            if (XMLUtil.isXml(docData)) {

                //dss_InputDocuments_dss_Document_dss_Base64XML
                inParams.put(DSSTagsRequest.BASE64XML, encodedDoc);
                // "dss:InputDocuments/dss:Document@ID";
                inParams.put(DSSTagsRequest.DOCUMENT_ATR_ID, System.nanoTime() + " " + System.currentTimeMillis());
            } else {
                //dss_InputDocuments_dss_Document_dss_Base64Data
                inParams.put(DSSTagsRequest.BASE64DATA, encodedDoc);
            }

        }

        if (debug) {
            log.debug(" ========== IN PARAMS =========== ");

            for (String b : inParams.keySet()) {
                String str = (String) inParams.get(b);
                if (str.length() > 80) {
                    log.debug(b + " => " + str.substring(1, 80));
                } else {
                    log.debug(b + " => " + str);
                }
            }
            log.debug(" ================================= ");
        }

        // Construimos el XML que constituye la petici�n
        String xmlInput;

        if (!isXAdES) {
            try {
                xmlInput = transformersFacade.generateXml(inParams, GeneralConstants.DSS_AFIRMA_VERIFY_REQUEST,
                        GeneralConstants.DSS_AFIRMA_VERIFY_METHOD, TransformersConstants.VERSION_10);
            } catch (es.gob.afirma.transformers.TransformersException e) {
                init();
                xmlInput = transformersFacade.generateXml(inParams, GeneralConstants.DSS_AFIRMA_VERIFY_REQUEST,
                        GeneralConstants.DSS_AFIRMA_VERIFY_METHOD, TransformersConstants.VERSION_10);
            }

        } else {
            // Generar XML XADES MANUALMENT
            /* EN JBOSS Es produeix un error al crear l'XML en XADES des de INTEGRA, 
             * per la qual cosa, es que es fa es generar el XMl manualment a partir 
             * d'una plantilla FreeMarker:
             * 
             * org.apache.cxf.binding.soap.SoapFault: java.lang.Exception: Error en los parßmetros de entrada.
             * 
             */
            if (log.isDebugEnabled()) {
                log.debug("Generant XML INput Manualment per XAdES.");
            }

            Map<String, Object> keys = new HashMap<String, Object>();

            for (String key : inParams.keySet()) {

                String value = (String) inParams.get(key);

                if (key.equals("dss:SignatureObject")) {

                    final String xmlUtf = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

                    if (value.trim().startsWith(xmlUtf)) {
                        value = "\t" + value.trim().substring(xmlUtf.length());
                    }

                    if (value.startsWith("\r") || value.startsWith("\n")) {
                        value = value.substring(1);
                    }

                    if (value.startsWith("\r") || value.startsWith("\n")) {
                        value = value.substring(1);
                    }

                }

                keys.put(key.replace(":", "_").replace("/", "_").replace("@", "_"), value);
            }

            keys.put("validationRequest", validationRequest);

            xmlInput = processExpressionLanguage("xades_input_template.xml", keys);
        }

        if (Boolean.TRUE.equals(sri.getReturnTimeStampInfo())) {

            String search = "<afxp:IncludeProperty Type=\"urn:afirma:dss:1.0:profile:XSS:SignatureProperty:SignatureTimeStamp\"/>";

            String add = "\n\t\t\t\t"
                    + "<afxp:IncludeProperty Type=\"urn:afirma:dss:1.0:profile:XSS:SignatureProperty:ArchiveTimeStamp\"/>";

            if (xmlInput.indexOf(search) != -1) {
                xmlInput = xmlInput.replace(search, search + add);
            }
        }

        final boolean printXML = "true".equals(getProperty(PRINT_XML));

        if (printXML) {
            log.debug("IN_XML = \n" + xmlInput);
        }

        // Invocamos el servicio y obtenemos un XML de respuesta
        String xmlOutput = cridadaWs(xmlInput);

        if (printXML) {
            log.debug("OUT_XML = \n" + xmlOutput);
        }

        // Parseamos la respuesta en un mapa
        Map<String, Object> propertiesResult = transformersFacade.parseResponse(xmlOutput,
                GeneralConstants.DSS_AFIRMA_VERIFY_REQUEST, GeneralConstants.DSS_AFIRMA_VERIFY_METHOD,
                TransformersConstants.VERSION_10);

        if (debug) {
            log.debug(" ================================= ");

            for (String b : propertiesResult.keySet()) {
                String str = propertiesResult.get(b).toString();
                if (str.length() > 80) {
                    log.debug(b + " => " + str.substring(1, 80));
                } else {
                    log.debug(b + " => " + str);
                }
            }
            log.debug(" ================================= ");
        }

        VerifySignatureResponse verSigRes = new VerifySignatureResponse();

        if (propertiesResult != null) {
            GenerateMessageResponse.generateVerifySignatureResponse(propertiesResult, verSigRes);
        }

        if (debug) {
            log.debug(verifySignatureResponse2String(verSigRes));
        }

        // ************* FINAL PRINT ********************

        // SignatureFormatEnum sfe = new SignatureFormatEnum(type, form);

        ValidateSignatureResponse signatureInfo = new ValidateSignatureResponse();

        if (verSigRes.getResult() == null) {
            signatureInfo.getValidationStatus().setErrorMsg("No ha retornat informació de l'estat de la firma");
            return signatureInfo;
        }

        String major = verSigRes.getResult().getResultMajor();

        ValidationStatus status = signatureInfo.getValidationStatus();

        if (DSSConstants.ResultProcessIds.VALID_SIGNATURE.equals(major)) {
            status.setStatus(ValidationStatus.SIGNATURE_VALID);
            status.setErrorMsg(null);
        } else {

            String msg = verSigRes.getResult().getResultMessage();

            if (msg == null) {
                // XYZ ZZZ Traduir
                msg = "Informació de l'error no disponible";
            }

            // Error de Comunicacio o de Servidor
            if (DSSConstants.ResultProcessIds.REQUESTER_ERROR.equals(major)
                    || DSSConstants.ResultProcessIds.RESPONDER_ERROR.equals(major)) {

                log.error("IN_XML = \n" + xmlInput);

                log.error("OUT_XML = \n" + xmlOutput);

                log.error("VerifySignatureResponse = \n" + verifySignatureResponse2String(verSigRes));

                throw new Exception(msg + "(" + major + ")");
            }

            if (DSSConstants.ResultProcessIds.INVALID_SIGNATURE.equals(major)) {

                status.setStatus(ValidationStatus.SIGNATURE_INVALID);

                String minor = verSigRes.getResult().getResultMinor();

                if (minor != null) {
                    msg = msg + " (" + minor + ")";
                }
            } else {
                status.setStatus(ValidationStatus.SIGNATURE_ERROR);

                String minor = verSigRes.getResult().getResultMinor();

                if (minor == null) {
                    msg = msg + " (" + major + ")";
                } else {
                    msg = msg + " (" + major + " | " + minor + ")";
                }

            }

            status.setErrorMsg(msg);

        }

        {
            String[][] values = parseAlgorithDigest(xmlOutput);

            if (values != null) {
                initArray(signatureInfo, values[0].length);
                SignatureDetailInfo[] detailInfo = signatureInfo.getSignatureDetailInfo();

                for (int j = 0; j < detailInfo.length; j++) {
                    detailInfo[j].setAlgorithm(localAlgorithm2PluginAlgorithm.get(values[0][j]));
                    detailInfo[j].setDigestValue(values[1][j]);
                }

            }

        }
        // Certificate
        extractCertificateChain(xmlOutput, signatureInfo);

        // Informació TimeStamp
        TimeStampInfo[] allTSI = parseTimeStamp(xmlOutput);
        if (allTSI != null) {
            SignatureDetailInfo[] detailInfo = signatureInfo.getSignatureDetailInfo();

            for (int j = 0; j < allTSI.length; j++) {
                // XYZ Pot ser no tengui informacio de Segell de temps alguna firma i
                // l'array ja no correspon
                detailInfo[j].setTimeStampInfo(allTSI[j]);
            }
        }

        // DSSConstants.ResultProcessIds.INVALID_SIGNATURE
        // DSSConstants.ResultProcessIds.REQUESTER_ERROR
        // DSSConstants.ResultProcessIds.RESPONDER_ERROR

        String type = (String) propertiesResult.get("dss:OptionalOutputs/dss:SignatureType"); // =>
                                                                                              // urn:afirma:dss:1.0:profile:XSS:forms:PAdES
        String profile = (String) propertiesResult.get("dss:OptionalOutputs/ades:SignatureForm"); // =>
                                                                                                  // urn:afirma:dss:1.0:profile:XSS:PAdES:1.2.1:forms:Basico
        String pluginSignType = null;
        if (type != null) {
            pluginSignType = localSignType2PluginSignType.get(type);
            signatureInfo.setSignType(pluginSignType);

            if (pluginSignType != null) {
                // Cercarem el format: implicit(attached), explicit (detached)
                int signFormat = SignatureCommonUtils.getSignMode(pluginSignType, signData);
                signatureInfo.setSignMode(signFormat);
            }
        }

        if (profile != null) {

            String profilePlugin = localSignProfile2PluginSignProfile.get(profile);

            if ((SIGNTYPE_PAdES.equals(pluginSignType) || SIGNTYPE_CAdES.equals(pluginSignType))) {

                List<IndividualSignatureReport> reports = verSigRes.getVerificationReport();
                if (reports != null && reports.size() != 0) {
                    // Get last Signature 
                    IndividualSignatureReport report = reports.get(reports.size() - 1);
                    if (SIGNPROFILE_BES.equals(profilePlugin) && report.getSignaturePolicyIdentifier() != null) {
                        profilePlugin = SIGNPROFILE_EPES;
                    }
                }

                if (SIGNTYPE_PAdES.equals(pluginSignType)) {

                    if (SIGNPROFILE_EPES.equals(profilePlugin) || SIGNPROFILE_BES.equals(profilePlugin)) {
                        if (containsTimeStamp(signData)) {
                            profilePlugin = SIGNPROFILE_T;
                        }
                    } else if (SIGNPROFILE_XL.equals(profilePlugin)) {
                        profilePlugin = SIGNPROFILE_PADES_LTV;
                    }
                }

            }
            signatureInfo.setSignProfile(profilePlugin);
        }

        List<IndividualSignatureReport> reports = verSigRes.getVerificationReport();
        initArray(signatureInfo, reports.size());
        int c = 0;
        for (IndividualSignatureReport report : reports) {

            SignatureDetailInfo di = signatureInfo.getSignatureDetailInfo()[c++];

            // Politica EPES
            di.setPolicyIdentifier(report.getSignaturePolicyIdentifier());

            // Detalls de Checks de Validacio
            ProcessingDetail pd = report.getProcessingDetails();
            if (pd != null) {
                di.setValidChecks(convertDetail(pd.getListValidDetail()));
                di.setInvalidChecks(convertDetail(pd.getListInvalidDetail()));
                di.setIndeterminateChecks(convertDetail(pd.getListIndeterminateDetail()));
            }

            // Info de Certificat
            Map<String, Object> certificateInfo = report.getReadableCertificateInfo();
            if (certificateInfo != null && certificateInfo.size() != 0) {
                InformacioCertificat ic = InfoCertificatUtils.processInfoCertificate(certificateInfo);
                di.setCertificateInfo(ic);

                //di.setSignDate(null)
            }
        }

        // TODO Extreure data de signatura en PDFs

        if (SIGNTYPE_PAdES.equals(signatureInfo.getSignType())) {
            Map<String, Calendar> datesByCN = getSignDateOfPdf(validationRequest.getSignatureData());
            if (datesByCN != null) {
                for (SignatureDetailInfo di : signatureInfo.getSignatureDetailInfo()) {
                    if (di.getSignDate() == null) {
                        String subject = di.getCertificateInfo().getSubject();
                        if (subject != null) {
                            String cn = CertificateUtils.getCN(subject);
                            Calendar cal = datesByCN.get(cn);
                            if (cal != null) {
                                di.setSignDate(cal.getTime());
                            }
                        }
                    }
                }
            }
        }

        return signatureInfo;

    }

    /*
    public static void main(String[] args) {
        //File file = new File("./datafirma/testSignPdf_result_testSignPdf_1753255937861.pdf");

        File file = new File("./personal/holacaracola_signed_1.pdf");


        try {

            Map<String, Calendar> calendar = getSignDateOfPdf(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    protected static Map<String, Calendar> getSignDateOfPdf(File file) throws Exception {

        RandomAccessRead rar = new RandomAccessReadBufferedFile(file);

        return getSignDateOfPdf(rar);
    }

    protected static Map<String, Calendar> getSignDateOfPdf(byte[] file) throws Exception {

        RandomAccessRead rar = new RandomAccessReadBuffer(file);

        return getSignDateOfPdf(rar);
    }

    protected static Map<String, Calendar> getSignDateOfPdf(RandomAccessRead rar) throws Exception {

        PDFParser parser = new PDFParser(rar);

        PDDocument document = parser.parse();

        Map<String, Calendar> cal = new HashMap<String, Calendar>();

        List<PDSignature> signatureDictionaries = document.getSignatureDictionaries();
        if (signatureDictionaries.isEmpty()) {
            return cal;
        }

        for (PDSignature signature : signatureDictionaries) {
/*
            System.out.println(" -----------------------------------");
            System.out.println(" CN:" + signature.getName());

            System.out.println(" CI:" + signature.getContactInfo());

            System.out.println(" SU:" + signature.getSubFilter());
            System.out.println(" FI:" + signature.getFilter());

            System.out.println(" PB:" + signature.getPropBuild());
*/
            Calendar signDate = signature.getSignDate();
            if (signDate != null) {
                //System.out.println("     - Fecha de firma: " + signDate.getTime());
                cal.put(signature.getName(), signDate);
            } /*else {
                System.out.println("      - No se pudo obtener la fecha de firma.");
            } */
/*
            byte[] contents = signature.getContents();
            if (contents == null || contents.length == 0) {
                System.out.println("Firma vacía.");
                continue;
            }

            CMSSignedData cms = new CMSSignedData(contents);
            SignerInformationStore signers = cms.getSignerInfos();
            Collection<SignerInformation> signerInfos = signers.getSigners();

            // Obtener el certificado (solo el primero en este ejemplo)
            Collection<X509CertificateHolder> certHolders = cms.getCertificates().getMatches(null);
            JcaX509CertificateConverter certConverter = new JcaX509CertificateConverter();

            for (SignerInformation signer : signerInfos) {

                for (X509CertificateHolder certHolder : certHolders) {
                    if (signer.getSID().match(certHolder)) {
                        X509Certificate cert = certConverter.getCertificate(certHolder);
                        System.out.println("Certificado:");

                        System.out.println("  CN: " + CertificateUtils.getCN(cert));

                        System.out.println("  Sujeto: " + cert.getSubjectDN());
                        System.out.println("  Emisor: " + cert.getIssuerDN());
                        System.out.println("  Válido desde: " + cert.getNotBefore());
                        System.out.println("  Válido hasta: " + cert.getNotAfter());
                        break;
                    }
                }
            }
*/
        }

        return cal;
    }

    protected void extractCertificateChain(String xmlOutput, ValidateSignatureResponse signatureInfo) {
        // TODO Es pega amb la informació de Segell de Temps ???
        final String splitBy = "<vr:IndividualSignatureReport>"; // <vr:CertificatePathValidity>";

        final String preA = "<vr:CertificateValue><![CDATA[";
        final String postA = "]]></vr:CertificateValue>";

        String[][] certificatesB64 = parseXmlByIndexOfAndByGroup(xmlOutput, splitBy, preA, postA);

        if (certificatesB64 != null) {

            initArray(signatureInfo, certificatesB64.length);
            SignatureDetailInfo[] detailInfo = signatureInfo.getSignatureDetailInfo();

            for (int j = 0; j < detailInfo.length; j++) {
                String[] certificatesBySign = certificatesB64[j];
                if (certificatesBySign != null) {
                    byte[][] chain = new byte[certificatesBySign.length][];
                    for (int i = 0; i < chain.length; i++) {
                        chain[i] = Base64.getDecoder().decode(certificatesBySign[i]);
                    }

                    detailInfo[j].setCertificateChain(chain);
                }
            }

        }
    }

    protected boolean containsTimeStamp(byte[] signature) {
        try {
            PdfReader reader = new PdfReader(signature);

            AcroFields fields = reader.getAcroFields();
            List<String> names = fields.getSignatureNames();

            String signatureName = names.get(names.size() - 1);

            System.out.println("\n\nSignature Name: " + signatureName + "\n\n");

            PdfPKCS7 pkcs7 = fields.verifySignature(signatureName);

            if (pkcs7.getTimeStampDate() != null && pkcs7.getTimeStampToken() != null) {
                return true;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    protected static String verifySignatureResponse2String(VerifySignatureResponse verSigRes) {

        StringBuilder str = new StringBuilder();

        str.append('\n').append("RESULT MAJOR= " + verSigRes.getResult().getResultMajor());
        str.append('\n').append("RESULT MINOR= " + verSigRes.getResult().getResultMinor());
        str.append('\n').append("RESULT MESSAGE= " + verSigRes.getResult().getResultMessage());

        str.append('\n').append("FORMAT = " + verSigRes.getSignatureFormat());

        List<IndividualSignatureReport> reports = verSigRes.getVerificationReport();
        int r = 0;
        for (IndividualSignatureReport report : reports) {
            str.append('\n').append(" ---- REPORT SIGNATURE[" + r++ + "] ---- ");

            if (report.getDetailedReport() != null) {
                str.append('\n').append("  report.getDetailedReport(): " + report.getDetailedReport());
            }

            ProcessingDetail pd = report.getProcessingDetails();
            if (pd != null) {
                str.append('\n').append(printDetail(pd.getListInvalidDetail(), "INVALIT"));
                str.append('\n').append(printDetail(pd.getListIndeterminateDetail(), "INDETERMINATE"));
                str.append('\n').append(printDetail(pd.getListValidDetail(), "VALIT"));
            }

            Map<String, Object> certificateInfo = report.getReadableCertificateInfo();
            if (certificateInfo != null && certificateInfo.size() != 0) {

                for (String k : certificateInfo.keySet()) {
                    str.append('\n').append("  InfoCert[" + k + "] = " + certificateInfo.get(k));
                }
            }

            str.append('\n')
                    .append("  SIGN report.getResult().getResultMajor(): " + report.getResult().getResultMajor());
            str.append('\n')
                    .append("  SIGN report.getResult().getResultMinor(): " + report.getResult().getResultMinor());
            str.append('\n')
                    .append("  SIGN report.getResult().getResultMessage(): " + report.getResult().getResultMessage());

            str.append('\n')
                    .append("  SIGN report.getSignaturePolicyIdentifier(): " + report.getSignaturePolicyIdentifier());

            if (report.getSigPolicyDocument() != null) {
                str.append('\n').append(
                        "  SING report.getSigPolicyDocument()" + Arrays.toString(report.getSigPolicyDocument()));
            }

        }

        List<DataInfo> dataList = verSigRes.getSignedDataInfo();
        int n = 0;
        for (DataInfo dataInfo : dataList) {
            str.append('\n').append(" ---- SIGN[" + n++ + "] ---- ");

            if (dataInfo.getSignedDataRefs() != null) {
                str.append('\n').append("    dataInfo.getSignedDataRefs() = "
                        + Arrays.toString(dataInfo.getSignedDataRefs().toArray()));
            }
            if (dataInfo.getContentData() != null) {
                str.append('\n').append("    dataInfo.getContentData().length = " + dataInfo.getContentData().length);
            }

            str.append('\n').append("    dataInfo.getDocumentHash().getDigestMethod() = "
                    + dataInfo.getDocumentHash().getDigestMethod());

            str.append('\n').append("    dataInfo.getDocumentHash().getDigestValue().length = "
                    + dataInfo.getDocumentHash().getDigestValue().length);

        }

        return str.toString();
    }

    protected List<SignatureCheck> convertDetail(List<Detail> details) {
        if (details == null || details.size() == 0) {
            return null;
        }

        List<SignatureCheck> checks = new ArrayList<SignatureCheck>();
        for (Detail detail : details) {
            checks.add(new SignatureCheck(detail.getCode(), detail.getType()));
        }

        return checks;
    }

    protected void initArray(ValidateSignatureResponse si, int size) {
        if (si.getSignatureDetailInfo() == null) {
            SignatureDetailInfo[] array = new SignatureDetailInfo[size];
            si.setSignatureDetailInfo(array);
            for (int i = 0; i < array.length; i++) {
                array[i] = new SignatureDetailInfo();
            }
        }

    }

    public static String printDetail(List<Detail> details, String title) {

        if (details == null || details.size() == 0) {
            return "";
        }

        StringBuilder str = new StringBuilder(" +++++  DETAIL " + title + " +++++\n");
        int d = 0;
        for (Detail detail : details) {
            str.append(d).append(".-CODE=").append(detail.getCode()).append("\n");
            str.append(d).append(".-MESS=").append(detail.getMessage()).append("\n");
            str.append(d).append(".-TYPE=").append(detail.getType()).append("\n");
            d++;
        }
        str.append("\n");
        return str.toString();
    }

    public String cridadaWs(String inputXml) {
        return api.verify(inputXml);
    }

    // ----------------------------------------------------------------------------
    // ----------------------------------------------------------------------------
    // ------------- METODES COMUNICACIO AFIRMA FEDERAT
    // ---------------------------
    // ----------------------------------------------------------------------------
    // ----------------------------------------------------------------------------

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    protected void incorporateXMLSignature(Map<String, Object> inputParameters, byte[] signature, int xadesFormat) {

        if (SIGN_MODE_ATTACHED_ENVELOPING == xadesFormat) { // "XAdES Enveloping"
            inputParameters.put("dss:SignatureObject", new String(signature, UTF_8));
        } else if (SIGN_MODE_ATTACHED_ENVELOPED == xadesFormat // "XAdES Enveloped"
                || SIGN_MODE_DETACHED == xadesFormat) { // "XAdES Detached"

            String idSignaturePtr = String.valueOf(Math.random() * 9999.0D);
            inputParameters.put("dss:SignatureObject/dss:SignaturePtr@WhichDocument", idSignaturePtr);
            inputParameters.put("dss:InputDocuments/dss:Document@ID", idSignaturePtr);

            inputParameters.put("dss:InputDocuments/dss:Document/dss:Base64XML",
                    Base64.getEncoder().encodeToString(signature));
        }

    }

    private String processExpressionLanguage(String plantilla, Map<String, Object> custodyParameters) throws Exception {
        try {
            if (custodyParameters == null) {
                custodyParameters = new HashMap<String, Object>();
            }

            Writer out = new StringWriter();
            configuration.getTemplate(plantilla).process(custodyParameters, out);

            return out.toString();
        } catch (Exception e) {
            final String msg = "No s'ha pogut processar l'Expression Language " + plantilla + ":" + e.getMessage();
            throw new Exception(msg, e);
        }
    }

    @Override
    public String getResourceBundleName() {
        return "validatesignature-afirmacxf";
    }

}
