package com.smhrd.model;

public class VO {

	
	private String id;
	private String pw;
	private String name;
	
	// 생성자 메소드
	public VO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public VO(String id, String pw) {
		this.id = id;
		this.pw = pw;
		
	}

	// getter 메소드
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
