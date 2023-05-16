package com.melting.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Main {
	private String dcUrl;
//	private String fmUrl;
//	private String ppUrl;
//	private String ruUrl;
//	private String ivUrl;
	
	private String[] dcTitle;
	private String[] dcWriter;
	private String[] dcRegDate;
	private String[] dcViews;
	private String[] dcLike;
	private String[] dcComment;
	private String[] dcLink;
	private String[] dcCategory;
	

}
