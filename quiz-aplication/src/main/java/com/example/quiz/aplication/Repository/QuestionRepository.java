package com.example.quiz.aplication.Repository;

import com.example.quiz.aplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAll();

    List<Question> findByCategory(String category);


    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category, @Param("numQ") int numQ);
}
