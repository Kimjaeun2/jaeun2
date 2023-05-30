package jaeun.exe;

import java.util.Scanner;

import jaeun.member.memberService;

public class Start {
	Scanner sc = new Scanner(System.in);
	memberService ms = new memberService();
	
	public Start() {
		run();
	}
	
	private void run() {
		while(true) {
			if(memberService.memberInfo == null) {
				System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
				int menu = Integer.parseInt(sc.nextLine());
				if(menu == 1) {
					ms.login();
				}else if(menu == 2) {
					ms.insertMember();
				}else if(menu == 3){
					System.out.println("종료");
					break;
				}else {
					System.out.println("잘못된 메뉴 입니다.");
				}
			}else if(memberService.memberInfo != null) {
				if(memberService.memberInfo.getMemberAuth().equals("N")) {
					new customerApp();
				}else if(memberService.memberInfo.getMemberAuth().equals("A")) {
					new AdminApp();
				}
			}
		}
	}
	
}
