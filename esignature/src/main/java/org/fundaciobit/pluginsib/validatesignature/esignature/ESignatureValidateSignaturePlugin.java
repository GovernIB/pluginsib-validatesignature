package org.fundaciobit.pluginsib.validatesignature.esignature;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.BindingProvider;

import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.cms.CMSSignedData;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.BasicSignature;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.Certificate3;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificatePolicy;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertifiedRole;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.ContainerInfo;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.DataToValidateDTO;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.DetailedReport2;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.DiagnosticData;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.DigestAlgoAndValue;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.DistinguishedName;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.ManifestFile;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.MimeType;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.OID;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.RemoteDocument;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.Signature2;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.Signature2.CertificateChain.ChainItem;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.SimpleReport;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.SoapDocumentValidationService;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.SoapDocumentValidationServiceImplService;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.Timestamp;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.TrustedList;
import org.fundaciobit.plugins.certificate.InformacioCertificat;
import org.fundaciobit.plugins.validatesignature.api.AbstractValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.SignatureDetailInfo;
import org.fundaciobit.plugins.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.plugins.validatesignature.api.TimeStampInfo;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.plugins.validatesignature.api.ValidationStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



//import es.gob.afirma.i18n.Language;
//import es.gob.afirma.signature.SigningException;
import net.java.xades.security.xml.XMLSignatureElement;
/**
 * 
 * @author fbosch
 *
 */
