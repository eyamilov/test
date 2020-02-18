package com.yamilov.test.util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class RestClient {
    private static final Logger LOG = Logger.getLogger(RestClient.class);
    private static Response response;

    public static void get(String requestURL) {
        LOG.info(String.format("[GET]: %s", requestURL));

        RequestSpecification requestSpecification = given()
                .contentType(ContentType.JSON);

        response = requestSpecification
                .when()
                .get(requestURL);

        LOG.info("Response HTTP-code: " + RestClient.getResponse().statusCode());
        LOG.info("Response body: " + RestClient.getResponseBody());
    }

    public static Response getResponse() {
        return response;
    }

    public static String getResponseBody() {
        return getResponse().getBody().asString();
    }
}
