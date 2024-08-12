package br.com.erakles.springopenai.security;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SslConnector {

    public static TrustManager TRUST_ALL_CERTS = new X509TrustManager() {

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[] {};
        }

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {}

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {}
    };

    public static void buildHttps() {
        String cacerts = System.getenv("JAVA_HOME") + "\\lib\\security\\cacerts";
        System.setProperty("javax.net.ssl.trustStore", cacerts);
        System.setProperty("javax.net.ssl.trustStorePassword", ""); // the default value is changeit
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { TRUST_ALL_CERTS }, new SecureRandom());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
    }
}
