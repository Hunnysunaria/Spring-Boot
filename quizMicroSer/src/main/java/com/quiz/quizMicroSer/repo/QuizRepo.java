package com.quiz.quizMicroSer.repo;

import com.quiz.quizMicroSer.model.Questions;
import com.quiz.quizMicroSer.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
