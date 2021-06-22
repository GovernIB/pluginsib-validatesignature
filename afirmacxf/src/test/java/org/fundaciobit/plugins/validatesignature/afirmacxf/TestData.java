package org.fundaciobit.plugins.validatesignature.afirmacxf;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {

    private DateFormat dateFormat;

    @Before
    public void setup() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss X", new Locale("es", "ES"));
    }

    @Test
    public void testData1() throws ParseException {
        Date parsedDate = dateFormat.parse("2020-11-05 jue. 14:04:20 +0100");
        System.out.println(parsedDate);
    }

    @Test
    public void testData2() throws ParseException {
        Date parsedDate = dateFormat.parse("2024-11-05 mar. 14:04:20 +0100");
        System.out.println(parsedDate);
    }

    @Test
    public void testCoses() {

        String format = dateFormat.format(new Date());

        System.out.println(format);

    }
}
