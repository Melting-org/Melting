package com.melting.domain;

import lombok.AllArgsConstructor;
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

public class Board {
	private int boardseq;
	private String membername;
	private String title;
	private String boardtxt;
	private String regdate;
	private int viewscnt;
	private int likecnt;
	private int replycnt;
	
	
}
