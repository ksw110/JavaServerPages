package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


// @Data // 기본생성자, getter, setter, toString, equals...
@AllArgsConstructor // 모든 파라미터를 받는 생성자
@RequiredArgsConstructor // final or @NonNull 파라미터만 받는 생성자
@NoArgsConstructor // 기본생성자
@Getter // getter메소드
public class MemberVO {
	
//	private final String email;
//	private final String pw;
	
	@NonNull
	private String email;
	@NonNull
	private String pw;
	private String tel;
	private String address;
	
	
}
