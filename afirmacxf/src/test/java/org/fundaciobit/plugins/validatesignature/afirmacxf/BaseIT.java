package org.fundaciobit.plugins.validatesignature.afirmacxf;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.junit.Assert;

import java.security.Security;

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
        Assert.assertEquals(expected.signFormat, response.getSignFormat());
        if (expected.signatureDetailLength > 0) {
            Assert.assertEquals(expected.signatureDetailLength, response.getSignatureDetailInfo().length);
        }
    }
}
