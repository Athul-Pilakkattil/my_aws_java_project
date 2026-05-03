package com.myapp;

import java.util.HashMap;
import java.util.Map;

public class HelloHandler {

    public Map<String, Object> handleRequest(Map<String, Object> event) {

        // Get query parameters
        Map<String, String> queryParams =
                (Map<String, String>) event.get("queryStringParameters");

        String name = "World";
        if (queryParams != null && queryParams.get("name") != null) {
            name = queryParams.get("name");
        }

        // HTML response
        String body = "<html>" +
                      "<body>" +
                      "<h1>Hello world, This is  " + name + "!</h1>" +
                      "</body>" +
                      "</html>";

        // Build response
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 200);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html");

        response.put("headers", headers);
        response.put("body", body);
        response.put("isBase64Encoded", false);

        return response;
    }
}
