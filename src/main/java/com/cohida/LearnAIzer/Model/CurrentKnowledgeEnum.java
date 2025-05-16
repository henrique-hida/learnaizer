package com.cohida.LearnAIzer.Model;

public enum CurrentKnowledgeEnum {

    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    final String label;

    CurrentKnowledgeEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
