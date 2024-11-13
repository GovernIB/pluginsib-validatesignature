package org.fundaciobit.pluginsib.validatesignature.afirmacxf;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.fundaciobit.pluginsib.core.v3.utils.FileUtils;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.junit.Assert;

import java.security.Security;

/**
 * 
 * @author anadal
 * 5 nov 2024 8:05:33
 */
public abstract class BaseIT {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    protected byte[] getResource(String path) throws Exception {
        return FileUtils.toByteArray(getClass().getResourceAsStream(path));
    }

    protected void checkResponse(ExpectedValidation expected, ValidateSignatureResponse response) {
        Assert.assertEquals(expected.validationStatus, response.getValidationStatus().getStatus());
        Assert.assertEquals(expected.signType, response.getSignType());
        Assert.assertEquals(expected.signProfile, response.getSignProfile());
        Assert.assertEquals(expected.signMode, response.getSignMode());
        if (expected.signatureDetailLength > 0) {
            Assert.assertEquals(expected.signatureDetailLength, response.getSignatureDetailInfo().length);
        }
    }
}
