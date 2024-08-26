package com.telsko.QuizApp.Model;

import java.util.List;

public class Response {
	private int queiId;
	private String responses;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(int queiId, String responses) {
		super();
		this.queiId = queiId;
		this.responses = responses;
	}
	public int getQueiId() {
		return queiId;
	}
	public void setQueiId(int queiId) {
		this.queiId = queiId;
	}
	public String getResponses() {
		return responses;
	}
	public void setResponses(String responses) {
		this.responses = responses;
	}
	@Override
	public String toString() {
		return "Response [queiId=" + queiId + ", responses=" + responses + "]";
	}
	

}
