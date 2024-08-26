package com.telsko.QuizApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telsko.QuizApp.Model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>{
	

	
}
