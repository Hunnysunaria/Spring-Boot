package com.quiz.quizMicroSer.service;

import com.quiz.quizMicroSer.model.Questions;
import com.quiz.quizMicroSer.model.Quiz;
import com.quiz.quizMicroSer.model.Response;
import com.quiz.quizMicroSer.repo.QuestionRepo;
import com.quiz.quizMicroSer.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
QuestionRepo repo;
@Autowired
QuizRepo quizRepo;

    public String create(String category, int numQ, String qTitle) {
List<Questions> questions= repo.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz= new Quiz();
quiz.setTitle(qTitle);
quiz.setQuestions(questions);
quizRepo.save(quiz);
        return "success";
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
  Quiz quiz= quizRepo.findById(id).get();
  List<Questions>questions= quiz.getQuestions();
  Integer right=0;
  int i=0;
  for(Response response: responses){
    if(response.getResponse().equals(questions.get(i).getRightAnswer()))
        right++;
    i++;
  }

return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
