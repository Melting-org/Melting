package com.melting.domain;

import java.util.Date;

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
	private String link;
	private String image;
	private String membername;
	private Date created_at;
	private int likecnt;
//	private String regdate;
//	private int viewscnt;
	

}
