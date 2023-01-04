package com.smhrd.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor 
@Getter
public class MessageVO {
	private BigDecimal num;
	@NonNull
	private String sendname;
	@NonNull
	private String receiveemail;
	@NonNull
	private String message;
	private Timestamp m_date;
}
