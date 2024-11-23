package com.quiz.quizMicroSer.controller;

import com.quiz.quizMicroSer.model.Response;
import com.quiz.quizMicroSer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

@PostMapping("create")
    public ResponseEntity<String>CreateQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String q_title){


    return new ResponseEntity<>(quizService.create(category,numQ,q_title), HttpStatus.CREATED);
}

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
