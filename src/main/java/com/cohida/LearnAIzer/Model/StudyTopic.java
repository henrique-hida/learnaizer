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
    private String studyTopic;
    private CurrentKnowledgeEnum currentKnowledge;
    private int timeAvailable;
    private LocalDate dueDate;
    private StudyStyleEnum studyStyle;
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
