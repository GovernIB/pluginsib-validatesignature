package org.fundaciobit.plugins.validatesignature.tester;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class ValidateServletIT {

    private  static String endpoint;

    private CloseableHttpClient httpclient;
    private HttpPost httpPost;

    @BeforeClass
    public static void setup() throws IOException {
        Properties properties = new Properties();
        try (var reader = new FileReader("test.properties")){
            properties.load(reader);
        }
        endpoint = properties.getProperty("endpoint");
    }

    @Before
    public void before() {
        httpclient = HttpClients.createDefault();
        httpPost = new HttpPost(endpoint + "validate");
    }

    @After
    public void tearDown() throws IOException {
        httpclient.close();
    }

    @Test
    public void testValidaPdf1AfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pdf-1signed.pdf", "application/pdf", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(1, elements.size());
            Assert.assertEquals("PRUEBAS EIDAS CERTIFICADO", elements.get(0).text());
        }
    }

    @Test
    public void testValidaPdf2AfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pdf-2signed.pdf", "application/pdf", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("-2", document.getElementById("status").text());
            Assert.assertTrue(document.getElementById("errorMsg").text()
                    .contains("urn:afirma:dss:1.0:profile:XSS:resultminor:InvalidNotSignerCertificate"));
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(2, elements.size());
        }
    }

    @Test
    public void testValidaPdfRepAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pdf_rep_signed.pdf", "application/pdf", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(1, elements.size());
            Assert.assertEquals("JUAN ANTONIO CÁMARA ESPAÑOL", elements.get(0).text());
        }
    }

    @Test
    public void testValidaXmlDetachedAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pom_signed_detached.xsig", "text/xml", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(1, elements.size());
            Assert.assertEquals("PRUEBAS EIDAS CERTIFICADO", elements.get(0).text());
        }
    }

    @Test
    public void testValidaXmlDetachedCosignedAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pom_signed_detached_cosigned.xsig", "text/xml", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(2, elements.size());
        }
    }

    @Test
    public void testValidaXmlEnvelopedAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pom_signed_enveloped.xsig", "text/xml", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(1, elements.size());
            Assert.assertEquals("PRUEBAS EIDAS CERTIFICADO", elements.get(0).text());
        }
    }

    @Test
    public void testValidaXmlEnvelopedCosignedAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pom_signed_enveloped_cosigned.xsig", "text/xml", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(2, elements.size());
        }
    }

    @Test
    public void testValidaXmlEnvelopingAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pom_signed_enveloping.xsig", "text/xml", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(1, elements.size());
            Assert.assertEquals("PRUEBAS EIDAS CERTIFICADO", elements.get(0).text());
        }
    }

    @Test
    public void testValidaCadesAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/Document.txt_asigned.csig", "application/octet-stream", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(1, elements.size());
            Assert.assertEquals("PRUEBAS EIDAS CERTIFICADO", elements.get(0).text());
        }
    }

    @Test
    public void testValidaCadesCosignedAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/Document.txt_acosigned.csig", "application/octet-stream", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Document document = Jsoup.parse(resEntity.getContent(), "UTF-8", httpPost.getURI().toString());
            Assert.assertEquals("1", document.getElementById("status").text());
            Assert.assertEquals("Estat no definit", document.getElementById("errorMsg").text());
            Elements elements = document.getElementById("signatures").getElementsByTag("li");
            Assert.assertEquals(2, elements.size());
        }
    }

    private HttpEntity getHttpEntity(String fileName, String mime, String pluginName) throws URISyntaxException {
        File file = getFile(fileName);
        return MultipartEntityBuilder.create()
                .addPart("fitxer", new FileBody(file, ContentType.create(mime)))
                .addTextBody("pluginName", pluginName)
                .build();
    }

    private File getFile(String resourceName) throws URISyntaxException {
        URL resource = getClass().getResource(resourceName);
        Objects.requireNonNull(resource, () -> "No s'ha trobat el recurs " + resourceName);
        return new File(resource.toURI());
    }
}
