package com.example.quiz.aplication.Service;

import com.example.quiz.aplication.Repository.QuestionRepository;
import com.example.quiz.aplication.Repository.QuizRepository;
import com.example.quiz.aplication.model.Question;
import com.example.quiz.aplication.model.QuestionWrapper;
import com.example.quiz.aplication.model.Quiz;
import com.example.quiz.aplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questionList=questionRepository.findRandomQuestionByCategory(category, numQ);

//        if (questionList.size() < numQ) {
//            return new ResponseEntity<>("Not enough questions available in the selected category.", HttpStatus.BAD_REQUEST);
//        }

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);

        quizRepository.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz=quizRepository.findById(id);

        List<Question> QuestionsFromdb=quiz.get().getQuestions();
        List<QuestionWrapper> QuestionforUser=new ArrayList<>();

        for(Question q: QuestionsFromdb){
            QuestionWrapper qw=new QuestionWrapper(q.getId() , q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            QuestionforUser.add(qw);
        }
        return new ResponseEntity<>(QuestionforUser, HttpStatus.OK);
    }


    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> response) {
        Quiz quiz= quizRepository.findById(id).get();

        List<Question> questions= quiz.getQuestions();

        int right=0;
        int i=0;

        for(Response response1: response){
            if(response1.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
