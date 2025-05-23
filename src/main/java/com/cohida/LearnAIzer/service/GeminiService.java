package com.cohida.LearnAIzer.service;

import com.cohida.LearnAIzer.model.StudyTopic;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {

    private final WebClient webClient;
    private String apiKey = System.getenv("GEMINI_API_KEY");

    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generatePlan(List<StudyTopic> studyTopics) {
        String topics = studyTopics.stream()
                .map(item -> String.format(
                        "%s (Conhecimento atual: %s, Estilo de estudo: %s, Objetivo: %s) - Tempo disponível: %d horas por semana, Prazo: %s",
                        item.getStudyTopic(),
                        item.getCurrentKnowledge(),
                        item.getStudyStyle(),
                        item.getObjective(),
                        item.getTimeAvailable(),
                        item.getDueDate().toString()))
                .collect(Collectors.joining("\n"));

        String prompt = "Crie uma rotina de estudos para mim, de segunda à sábado, baseado nos seguintes tópicos: " + topics;

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("key", apiKey)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                    if (candidates != null && !candidates.isEmpty()) {
                        Map<String, Object> candidate = candidates.get(0);
                        Map<String, Object> content = (Map<String, Object>) candidate.get("content");
                        List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
                        if (parts != null && !parts.isEmpty()) {
                            return parts.get(0).get("text").toString();
                        }
                    }
                    return "No content found in response.";
                });
    }

}
