package jaeun.admin;

import java.util.Scanner;

public class AdminService {
	public static Admin adminInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//회원 조회
	public void getAdmin() {
		System.out.println("아이디 입력 >");
		String admId = sc.nextLine();
		
		Admin ad = AdminDAO.getInstance().getAdmin(admId);
		
		if(ad == null) {
			System.out.println("없는 회원 입니다");
		}else {
			System.out.println("이름 : " + ad.getMemberName());
			System.out.println("ID : " + ad.getMemberId());
			System.out.println("PW : " + ad.getMemberPw());
			System.out.println("닉네임 : " + ad.getMemberNick());
			System.out.println("이메일 : " + ad.getMemberEma());
			System.out.println("주소 : " + ad.getMemberAddr());
			System.out.println("전화번호 : " + ad.getMemberPhone());
		}
	}
}
