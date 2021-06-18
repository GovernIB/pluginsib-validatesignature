package org.fundaciobit.plugins.validatesignature.afirmacxf.test;

import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.junit.Assert;

public abstract class BaseAfirmaCxfTest {


    protected byte[] getResource(String path) throws Exception {
        return FileUtils.toByteArray(getClass().getResourceAsStream(path));
    }

    protected void checkResponse(ExpectedValidation expected, ValidateSignatureResponse response) {
        Assert.assertEquals(expected.validationStatus, response.getValidationStatus().getStatus());
        Assert.assertEquals(expected.signType, response.getSignType());
        Assert.assertEquals(expected.signProfile, response.getSignProfile());
        Assert.assertEquals(expected.signFormat, response.getSignFormat());
        Assert.assertEquals(expected.signatureDetailLength, response.getSignatureDetailInfo().length);
    }
}
