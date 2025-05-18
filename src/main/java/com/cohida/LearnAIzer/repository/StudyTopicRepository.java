package com.cohida.LearnAIzer.repository;

import com.cohida.LearnAIzer.model.StudyTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTopicRepository extends JpaRepository<StudyTopic, Long> {
}
