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

public class Member {

	private String memberid;
	private String memberpwd;
	private String membername;
	private String email;
	private int enabled;
	private String rolename;
}


