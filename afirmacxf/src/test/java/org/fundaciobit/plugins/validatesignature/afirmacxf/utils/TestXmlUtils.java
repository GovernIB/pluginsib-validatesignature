package org.fundaciobit.plugins.validatesignature.afirmacxf.utils;

import org.fundaciobit.plugins.validatesignature.afirmacxf.utils.XMLUtil;
import org.fundaciobit.pluginsib.core.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestXmlUtils {

    private byte[] getResource(String path) throws Exception {
        return FileUtils.toByteArray(getClass().getResourceAsStream(path));
    }

    @Test
    public void testFitxerValid() throws Exception {
        byte[] resource = getResource("/responses/validacioValidInvalid.xml");
        Assert.assertTrue(XMLUtil.isXml(resource));
    }

    @Test
    public void testFitxerInvalid() throws Exception {
        byte[] resource = getResource("/log4j.properties");
        Assert.assertFalse(XMLUtil.isXml(resource));
    }

    @Test
    public void testXmlInvalid() throws Exception {
        String resource = "<hola>dddd</hol";
        Assert.assertFalse(XMLUtil.isXml(resource.getBytes("UTF-8")));
    }

}
