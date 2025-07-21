package com.example.quiz.aplication.Service;

import com.example.quiz.aplication.Repository.QuestionRepository;
import com.example.quiz.aplication.Repository.QuizRepository;
import com.example.quiz.aplication.model.Question;
import com.example.quiz.aplication.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questionList=questionRepository.findRandomQuestionByCategory(category, numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);

        quizRepository.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }
}
