package com.example.quiz.aplication.Repository;

import com.example.quiz.aplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
