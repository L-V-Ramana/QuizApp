package com.telsko.QuizApp.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telsko.QuizApp.Model.Question;
import com.telsko.QuizApp.Repo.QuestionDAO;


@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questiondao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		List<Question> questions = questiondao.findAll();
		for(int i=0;i<questions.size();i++) {
			System.out.println( questions.get(i).getCategory());
		}
		
		return new ResponseEntity(questions,HttpStatus.OK);
	}
	
	public ResponseEntity<String> createQuestion(Question question){
		
		questiondao.save(question);
		return new ResponseEntity("Successfullu added",HttpStatus.OK);
	}

	public ResponseEntity<Question> getQuestionById(int id) {
		
		return new ResponseEntity(questiondao.findById(id),HttpStatus.OK);
	}

	public ResponseEntity<String> updateQuestion(int id, Question question) {
		Question questionfromdb = questiondao.findById(id).get();
		questionfromdb.setAnswer(question.getAnswer());
		questionfromdb.setCategory(question.getCategory());
		questionfromdb.setOption1(question.getOption1());
		questionfromdb.setOption2(question.getOption2());
		questionfromdb.setOption3(question.getOption3());
		questionfromdb.setOption4(question.getOption4());
		questionfromdb.setQuestion(question.getQuestion());
		
		questiondao.save(questionfromdb);
		return new ResponseEntity("Question Updated",HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		questiondao.deleteById(id);;
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		 
		return new ResponseEntity<List<Question>>(questiondao.findByCategory(category),HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> createQuiz(@Param(value ="category") String category, @Param(value = "numQues") int numQues) {
		
		List<Question> quiz = questiondao.createQuiz(category,numQues);
		return new ResponseEntity<List<Question>>(quiz,HttpStatus.OK);
	}

}
