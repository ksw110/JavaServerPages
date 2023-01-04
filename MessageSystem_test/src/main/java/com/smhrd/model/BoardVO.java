package com.smhrd.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardVO {
//BigDecimal
	//Timestamp
	private BigDecimal num;
	@NonNull
	private String title;
	@NonNull
	private String writer;
	@NonNull
	private String filename;
	@NonNull
	private String content;
	private Timestamp b_date;
}
