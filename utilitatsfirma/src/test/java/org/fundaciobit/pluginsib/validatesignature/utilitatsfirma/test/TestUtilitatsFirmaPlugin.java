package org.fundaciobit.pluginsib.validatesignature.utilitatsfirma.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.fundaciobit.pluginsib.core.v3.utils.CertificateUtils;
import org.fundaciobit.pluginsib.core.v3.utils.FileUtils;
import org.fundaciobit.pluginsib.utils.signature.SignatureCommonUtils;
import org.fundaciobit.pluginsib.validatecertificate.InformacioCertificat;
import org.fundaciobit.pluginsib.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureDetailInfo;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.TimeStampInfo;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus;
import org.fundaciobit.pluginsib.validatesignature.utilitatsfirma.UtilitatsFirmaValidateSignaturePlugin;
import org.jboss.logging.Logger;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author anadal
 *
 */
public class TestUtilitatsFirmaPlugin {

    protected final static Logger log = Logger.getLogger(TestUtilitatsFirmaPlugin.class);

    public static IValidateSignaturePlugin instantiatePlugin() throws Exception {
        Properties pluginProperties = new Properties();
        pluginProperties.load(new FileInputStream(new File("./utilitatsfirma.properties")));

        String propertyKeyBase = "org.sample.app.";

        IValidateSignaturePlugin plugin;
        plugin = new UtilitatsFirmaValidateSignaturePlugin(propertyKeyBase, pluginProperties);
        return plugin;
    }

