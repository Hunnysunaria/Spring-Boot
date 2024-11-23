package com.quiz.quizMicroSer.service;

import com.quiz.quizMicroSer.model.Questions;
import com.quiz.quizMicroSer.repo.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo repo;

    public List<Questions> allQuestions(){
        return repo.findAll();
    }

    public List<Questions> getQuestionbycategory(String category) {
        return repo.findByCategory(category);

    }

    public void save(Questions question) {
        repo.save(question);
    }


    public void delete(int id) {
        repo.deleteById(id);
    }
}
