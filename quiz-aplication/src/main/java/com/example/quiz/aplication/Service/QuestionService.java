package com.example.quiz.aplication.Service;

import com.example.quiz.aplication.Repository.QuestionRepository;
import com.example.quiz.aplication.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getallQuestion() {
          return questionRepository.findAll();
    }


    public String save(Question question) {
         questionRepository.save(question);
         return "success";
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }


}
