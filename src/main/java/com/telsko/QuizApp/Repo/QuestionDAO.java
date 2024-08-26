package com.telsko.QuizApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telsko.QuizApp.Model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
	
	
	List<Question> findByCategory( String category);
	
	@Query(value="SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQues",nativeQuery = true)
	List<Question> createQuiz( @Param(value ="category") String category,  @Param(value = "numQues") int numQues);

}
