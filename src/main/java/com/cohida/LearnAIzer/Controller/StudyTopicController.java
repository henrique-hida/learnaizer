package com.cohida.LearnAIzer.Controller;
import com.cohida.LearnAIzer.Model.StudyTopic;
import com.cohida.LearnAIzer.Service.StudyTopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    @PostMapping
    public ResponseEntity<StudyTopic> createStudyTopic(@RequestBody StudyTopic studyTopic) {
        StudyTopic savedStudyTopic = studyTopicService.saveStudyTopic(studyTopic);
        return ResponseEntity.ok(savedStudyTopic);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<StudyTopic>> listAllStudyTopics() {
        List<StudyTopic> studyTopics = studyTopicService.listAllStudyTopics();
        return ResponseEntity.ok(studyTopics);
    }

    // GET BY ID
    @GetMapping
    public ResponseEntity<?> listStudyTopicById(@PathVariable Long id) {
        Optional<StudyTopic> studyTopicById = studyTopicService.listStudyTopicById(id);
        if (studyTopicById.isPresent()) {
            return ResponseEntity.ok(studyTopicById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: StudyTopic not found");
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<StudyTopic> editStudyTopic(@RequestBody StudyTopic studyTopic, @PathVariable Long id) {
        return studyTopicService.listStudyTopicById(id)
                .map(existingStudyTopic -> {
                    studyTopic.setId(existingStudyTopic.getId());
                    StudyTopic updatedStudyTopic = studyTopicService.editStudyTopic(studyTopic);
                    return ResponseEntity.ok(updatedStudyTopic);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping
    public ResponseEntity<String> deleteStudyTopic(@PathVariable Long id) {
        studyTopicService.deleteStudyTopic(id);
        return ResponseEntity.noContent().build();
        }
    }
