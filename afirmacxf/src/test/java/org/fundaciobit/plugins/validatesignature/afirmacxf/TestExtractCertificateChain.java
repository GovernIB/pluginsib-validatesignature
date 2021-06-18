package org.fundaciobit.plugins.validatesignature.afirmacxf;

import org.fundaciobit.plugins.validatesignature.afirmacxf.AfirmaCxfValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class TestExtractCertificateChain {

    private static AfirmaCxfValidateSignaturePlugin plugin;

    @BeforeClass
    public static void setup() throws Exception {

        Properties pluginProperties = new Properties();
        pluginProperties.load(new FileInputStream("./config/plugin.properties"));
        String propertyKeyBase = "org.fundaciobit.exemple.base.";
        plugin = new AfirmaCxfValidateSignaturePlugin(propertyKeyBase, pluginProperties);
    }

    private byte[] getResource(String path) throws Exception {
        return FileUtils.toByteArray(getClass().getResourceAsStream(path));
    }

    @Test
    public void testValidInvalid() throws Exception {
        String xml = new String(getResource("/responses/validacioValidInvalid.xml"));

        ValidateSignatureResponse response = new ValidateSignatureResponse();
        plugin.extractCertificateChain(xml, response);

        // hi ha dues firmes, la primera té chain i la segona no
        Assert.assertEquals(2, response.getSignatureDetailInfo().length);
        Assert.assertNotNull(response.getSignatureDetailInfo()[0].getCertificateChain());
        Assert.assertNull(response.getSignatureDetailInfo()[1].getCertificateChain());
    }

    @Test
    public void testInvalidValid() throws Exception {
        String xml = new String(getResource("/responses/validacioInvalidValid.xml"));

        ValidateSignatureResponse response = new ValidateSignatureResponse();
        plugin.extractCertificateChain(xml, response);

        // hi ha dues firmes, la primera no té chain i la segona sí
        Assert.assertEquals(2, response.getSignatureDetailInfo().length);
        Assert.assertNull(response.getSignatureDetailInfo()[0].getCertificateChain());
        Assert.assertNotNull(response.getSignatureDetailInfo()[1].getCertificateChain());
    }

}
