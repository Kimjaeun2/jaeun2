package jaeun.admin;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
	
	
	private String memberName;
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberEma;
	private String memberAddr;
	private String memberPhone;
	private String memberAuth;
	
//	PRODUCT_NUM     NOT NULL NUMBER         
//	PRODUCT_NAME             VARCHAR2(100)  
//	PRODUCT_PRICE             VARCHAR2(100)          
//	PRODUCT_EXPLAIN          VARCHAR2(1000) 
	
	private String productNum;
	private String productName;
	private int productPrice;
	private String productExplain;
	
//	PRODUCT_NAME    VARCHAR2(100) 
//	MEMBER_NICK     VARCHAR2(20)  
//	COMMENTS        VARCHAR2(500) 
	
	private String comments;
	
	private int amount;
	
//	recipt_date DATE,
//	MEMBER_ID VARCHAR2(10),
//	PRODUCT_NAME             VARCHAR2(100) ,
//	PRODUCT_PRICE            NUMBER,
//	AMOUNT      number,
//	PRODUCT_TOTAL           number);
	
	private Date reciptDate;
	private int productTotal;
	
//	ANNOUN_NUM      NUMBER         
//	MEMBER_ID       VARCHAR2(10)   
//	MEMBER_NICK     VARCHAR2(20)   
//	ANNOUN_FIRST    VARCHAR2(100)  
//	ANNOUN_LAST     VARCHAR2(1000) 
	private int announNum;
	private String announFirst;
	private String announLast;
	private Date annountDate;
	
	private String announComm;
	
}
