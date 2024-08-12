package br.com.erakles.springopenai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JavaOpenAIService {

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.model}")
    private String modelVersion;

    private final RestTemplate restTemplate;

    public JavaOpenAIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @param prompt - the question you are expecting to ask ChatGPT
     * @return the response in JSON format
     */
    public String ask(String prompt) {
        HttpEntity<String> entity = new HttpEntity<>(buildMessageBody(modelVersion, prompt), buildOpenAIHeaders());
        return restTemplate
                .exchange(apiUrl, HttpMethod.POST, entity, String.class)
                .getBody();
    }

    private HttpHeaders buildOpenAIHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private String buildMessageBody(String modelVersion, String prompt) {
        return String.format("{ \"model\": \"%s\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}", modelVersion, prompt);
    }
}