public class ESignatureValidateSignaturePlugin extends AbstractValidateSignaturePlugin
    implements IValidateSignaturePlugin {

  public static final String ESIGNATURE_BASE_PROPERTIES = VALIDATE_SIGNATURE_BASE_PROPERTY + "esignature.";
  public static final String URL_BASE_PROPERTY = ESIGNATURE_BASE_PROPERTIES + "url";
  public static final String DEBUG_BASE_PROPERTY = ESIGNATURE_BASE_PROPERTIES + "debug";
  public static final Map<String, String> localSignType2PluginSignType = new HashMap<String, String>();
  public static final Map<String, TypeFormatProfile> esignature2TypeFormatProfile = new HashMap<String, TypeFormatProfile>();
  
  final String DISTINGUISHED_NAME_FORMAT = "RFC";
  
  public static final SignatureRequestedInformation supportedSignatureRequestedInformation = new SignatureRequestedInformation();


  static {

    supportedSignatureRequestedInformation.setReturnCertificateInfo(true);
    supportedSignatureRequestedInformation.setReturnCertificates(true);
    supportedSignatureRequestedInformation.setReturnSignatureTypeFormatProfile(true);
    supportedSignatureRequestedInformation.setReturnTimeStampInfo(true);
    supportedSignatureRequestedInformation.setReturnValidationChecks(true);
    supportedSignatureRequestedInformation.setValidateCertificateRevocation(true);


    
    final String PADES_BASELINE_B = "PAdES-BASELINE-B";
    final String PAdES_BASELINE_T = "PAdES-BASELINE-T";
    final String PADES7_T = "PKCS7-T";
    
    final String XADES_BASELINE_T = "XAdES-BASELINE-T";
    final String XADES_BASELINE_LT = "XAdES-BASELINE-LT";
    final String XADES_BASELINE_LTA = "XAdES-BASELINE-LTA";
    final String XADES_X = "XAdES-X";
    final String XADES_C = "XAdES-C";
       
    final String CADES_BASELINE_T = "CAdES-BASELINE-T";
    final String CADES_BASELINE_LTA = "CAdES-BASELINE-LTA";
    final String CADES_BASELINE_LT = "CAdES-BASELINE-LT";
    final String CADES_X = "CAdES-101733-X";
    

    esignature2TypeFormatProfile.put(PADES_BASELINE_B,
        new TypeFormatProfile(SIGNTYPE_PAdES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, SIGNPROFILE_PADES_LTV));
    
    esignature2TypeFormatProfile.put(PAdES_BASELINE_T,
        new TypeFormatProfile(SIGNTYPE_PAdES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, SIGNPROFILE_T));
    
    esignature2TypeFormatProfile.put(PADES7_T,
        new TypeFormatProfile(SIGNTYPE_PAdES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, SIGNPROFILE_T));
    
    
    
    esignature2TypeFormatProfile.put(XADES_BASELINE_T,
        new TypeFormatProfile(SIGNTYPE_XAdES, null, SIGNPROFILE_T));
    
    esignature2TypeFormatProfile.put(XADES_BASELINE_LT,
        new TypeFormatProfile(SIGNTYPE_XAdES, null, SIGNPROFILE_XL1));
    
    esignature2TypeFormatProfile.put(XADES_BASELINE_LTA,
        new TypeFormatProfile(SIGNTYPE_XAdES, null, SIGNPROFILE_A));
    
    esignature2TypeFormatProfile.put(XADES_X,
        new TypeFormatProfile(SIGNTYPE_XAdES, null, SIGNPROFILE_X1));
    
    esignature2TypeFormatProfile.put(XADES_C,
        new TypeFormatProfile(SIGNTYPE_XAdES, null, SIGNPROFILE_X2));
    
    
    
    esignature2TypeFormatProfile.put(CADES_BASELINE_T,
        new TypeFormatProfile(SIGNTYPE_CAdES, null, SIGNPROFILE_T));
    
    esignature2TypeFormatProfile.put(CADES_BASELINE_LTA,
        new TypeFormatProfile(SIGNTYPE_CAdES, null, SIGNPROFILE_A));

    esignature2TypeFormatProfile.put(CADES_X,
        new TypeFormatProfile(SIGNTYPE_CAdES, null, SIGNPROFILE_X1));
    
    esignature2TypeFormatProfile.put(CADES_BASELINE_LT,
        new TypeFormatProfile(SIGNTYPE_CAdES, null, SIGNPROFILE_XL1));
  }

  public ESignatureValidateSignaturePlugin() {
    super();
  }
  public ESignatureValidateSignaturePlugin(String propertyKeyBase, Properties properties) {
    super(propertyKeyBase, properties);
  }
  public ESignatureValidateSignaturePlugin(String propertyKeyBase) {
    super(propertyKeyBase);
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

    // DEFINICIO DE CONSTANTS:
    boolean returnTypeFormatProfile = validationRequest.getSignatureRequestedInformation().getReturnSignatureTypeFormatProfile();
    boolean returnCertificateInfo = validationRequest.getSignatureRequestedInformation().getReturnCertificateInfo();
    boolean returnCertificates = validationRequest.getSignatureRequestedInformation().getReturnCertificates();
    boolean returnValidationChecks = validationRequest.getSignatureRequestedInformation().getReturnValidationChecks();
    boolean returnCertificateRevocation = validationRequest.getSignatureRequestedInformation().getValidateCertificateRevocation();
    boolean returnTimeStampInfo = validationRequest.getSignatureRequestedInformation().getReturnTimeStampInfo();
    
    
    // Final String endpoint = "http://localhost:8080/services/soap/validation";
    final String endpoint = this.getPropertyRequired(URL_BASE_PROPERTY);
    final boolean debug = "true".equals(this.getProperty(DEBUG_BASE_PROPERTY));

    // CONSTRUCCIO DEL SERVEI
    SoapDocumentValidationService validationService;
    {
      SoapDocumentValidationServiceImplService service;
      URL wsdl = new URL(endpoint + "?wsdl");
      service = new SoapDocumentValidationServiceImplService(wsdl);
      validationService = service.getSoapDocumentValidationServiceImplPort();
      Map<String, Object> reqContext;
      reqContext = ((BindingProvider) validationService).getRequestContext();
      reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
    }

    //DECLARACIÓ DELS REMOTEDOCUMENT
    RemoteDocument remSign = new RemoteDocument();
    RemoteDocument doc = null;
    byte[] sigData = validationRequest.getSignatureData();

    //FIRMA
    if (sigData != null) {
      remSign.setBytes(sigData);
      remSign.setDigestAlgorithm(null);
      remSign.setMimeType(getMimeType(sigData));
      remSign.setName(null);

      //DOCUMENT FIRMAT
      byte[] docData = validationRequest.getSignedDocumentData();
      if (docData != null) {
        doc = new RemoteDocument();
        doc.setBytes(docData);
        doc.setDigestAlgorithm(null);
        doc.setMimeType(getMimeType(docData));
        doc.setName(null);
      }
    }
    
    //Objecte final a validar "DataToValidate"
    org.fundaciobit.pluginsib.validatesignature.esignature.ws.DataToValidateDTO dataToValidateDTO = new DataToValidateDTO();
    dataToValidateDTO.setSignedDocument(remSign);
    dataToValidateDTO.setOriginalDocument(doc);
    dataToValidateDTO.setPolicy(null);

    //Validacio del document
    org.fundaciobit.pluginsib.validatesignature.esignature.ws.WsReportsDTO signatureReport;
    ValidateSignatureResponse validateSignatureResponse = new ValidateSignatureResponse();
    
    try {
      signatureReport = validationService.validateSignature(dataToValidateDTO);
    }catch(Throwable e) {
      //"Error no controlat cridant al servei ws de esignature: ";
      String msg = getTraduccio(getResourceBundleName(), "error.cridadaws", new Locale(validationRequest.getLanguage()), e.getMessage());
      log.error(msg, e);
      ValidationStatus validationStatus =  new ValidationStatus();
      validationStatus.setStatus(ValidationStatus.SIGNATURE_ERROR);
    
      validationStatus.setErrorMsg(msg);
      validationStatus.setErrorException(e);
      
      validateSignatureResponse.setValidationStatus(validationStatus);
      return validateSignatureResponse;
    }
    
    
    //Variables per treballar amb les dades retornades de la validacio
    SimpleReport simple = signatureReport.getSimpleReport();
    DiagnosticData diagnostic = signatureReport.getDiagnosticData();
    

    if (debug){
      log.info("****************************************");
      log.info("************ D E B U G  O N ************");
      log.info("****************************************");
      debuggerOn(signatureReport);
    }

    

    //Resultat de la validacio: Sempre es retorna
    ValidationStatus status = new ValidationStatus();
    if (simple.getSignaturesCount() == simple.getValidSignaturesCount()) {
      status.setStatus(ValidationStatus.SIGNATURE_VALID);
    }else{
      status.setStatus(ValidationStatus.SIGNATURE_INVALID);      
    }
    validateSignatureResponse.setValidationStatus(status);

    //Signature Detail Info List:
    List<SignatureDetailInfo> detailsList = new ArrayList<SignatureDetailInfo>();
    SignatureDetailInfo sdi = new SignatureDetailInfo();
    
    StringBuffer errorBuffer = new StringBuffer();
    
    int i=1;
    //Resultats opcionals de la validacio:
    for (Signature2 sig2 : diagnostic.getSignatures().getSignature()) {
      
      String subInd=simple.getSignature().get(i-1).getSubIndication();
      
      if("NO_POE".equals(subInd)) {
        //XYZ S'ha de traduir
        errorBuffer.append("Error de validacio dins el Timestamp");
      }else if("SIGNED_DATA_NOT_FOUND".equals(subInd)) {
        //XYZ S'ha de traduir
        errorBuffer.append("No s'ha trobat l'arxiu original");
      }else {
        errorBuffer.append(subInd);
      }
      
      
      if(returnTypeFormatProfile){        
        TypeFormatProfile tfp = esignature2TypeFormatProfile.get(sig2.getSignatureFormat());

        if(tfp != null) {
          if(sig2.getSignatureFormat().equals("PAdES-BASELINE-B") && sig2.getTimestamps().getTimestamp().size() == 0) {
            validateSignatureResponse.setSignType(SIGNTYPE_PAdES);
            validateSignatureResponse.setSignFormat(getSignFormat(SIGNTYPE_PAdES,sigData));
              if(sig2.getPolicy() == null) {
                validateSignatureResponse.setSignProfile(SIGNPROFILE_BES);
              }else{
                validateSignatureResponse.setSignProfile(SIGNPROFILE_EPES);
              }
          }else{
            validateSignatureResponse.setSignType(tfp.type);
            validateSignatureResponse.setSignFormat(getSignFormat(tfp.type,sigData));
            validateSignatureResponse.setSignProfile(tfp.profile); 
          } 
        }
      }
      
      //Certificate Info
      if (returnCertificateInfo) {
        sdi.setAlgorithm(sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
        sdi.setCertificateInfo(constructCertificateInfo(diagnostic));
      }

      //Certificates (binaris)
      if(returnCertificates){
        List<byte[]> cadena = new ArrayList<byte[]>();
        sdi.setAlgorithm(sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
        for (Certificate3 ce : diagnostic.getUsedCertificates().getCertificate()) {
          cadena.add(ce.getBase64Encoded());
        }
        if (cadena.size() > 0){
          sdi.setCertificateChain(cadena.toArray(new byte[cadena.size()][]));
        }
      }

      //Validation Checks. (No es retornen desde esignature)
      if (returnValidationChecks){ 
        sdi.setAlgorithm(sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
      }

      // Cert. Revocation
      if (returnCertificateRevocation) {
        sdi.setAlgorithm(sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
      }

      // TimeStampInfo
      if (returnTimeStampInfo) {
        TimeStampInfo tsi = new TimeStampInfo();
        HashMap<String, Certificate3> timestampCertificateMap = new HashMap<String,Certificate3>();
        tsi.setAlgorithm(sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
      
        if(sig2.getTimestamps().getTimestamp().size()>0) {
          for(Timestamp ts: sig2.getTimestamps().getTimestamp()) {
            for(Certificate3 cert: diagnostic.getUsedCertificates().getCertificate()) {
              if(ts.getSigningCertificate().getId().equals(cert.getId())) {
                timestampCertificateMap.put(ts.getSigningCertificate().getId(), cert);
              }
            }
          }
        }           
        
        for(Timestamp ts: sig2.getTimestamps().getTimestamp()){
            for(DistinguishedName ds: timestampCertificateMap.get(ts.getSigningCertificate().getId()).getIssuerDistinguishedName()) {
              if(ds.getValue().contains(DISTINGUISHED_NAME_FORMAT)) {
                tsi.setCertificateIssuer(ds.getValue());
                break;
              }else{
                tsi.setCertificateIssuer(ds.getValue());
              }
          }
            
          for(DistinguishedName ds: timestampCertificateMap.get(ts.getSigningCertificate().getId()).getSubjectDistinguishedName()) {
            if(ds.getValue().contains(DISTINGUISHED_NAME_FORMAT)) {
              tsi.setCertificateSubject(ds.getValue());
              break;
            }else {
              tsi.setCertificateSubject(ds.getValue());
            }
          } 
        }  
       sdi.setTimeStampInfo(tsi);
      }
      sdi.setAlgorithm(sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
      detailsList.add(sdi);
    }
    
    status.setErrorMsg(errorBuffer.toString());
    SignatureDetailInfo[] detailsArray = new SignatureDetailInfo[detailsList.size()];
    detailsList.toArray(detailsArray);
    validateSignatureResponse.setSignatureDetailInfo((detailsArray));
    
    return validateSignatureResponse;
  }

  private MimeType getMimeType(byte[] signatureData) throws IOException {

    InputStream is = new BufferedInputStream(new ByteArrayInputStream(signatureData));
    String mimeType = URLConnection.guessContentTypeFromStream(is);

    MimeType mt = new MimeType();
    mt.setMimeTypeString(mimeType);
    return mt;
  }

  private InformacioCertificat constructCertificateInfo(DiagnosticData diagnostic) {

    InformacioCertificat ci = new InformacioCertificat();
    final boolean debug = "true".equals(this.getProperty(DEBUG_BASE_PROPERTY));
    
    if (debug) {
      log.info("\n\n");
      log.info("**** C E R T I F I C A T E  I N F O ****");
      log.info("Lista de atributos no especificados:\n");
    }

    for (Certificate3 cert : diagnostic.getUsedCertificates().getCertificate()) {

      //ci.setClasificacion();
      //ci.setExtensionUsoCertificado();
      
      if(cert.getId()!=null) {
        ci.setEmissorID(cert.getId());
      }else if(debug) {
        log.info("Certificate Id = NULL");
      }
      
      if(cert.getCertificatePolicies().getCertificatePolicy().size()>0) {
        ci.setPoliticaID(cert.getCertificatePolicies().getCertificatePolicy().get(0).getValue());
      }else if(debug) {
        log.info("Certificate Policy Id = NULL");
      }
      
      if (cert.getSerialNumber().toString() != null) {
        ci.setNumeroSerie(new BigInteger(cert.getSerialNumber().toString()));
      }else if(debug){
        log.info("Num de Serie: NULL.");
      }
      
      if (cert.getOrganizationName()!=null) {
        ci.setOrganitzacio(cert.getOrganizationName());
      } else if (debug) {
        log.info("Certificate Organizacion: NULL.");
      }
      //ci.setOrganizacionEmisora();
      
      if (cert.getCountryName() != null) {
        ci.setPais(cert.getCountryName());
      } else if (debug) {
        log.info("Pais: NULL.");
      }

      
      if (cert.getCertificatePolicies().getCertificatePolicy().size() > 0) {
        ci.setPolitica(cert.getCertificatePolicies().getCertificatePolicy().get(0).getValue());
      } else if (debug) {
        log.info("Politica: NULL.");
      }
      
      //ci.setSubject();
      //ci.setTipoCertificado();
      
      if (cert.getOrganizationName() != null) {
        ci.setUnitatOrganitzativa(cert.getOrganizationName());
      } else if (debug) {
        log.info("Unidad Organizativa: NULL.");
      }
      
      if (cert.getSigningCertificate() != null) {
        ci.setUsCertificat(cert.getSigningCertificate().getSigned());
      } else if (debug){
        log.info("Uso Certificado: NULL.");
      }
      
      if(cert.getNotBefore()!=null) {
        ci.setValidDesDe(cert.getNotBefore().toGregorianCalendar().getTime());
      }
      
      if(cert.getNotAfter()!=null) {
        ci.setValidFins(cert.getNotAfter().toGregorianCalendar().getTime());
      }
      //ci.setVersionPolitica();
    }
    return ci;
  }

  private void debuggerOn(org.fundaciobit.pluginsib.validatesignature.esignature.ws.WsReportsDTO signatureReport) {

    SimpleReport simple = signatureReport.getSimpleReport();
    DiagnosticData diagnostic = signatureReport.getDiagnosticData();
    DetailedReport2 detailed = signatureReport.getDetailedReport();

    log.info("\n");
    log.info("**** S I M P L E   R E P O R T ****\n");

    log.info("Simple.getContainerType: " + simple.getContainerType());
    log.info("Simple.getDocumentName: " + simple.getDocumentName());
    log.info("simple.getSignaturesCount: " + simple.getSignaturesCount());
    log.info("simple.getValidSignaturesCount: " + simple.getValidSignaturesCount());
    log.info("simple.getPolicy.getPolicyName: " + simple.getPolicy().getPolicyName());
    // log.info("Policy Description:
    // "+simple.getPolicy().getPolicyDescription());
    log.info("diagnostic.getSignatures.getSignature.get(0).getBasicSignature.getDigestAlgoUsedToSignThisToken: "
            + diagnostic.getSignatures().getSignature().get(0).getBasicSignature().getDigestAlgoUsedToSignThisToken());
    log.info("simple.getSignature.get(0).getCertificateChain.getCertificate.get(0).getQualifiedName: "
        + simple.getSignature().get(0).getCertificateChain().getCertificate().get(0).getQualifiedName());
    for (SimpleReport.Signature s : simple.getSignature()) {
      log.info("simple.getSignature.get(i).getId" + s.getId());
      log.info("simple.getSignature.get(i).getFileName:" + s.getFilename());
      log.info("simple.getSignature.get(i).getIndication: " + s.getIndication());
      log.info("simple.getSignature.get(i).getSignatureFormat: " + s.getSignatureFormat());
      log.info("simple.getSignature.get(i).getSignedBy: " + s.getSignedBy());
      log.info("simple.getSignature.get(i).getSubIndication: " + s.getSubIndication());
      log.info("simple.getSignature.get(i).getBestSignatureTime: " + s.getBestSignatureTime());
      log.info("simple.getSignature.get(i).getSignatureLevel.getValue: " + s.getSignatureLevel().getValue());
      log.info(
          "simple.getSignature.get(i).getSignatureLevel.getDescription: " + s.getSignatureLevel().getDescription());
    }

    log.info("\n");
    log.info("**** D I A G N O S T I C   R E P O R T ****");

    log.info("  diagnostic.getDocumentName: " + diagnostic.getDocumentName());
    log.info("  diagnostic.getValidationDate: " + diagnostic.getValidationDate());

    log.info("");
    log.info("- C E R T I F I C A T E S: ");

    for (Certificate3 cert : diagnostic.getUsedCertificates().getCertificate()) {
      log.info("\n");
      log.info("** CERTIFICATE NAME: " + cert.getCommonName());
      log.info("cert.getCountryName: " + cert.getCountryName());
      log.info("cert.getEmail: " + cert.getEmail());
      log.info("cert.getGivenName: " + cert.getGivenName());
      log.info("cert.getId: " + cert.getId());
      log.info("cert.getLocality: " + cert.getLocality());
      log.info("cert.getOrganizationalUnit: " + cert.getOrganizationalUnit());
      log.info("cert.getOrganizationName: " + cert.getOrganizationName());
      log.info("cert.getPseudonym: " + cert.getPseudonym());
      log.info("cert.getPublicKeyEncriptionAlgo: " + cert.getPublicKeyEncryptionAlgo());
      log.info("cert.getPublicKeySize: " + cert.getPublicKeySize());
      log.info("cert.getState: " + cert.getState());
      log.info("cert.getSurname: " + cert.getSurname());
      log.info("cert.getAuthorityInformationAccessUrls:");
      if (cert.getAuthorityInformationAccessUrls().getUrl() != null) {
        for (String str : cert.getAuthorityInformationAccessUrls().getUrl()) {
          log.info("        URL: " + str);
        }
      } else {
        log.info("        -no authority information access urls-");
      }

      log.info("cert.getBase64Encoded: " + cert.getBase64Encoded());
      log.info("cert.getBasicSignature.");
      BasicSignature basicSign = cert.getBasicSignature();

      log.info("      getDigestAlgorithmUsedToSignThisToken: " + basicSign.getDigestAlgoUsedToSignThisToken());
      log.info(
          "      getEncryptionAlgorithmUsedToSignThisToken: " + basicSign.getEncryptionAlgoUsedToSignThisToken());
      log.info("      getKeyLengthUsedToSignThisToken: " + basicSign.getKeyLengthUsedToSignThisToken());
      log.info("      getMaskGenerationFunctionToSignThisToken: "
          + basicSign.getMaskGenerationFunctionUsedToSignThisToken());

      // Cadena de certificats.
      log.info("Certificate Chain: ");
      if (cert.getCertificateChain() != null) {
        for (org.fundaciobit.pluginsib.validatesignature.esignature.ws.Certificate3.CertificateChain.ChainItem chain : cert
            .getCertificateChain().getChainItem()) {
          log.info("    chain.getId: " + chain.getId());
          log.info("    chain.getSource: " + chain.getSource());
        }
      } else {
        log.info("    -no certificate chain-");
      }

      // Certificats de politiques
      System.out.println("CertificatePolicies:");
      if (cert.getCertificatePolicies().getCertificatePolicy() != null) {
        for (CertificatePolicy policy : cert.getCertificatePolicies().getCertificatePolicy()) {
          log.info("    Policy Value: " + policy.getValue());
          log.info("    Policy CpsUrl: " + policy.getCpsUrl());
          log.info("      Policy Description: " + policy.getDescription());
        }
      } else {
        log.info("    -no certificate policies-");
      }

      // Distribution points.
      log.info("Distribution Points: ");
      if (cert.getCRLDistributionPoints().getUrl() != null) {
        for (String s : cert.getCRLDistributionPoints().getUrl()) {
          log.info("    Distribution point: " + s);
        }
      } else {
        log.info("   -no distribution points-");
      }

      // Digest algorithms and values.
      log.info("DigestAlgoAndValues:");
      if (cert.getDigestAlgoAndValues().getDigestAlgoAndValue() != null) {
        for (DigestAlgoAndValue algoValues : cert.getDigestAlgoAndValues().getDigestAlgoAndValue()) {
          log.info("    Digest Method: " + algoValues.getDigestMethod());
          log.info("    Digest Value: " + algoValues.getDigestValue());
        }
      } else {
        log.info("    -no digest algortihms and values-");
      }

      // Exteded key usages.
      log.info("ExtendedKeyUsages:");
      if (cert.getExtendedKeyUsages().getOid() != null) {
        for (OID oid : cert.getExtendedKeyUsages().getOid()) {
          log.info("    Extended Key value: " + oid.getValue());
          log.info("    Extended Key Description: " + oid.getDescription());
        }
      } else {
        log.info("    -no extended keys usage-");
      }

      // Info and messages
      log.info("Info:");
      if (cert.getInfo().getMessage() != null) {
        for (Certificate3.Info.Message message : cert.getInfo().getMessage()) {
          log.info("    Message Id: " + message.getId());
          log.info("    Message Value: " + message.getValue());
        }
      } else {
        log.info("    -no info or messages-");
      }
      log.info("\n");
    }
    log.info("\n");
    log.info("**** S I G N A T U R E S   R E P O R T ****\n");

    for (Signature2 sig2 : diagnostic.getSignatures().getSignature()) {
      log.info("sig2.getContentHints: " + sig2.getContentHints());
      log.info("sig2.getContentIdentifier: " + sig2.getContentIdentifier());
      log.info("sig2.getContentType: " + sig2.getContentType());
      log.info("sig2.getContentHints: " + sig2.getContentHints());
      log.info("sig2.getParentId: " + sig2.getParentId());
      log.info("sig2.getSignatureFilename" + sig2.getSignatureFilename());
      log.info("sig2.getSignatureFormat: " + sig2.getSignatureFormat());
      log.info("-Basic Signature: ");
      log.info("    basicSignature.getDigestAlgoUsedToSignThisToken: "
          + sig2.getBasicSignature().getDigestAlgoUsedToSignThisToken());
      log.info("    basicSignature.getEncryptionAlgoUsedToSignThisToken: "
          + sig2.getBasicSignature().getEncryptionAlgoUsedToSignThisToken());
      log.info("    basicSignature.getKeyLengthToSignThisToken: "
          + sig2.getBasicSignature().getKeyLengthUsedToSignThisToken());
      log.info("    basicSignature.getMaskGenerationFunctionUsedToSignThisToken: "
          + sig2.getBasicSignature().getMaskGenerationFunctionUsedToSignThisToken());

      log.info("-Certificate Chain: ");
      for (ChainItem ci : sig2.getCertificateChain().getChainItem()) {
        log.info("    chainItem.getId: " + ci.getId());
        log.info("    chainItem.getSource: " + ci.getSource());
      }
      log.info("-Certified Roles: ");
      for (CertifiedRole cr : sig2.getCertifiedRoles()) {
        log.info("    certifiedRole.getCategory: " + cr.getCategory());
        log.info("    certifiedRole.getCertifiedRole: " + cr.getCertifiedRole());
        log.info("    certifiedRole.getNotAfter: " + cr.getNotAfter());
        log.info("    certifiedRole.getNotBefore: " + cr.getNotBefore());
      }

      log.info("-Claimed Roles: ");
      for (String s : sig2.getClaimedRoles().getClaimedRoles()) {
        log.info("    claimedRole.getClaimedRoles: " + s);
      }

      log.info("-Commitment Type Indications: ");
      if (sig2.getCommitmentTypeIndication() != null) {
        for (String s : sig2.getCommitmentTypeIndication().getIndication()) {
          log.info("    Indication: " + s);
        }
      } else {
        log.info("    - No Commitment Type Indications: ");
      }

      if (diagnostic.getContainerInfo() != null) {

        log.info("\n");
        log.info("**** C O N T A I N E R  I N F O   R E P O R T ****\n");

        ContainerInfo contInfo = diagnostic.getContainerInfo();
        log.info("contInfo.getContainerType: " + contInfo.getContainerType());
        log.info("contInfo.getMimeType: " + contInfo.getMimeTypeContent());
        log.info("contInfo.getZipComment: " + contInfo.getZipComment());

        log.info("-Content Files: ");
        for (String s : diagnostic.getContainerInfo().getContentFiles().getContentFile()) {
          log.info("    Content File: " + s);
        }

        log.info("-Manifest Files: ");
        for (ManifestFile mf : diagnostic.getContainerInfo().getManifestFiles().getManifestFile()) {
          log.info("    manifestFile.getFilename: " + mf.getFilename());
          log.info("    manifestFile.getSignatureFilename: " + mf.getSignatureFilename());
          log.info("    -Entries: ");
          for (String s : mf.getEntries().getEntry()) {
            log.info("        Entry: " + s);
          }
        }

        log.info("\n\n");
        log.info("**** L I S T  O F  T R U S T E D  L I S T   R E P O R T ****\n");

        TrustedList tl = diagnostic.getListOfTrustedLists();

        log.info("trustedList.getCountryCode: " + tl.getCountryCode());
        log.info("trustedList.getUrl: " + tl.getUrl());
        log.info("trustedList.getSequenceNumber: " + tl.getSequenceNumber());
        log.info("trustedList.getVersion: " + tl.getVersion());

        log.info("-Content Files: ");
        for (TrustedList tlst : diagnostic.getTrustedLists().getTrustedList()) {
          log.info("    trustedList.getCountryCode: " + tlst.getCountryCode());
          log.info("    trustedList.getUrl: " + tlst.getUrl());
          log.info("    trustedList.getVersion: " + tlst.getVersion());
          log.info("    trustedList.getSequenceNumber: " + tlst.getSequenceNumber());
          log.info("    trustedList.getIssueDate: " + tlst.getIssueDate());
          log.info("    trustedList.getLastLoading: " + tlst.getLastLoading());
          log.info("    trustedList.getNextUpdate: " + tlst.getNextUpdate());
        }

      }
    }
  }
  
  /**
   * AQUEST MÈTODE ESTA DUPLICAT AL PLUGIN-INTEGR@
   * @param signType
   * @param signData
   * @return
   * @throws Exception
   */
  protected String getSignFormat(String signType, final byte[] signData) throws Exception {
    String signFormat;
    if (SIGNTYPE_CMS.equals(signType)) { // "CMS";
      // TODO Això no se si es correcte !!!!!!!
      try {
        signFormat = getCAdESFormat(signData);
      } catch(Throwable th) {
        log.error("Error intentant obtenir el format d'una firma CMS emprant el mètode getCAdESFormat(): " + th.getMessage(), th);
        signFormat = null;
      }
    } else if (SIGNTYPE_CAdES.equals(signType)) { // "CAdES";
      signFormat = getCAdESFormat(signData);
    } else if (SIGNTYPE_XAdES.equals(signType)) { // "XAdES";
      signFormat = getXAdESFormat(signData);
    } else if (SIGNTYPE_ODF.equals(signType)) { // "ODF";
      signFormat = SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED;
    } else if (SIGNTYPE_PDF.equals(signType)) { // "PDF"; //
      signFormat = SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED;
    } else if (SIGNTYPE_PAdES.equals(signType)) { // "PAdES";
      signFormat = SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED;
    } else if (SIGNTYPE_OOXML.equals(signType)) { // "OOXML";
      signFormat = SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED;
    } else if (SIGNTYPE_XML_DSIG.equals(signType)) { // "XML_DSIG";
      // TODO Això no se si es correcte !!!!!!!
      try {
        signFormat = getXAdESFormat(signData);
      } catch(Throwable th) {
        log.error("Error intentant obtenir el format d'una firma XML_DSIG emprant el"
            + " mètode getXAdESFormat(): " + th.getMessage(), th);
        signFormat = null;
      }
    } else {
      log.warn("Error intentant trobar el format de una firma amb tipus desconegut: "
        + signType, new Exception());
      signFormat = null;
    }
    return signFormat;
  }
  
  /**
   * AQUEST MÈTODE ESTA DUPLICAT AL PLUGIN-INTEGR@ 
   * @param eSignature
   * @return
   * @throws SigningException
   */
  public static String getXAdESFormat(byte[] signature) throws Exception {
    
    DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
    dBFactory.setNamespaceAware(true);

    Document eSignature = dBFactory.newDocumentBuilder().parse(
        new ByteArrayInputStream(signature));

    XMLSignature xmlSignature;
    String rootName = eSignature.getDocumentElement().getNodeName();
    if (rootName.equalsIgnoreCase("ds:Signature") || rootName.equals("ROOT_COSIGNATURES")) {
      // "XAdES Enveloping"
      return SIGNFORMAT_IMPLICIT_ENVELOPING_ATTACHED;
    }
    NodeList signatureNodeLs = eSignature.getElementsByTagName("ds:Manifest");
    if (signatureNodeLs.getLength() > 0) {
      // "XAdES Externally Detached
      return SIGNFORMAT_EXPLICIT_EXTERNALLY_DETACHED;
    }
    NodeList signsList = eSignature.getElementsByTagNameNS(
        "http://www.w3.org/2000/09/xmldsig#", "Signature");
    if (signsList.getLength() == 0) {
      throw new Exception("La llista de firmes esta buida: XS003");
    }
    Node signatureNode = signsList.item(0);
    try {
      xmlSignature = new XMLSignatureElement((Element) signatureNode).getXMLSignature();
    } catch (MarshalException e) {
      throw new Exception(e);
    }
    List<?> references = xmlSignature.getSignedInfo().getReferences();
    for (int i = 0; i < references.size(); ++i) {
      if (!"".equals(((Reference) references.get(i)).getURI()))
        continue;
      // "XAdES Enveloped"
      return SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED;
    }
    // "XAdES Detached"
    return SIGNFORMAT_EXPLICIT_DETACHED;
  }
   
  /**
   * AQUEST MÈTODE ESTA DUPLICAT AL PLUGIN-INTEGR@  
   * @param signature
   * @return
   * @throws Exception
   */
  public static String getCAdESFormat(byte[] signature) throws Exception {

    CMSSignedData cmsSignedData = new CMSSignedData(signature);

    // ContentInfo contentInfo = cmsSignedData.toASN1Structure();
    // //getContentInfo();
    ContentInfo contentInfo;
    try {
      java.lang.reflect.Method method;
      method = cmsSignedData.getClass().getMethod("toASN1Structure");

      contentInfo = (ContentInfo) method.invoke(cmsSignedData);

    } catch (Exception e) {
      java.lang.reflect.Method method;
      method = cmsSignedData.getClass().getMethod("getContentInfo");

      contentInfo = (ContentInfo) method.invoke(cmsSignedData);
    }

    // (Object)contentInfo.getContent()
    java.lang.reflect.Method method;
    method = contentInfo.getClass().getMethod("getContent");

    Object encodable = method.invoke(contentInfo);

    SignedData signedData = SignedData.getInstance(encodable);
    ContentInfo contentInfo2 = signedData.getEncapContentInfo();
    boolean isImplicit = false;
    if (contentInfo2 != null) {

      // signedData.getEncapContentInfo().getContent() != null) {
      java.lang.reflect.Method method2;
      method2 = contentInfo2.getClass().getMethod("getContent");

      Object obj = method2.invoke(contentInfo2);

      if (obj != null) {
        isImplicit = true;
      }
    }

    if (isImplicit) {
      //  "CAdES attached/implicit signature";
      return SIGNFORMAT_IMPLICIT_ENVELOPING_ATTACHED;
    } else {
      //  "CAdES detached/explicit signature"
      return SIGNFORMAT_EXPLICIT_DETACHED;
    }
  }



  @Override
  public String getResourceBundleName() {
    return "validatesignature-esignature";
  }
  
  
  
}
