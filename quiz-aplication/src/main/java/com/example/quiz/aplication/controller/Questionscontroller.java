package com.example.quiz.aplication.controller;

import com.example.quiz.aplication.Service.QuestionService;
import com.example.quiz.aplication.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class Questionscontroller {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getallQuestion(){
        return questionService.getallQuestion();
    }

    @PostMapping("addquiz")
    public String addQuiz(@RequestBody Question question){
        return questionService.save(question);
    }


    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
          return questionService.getQuestionByCategory(category);
    }

}
