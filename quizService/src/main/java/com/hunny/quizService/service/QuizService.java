package com.hunny.quizService.service;


import com.hunny.quizService.feign.QuizInterface;
import com.hunny.quizService.model.Questions;
import com.hunny.quizService.model.Quiz;
import com.hunny.quizService.model.Response;
import com.hunny.quizService.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {


@Autowired
QuizRepo quizRepo;

@Autowired
QuizInterface quizInterface;


//create quiz

    public String create(String category, int numQ, String qTitle) {
List<Integer> questions= quizInterface.getQuestionsForQuiz(category,numQ).getBody();
System.out.println(questions);
        Quiz quiz= new Quiz();
quiz.setTitle(qTitle);
quiz.setQuestionIds(questions);
quizRepo.save(quiz);
        return "success";
    }

//calculate result
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//  Quiz quiz= quizRepo.findById(id).get();
//  List<Questions>questions= quiz.getQuestions();
  Integer right=0;
//  int i=0;
//  for(Response response: responses){
//    if(response.getResponse().equals(questions.get(i).getRightAnswer()))
//        right++;
//    i++;
//  }

return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
