package com.cohida.LearnAIzer.Service;
import com.cohida.LearnAIzer.Model.StudyTopic;
import com.cohida.LearnAIzer.Repository.StudyTopicRepository;
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
