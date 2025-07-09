package com.example.quiz.aplication.Repository;

import com.example.quiz.aplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
