package org.fundaciobit.pluginsib.validatesignature.afirmacxf.test;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.fundaciobit.pluginsib.core.v3.utils.FileUtils;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 */
public class CheckXadesinternallyDetached {

    public static void main(String[] args) {

        try {
            File inputFile = new File("./apb_planol/aaa_manual_PALA_TRASERA1634712699-signat.xsig");
            byte[] xmlFile = FileUtils.readFromFile(inputFile);

            boolean valid = isXadesInternallyDetached(xmlFile);

            if (valid) {
                System.out.println("Es un XadesInternallyDetached ");
            } else {
                System.out.println("No és un XadesInternallyDetached");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    


    // ----------------------------------------------------------------------------
    // ----------------------------------------------------------------------------
    // ---------- METODES PER SABER SI XADES ES INTERNALLY DETACHED ---------------
    // ----------------------------------------------------------------------------
    // ----------------------------------------------------------------------------



    public static boolean isXadesInternallyDetached(byte[] xmlFile) {

        try {
            
        
            SAXParserFactory factory = SAXParserFactory.newInstance();
      
            // XXE attack, see https://rules.sonarsource.com/java/RSPEC-2755
            SAXParser saxParser = factory.newSAXParser();
      
            XadesInternallyDetachedParser handler = new XadesInternallyDetachedParser();
      
            saxParser.parse(new ByteArrayInputStream(xmlFile), handler);
            System.out.println("Current Value: " + handler.internalStructure.toString());
      
            return handler.internalStructure.toString().equals(XadesInternallyDetachedParser.EXPECTED_STRUCTURE);

        } catch (Throwable e) {
            // TODO: handle exception
            System.err.println("isXadesInternallyDetached() => Error parsing XML: " + e.getMessage());
            e.printStackTrace(System.err);
            return false;
        }
        
    }

    public static class XadesInternallyDetachedParser extends DefaultHandler {

        public static final String EXPECTED_STRUCTURE = "START-AFIRMA-CONTENT-CONTENT-ds:Signature-ds:Signature-AFIRMA-END";

        private StringBuilder internalStructure = new StringBuilder();

        @Override
        public void startDocument() {
            internalStructure.append("START-");
        }

        @Override
        public void endDocument() {
            internalStructure.append("END");
        }

        @Override
        public void startElement(String uri, String localName, String qname, Attributes attributes) {

            // reset the tag value
            if (qname.equalsIgnoreCase("CONTENT") || qname.equalsIgnoreCase("ds:Signature")
                    || qname.equalsIgnoreCase("AFIRMA")) {
                internalStructure.append(qname).append("-");
            }

        }

        @Override
        public void endElement(String uri, String localName, String qname) {

            if (qname.equalsIgnoreCase("CONTENT") || qname.equalsIgnoreCase("ds:Signature")
                    || qname.equalsIgnoreCase("AFIRMA")) {
                internalStructure.append(qname).append("-");
            }

        }

        @Override
        public void characters(char ch[], int start, int length) {

        }

    }

}