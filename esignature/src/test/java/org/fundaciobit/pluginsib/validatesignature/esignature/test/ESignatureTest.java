package org.fundaciobit.pluginsib.validatesignature.esignature.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.fundaciobit.pluginsib.core.test.TestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.Certificate2;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.Certificate3;
import org.fundaciobit.pluginsib.validatesignature.esignature.ws.SimpleReport;
import org.fundaciobit.pluginsib.validatesignature.esignature.ESignatureValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.esignature.TypeFormatProfile;
import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.plugins.validatesignature.api.ValidationStatus;

public class ESignatureTest {

  public static final Logger log = Logger.getLogger(ESignatureTest.class);

  public static void main(String[] args) {
    try {
      ESignatureTest tester = new ESignatureTest();

      // tester.testSignaturesCades();
      tester.testSignatures();

      // tester.testAttachedPades();
      // tester.testDetachedXades();
      // tester.testDetachedCades();
      // tester.testAttachedXadesOrve();

    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Error desconegut: " + e.getMessage());
    }
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


  public void testAttachedXadesOrve() throws Exception {

    HashMap<String, TypeFormatProfile> tfpMap = new HashMap<String, TypeFormatProfile>();
    File signedDocumentData = new File("foto.jpg");

    TypeFormatProfile tf_bes = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_XAdES,
        ValidateSignatureResponse.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, ValidateSignatureResponse.SIGNPROFILE_BES);
    tfpMap.put("ORVE_firma0.xsig", tf_bes);

    StringBuffer resultatOk = new StringBuffer();
    StringBuffer resultatError = new StringBuffer();

    File dir = new File("./resultsXAdESORVE");
    File[] docus = dir.listFiles();

    for (int i = 0; i < docus.length; i++) {

      File signatureData = docus[i];
      String name = signatureData.getName();
      System.out.println("================ " + name);

      TypeFormatProfile expected = tfpMap.get(name);

      try {
        ValidateSignatureResponse vresp = internalValidation(signatureData, signedDocumentData);
        System.out.println("Nom del fitxer: " + docus[0].getName());
        System.out.println("Type: " + vresp.getSignType());
        if (vresp.getSignFormat() != expected.getFormat()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignFormat()
              + ") (Expected: " + expected.getFormat() + ")");
        }
        if (vresp.getSignProfile() != expected.getProfile()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignProfile()
              + ") (Expected: " + expected.getProfile() + ")");
        }
        if (vresp.getSignType() != expected.getType()) {
          throw new Exception("Tipo de firma diferente al esperado (Actual: " + vresp.getSignType() + ") (Expected: "
              + expected.getType() + ")");
        }

        resultatOk
            .append(name + " -> OK " + vresp.getSignType() + vresp.getSignFormat() + vresp.getSignProfile() + "\n");
        System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|OK|"
            + vresp.getSignType() + "|" + vresp.getSignFormat() + "|" + vresp.getSignProfile());
      } catch (Exception e) {
        e.printStackTrace();
        resultatError.append(name + " -> ERROR " + e.getMessage() + "\n");
      }
    }
  }

  public void testAttachedPades() throws Exception {

    HashMap<String, TypeFormatProfile> tfpMap = new HashMap<String, TypeFormatProfile>();
    File signedDocumentData = new File("foto.jpg");

    TypeFormatProfile tf_ltv = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_PAdES,
        ValidateSignatureResponse.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED,
        ValidateSignatureResponse.SIGNPROFILE_PADES_LTV);
    tfpMap.put("hola.pdf_upgraded_to_PAdES_LTA_LEVEL.pdf", tf_ltv);
    tfpMap.put("hola.pdf_upgraded_to_PAdES_LTV.pdf", tf_ltv);
    tfpMap.put("hola.pdf_upgraded_to_PAdES_LT_LEVEL.pdf", tf_ltv);

    TypeFormatProfile tf_t = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_PAdES,
        ValidateSignatureResponse.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, ValidateSignatureResponse.SIGNPROFILE_T);
    tfpMap.put("miniapplet_epes_segelltemps_afirma.pdf", tf_t);
    tfpMap.put("PADES_T.pdf", tf_t);

    TypeFormatProfile tf_bes = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_PAdES,
        ValidateSignatureResponse.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, ValidateSignatureResponse.SIGNPROFILE_BES);
    tfpMap.put("PADES_BES.pdf", tf_bes);

    TypeFormatProfile tf_epes = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_PAdES,
        ValidateSignatureResponse.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, ValidateSignatureResponse.SIGNPROFILE_EPES);
    tfpMap.put("PADES_EPES.pdf", tf_epes);

    TypeFormatProfile tf_pkcs = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_PAdES,
        ValidateSignatureResponse.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, ValidateSignatureResponse.SIGNPROFILE_T);
    tfpMap.put("justificante.pdf", tf_pkcs);

    StringBuffer resultatOk = new StringBuffer();
    StringBuffer resultatError = new StringBuffer();

    File dir = new File("./resultsPDF");
    File[] docus = dir.listFiles();

    for (int i = 0; i < docus.length; i++) {

      File signatureData = docus[i];
      String name = signatureData.getName();
      System.out.println("================ " + name);

      TypeFormatProfile expected = tfpMap.get(name);

      try {
        ValidateSignatureResponse vresp = internalValidation(signatureData, signedDocumentData);

        int status = vresp.getValidationStatus().getStatus();
        switch (status) {

        case ValidationStatus.SIGNATURE_VALID:
          System.out.println("firma.x=" + dir.getName()+"/"+name+"|"+signedDocumentData.getName()+"|VALID|"
              +vresp.getSignType()+"|"+vresp.getSignFormat()+"|"+vresp.getSignProfile());
          break;

        case ValidationStatus.SIGNATURE_INVALID:
          System.out.println("firma.x="+dir.getName()+"/"+name+"|"+signedDocumentData.getName()+"|INVALID|"
              +vresp.getSignType()+"|"+vresp.getSignFormat()+"|"+vresp.getSignProfile());
          break;

        case ValidationStatus.SIGNATURE_ERROR:
          System.out.println("firma.x=" + dir.getName()+"/"+name+"|"+signedDocumentData.getName()+"|ERROR|"
              +"null|null|null");
          break;
        }

        if (vresp.getSignFormat() != expected.getFormat()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: "+vresp.getSignFormat()
              +") (Expected: "+expected.getFormat()+")");
        }
        if (vresp.getSignProfile() != expected.getProfile()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignProfile()
              + ") (Expected: " + expected.getProfile() + ")");
        }
        if (vresp.getSignType() != expected.getType()) {
          throw new Exception("Tipo de firma diferente al esperado (Actual: " + vresp.getSignType() + ") (Expected: "
              + expected.getType() + ")");
        }

        resultatOk
            .append(name + " -> OK " + vresp.getSignType() + vresp.getSignFormat() + vresp.getSignProfile() + "\n");

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

  public void testDetachedXades() throws Exception {

    HashMap<String, TypeFormatProfile> tfpMap = new HashMap<String, TypeFormatProfile>();
    File signedDocumentData = new File("foto.jpg");

    TypeFormatProfile tf_a = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_XAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_A);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_A.xsig", tf_a);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_LTA_LEVEL.xsig", tf_a);

    TypeFormatProfile tf_t = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_XAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_T);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_C.xsig", tf_t);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_T.xsig", tf_t);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_T_LEVEL.xsig", tf_t);

    TypeFormatProfile tf_x1 = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_XAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_X1);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_X.xsig", tf_x1);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_X1.xsig", tf_x1);

    TypeFormatProfile tf_x2 = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_XAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_X2);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_X2.xsig", tf_x2);

    TypeFormatProfile tf_xl1 = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_XAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_XL1);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_LT_LEVEL.xsig", tf_xl1);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_XL.xsig", tf_xl1);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_XL1.xsig", tf_xl1);
    tfpMap.put("foto_xades_attached_UpgradedTo_XAdES_XL2.xsig", tf_xl1);

    StringBuffer resultatOk = new StringBuffer();
    StringBuffer resultatError = new StringBuffer();

    File dir = new File("./resultsXAdES");
    File[] docus = dir.listFiles();

    for (int i = 0; i < docus.length; i++) {

      File signatureData = docus[i];
      String name = signatureData.getName();
      System.out.println("================ " + name);

      TypeFormatProfile expected = tfpMap.get(name);

      try {
        ValidateSignatureResponse vresp = internalValidation(signatureData, signedDocumentData);

        int status = vresp.getValidationStatus().getStatus();
        switch (status) {

        case ValidationStatus.SIGNATURE_VALID:
          System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|VALID|"
              + vresp.getSignType() + "|" + vresp.getSignFormat() + "|" + vresp.getSignProfile());
          break;

        case ValidationStatus.SIGNATURE_INVALID:
          System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|INVALID|"
              + vresp.getSignType() + "|" + vresp.getSignFormat() + "|" + vresp.getSignProfile());
          break;

        case ValidationStatus.SIGNATURE_ERROR:
          System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|ERROR|"
              + "null|null|null");
          break;
        }

        if (vresp.getSignFormat() != expected.getFormat()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignFormat()
              + ") (Expected: " + expected.getFormat() + ")");
        }
        if (vresp.getSignProfile() != expected.getProfile()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignProfile()
              + ") (Expected: " + expected.getProfile() + ")");
        }
        if (vresp.getSignType() != expected.getType()) {
          throw new Exception("Tipo de firma diferente al esperado (Actual: " + vresp.getSignType() + ") (Expected: "
              + expected.getType() + ")");
        }

        resultatOk
            .append(name + " -> OK " + vresp.getSignType() + vresp.getSignFormat() + vresp.getSignProfile() + "\n");

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

  public void testDetachedCades() throws Exception {
    HashMap<String, TypeFormatProfile> tfpMap = new HashMap<String, TypeFormatProfile>();
    File signedDocumentData = new File("foto.jpg");

    TypeFormatProfile tf_a = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_CAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_A);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_A.csig", tf_a);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_LTA_LEVEL.csig", tf_a);

    TypeFormatProfile tf_t = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_CAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_T);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_T.csig", tf_t);

    TypeFormatProfile tf_x1 = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_CAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_X1);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_X1.csig", tf_x1);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_X2.csig", tf_x1);

    TypeFormatProfile tf_xl1 = new TypeFormatProfile(ValidateSignatureResponse.SIGNTYPE_CAdES,
        ValidateSignatureResponse.SIGNFORMAT_EXPLICIT_DETACHED, ValidateSignatureResponse.SIGNPROFILE_XL1);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_LT_LEVEL.csig", tf_xl1);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_XL.csig", tf_xl1);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_XL1.csig", tf_xl1);
    tfpMap.put("foto.jpg_cades_detached_UpgradedTo_CAdES_XL2.csig", tf_xl1);

    StringBuffer resultatOk = new StringBuffer();
    StringBuffer resultatError = new StringBuffer();

    File dir = new File("./resultsCAdES");
    File[] docus = dir.listFiles();

    for (int i = 0; i < docus.length; i++) {

      File signatureData = docus[i];
      String name = signatureData.getName();
      System.out.println("================ " + name);

      TypeFormatProfile expected = tfpMap.get(name);

      try {
        ValidateSignatureResponse vresp = internalValidation(signatureData, signedDocumentData);

        int status = vresp.getValidationStatus().getStatus();
        switch (status) {

        case ValidationStatus.SIGNATURE_VALID:
          System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|VALID|"
              + vresp.getSignType() + "|" + vresp.getSignFormat() + "|" + vresp.getSignProfile());
          break;

        case ValidationStatus.SIGNATURE_INVALID:
          System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|INVALID|"
              + vresp.getSignType() + "|" + vresp.getSignFormat() + "|" + vresp.getSignProfile());
          break;

        case ValidationStatus.SIGNATURE_ERROR:
          System.out.println("firma.x=" + dir.getName() + "/" + name + "|" + signedDocumentData.getName() + "|ERROR|"
              + "null|null|null");
          break;
        }

        if (vresp.getSignFormat() != expected.getFormat()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignFormat()
              + ") (Expected: " + expected.getFormat() + ")");
        }
        if (vresp.getSignProfile() != expected.getProfile()) {
          throw new Exception("Perfil de firma diferente al esperado (Actual: " + vresp.getSignProfile()
              + ") (Expected: " + expected.getProfile() + ")");
        }
        if (vresp.getSignType() != expected.getType()) {
          throw new Exception("Tipo de firma diferente al esperado (Actual: " + vresp.getSignType() + ") (Expected: "
              + expected.getType() + ")");
        }

        resultatOk
            .append(name + " -> OK " + vresp.getSignType() + vresp.getSignFormat() + vresp.getSignProfile() + "\n");

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
    p.load(new FileInputStream("./config/config.properties"));
    String propertyKeyBase = "org.fundaciobit.exemple.";

    IValidateSignaturePlugin api = new ESignatureValidateSignaturePlugin(propertyKeyBase, p);

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
      sri.setReturnCertificateInfo(true);
      sri.setReturnCertificates(true);
      sri.setReturnValidationChecks(true);
      sri.setValidateCertificateRevocation(true);
      sri.setReturnTimeStampInfo(true);

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

  private static void printSimpleReport(org.fundaciobit.pluginsib.validatesignature.esignature.ws.WsReportsDTO ret) {

    System.out.println("RESULTAT DE FIRMA");
    SimpleReport simple = ret.getSimpleReport();

    System.out.println("Document Name: " + simple.getDocumentName());
    System.out.println("Estat de firma: " + simple.getValidSignaturesCount() + " signatures correctes de "
        + (simple.getSignaturesCount() - ret.getSimpleReport().getValidSignaturesCount()));
    System.out
        .println("Firmes incorrectes: " + (simple.getSignaturesCount() - simple.getValidSignaturesCount()) + "\n");

    if (simple.getSignaturesCount() == 0) {
      System.out.println("NOT_PASSED");
    } else if (simple.getSignaturesCount() == simple.getValidSignaturesCount()) {
      System.out.println("TOTAL_PASSED");
    } else {
      System.out.println("PARTIAL_PASSED");
    }

    System.out.println("Format de firma: " + (simple.getSignature().get(0).getSignatureFormat()));
    System.out.println("Cadena de certificat: " + (simple.getSignature().get(0).getSignedBy()));
    System.out.println("Id de certificat: " + (simple.getSignature().get(0).getId()));

    System.out.println("Politica de firma: " + (simple.getPolicy().getPolicyName()));
    System.out.println("Contsancia de firma: " + simple.getSignature().get(0).getBestSignatureTime());

    System.out.println("Politica: " + simple.getPolicy());
    System.out.println("Hora de validacio: " + simple.getValidationTime());

  }

  private static void printCertificateInfo(org.fundaciobit.pluginsib.validatesignature.esignature.ws.WsReportsDTO ret) {
    for (Certificate3 cert : ret.getDiagnosticData().getUsedCertificates().getCertificate()) {
      System.out.println("-Nombre del certificado:" + cert.getCommonName());
      System.out.println("Pais: " + cert.getCountryName());
      System.out.println("E-mail: " + cert.getEmail());
      System.out.println("Localidad: " + cert.getLocality());
      System.out.println("ID: " + cert.getId());
      System.out.println("Unitat organitzativa: " + cert.getOrganizationalUnit());
      System.out.println("Nom de la organitzacio: " + cert.getOrganizationName());
      System.out.println("Authority Informaton Access URL: " + cert.getAuthorityInformationAccessUrls());
    }
  }

  private static void logReport(org.fundaciobit.pluginsib.validatesignature.esignature.ws.WsReportsDTO ret) {

    try {
      Writer writer = new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream("src/test/resources/log.txt"), "utf-8"));
      writer.close();
    } catch (Exception e) {

    }

  }

  /*
   * private static void validateDoc(File f, SoapDocumentValidationService
   * validationService, MimeType mt) throws IOException {
   * 
   * byte[] b = FileUtils.readFileToByteArray(f); RemoteDocument rem = new
   * RemoteDocument(); rem.setBytes(b); rem.setDigestAlgorithm(null);
   * rem.setMimeType(mt); rem.setName(f.getName());
   * 
   * org.fundaciobit.pluginsib.validatesignature.esignature.ws.DataToValidateDTO
   * dataToValidateDTO = new DataToValidateDTO();
   * dataToValidateDTO.setSignedDocument(rem);
   * dataToValidateDTO.setOriginalDocument(null);
   * dataToValidateDTO.setPolicy(null);
   * 
   * org.fundaciobit.pluginsib.validatesignature.esignature.ws.WsReportsDTO ret;
   * ret = validationService.validateSignature(dataToValidateDTO);
   * log.info("**REPORT**\n"); }
   */

  /*
   * public static void main2(String[] args) { try { // Adreça servidor final
   * String endpointBase = "http://localhost:8080/services/soap/"; //Construcio
   * del servei SoapDocumentValidationService validationService; { String endpoint
   * = endpointBase + "validation"; SoapDocumentValidationServiceImplService
   * service; URL wsdl = new URL(endpoint + "?wsdl"); service = new
   * SoapDocumentValidationServiceImplService(wsdl); validationService =
   * service.getSoapDocumentValidationServiceImplPort(); Map<String, Object>
   * reqContext; reqContext = ((BindingProvider)
   * validationService).getRequestContext();
   * reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint); }
   * 
   * //Arxius a validar: File f1 = new File("src/test/resources/XAdESLTA.xml");
   * validateDocXml(f1,validationService); File f2= new
   * File("src/test/resources/hola_signat.pdf");
   * validateDocPdf(f2,validationService); File f3 = new
   * File("src/test/resources/Test_7_RESULT_WARN.pdf");
   * validateDocPdf(f3,validationService);
   * 
   * try {}finally {} }catch (Exception e) {
   * System.err.println("Error desconegut: " + e.getMessage()); }
   * 
   * }
   */

}
