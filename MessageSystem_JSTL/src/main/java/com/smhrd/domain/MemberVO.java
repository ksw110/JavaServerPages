package com.smhrd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor 
@Getter
public class MemberVO {
	@NonNull
	private String email;
	@NonNull
	private String pw;
	private String tel;
	private String address;

}
