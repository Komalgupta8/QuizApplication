package com.example.quiz.aplication.Repository;

import com.example.quiz.aplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAll();

    List<Question> findByCategory(String category);


}
