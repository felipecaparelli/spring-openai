package br.com.erakles.springopenai.controller;

import br.com.erakles.springopenai.service.JavaOpenAIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces="application/json")
@CrossOrigin(origins="*")
public class SpringOpenAIController {

    private final JavaOpenAIService javaOpenAIService;

    SpringOpenAIController(JavaOpenAIService javaOpenAIService) {
        this.javaOpenAIService = javaOpenAIService;
    }

    @GetMapping("/ask")
    public ResponseEntity<String> ask(@RequestParam(value = "prompt", defaultValue = "Tell me a joke") String prompt) {
        return ResponseEntity.ok(javaOpenAIService.ask(prompt));
    }
}
