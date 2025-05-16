package com.cohida.LearnAIzer.Service;
import com.cohida.LearnAIzer.Controller.StudyTopicController;
import com.cohida.LearnAIzer.Model.StudyTopic;
import com.cohida.LearnAIzer.Repository.StudyTopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyTopicService {

    private StudyTopicRepository studyTopicRepository;
    private StudyTopicController studyTopicController;

    public StudyTopicService() {
    }

    public StudyTopicService(StudyTopicRepository studyTopicRepository, StudyTopicController studyTopicController) {
        this.studyTopicRepository = studyTopicRepository;
        this.studyTopicController = studyTopicController;
    }

    public StudyTopic saveStudyTopic(StudyTopic studyTopic) {
        return studyTopicRepository.save(studyTopic);
    }

    public List<StudyTopic> listAllStudyTopics() {
        return studyTopicRepository.findAll();
    }

    public StudyTopic listStudyTopicById(Long id) {
        Optional<StudyTopic> studyTopicById = studyTopicRepository.findById(id);
        return studyTopicById.orElse(null);
    }

    public StudyTopic editStudyTopic(StudyTopic studyTopic, Long id) {
        Optional<StudyTopic> existingStudyTopic = studyTopicRepository.findById(id);
        if (existingStudyTopic.isPresent()) {
            StudyTopic updatedStudyTopic = studyTopic;
            updatedStudyTopic.setId(id);
            StudyTopic savedStudyTopic = studyTopicRepository.save(updatedStudyTopic);
            return savedStudyTopic;
        } else {
            return null;
        }
    }

    public void deleteStudyTopic(Long id) {
        studyTopicRepository.deleteById(id);
    }

}
