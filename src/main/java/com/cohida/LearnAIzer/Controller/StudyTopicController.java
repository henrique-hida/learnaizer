package com.cohida.LearnAIzer.Controller;
import com.cohida.LearnAIzer.Model.StudyTopic;
import com.cohida.LearnAIzer.Service.StudyTopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyTopicController {

    private StudyTopicService studyTopicService;

    public StudyTopicController() {
    }

    public StudyTopicController(StudyTopicService studyTopicService) {
        this.studyTopicService = studyTopicService;
    }

    // POST
    public ResponseEntity<StudyTopic> createStudyTopic(@RequestBody StudyTopic studyTopic) {
        StudyTopic savedStudyTopic = studyTopicService.saveStudyTopic(studyTopic);
        return ResponseEntity.ok(savedStudyTopic);
    }

    // GET ALL
    public ResponseEntity<List<StudyTopic>> listAllStudyTopics() {
        List<StudyTopic> studyTopics = studyTopicService.listAllStudyTopics();
        return ResponseEntity.ok(studyTopics);
    }

    // GET BY ID
    public ResponseEntity<?> listStudyTopicById(Long id) {
        StudyTopic studyTopicById = studyTopicService.listStudyTopicById(id);
        if (studyTopicById != null) {
            return ResponseEntity.ok(studyTopicById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: StudyTopic not found");
        }
    }

    // UPDATE
    public ResponseEntity<?> editStudyTopic(@RequestBody StudyTopic studyTopic, Long id) {
        StudyTopic editedStudyTopic = studyTopicService.editStudyTopic(studyTopic, id);
        if (editedStudyTopic != null) {
            return ResponseEntity.ok(editedStudyTopic);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: StudyTopic Not Found");
        }
    }

    // DELETE
    public ResponseEntity<String> deleteStudyTopic(Long id) {
        StudyTopic existingStudyTopic = studyTopicService.listStudyTopicById(id);
        if (existingStudyTopic != null) {
            studyTopicService.deleteStudyTopic(id);
            return ResponseEntity.ok("StudyTopic deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: StudyTopic Not Found!");
        }
    }

}
