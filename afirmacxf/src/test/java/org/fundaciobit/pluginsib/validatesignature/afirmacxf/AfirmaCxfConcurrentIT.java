package org.fundaciobit.pluginsib.validatesignature.afirmacxf;


import org.fundaciobit.pluginsib.utils.signature.SignatureConstants;
import org.fundaciobit.pluginsib.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus.SIGNATURE_INVALID;
import static org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus.SIGNATURE_VALID;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author anadal
 * 6 nov 2024 8:38:45
 */
public class AfirmaCxfConcurrentIT extends BaseIT implements SignatureConstants {

    private static IValidateSignaturePlugin plugin;

    private static final Map<String, ExpectedValidation> tests = new HashMap<>();

    @BeforeClass
    public static void setup() throws Exception {

        Properties pluginProperties = new Properties();
        pluginProperties.load(new FileInputStream("./config/plugin.properties"));
        String propertyKeyBase = "org.fundaciobit.exemple.base.";

        plugin = new AfirmaCxfValidateSignaturePlugin(propertyKeyBase, pluginProperties);

        tests.put("/firmes/pdf-1signed.pdf", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SignatureConstants.SIGN_MODE_ATTACHED_ENVELOPED, 1));

        tests.put("/firmes/pdf-2signed.pdf", new ExpectedValidation(SIGNATURE_INVALID,
                SIGNTYPE_PAdES, SIGNPROFILE_BES, SignatureConstants.SIGN_MODE_ATTACHED_ENVELOPED, 2));

        tests.put("/firmes/Document.txt_asigned.csig", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_CAdES, SIGNPROFILE_BES, SignatureConstants.SIGN_MODE_ATTACHED_ENVELOPING, 1));

        tests.put("/firmes/dibuix.png_acosigned.csig", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_CAdES, SIGNPROFILE_BES, SignatureConstants.SIGN_MODE_DETACHED, 2));

        tests.put("/firmes/pdf-xades-signat-cosignat.xsig", new ExpectedValidation(SIGNATURE_VALID,
                SIGNTYPE_XAdES, SIGNPROFILE_BES, SignatureConstants.SIGN_MODE_DETACHED, 2));
    }


    @Test
    @Ignore
    public void testValidacio() {

        System.out.println("iniciant warmapp");
        // WARMMMM
        for (final String file : tests.keySet()) {
            try {
                testValidacio(file, tests.get(file));
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail();
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(30);

        final AtomicInteger firmes = new AtomicInteger(0);

        System.out.println("iniciant test");

        long startTime = System.nanoTime();

        int interations = 10;

        for (int i = 0; i < interations; i++) {
            for (final String file : tests.keySet()) {
                executor.submit(() -> {
                    try {
                        testValidacio(file, tests.get(file));
                        firmes.incrementAndGet();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long duration = System.nanoTime() - startTime;
        System.out.printf("Firmes: %d%n", firmes.get());
        System.out.printf("Duració: %d ms.%n", TimeUnit.NANOSECONDS.toMillis(duration));

        Assert.assertEquals(tests.keySet().size() * interations, firmes.get());

    }

    private void testValidacio(String file, ExpectedValidation expectedValidation) throws Exception {
        ValidateSignatureRequest request = new ValidateSignatureRequest();
        request.setSignatureData(getResource(file));

        SignatureRequestedInformation sri = new SignatureRequestedInformation();
        sri.setReturnSignatureTypeFormatProfile(true);
        sri.setReturnCertificateInfo(true);

        request.setSignatureRequestedInformation(sri);
        ValidateSignatureResponse response = plugin.validateSignature(request);

        checkResponse(expectedValidation, response);
    }

}
