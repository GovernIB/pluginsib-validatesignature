package org.fundaciobit.plugins.validatesignature.integra.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.plugins.validatesignature.api.ValidationStatus;
import org.fundaciobit.plugins.validatesignature.api.test.AbstractTestValidateSignature;
import org.fundaciobit.plugins.validatesignature.api.test.SignatureValidationTestResult;
import org.fundaciobit.plugins.validatesignature.integra.IntegraValidateSignaturePlugin;
import org.fundaciobit.pluginsib.core.test.TestUtils;

/**
 * 
 * @author anadal
 *
 */
public class TestIntegra extends AbstractTestValidateSignature {

  public IValidateSignaturePlugin instantiatePlugin() throws Exception {
    Properties pluginProperties = new Properties();

    String propertyKeyBase = "org.fundaciobit.exemple.base.";

    IValidateSignaturePlugin plugin;
    plugin = new IntegraValidateSignaturePlugin(propertyKeyBase, pluginProperties);
    return plugin;
  }
  
  protected Map<String, String[]> currentTests = null;
  
  public Map<String, String[]> getTests() {
    if (currentTests == null) {
      
      Map<String, String[]> tests = new TreeMap<String, String[]>(super.getTests());
      
      // TODO Com solucionar Això !!!!
      // ERROR Com és lògic no és un LTV
      // FIRMA_DOCUMENT[2][3] = ValidateSignatureResponse.SIGNPROFILE_PADES_LTV;
      // tests.get("peticioOK.pdf")[3] = ValidateSignatureResponse.SIGNPROFILE_PADES_LTV;
      
      // WARN És EPES + SegellDetemps 
      //FIRMA_DOCUMENT[6][3] = ValidateSignatureResponse.SIGNPROFILE_EPES;
      //tests.get("miniapplet_epes_segelltemps_catcert.pdf")[3] = ValidateSignatureResponse.SIGNPROFILE_EPES;
      
      // WARN És EPES + SegellDetemps 
      //FIRMA_DOCUMENT[7][3] = ValidateSignatureResponse.SIGNPROFILE_EPES;
      //tests.get("miniapplet_epes_segelltemps_afirma.pdf")[3] = ValidateSignatureResponse.SIGNPROFILE_EPES;
      
      
      // ERROR
      //tests.get("miniapplet_empleat_public.pdf")[3] = ValidateSignatureResponse.SIGNPROFILE_EPES;
      
      
      //FIRMA_DOCUMENT[8][3] = ValidateSignatureResponse.SIGNPROFILE_EPES; // ERROR
      currentTests = tests;
    }
    return currentTests;
  }
  
  
  
//  @org.junit.Test
//  public void testBasic() throws Exception {
//    
//    Map<String, SignatureValidationTestResult> results = internalTestBasic(false);
//    
//    System.out.println();
//    System.out.println();
//    System.out.flush();
//    
//    for (String key : results.keySet()) {
//      String msg = internalCheckTestBasicResults(results.get(key), key, false);
//      
//      if (msg == null) {
//        System.out.println("TEST[" + key + "] => OK");
//        System.out.flush();
//      } else {
//        System.err.println("TEST[" + key + "] => ERROR : " + msg);
//        System.err.flush();
//      }
//      
//    }
//    
//  }
  
  
  
  public static void main(String[] args) {
//    
//    try {
//      new TestIntegra().testBasic();
//    } catch (Exception e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    
//    }
  
	  TestIntegra tintegra = new TestIntegra();
      tintegra.testSignatures();
  
  }
  
  public String[] getSignatures() {
	    String signStr = TestUtils.getProperty("signatures");
	    if (signStr == null || signStr.trim().length() == 0) {
	      return new String[0];
	    } else {
	      return signStr.split(",");
	    }

	  }

