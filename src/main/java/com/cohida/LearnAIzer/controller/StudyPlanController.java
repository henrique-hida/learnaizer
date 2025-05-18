package com.cohida.LearnAIzer.controller;

import com.cohida.LearnAIzer.model.StudyTopic;
import com.cohida.LearnAIzer.service.GeminiService;
import com.cohida.LearnAIzer.service.StudyTopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/plan")
public class StudyPlanController {

    private StudyTopicService studyTopicService;
    private GeminiService geminiService;

    public StudyPlanController(StudyTopicService studyTopicService, GeminiService geminiService) {
        this.studyTopicService = studyTopicService;
        this.geminiService = geminiService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generatePlan() {
        List<StudyTopic> studyTopics = studyTopicService.listAllStudyTopics();
        return geminiService.generatePlan(studyTopics)
        .map(plan -> ResponseEntity.ok(plan))
        .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
