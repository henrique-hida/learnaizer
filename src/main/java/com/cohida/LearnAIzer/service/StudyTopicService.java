package com.cohida.LearnAIzer.service;
import com.cohida.LearnAIzer.model.StudyTopic;
import com.cohida.LearnAIzer.repository.StudyTopicRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudyTopicService {

    private StudyTopicRepository studyTopicRepository;

    public StudyTopicService(StudyTopicRepository studyTopicRepository) {
        this.studyTopicRepository = studyTopicRepository;
    }

    public StudyTopic saveStudyTopic(StudyTopic studyTopic) {
        return studyTopicRepository.save(studyTopic);
    }

    public List<StudyTopic> listAllStudyTopics() {
        return studyTopicRepository.findAll();
    }

    public Optional<StudyTopic> listStudyTopicById(Long id) {
        return studyTopicRepository.findById(id);
    }

    public StudyTopic editStudyTopic(StudyTopic studyTopic) {
        return studyTopicRepository.save(studyTopic);
    }

    public void deleteStudyTopic(Long id) {
        studyTopicRepository.deleteById(id);
    }

}
