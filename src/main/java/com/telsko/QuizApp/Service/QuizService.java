package com.telsko.QuizApp.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telsko.QuizApp.Model.Question;
import com.telsko.QuizApp.Model.Quiz;
import com.telsko.QuizApp.Model.QuizWrapper;
import com.telsko.QuizApp.Model.Response;
import com.telsko.QuizApp.Repo.QuestionDAO;
import com.telsko.QuizApp.Repo.QuizDAO;

@Service
public class QuizService {
	
	@Autowired
	QuestionDAO questionDao;
	@Autowired
	QuizDAO quizDao;
	
	public ResponseEntity<List<Question>> createQuiz(String category, int numQues,String title) {
		List<Question> quiz = questionDao.createQuiz(category, numQues);
		Quiz q   = new Quiz();
		q.setQuestions(quiz);
		q.setTitle(title);
		return new ResponseEntity(quiz,HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuizWrapper>> getQuiz(int quizId) {
		  Optional<Quiz> quiz = quizDao.findById(quizId);
		 List<Question> q = quiz.get().getQuestions();
		 ArrayList<QuizWrapper> questionsForUser = new ArrayList<QuizWrapper>();
		
		 for(Question que : q) {
			
			 QuizWrapper quizWrapper = new QuizWrapper();
			quizWrapper.setId(que.getId());
			quizWrapper.setQuestion(que.getQuestion());
			quizWrapper.setOption1(que.getOption1());
			quizWrapper.setOption2(que.getOption2());
			quizWrapper.setOption3(que.getOption3());
			quizWrapper.setOption4(que.getOption4());
			
			questionsForUser.add(quizWrapper);
			
		 }
			
			
		return new ResponseEntity<List<QuizWrapper>>(questionsForUser,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Integer> submit(int id, List<Response> responses) {
			Optional<Quiz> quiz = quizDao.findById(id);
			List<Question> questions = quiz.get().getQuestions();
			int i=0;
			int right=0;
			for(Response r : responses) {
				if(r.getResponses().equals(questions.get(i).getAnswer())) {
					right++;
					
				}
				i++;
			}
		return new ResponseEntity<Integer>( right,HttpStatus.OK);
	}
	
}
