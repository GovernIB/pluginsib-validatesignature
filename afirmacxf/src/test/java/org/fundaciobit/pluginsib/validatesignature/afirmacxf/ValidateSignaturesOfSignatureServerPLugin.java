package org.fundaciobit.pluginsib.validatesignature.afirmacxf;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.fundaciobit.pluginsib.core.v3.utils.FileUtils;
import org.fundaciobit.pluginsib.utils.signature.SignatureConstants;
import org.fundaciobit.pluginsib.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus;
import org.jboss.logging.Logger;

/**
 * 
 * @author anadal
 * 4 nov 2024 10:21:19
 */
public class ValidateSignaturesOfSignatureServerPLugin {

    public static final String SIGNTYPE_CMS = "CMS";
    public static final String SIGNTYPE_CAdES = "CAdES";
    public static final String SIGNTYPE_XAdES = "XAdES";
    public static final String SIGNTYPE_ODF = "ODF";
    public static final String SIGNTYPE_PDF = "PDF"; // ?????
    public static final String SIGNTYPE_PAdES = "PAdES";
    public static final String SIGNTYPE_OOXML = "OOXML";
    public static final String SIGNTYPE_XML_DSIG = "XML_DSIG";

    /** El fitxer de dades resultant inclou la firma: PDF, ODT, ... */
    public static final int SIGN_MODE_ATTACHED_ENVELOPED = 0;

    /** El fitxer resultant serà la firma que incloura les dades originals */
    public static final int SIGN_MODE_ATTACHED_ENVELOPING = 3;

    /** El fitxer de firma no inclourà les dades: per separat trobarem un fitxer de firma i el fitxer original */
    public static final int SIGN_MODE_DETACHED = 1;

    /** Firma especial XAdES en que la firma i les dades estan al mateix nivell dins de l'XML: ni la firma inclou les dades ni les dades inclouen la firma */
    public static final int SIGN_MODE_INTERNALLY_DETACHED = 4;
    
    /** Firma especial XAdES també anomenada XAdES-Manifest
  * 
  * https://www.linkedin.com/pulse/art%C3%ADculo-t%C3%A9cnico-firmas-electr%C3%B3nicas-xades-de-con-tom%C3%A1s-garc%C3%ADa-mer%C3%A1s/
  * https://administracionelectronica.gob.es/ctt/resources/Soluciones/323/Descargas/Sistema%20de%20referenciacion%20de%20documentos%20en%20las%20AAPP-v11.docx?idIniciativa=323&idElemento=16433
  * https://www.w3.org/TR/2000/WD-xmldsig-core-20000510/#sec-o-Manifest
  */
 public static final int SIGN_MODE_EXTERNALLY_DETACHED = 5;

    public static final Logger log = Logger.getLogger(ValidateSignaturesOfSignatureServerPLugin.class);