	  public void testSignatures() {

	    String[] signs = getSignatures();
	    StringBuffer resultatOk = new StringBuffer();
	    StringBuffer resultatError = new StringBuffer();
	    
	    for (String signNumber : signs) {
	      System.out.println(" ---- " + signNumber + " -------");

	      String sigInfo = TestUtils.getProperty("firma." + signNumber);
	      String[] fields = sigInfo.split("\\|");

	      String signPath = fields[0];
	      String docPath = fields[1];
	      String status = fields[2];
	      String type = fields[3];
	      String format = fields[4];
	      String profile = fields[5];

	      
	      File signatureData = new File(signPath);
	      String name = signatureData.getName();
	      System.out.println("================ " + name);

	      File signedDocumentData = new File(docPath);

	      TypeFormatProfile expected = new TypeFormatProfile();
	      expected.setFormat(format);
	      expected.setProfile(profile);
	      expected.setType(type);

	      try {
	        ValidateSignatureResponse vresp = internalValidation(signatureData, signedDocumentData);
	        int statusActual = vresp.getValidationStatus().getStatus();
	        if (!status.equals(statusActual + "")) {
	          throw new Exception(
	              "Estat final diferent a l'esperat (Actual: " + statusActual + ") (Expected: " + status + ")");
	        }

	        if (statusActual != ValidationStatus.SIGNATURE_ERROR) {

	          if (!vresp.getSignFormat().equals(expected.getFormat())){
	            throw new Exception("Format de firma diferente al esperado (Actual: " + vresp.getSignFormat()
	                + ") (Expected: " + expected.getFormat() + ")");
	          }
	          if (!vresp.getSignProfile().equals(expected.getProfile())){
	            throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignProfile()
	                + ") (Expected: " + expected.getProfile() + ")");
	          }
	          if (!vresp.getSignType().equals(expected.getType())){
	            throw new Exception("Tipo de firma diferente al esperado (Actual: " + vresp.getSignType() + ") (Expected: "
	                + expected.getType() + ")");
	          }
	        }
	        resultatOk
	            .append(name + ": OK -> " + vresp.getSignType()+" | " + vresp.getSignFormat() +" | "+ vresp.getSignProfile() +" | "+ "\n");
	      } catch (Exception e) {
	        e.printStackTrace();
	        resultatError.append(name + " -> ERROR " + e.getMessage() + "\n");
	      }
	    }
	    
	    System.out.println(resultatOk.toString());
	    System.out.flush();
	    System.err.println(resultatError.toString());
	    System.err.flush();

	  }
  
	  private static ValidateSignatureResponse internalValidation(File signatureData, File signedDocumentData)
		      throws Exception {

		    Properties p = new Properties();
		    p.load(new FileInputStream("./conf/plugin_config.properties"));
		    String propertyKeyBase = "org.fundaciobit.exemple.";

		    IValidateSignaturePlugin api = new IntegraValidateSignaturePlugin(propertyKeyBase);

		    ValidateSignatureRequest vsr = new ValidateSignatureRequest();
		    ValidateSignatureResponse vresp;
		    if (signatureData != null) {
		      byte[] signedData = FileUtils.readFileToByteArray(signatureData);
		      vsr.setSignatureData(signedData);
		      if (signedDocumentData != null) {
		        byte[] documentData = FileUtils.readFileToByteArray(signedDocumentData);
		        vsr.setSignedDocumentData(documentData);
		      }
		      vsr.setLanguage("ca");

		      SignatureRequestedInformation sri = new SignatureRequestedInformation();
		      sri.setReturnSignatureTypeFormatProfile(true); // tipo format i resultat
		      sri.setReturnCertificateInfo(false);
		      sri.setReturnCertificates(false);
		      sri.setReturnValidationChecks(false);
		      sri.setValidateCertificateRevocation(false);
		      sri.setReturnTimeStampInfo(false);

		      vsr.setSignatureRequestedInformation(sri);
		      vresp = api.validateSignature(vsr);

		      final boolean debug = false;

		      if (debug) {
		        StringWriter writer = new StringWriter();
		        JAXBContext context = JAXBContext.newInstance(ValidateSignatureResponse.class);
		        Marshaller m = context.createMarshaller();
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		        m.marshal(new JAXBElement<ValidateSignatureResponse>(new QName(ValidateSignatureResponse.class.getSimpleName()),
		            ValidateSignatureResponse.class, vresp), writer);
		        System.out.println(writer.toString());
		        FileOutputStream fos = new FileOutputStream(new File(signatureData.getName() + "_validation.xml"));
		        fos.write(writer.toString().getBytes());
		        fos.close();
		      }
		    } else {
		      vresp = null;
		    }
		    return vresp;
		  }

}
