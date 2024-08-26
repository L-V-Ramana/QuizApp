package com.telsko.QuizApp.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizid;
	private String title;
	@ManyToMany
	private List<Question> questions;
	public int getQuizid() {
		return quizid;
	}
	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Quiz [quizid=" + quizid + ", title=" + title + ", questions=" + questions + "]";
	}
	public Quiz(int quizid, String title, List<Question> questions) {
		super();
		this.quizid = quizid;
		this.title = title;
		this.questions = questions;
	}
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
