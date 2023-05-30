package jaeun.member;

import java.util.ArrayList;
import java.util.List;

import jaeun.admin.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class member {       
//	MEMBER_NAME           VARCHAR2(20)    
//	MEMBER_ID    NOT NULL VARCHAR2(10)  
//	MEMBER_PW             VARCHAR2(20)  
//	MEMBER_NICK  NOT NULL VARCHAR2(20)
//	MEMBER_EMA            VARCHAR2(100) 
//	MEMBER_ADDR           VARCHAR2(100) 
//	MEMBER_PHONE          VARCHAR2(100) 
//	MEMEBR_AUTH           VARCHAR2(2)   
	

	private String memberName;
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberEma;
	private String memberAddr;
	private String memberPhone;
	private String memberAuth;
	
	List<Admin> list = new ArrayList<>();

}
