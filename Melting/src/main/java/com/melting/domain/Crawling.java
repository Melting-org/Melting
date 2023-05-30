package com.melting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
@Builder

public class Crawling {
	
	private String title;
	private String replycnt;
	private String kind;
//	private String writer;
//	private String regdate;
//	private String link;
//	private int viewscnt;
//	private int likecnt;
	

}
