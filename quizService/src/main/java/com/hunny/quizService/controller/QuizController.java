package com.hunny.quizService.controller;


import com.hunny.quizService.model.Response;
import com.hunny.quizService.service.QuizService;
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


    return new ResponseEntity<>(quizService.create(category,numQ,q_title), HttpStatus.OK);
}

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