    public static void main(String[] args) {
        try {

            //        Enumeration<URL> resEnum = TestEsborrar.class.getClassLoader().getResources("javax/xml/parsers/ParserConfigurationException.class");
            //        ArrayList<URL> resources = Collections.list(resEnum);
            //        for (Iterator<URL> iterator = resources.iterator(); iterator.hasNext();) {
            //            URL url = (URL) iterator.next();
            //            System.out.println(url);
            //        }
            //        

            System.setProperty("org.jboss.logging.provider", "log4j");

            long start = System.currentTimeMillis();

            System.out.println("  ==============================================");
            
            System.setProperty("es.gob.afirma.i18n.Language", "es_ES");
            

            IValidateSignaturePlugin plugin = instantiatePlugin();

            Properties p = new Properties();
            p.setProperty("executar", "6"); // Separat per comes

           
            
            
            // EIDAS
            p.setProperty("6.directori", ".\\fitxers_de_test\\eidas");
            
            // PADES amb segell de temps
            p.setProperty("10.directori", ".\\fitxers_de_test\\testsegelldetemps");


            p.setProperty("11.directori", ".\\fitxers_de_test\\limit_representant");

            p.setProperty("12.directori", ".\\fitxers_de_test\\testcaib");

            p.setProperty("13.directori", ".\\fitxers_de_test\\testcaib\\segelldetempsX3");
            

            p.setProperty("15.directori", ".\\fitxers_de_test\\personal");
            p.setProperty("16.directori", ".\\fitxers_de_test\\odt_docx");



            StringBuffer errors = new StringBuffer();
            StringBuffer oks = new StringBuffer();

            String[] tests = p.getProperty("executar").split(",");

            for (String tst : tests) {

                String doc = p.getProperty(tst + ".document");

                File docFile = null;
                if (doc != null) {
                    docFile = new File(doc);
                }

                File dir = new File(p.getProperty(tst + ".directori"));
                for (File signFile : dir.listFiles()) {

                    if (signFile.isDirectory()) {
                        continue;
                    }
                    String name = signFile.getName().toLowerCase();
                    if (name.endsWith(".pdf") || name.endsWith(".xsig") || name.endsWith(".csig") || name.endsWith(".odt")) {
                        // OK
                    } else if (name.endsWith(".result")) {
                        // Omitim resultats anteriors
                        continue;
                    } else {
                        System.out.println("Omitim fitxer " + name);
                        continue;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println(" ==============================================");
                    System.out.println("SIGN FILE ==> " + signFile.getAbsolutePath());
                    if (docFile != null) {
                        System.out.println("DOC FILE ==> " + docFile.getAbsolutePath());
                    }
                    try {
                        byte[] signatureData = FileUtils.readFromFile(signFile);
                        byte[] documentData = docFile != null ? FileUtils.readFromFile(docFile) : null;

                        ValidateSignatureResponse vsr = callToValidate(plugin, signatureData, documentData);
                        
                        {
                            File resultFile = new File(signFile.getAbsolutePath() + ".result");
                            // Instanciar Gson
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            Files.write(gson.toJson(vsr).getBytes(), resultFile);
                        }
                        

                        int status = vsr.getValidationStatus().getStatus();

                        if (status == ValidationStatus.SIGNATURE_VALID
                                || status == ValidationStatus.SIGNATURE_INVALID) {
                            oks.append(" ===================================================\n");
                            oks.append(" FILE: " + signFile.getName() + "\n");
                            oks.append(" ===================================================\n");

                            if (status == ValidationStatus.SIGNATURE_VALID) {
                                oks.append(" Status  => VALID\n");
                            } else {
                                oks.append(" Status  => INVALID\n");
                            }
                            oks.append(" ===================================================\n");
                            oks.append(" TYPE: " + vsr.getSignType() + "\n");
                            oks.append(" FORMAT: " + SignatureCommonUtils.signModeToString(vsr.getSignMode()) + "\n");
                            oks.append(" PROFILE: " + vsr.getSignProfile() + "\n");
                            oks.append(" ===================================================\n");
                            {

                                int ts = 0;

                                for (SignatureDetailInfo adi : vsr.getSignatureDetailInfo()) {
                                    oks.append("\n");
                                    oks.append(" ========= SIGNATURE [ " + ts + " ] ===========\n");

                                    oks.append("\t== SIGN_DATE: " + adi.getSignDate() + "\n");

                                    oks.append("\t== DIGESTVALUE: " + adi.getDigestValue() + "\n");

                                    oks.append("\t== CERT_INFO:\n");

                                    InformacioCertificat certInfo = adi.getCertificateInfo();

                                    oks.append("\t\t " + certInfo.toString().replaceAll("\n", "\n\t\t"));
                                    oks.append("\n");

                                    if (adi.getTimeStampInfo() != null) {
                                        oks.append("\t== TIMESTAMP_INFO:\n");
                                        TimeStampInfo tsi = adi.getTimeStampInfo();

                                        oks.append("\t\t\t TSINFO[getAlgorithm]: " + tsi.getAlgorithm() + "\n");
                                        oks.append("\t\t\t TSINFO[getCertificateIssuer]: " + tsi.getCertificateIssuer()
                                                + "\n");
                                        oks.append("\t\t\t TSINFO[getCertificateSubject]:" + tsi.getCertificateSubject()
                                                + "\n");
                                        oks.append("\t\t\t TSINFO[getCreationTime]: " + tsi.getCreationTime() + "\n");

                                        byte[] datacertificate = tsi.getCertificate();
                                        oks.append(
                                                "\t\t\t TSINFO[getCertificatet]: byte[] => " + datacertificate + "\n");

                                        if (tsi.getCertificate() != null) {
                                            X509Certificate cert = CertificateUtils
                                                    .decodeCertificate(new ByteArrayInputStream(datacertificate));

                                            oks.append("\t\t\t\t-getNotAfter" + cert.getNotAfter() + "\n");
                                            oks.append("\t\t\t\t-getNotBefore" + cert.getNotBefore() + "\n");
                                            oks.append("\t\t\t\t-getSerialNumber" + cert.getSerialNumber() + "\n");
                                        }

                                    }

                                    ts++;

                                }
                            }

                            oks.append("\n");

                        } else {
                            if (status == -1) {
                                errors.append(signFile.getName() + " => ERROR\t");
                            } else {
                                errors.append(signFile.getName() + " => INVALIDA");
                                errors.append("\tTYPE: " + vsr.getSignType());
                                errors.append("\tFORMAT: " + SignatureCommonUtils.signModeToString(vsr.getSignMode()));
                                errors.append("\tPROFILE: " + vsr.getSignProfile());
                            }

                            errors.append("\n");
                            errors.append("         ( " + vsr.getValidationStatus().getErrorMsg() + " )");
                            errors.append("\n");
                        }

                    } catch (Exception e) {
                        errors.append(signFile.getName() + " => ERROR NO CONTROLAT\t" + e.getMessage());
                        e.printStackTrace(System.err);
                        errors.append("\n");
                    }

                }

            }

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(oks.toString());
            System.err.println(errors.toString());

            System.out.println("TEMPS " + (System.currentTimeMillis() - start) + " ms");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

}
