package org.fundaciobit.plugins.validatesignature.tester;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
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
    public void testValidaAfirmaCxf() throws IOException, URISyntaxException {
        HttpEntity reqEntity = getHttpEntity("/pdf-1signed.pdf", "application/pdf", "afirmacxf");
        httpPost.setEntity(reqEntity);

        try (var response = httpclient.execute(httpPost)) {
            HttpEntity resEntity = response.getEntity();
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            resEntity.writeTo(System.out);
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
