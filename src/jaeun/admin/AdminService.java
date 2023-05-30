package jaeun.admin;

import java.util.List;
import java.util.Scanner;

public class AdminService {
	public static Admin adminInfo = null;
	Scanner sc = new Scanner(System.in);
	
	public void getMember() {
		List<Admin> list = AdminDAO.getInstance().getmember();
		for (int i = 0; i < list.size(); i++) {
			System.out.print("이름 : " + list.get(i).getMemberName());
			System.out.print("   아이디 : " + list.get(i).getMemberId());
			System.out.println("   닉네임 : " + list.get(i).getMemberNick());
			
		}
		System.out.println("1. 상세 조회| 2. 뒤로가기");
		int menu =  Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			getAdmin();
		}else if(menu==2) {
			return;
		}
	}
	
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
