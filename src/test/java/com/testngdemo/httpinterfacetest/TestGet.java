package com.testngdemo.httpinterfacetest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class TestGet {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet1 = new HttpGet("http://localhost:8080/mobilePhone?model=iPhone+6S");

        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("http").setHost("localhost").
                    setPort(8080).setPath("/mobilePhone")
                    .setParameter("model", "iPhone 6S").build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpGet httpGet2 = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet1);
            System.out.println(EntityUtils.toString(response.getEntity()));
            response = client.execute(httpGet2);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("END");
    }
}
