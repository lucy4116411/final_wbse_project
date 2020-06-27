package ntou.cse.wbse.nkda.controller;


import ntou.cse.wbse.nkda.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ArrayList<String>> getQuestionsOfAYear() {
        ArrayList<String> questions = questionService.getQuestionsOfAYear("2020");
        return ResponseEntity.ok().body(questions);
    }

}
