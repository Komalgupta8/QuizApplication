package com.example.quiz.aplication.controller;


import com.example.quiz.aplication.Service.QuizService;
import com.example.quiz.aplication.model.QuestionWrapper;
import com.example.quiz.aplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> quiz(@RequestParam String category , @RequestParam int numQ, @RequestParam String title){
          return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
             return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> response){

        return quizService.submitQuiz(id , response);
    }

}
