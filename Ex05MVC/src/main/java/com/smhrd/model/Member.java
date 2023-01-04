package com.smhrd.model;

public class Member {
	
	// 필드
	private String id;
	private String pw;
	private String name;
	
	// 생성자
	public Member(String id, String pw, String name) {
		this.id= id;
		this.pw= pw;
		this.name= name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}
	

	
}
