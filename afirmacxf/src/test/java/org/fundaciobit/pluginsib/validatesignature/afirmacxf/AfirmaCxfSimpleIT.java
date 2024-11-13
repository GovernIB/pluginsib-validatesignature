package org.fundaciobit.pluginsib.validatesignature.afirmacxf;

import org.fundaciobit.pluginsib.utils.signature.SignatureConstants;
import org.fundaciobit.pluginsib.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author anadal
 * 6 nov 2024 7:36:55
 */
public class AfirmaCxfSimpleIT extends BaseIT implements SignatureConstants {

    private static IValidateSignaturePlugin plugin;

    @BeforeClass
    public static void setup() throws Exception {
        Properties pluginProperties = new Properties();
        pluginProperties.load(new FileInputStream("./config/plugin.properties"));
        String propertyKeyBase = "org.fundaciobit.exemple.base.";

        plugin = new AfirmaCxfValidateSignaturePlugin(propertyKeyBase, pluginProperties);
    }

    @Test
    public void testPdf1Signed() throws Exception {
        testValidacio("/firmes/pdf-1signed.pdf", new ExpectedValidation(ValidationStatus.SIGNATURE_VALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGN_MODE_ATTACHED_ENVELOPED, 1));
    }

    @Test
    public void testPdf2Signed() throws Exception {
        testValidacio("/firmes/pdf-2signed.pdf", new ExpectedValidation(ValidationStatus.SIGNATURE_INVALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGN_MODE_ATTACHED_ENVELOPED, 2));
    }
    @Test
    public void testDocumentAsigned() throws Exception {
        testValidacio("/firmes/Document.txt_asigned.csig", new ExpectedValidation(ValidationStatus.SIGNATURE_VALID,
                SIGNTYPE_CAdES, SIGNPROFILE_BES, SIGN_MODE_ATTACHED_ENVELOPING, 1));
    }

    @Test
    public void testDibuixACosigned() throws Exception {
        testValidacio("/firmes/dibuix.png_acosigned.csig", new ExpectedValidation(ValidationStatus.SIGNATURE_VALID,
                SIGNTYPE_CAdES, SIGNPROFILE_BES, SIGN_MODE_ATTACHED_ENVELOPING, 2));
    }

    @Test
    public void testXadesSignedCosigned() throws Exception {
        testValidacio("/firmes/pdf-xades-signat-cosignat.xsig", new ExpectedValidation(ValidationStatus.SIGNATURE_VALID,
                SIGNTYPE_XAdES, SIGNPROFILE_BES, SIGN_MODE_DETACHED, 2));
    }

    @Test
    public void testPdfRepSigned() throws Exception {
        testValidacio("/firmes/pdf_rep_signed.pdf", new ExpectedValidation(ValidationStatus.SIGNATURE_INVALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGN_MODE_ATTACHED_ENVELOPED, 1));
    }

    @Test
    public void testPdfRepSigned2() throws Exception {
        testValidacio("/firmes/pdf_rep_signed2.pdf", new ExpectedValidation(ValidationStatus.SIGNATURE_VALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGN_MODE_ATTACHED_ENVELOPED, 1));
    }

    protected void testValidacio(String file, ExpectedValidation expectedValidation) throws Exception {
        ValidateSignatureRequest request = new ValidateSignatureRequest();
        request.setSignatureData(getResource(file));

        SignatureRequestedInformation sri = new SignatureRequestedInformation();
        sri.setReturnSignatureTypeFormatProfile(true);
        sri.setReturnCertificateInfo(true);
        sri.setReturnTimeStampInfo(true);

        request.setSignatureRequestedInformation(sri);
        ValidateSignatureResponse response = plugin.validateSignature(request);

        checkResponse(expectedValidation, response);
    }

}
