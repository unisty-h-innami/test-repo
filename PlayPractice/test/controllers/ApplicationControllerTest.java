package controllers;

import static org.fest.assertions.Assertions.*;
import static play.mvc.Http.Status.*;
import static play.test.Helpers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.mvc.Result;

public class ApplicationControllerTest {

    @Before
    public void setup(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void testIndex() {
        Result result = route(fakeRequest(GET, "/test"));
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
    }

    @Test
    public void testInsert() {
        Map<String, String> params = new HashMap<String,String>();
        params.put("id", "345");
        params.put("columnOne", "alicecom");
        @SuppressWarnings("unused")
        Result result = route(
              fakeRequest(POST, "/test")
              .withFormUrlEncodedBody(params)
              );
    }

    @Test
    public void testGetList() {
        Result result = route(fakeRequest(GET, "/get"));
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
    }

    @Test
    public void testGetListIdDesc() {
        Result result = route(fakeRequest(GET, "/get/desc"));
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
    }
    @After
    public void end() {
        stop(fakeApplication());
    }

}
