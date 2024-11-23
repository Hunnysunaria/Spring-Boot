package com.hunny.question_service.controller;


import com.hunny.question_service.model.QuestionWrapper;
import com.hunny.question_service.model.Questions;

import com.hunny.question_service.model.Response;
import com.hunny.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//generate

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam int numQuestions){
    return  service.getQuestionsForQuiz(categoryName,numQuestions);
    }
    //getQuestions(questions)
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds){
    return service.getQuestionsFromId(questionIds);
    }

    //getScore

    @PostMapping("getscore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> responses){
    return service.getScore(responses);

    }



}

