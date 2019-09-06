package com.bank.domains;

import java.io.Serializable;

import lombok.Data;
@Data

public class MemberBean implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//직렬화는 빈객체에 걸어야된다. 이 값을 jsp랑 주고 받고 해야된다
	private String id,pw,name,ssn;

	
	
}
