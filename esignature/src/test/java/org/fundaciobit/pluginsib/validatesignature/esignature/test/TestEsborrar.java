package org.fundaciobit.pluginsib.validatesignature.esignature.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.fundaciobit.plugins.certificate.InformacioCertificat;
import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.SignatureDetailInfo;
import org.fundaciobit.plugins.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.fundaciobit.pluginsib.validatesignature.esignature.ESignatureValidateSignaturePlugin;

/**
 * 
 * @author anadal(u80067)
 *
 */
public class TestEsborrar {

  public static IValidateSignaturePlugin instantiatePlugin() throws Exception {
    Properties pluginProperties = new Properties();
    pluginProperties.load(new FileInputStream(new File("./config/config.properties")));
    String propertyKeyBase = "org.fundaciobit.exemple.";

    IValidateSignaturePlugin plugin;
    plugin = new ESignatureValidateSignaturePlugin(propertyKeyBase, pluginProperties);
    return plugin;
  }
  
   
  

  public static void main(String[] args) {
    try {

      IValidateSignaturePlugin plugin = instantiatePlugin();

      Properties p = new Properties();
      p.setProperty("executar", "1"); // Separat per comes

      // PADES
      p.setProperty("1.directori",  ".\\resultsPDF");
      // CADES
      p.setProperty("2.directori",   ".\\resultsCAdES");
      p.setProperty("2.document", ".\\foto.jpg");
      // XADES
      p.setProperty("3.directori",".\\resultsXAdES");
      
      // XADES ORVE
      p.setProperty("4.directori", ".\\resultsXAdESORVE");
      

      StringBuffer errors = new StringBuffer();
      StringBuffer oks = new StringBuffer();

      String[] tests = p.getProperty("executar").split(",");

      for (String tst : tests) {

        File dir = new File(p.getProperty(tst + ".directori"));

        String doc = p.getProperty(tst + ".document");

        byte[] documentData = null;
        if (doc != null) {
          documentData = FileUtils.readFromFile(new File(doc));
        }

        for (File signFile : dir.listFiles()) {
          
          if (signFile.isDirectory()) {
            continue;
          }
          
          try {
            byte[] signatureData = FileUtils.readFromFile(signFile);

            ValidateSignatureResponse vsr = callToValidate(plugin, signatureData, documentData);

            int status = vsr.getValidationStatus().getStatus();

            if (status == 1) {
              oks.append(signFile.getName() + " => VALID");

              oks.append("\tTYPE: " + vsr.getSignType());
              oks.append("\tFORMAT: " + vsr.getSignFormat());
              oks.append("\tPROFILE: " + vsr.getSignProfile());
              oks.append("\n");

            } else {
              if (status == -1) {
                errors.append(signFile.getName() + " => ERROR\t");
              } else {
                errors.append(signFile.getName() + " => INVALIDA");
                errors.append("\tTYPE: " + vsr.getSignType());
                errors.append("\tFORMAT: " + vsr.getSignFormat());
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

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main33(String[] args) {
    try {
      new TestEsborrar().run();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void run() throws Exception {

    IValidateSignaturePlugin plugin = instantiatePlugin();

    // byte[] signature = FileUtils.toByteArray(new FileInputStream(new
    // File("foto_xades_attached.xml")));
    // File fs = new File("hola_signat.pdf");
    // File fs = new File("PADES_LTV.pdf");
    // File fs = new File("foto_xades_attached_firmat.xsig");
    //File fs = new File("ORVE_firma0.xsig");
    
    //File fs = new File("..\\..\\portafib-2.0\\plugins-signatureserver\\afirmaserver\\resultsXAdES\\foto_xades_attached_UpgradedTo_XAdES_A.xsig");
    File fs = new File("..\\..\\portafib-2.0\\plugins-signatureserver\\afirmaserver\\resultsXAdES\\foto_xades_attached_UpgradedTo_XAdES_LTA_LEVEL.xsig");

    byte[] signature = FileUtils.toByteArray(new FileInputStream(fs));
    // byte[] document = FileUtils.toByteArray(new FileInputStream(new
    // File("ORVE_0Cert_pag_signat.pdf")));
    // byte[] document = FileUtils.toByteArray(new FileInputStream(new File("pom.xml")));

    // byte[] signature = FileUtils.toByteArray(new FileInputStream(new
    // File("peticioOK.pdf")));
    // byte[] signature = FileUtils.toByteArray(new FileInputStream(new
    // File("foto_xades_attached.xml")));
    byte[] document = null;

    // byte[] signature = FileUtils.toByteArray(new FileInputStream(new
    // File("2018-01-24_CAdES_Detached_foto_jpg.csig")));
    // byte[] document = FileUtils.toByteArray(new FileInputStream(new File("foto.jpg")));

    // byte[] signature = FileUtils.toByteArray(new FileInputStream(new
    // File("D:\\dades\\dades\\CarpetesPersonals\\ProgramacioPortaFIB2\\portafib-2.0\\apifirmasimple\\apifirmasimple\\"
    // + "signed_adaptat.pdf")));
    // + "BIG_19_Firmat.pdf")));
    // + "TEST_4_SegellTemps_ALGO_384_amb_politica_de_firma_AGE_1.9.pdf")));
    // + "hola_signed_SHA256.pdf")));
    // + "TEST_1_signed_adaptat_sense_politica.pdf")));

    // byte[] document = null; //FileUtils.toByteArray(new FileInputStream(new
    // File("foto.jpg")));
    ValidateSignatureResponse vs = callToValidate(plugin, signature, document);

    System.out
        .println("LLEGENDA: SIGNATURE_VALID = 1 | SIGNATURE_ERROR = -1 | SIGNATURE_INVALID = -2");

    System.out.println(" ESTAT VALIDACIO: " + vs.getValidationStatus().getStatus());

    System.out.println(" SIGN TYPE: " + vs.getSignType());
    System.out.println(" SIGN FORMAT: " + vs.getSignFormat());
    System.out.println(" SIGN PROFILE: " + vs.getSignProfile());

    if (vs.getSignatureDetailInfo() != null) {
      for (SignatureDetailInfo info : vs.getSignatureDetailInfo()) {

        InformacioCertificat ci = info.getCertificateInfo();

        if (ci != null) {
           System.out.println("***[EMISSOR: " + ci.getEmissorID() + "]***");
        }

      }
    }

    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(ValidateSignatureResponse.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    m.marshal(new JAXBElement<ValidateSignatureResponse>(new QName(ValidateSignatureResponse.class.getSimpleName()),
        ValidateSignatureResponse.class, vs), writer);
    // System.out.println(writer.toString());
    FileOutputStream fos = new FileOutputStream(new File(fs.getName() + "_validation.xml"));
    fos.write(writer.toString().getBytes());
    fos.close();

  }

  private static ValidateSignatureResponse callToValidate(IValidateSignaturePlugin plugin,
      byte[] signature, byte[] document) throws Exception {
    ValidateSignatureResponse vs;
    ValidateSignatureRequest validationRequest = new ValidateSignatureRequest();

    validationRequest.setSignatureData(signature);
    validationRequest.setSignedDocumentData(document);

    SignatureRequestedInformation sri = new SignatureRequestedInformation();
    sri.setReturnSignatureTypeFormatProfile(true);
    sri.setReturnCertificateInfo(false);
    sri.setReturnCertificates(false);
    sri.setReturnValidationChecks(false);
    sri.setValidateCertificateRevocation(false);
    sri.setReturnTimeStampInfo(false);

    validationRequest.setSignatureRequestedInformation(sri);

    vs = plugin.validateSignature(validationRequest);
    return vs;
  }

}
