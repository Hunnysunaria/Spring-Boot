package com.hunny.question_service.service;


import com.hunny.question_service.model.QuestionWrapper;
import com.hunny.question_service.model.Questions;
import com.hunny.question_service.model.Response;
import com.hunny.question_service.repo.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo repo;

//getting all questions
    public List<Questions> allQuestions(){
        return repo.findAll();
    }

   //getting questions by category
    public List<Questions> getQuestionbycategory(String category) {
        return repo.findByCategory(category);

    }

    //saving questions in question database
    public void save(Questions question) {
        repo.save(question);
    }

//deleting question
    public void delete(int id) {
        repo.deleteById(id);
    }

    //getting particular category questions for quiz
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
   List<Integer> questions= repo.findRandomQuestionsByCategory(categoryName,numQuestions);

return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    //getting questions only by ID
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
    List<QuestionWrapper> wrappers= new ArrayList<>();
    List<Questions>questions= new ArrayList<>();

    for(Integer id: questionIds){

        questions.add(repo.findById(id).get());
    }

    for(Questions question: questions){
        QuestionWrapper wrapper= new QuestionWrapper();

        wrapper.setId(question.getId());;
        wrapper.setQuestionTitle(question.getQuestionTitle());
        wrapper.setOption1(question.getOption1());
        wrapper.setOption2(question.getOption2());
        wrapper.setOption3(question.getOption3());
        wrapper.setOption4(question.getOption4());
        wrappers.add(wrapper);

    }

    return new ResponseEntity<>(wrappers,HttpStatus.FOUND);



    }
//for calculating score
    public ResponseEntity<Integer> getScore(List<Response> responses) {
   int right=0;

   for(Response response: responses) {
       Questions questions= repo.findById(response.getId()).get();

       if(response.getResponse().equals(questions.getRightAnswer())){
           right++;
   }

   }

   return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
