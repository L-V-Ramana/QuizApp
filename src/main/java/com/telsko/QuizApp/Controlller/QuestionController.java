package com.telsko.QuizApp.Controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telsko.QuizApp.Model.Question;
import com.telsko.QuizApp.Service.QuestionService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("/getAllQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionservice.getAllQuestions();
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<String> createQuestion(@RequestBody Question question){
		return questionservice.createQuestion(question);
	}
	@PostMapping("get/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int  id){
		return questionservice.getQuestionById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question question ){
		return questionservice.updateQuestion(id,question);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id){
		return questionservice.deleteQuestion(id);
		
	}
	
	@PostMapping("/getQuestion/{Category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable(value = "Category") String category){
		return questionservice.getQuestionByCategory(category);
	}
	
	@PostMapping("/getQuiz")
	public ResponseEntity<List<Question>> createQuiz(@RequestParam(value = "category") String category, @RequestParam int numQues,@RequestParam String title){
		
		return questionservice.createQuiz(category,numQues);
	}
}
