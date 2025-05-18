package com.cohida.LearnAIzer.controller;

import com.cohida.LearnAIzer.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/plan")
public class StudyPlanController {

    private GeminiService geminiService;

    public StudyPlanController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generatePlan() {
        return geminiService.generatePlan()
        .map(plan -> ResponseEntity.ok(plan))
        .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
