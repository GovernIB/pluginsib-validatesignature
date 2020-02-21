package org.fundaciobit.plugins.validatesignature.afirmacxf;

/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */

import es.gob.afirma.i18n.Language;
import es.gob.afirma.transformers.TransformersException;
import es.gob.afirma.transformers.xmlTransformers.IXmlTransformer;
import java.util.Properties;
import org.apache.log4j.Logger;

public final class XmlTransformersFactory {
    private static Logger logger = Logger.getLogger(XmlTransformersFactory.class);

    private XmlTransformersFactory() {
    }

    public static Class<?> getXmlTransformer(String serviceReq, String method, String type, String version) throws TransformersException {
        Class res = null;
        try {
            if (serviceReq == null || method == null || version == null) {
                throw new TransformersException(Language.getFormatResIntegra("XTF001", new Object[]{serviceReq, method, version}));
            }
            String transformerClass = XmlTransformersFactory.getTransformerClassName(serviceReq, method, type, version);
            if (transformerClass == null) {
                throw new TransformersException(Language.getFormatResIntegra("XTF002", new Object[]{serviceReq, method, version}));
            }
            res = Class.forName(transformerClass);
            Class<?>[] interfaces = res.getInterfaces();
            boolean found = false;
            for (int i = 0; i < interfaces.length && !found; ++i) {
                Class c = interfaces[i];
                if (!c.getName().equals(IXmlTransformer.class.getName())) continue;
                found = true;
            }
            if (!found) {
                res = null;
                throw new TransformersException(Language.getFormatResIntegra("XTF003", new Object[]{transformerClass, IXmlTransformer.class.getName()}));
            }
            logger.debug((Object)Language.getFormatResIntegra("XTF004", new Object[]{transformerClass}));
        }
        catch (ClassNotFoundException e) {
            logger.error((Object)e);
            throw new TransformersException(e.getMessage(), e);
        }
        return res;
    }

    private static String getTransformerClassName(String serviceReq, String method, String type, String version) {
        Properties properties = new Properties();
        if (type.equals("request")) {
            properties = TransformersProperties.getMethodRequestTransformersProperties(serviceReq, method, version);
        } else if (type.equals("response")) {
            properties = TransformersProperties.getMethodResponseTransformersProperties(serviceReq, method, version);
        }
        StringBuffer transfClassName = new StringBuffer(serviceReq).append(".");
        transfClassName.append(method).append(".");
        transfClassName.append(version).append(".");
        transfClassName.append(type).append(".");
        transfClassName.append("transformerClass");
        
        logger.info(" transformerClass [PROPERTY] => " + transfClassName.toString());
        
        String res = properties.getProperty(transfClassName.toString());
        
        logger.info(" transformerClass [PROPERTY VALUE] => " +res);
        return res;
    }
}

