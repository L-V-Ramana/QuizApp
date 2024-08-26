package com.telsko.QuizApp.Controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telsko.QuizApp.Model.Question;
import com.telsko.QuizApp.Model.QuizWrapper;
import com.telsko.QuizApp.Model.Response;
import com.telsko.QuizApp.Service.QuestionService;
import com.telsko.QuizApp.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping(value= "/createQuiz")
	public ResponseEntity<List<Question>> createQuiz(@RequestParam String category,@RequestParam int numQues,@RequestParam String title){
		return quizService.createQuiz(category,numQues,title);
	}
	
	public ResponseEntity<List<QuizWrapper>> getQuiz(@RequestParam int quizId){
		
		return quizService.getQuiz( quizId);
	}
	@PostMapping("/submit/{quizId}")
	public ResponseEntity<Integer> submit(@PathVariable(value="quizId") int id,@RequestParam List<Response> responses) {
		
		return quizService.submit(id,responses);
	}

}
