package com.example.filip.info.coin;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Filip on 2017-09-09.
 */
public class ParseJSONTest {

    public static final String TEST_STRING = "Test\n";
    ParseJSON mParseJSON;
    private InputStream mInputStream;


    @Before
    public void createParseJSON() {
        mParseJSON = new ParseJSON();
        mInputStream = new ByteArrayInputStream(TEST_STRING.getBytes());
    }


    @Test
    public void streamToString() throws Exception {
        assertEquals(
                TEST_STRING,
                ParseJSON.streamToString(mInputStream)
        );
    }

    @Test
    public void getCoins() throws Exception {

    }

}