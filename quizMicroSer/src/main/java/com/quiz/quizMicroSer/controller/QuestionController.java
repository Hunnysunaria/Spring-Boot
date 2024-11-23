package com.quiz.quizMicroSer.controller;

import com.quiz.quizMicroSer.model.Questions;
import com.quiz.quizMicroSer.model.Response;
import com.quiz.quizMicroSer.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService service;

@GetMapping("allquestions")
    public ResponseEntity<List<Questions>> Allquestions(){
    return new ResponseEntity<>(service.allQuestions(),HttpStatus.FOUND);
}

@GetMapping("/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
System.out.println(category);
System.out.println(service.getQuestionbycategory(category));
    return service.getQuestionbycategory(category);
}

@PostMapping("create")

    public ResponseEntity<String> createQuestions(@RequestBody Questions Question){
    service.save(Question);

    return new ResponseEntity("success",HttpStatus.CREATED);

    }

    @PutMapping("update")

    public ResponseEntity<String>UpdateQuestions(@RequestBody Questions question){
    service.save(question);

    return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>DeleteQuestions(@PathVariable int id){
    service.delete(id);

    return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }




}

