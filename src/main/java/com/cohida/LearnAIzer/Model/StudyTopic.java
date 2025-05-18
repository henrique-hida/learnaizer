package com.cohida.LearnAIzer.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.time.LocalDate;

@Entity
@Table(name = "study_topic")
@NoArgsConstructor
@AllArgsConstructor
public class StudyTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "study_topic", nullable = false)
    private String studyTopic;

    @Column(name = "current_knowledge", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrentKnowledgeEnum currentKnowledge;

    @Column(name = "time_available", nullable = false)
    private int timeAvailable;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "study_style", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyStyleEnum studyStyle;

    @Column(name = "objective", nullable = false)
    private String objective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudyTopic() {
        return studyTopic;
    }

    public void setStudyTopic(String studyTopic) {
        this.studyTopic = studyTopic;
    }

    public CurrentKnowledgeEnum getCurrentKnowledge() {
        return currentKnowledge;
    }

    public void setCurrentKnowledge(CurrentKnowledgeEnum currentKnowledge) {
        this.currentKnowledge = currentKnowledge;
    }

    public int getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(int timeAvailable) {
        this.timeAvailable = timeAvailable;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public StudyStyleEnum getStudyStyle() {
        return studyStyle;
    }

    public void setStudyStyle(StudyStyleEnum studyStyle) {
        this.studyStyle = studyStyle;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
}
