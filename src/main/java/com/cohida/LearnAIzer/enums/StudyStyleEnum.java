package com.cohida.LearnAIzer.enums;

public enum StudyStyleEnum {
    VISUAL("Visual"),
    READ_WRITE("Read/Write"),
    AUDITORY("Auditory"),
    KINESTHETIC("Kinesthetic(practical)");

    final String label;

    StudyStyleEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