    public static void main(String[] args) {
        try {

            System.setProperty("org.jboss.logging.provider", "log4j");

            long start = System.currentTimeMillis();

            log.error("  ==============================================");

            File results = new File("../../pluginsib-signatureserver-4.1/afirmaserver/results");

            IValidateSignaturePlugin plugin = instantiatePlugin();

            StringBuffer errors = new StringBuffer();
            StringBuffer oks = new StringBuffer();

            for (File f : results.listFiles()) {
                if (!f.getName().endsWith(".properties")) {
                    continue;
                }

                SignatureInfoProperties sip = getSignatureInfoProperties(f);

                File docFile = new File(results, sip.getFileOriginal());

                File signFile = new File(results, sip.getFileSigned());

                String name = signFile.getName().toLowerCase();
                if (name.endsWith(".pdf") || name.endsWith(".xsig") || name.endsWith(".csig")) {
                    // OK
                } else {
                    errors.append("TEST[" + sip.getName() + "] el fitxer signat no té extensió correcta ("
                            + signFile.getName() + ")");
                    continue;
                }
                System.out.println();
                System.out.println();
                System.out.println(" ===================[" + sip.getName() + "]===========================");
                System.out.println("SIGN FILE ==> " + signFile.getAbsolutePath());
                System.out.println("DOC FILE ==> " + docFile.getAbsolutePath());

                try {
                    byte[] signatureData = FileUtils.readFromFile(signFile);
                    byte[] documentData = null;
                    //docFile != null ? FileUtils.readFromFile(docFile) : null;
                    int signMode = sip.getSignMode();
                    if (signMode == SIGN_MODE_DETACHED) {
                        documentData = FileUtils.readFromFile(docFile);
                    }

                    ValidateSignatureResponse vsr = callToValidate(plugin, signatureData, documentData);

                    int status = vsr.getValidationStatus().getStatus();

                    if (status == ValidationStatus.SIGNATURE_VALID || status == ValidationStatus.SIGNATURE_INVALID) {

                        try {
                            String signTypeValidation = getSignTypePluginSignature(vsr.getSignType());
                            int signModeValidation = getSignModePluginSignature(vsr.getSignMode());

                            if (signMode != signModeValidation) {
                                errors.append("TEST[" + sip.getName() + "]  => ERROR MODE SIGNATURE: "
                                        + signModeValidation + "(validador) != " + signMode + "(firma)\n");

                            } else if (!signTypeValidation.equals(sip.getSignType())) {
                                errors.append("TEST[" + sip.getName() + "]  => ERROR TYPE SIGNATURE: "
                                        + signTypeValidation + " != " + sip.getSignType() + "\n");
                            } else {
                                oks.append("TEST[" + sip.getName() + "]  => OK\n");
                            }

                        } catch (Exception e) {
                            errors.append(
                                    "TEST[" + sip.getName() + "]  => ERROR NO CONTROLAT: " + e.getMessage() + "\n");
                        }

                        /*
                        oks.append(" ===================================================\n");
                        oks.append(" " + signFile.getName() + "\n");
                        oks.append("\tStatus" + " => VALID");
                        
                        oks.append("\tTYPE: " + vsr.getSignType() + "\n");
                        oks.append("\tFORMAT: " + vsr.getSignFormat() + "\n");
                        oks.append("\tPROFILE: " + vsr.getSignProfile() + "\n");
                        {
                            int ts = 0;
                            for (SignatureDetailInfo adi : vsr.getSignatureDetailInfo()) {
                        
                                oks.append("\t-----CERT_INFO[" + ts + "] ------------\n");
                        
                                InformacioCertificat certInfo = adi.getCertificateInfo();
                        
                                oks.append("\t\t " + certInfo.toString().replaceAll("\n", "\n\t\t "));
                        
                                oks.append("== SIGN_DATE: " + adi.getSignDate() + "\n");
                        
                                if (adi.getTimeStampInfo() != null) {
                                    oks.append("\t\t == TIMESTAMP_INFO[" + ts + "] ------------\n");
                                    TimeStampInfo tsi = adi.getTimeStampInfo();
                        
                                    oks.append("\t\t\t TSINFO[getAlgorithm]: " + tsi.getAlgorithm() + "\n");
                                    oks.append("\t\t\t TSINFO[getCertificateIssuer]: " + tsi.getCertificateIssuer()
                                            + "\n");
                                    oks.append("\t\t\t TSINFO[getCertificateSubject]:" + tsi.getCertificateSubject()
                                            + "\n");
                                    oks.append("\t\t\t TSINFO[getCreationTime]: " + tsi.getCreationTime() + "\n");
                        
                                    byte[] datacertificate = tsi.getCertificate();
                                    oks.append("\t\t\t TSINFO[getCertificatet]: byte[] => " + datacertificate + "\n");
                        
                                    if (tsi.getCertificate() != null) {
                                        X509Certificate cert = CertificateUtils
                                                .decodeCertificate(new ByteArrayInputStream(datacertificate));
                        
                                        oks.append("\t\t\t\t-getNotAfter" + cert.getNotAfter() + "\n");
                                        oks.append("\t\t\t\t-getNotBefore" + cert.getNotBefore() + "\n");
                                        oks.append("\t\t\t\t-getSerialNumber" + cert.getSerialNumber() + "\n");
                                    }
                        
                                    ts++;
                                }
                        
                            }
                        }
                        
                        oks.append("\n");
                        */

                    } else {
                        if (status == ValidationStatus.SIGNATURE_ERROR) {
                            errors.append("TEST[" + sip.getName() + "]  => ERROR: "
                                    + vsr.getValidationStatus().getErrorMsg() + "\n");
                        
                        /*
                        if (status == ValidationStatus.SIGNATURE_INVALID) {
                            errors.append("TEST[" + sip.getName() + "]  => INVALIDA:"
                                    + vsr.getValidationStatus().getErrorMsg() + "\n");
                            /*
                            errors.append("\tTYPE: " + vsr.getSignType());
                            errors.append("\tFORMAT: " + vsr.getSignFormat());
                            errors.append("\tPROFILE: " + vsr.getSignProfile());
                            */
                        } else {
                            errors.append("TEST[" + sip.getName() + "]  => Estat validacio desconegut: " + status + " ("
                                    + vsr.getValidationStatus().getErrorMsg() + ")\n");
                        }

                    }

                } catch (Exception e) {
                    errors.append("TEST[" + sip.getName() + "]  => ERROR NO CONTROLAT\t" + e.getMessage()).append("\n");
                    e.printStackTrace(System.err);
                }

            }

            System.out.println();
            System.out.println();
            System.out.println(" ==================== RESUM ===============================");
            System.out.println(oks.toString());
            System.err.println(errors.toString());

            System.out.println("TEMPS " + (System.currentTimeMillis() - start) + " ms");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getSignTypePluginSignature(String signTypeValidation) {

        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_CMS)) {
            return SIGNTYPE_CMS;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_CAdES)) {
            return SIGNTYPE_CAdES;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_XAdES)) {
            return SIGNTYPE_XAdES;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_ODF)) {
            return SIGNTYPE_ODF;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_PAdES)) {
            return SIGNTYPE_PAdES;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_PDF)) {
            return SIGNTYPE_PDF;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_XML_DSIG)) {
            return SIGNTYPE_XML_DSIG;
        }
        if (signTypeValidation.equals(SignatureConstants.SIGNTYPE_OOXML)) {
            return SIGNTYPE_OOXML;
        }
        throw new RuntimeException("SIGNTYPE de Validació desconegut: ]" + signTypeValidation + "[");

    }

    /**
     * Retorna el mode de signatura de l'APi de SignatureServer segons el Format de signatura retornat en la validacio
     * @return
     */
    public static int getSignModePluginSignature(int signFormat) throws Exception {
        
        // XAdES internally detached
        if (signFormat == SignatureConstants.SIGN_MODE_INTERNALLY_DETACHED) { // = "implicit/internally_detached";
            /** Firma especial XAdES en que la firma i les dades estan al mateix nivell dins de l'XML: ni la firma inclou les dades ni les dades inclouen la firma */
            return SIGN_MODE_INTERNALLY_DETACHED; // = 4;
        }

        /** La firma està continguda dins del document: PADES, ODT, OOXML */
        if (signFormat == SignatureConstants.SIGN_MODE_ATTACHED_ENVELOPED) { // = "implicit_enveloped/attached";
            /** El fitxer de dades resultant inclou la firma: PDF, ODT, ... */
            return SIGN_MODE_ATTACHED_ENVELOPED; //= 0;
        }

        /** La firma conté al document: Xades ATTACHED */
        if (signFormat == SignatureConstants.SIGN_MODE_ATTACHED_ENVELOPING) { // = "implicit_enveloping/attached";
            /** El fitxer resultant serà la firma que incloura les dades originals */
            return SIGN_MODE_ATTACHED_ENVELOPING; // = 3;
        }

        /**
         * El document està forà de la firma: xades detached i cades detached
         */
        if (signFormat == SignatureConstants.SIGN_MODE_DETACHED) { // = "explicit/detached";

            /** El fitxer de firma no inclourà les dades: per separat trobarem un fitxer de firma i el fitxer original */
            return SIGN_MODE_DETACHED; // == 1
        }

        /**
         * Cas específic de Xades externally detached
         */
        if (signFormat == SignatureConstants.SIGN_MODE_EXTERNALLY_DETACHED) {//  = "explicit/externally_detached";
            return SIGN_MODE_EXTERNALLY_DETACHED;
        }
        
        


        throw new Exception("SIGNFORMAT desconegut: ]" + signFormat + "[");

    };

    /**
     * Mètode que a partir d'una ruta a u fitxer de properties retorna un objecte de tipus SignatureInfoProperties
     */
    public static SignatureInfoProperties getSignatureInfoProperties(File propertiesFile) throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(propertiesFile));

        SignatureInfoProperties sip = new SignatureInfoProperties();

        sip.setName(p.getProperty("name"));
        sip.setFileOriginal(p.getProperty("fileOriginal"));
        sip.setFileSigned(p.getProperty("fileSigned"));
        sip.setSignType(p.getProperty("signType"));
        sip.setSignMode(Integer.parseInt(p.getProperty("signMode")));

        return sip;
    }

    private static ValidateSignatureResponse callToValidate(IValidateSignaturePlugin plugin, byte[] signature,
            byte[] document) throws Exception {
        ValidateSignatureResponse vs;
        ValidateSignatureRequest validationRequest = new ValidateSignatureRequest();

        validationRequest.setSignatureData(signature);
        validationRequest.setSignedDocumentData(document);

        SignatureRequestedInformation sri = new SignatureRequestedInformation();
        sri.setReturnSignatureTypeFormatProfile(true);
        sri.setReturnCertificateInfo(true);
        sri.setReturnCertificates(true);
        sri.setReturnValidationChecks(true);
        sri.setValidateCertificateRevocation(true);
        sri.setReturnTimeStampInfo(true);

        validationRequest.setSignatureRequestedInformation(sri);

        vs = plugin.validateSignature(validationRequest);
        return vs;
    }

    public static class SignatureInfoProperties {

        String name;
        String fileOriginal;
        String fileSigned;
        String signType;
        int signMode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFileOriginal() {
            return fileOriginal;
        }

        public void setFileOriginal(String fileOriginal) {
            this.fileOriginal = fileOriginal;
        }

        public String getFileSigned() {
            return fileSigned;
        }

        public void setFileSigned(String fileSigned) {
            this.fileSigned = fileSigned;
        }

        public String getSignType() {
            return signType;
        }

        public void setSignType(String signType) {
            this.signType = signType;
        }

        public int getSignMode() {
            return signMode;
        }

        public void setSignMode(int signMode) {
            this.signMode = signMode;
        }

    }

    public static IValidateSignaturePlugin instantiatePlugin() throws Exception {
        Properties pluginProperties = new Properties();
        pluginProperties.load(new FileInputStream(new File("./config/plugin.properties")));

        String propertyKeyBase = "org.fundaciobit.exemple.base.";

        IValidateSignaturePlugin plugin;
        plugin = new AfirmaCxfValidateSignaturePlugin(propertyKeyBase, pluginProperties);
        return plugin;
    }

}
