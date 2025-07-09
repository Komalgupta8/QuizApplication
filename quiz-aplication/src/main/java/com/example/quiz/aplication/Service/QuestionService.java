package com.example.quiz.aplication.Service;

import com.example.quiz.aplication.Repository.QuestionRepository;
import com.example.quiz.aplication.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    QuestionRepository questionRepository;
    public List<Question> getallQuestion() {
          return questionRepository.findAll();
    }
}
