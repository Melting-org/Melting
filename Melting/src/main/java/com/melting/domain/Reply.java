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

public class Reply {
	private int replyseq;
	private int boardseq;
	private String memberid;
	private String membername;
	private String replytxt;
	private int replycnt;
	private String regdate;

}
