package org.fundaciobit.plugins.validatesignature.afirmacxf.test;

import org.fundaciobit.plugins.validatesignature.afirmacxf.AfirmaCxfValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNFORMAT_EXPLICIT_DETACHED;
import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED;
import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNFORMAT_IMPLICIT_ENVELOPING_ATTACHED;
import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNPROFILE_BES;
import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNTYPE_CAdES;
import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNTYPE_PAdES;
import static org.fundaciobit.plugins.validatesignature.api.ValidateSignatureConstants.SIGNTYPE_XAdES;
import static org.fundaciobit.plugins.validatesignature.api.ValidationStatus.SIGNATURE_INVALID;
import static org.fundaciobit.plugins.validatesignature.api.ValidationStatus.SIGNATURE_VALID;

public class AfirmaCxfSimpleIT extends BaseAfirmaCxfIT {

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
        testValidacio("/firmes/pdf-1signed.pdf", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, 1));
    }

    @Test
    public void testPdf2Signed() throws Exception {
        testValidacio("/firmes/pdf-2signed.pdf", new ExpectedValidation(SIGNATURE_INVALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, 2));
    }
    @Test
    public void testDocumentAsigned() throws Exception {
        testValidacio("/firmes/Document.txt_asigned.csig", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_CAdES, SIGNPROFILE_BES, SIGNFORMAT_IMPLICIT_ENVELOPING_ATTACHED, 1));
    }

    @Test
    public void testDibuixACosigned() throws Exception {
        testValidacio("/firmes/dibuix.png_acosigned.csig", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_CAdES, SIGNPROFILE_BES, SIGNFORMAT_IMPLICIT_ENVELOPING_ATTACHED, 2));
    }

    @Test
    public void testXadesSignedCosigned() throws Exception {
        testValidacio("/firmes/pdf-xades-signat-cosignat.xsig", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_XAdES, SIGNPROFILE_BES, SIGNFORMAT_EXPLICIT_DETACHED, 2));
    }

    @Test
    public void testPdfRepSigned() throws Exception {
        testValidacio("/firmes/pdf_rep_signed.pdf", new ExpectedValidation(SIGNATURE_INVALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, 1));
    }

    @Test
    public void testPdfRepSigned2() throws Exception {
        testValidacio("/firmes/pdf_rep_signed2.pdf", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SIGNFORMAT_IMPLICIT_ENVELOPED_ATTACHED, 1));
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
