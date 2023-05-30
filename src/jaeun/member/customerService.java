package jaeun.member;

import java.util.Scanner;

import jaeun.admin.Admin;
import jaeun.admin.AdminDAO;
import jaeun.admin.productDAO;

public class customerService {

	public static member customerInfo = null;
	Scanner sc = new Scanner(System.in);
	memberService ms = new memberService();
	
	//회원 조회
	public void getAdmin() {
		String id = memberService.memberInfo.getMemberId();
		
		Admin ad = AdminDAO.getInstance().getAdmin(id);
		
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

	// 비밀번호 변경
	public void updatePw() {
		member mem = new member();
		String id = memberService.memberInfo.getMemberId();
		String pw = "";
		if (id == memberService.memberInfo.getMemberId()) {
			while (true) {
				System.out.println("변경할 비밀번호 입력 >");
				pw = sc.nextLine();
				if (pw.equals(pw) == memberService.memberInfo.getMemberPw().equals(pw)) {
					System.out.println("기존의 비밀번호와 동일합니다. 다시 입력하세요.");
				} else {
					if (pw.length() >= 20) {
						System.out.println("비밀번호 자릿수 초과 20자 미만으로 입력하세요.");
					} else {
						break;
					}
				}
			}
		} else {
			System.out.println("ID가 다릅니다. 다시 확인하세요");
		}
		mem.setMemberId(id);
		mem.setMemberPw(pw);
		int result = customerDAO.getInstance().updatePw(mem);
		
		System.out.println("비밀번호를 변경 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니오");
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu == 1 ) {
		if (result > 0) {
			System.out.println("비밀번호 변경 완료했습니다.");
			System.out.println("개인 정보 수정 사항이 있습니다. 다시 로그인 하세요.");
			ms.login();
		} else {
			System.out.println("비밀번호 수정 실패");
		}
		}else if(menu == 2) {
			System.out.println("비밀번호 변경이 취소되었습니다.");
		}
	}

	// 닉네임 변경
	public void updateNic() {
		member mem = new member();
		String id = memberService.memberInfo.getMemberId();
		String nick = "";

		if (id == memberService.memberInfo.getMemberId()) {
			while (true) {
				System.out.println("닉네임 변경 > ");
				nick = sc.nextLine();
				member mb = memberDAO.getInstance().login2(nick);

				if (mb != null) {
					System.out.println("이미 사용중인 닉네임 입니다.");
				} else if (mb == null) {
					System.out.println("사용 가능한 닉네임 입니다.");
					break;
				}
			}
		} else {
			System.out.println("아이디가 불일치합니다.");

		}
		mem.setMemberId(id);
		mem.setMemberNick(nick);
		int result = customerDAO.getInstance().updateNic(mem);

		System.out.println("닉네임을" + nick + "로 변경 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니오");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			if (result > 0) {
				System.out.println("닉네임이 변경 되었습니다.");
			}else {
				System.out.println("닉네임 변경이 실패했습니다.");
			}
		}else if(menu == 2){
			System.out.println("닉네임 변경이 취소되었습니다.");
			return;
		}
	}
	//이메일 수정
	public void updateEma() {
		member mem = new member();
		String ema = "";
		String id = memberService.memberInfo.getMemberId();
		System.out.println("수정 할 이메일 >");
		ema = sc.nextLine();
		mem.setMemberId(id);;
		mem.setMemberEma(ema);

		System.out.println("정말 수정 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = customerDAO.getInstance().updateEma(mem);
			if (result == 1) {
			System.out.println("수정이 완료되었습니다.");
				
			} else {
				System.out.println("수정을 실패하였습니다.");
			}
		} else if (menu == 2) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}

	}
	
	//주소 수정
	public void updateAddr() {
		member mem = new member();
		String addr = "";
		String id = memberService.memberInfo.getMemberId();
		System.out.println("수정 할 주소 >");
		addr = sc.nextLine();
		mem.setMemberId(id);;
		mem.setMemberAddr(addr);

		System.out.println("정말 수정 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = customerDAO.getInstance().updateAddr(mem);
			if (result == 1) {
			System.out.println("수정이 완료되었습니다.");
				
			} else {
				System.out.println("수정을 실패하였습니다.");
			}
		} else if (menu == 2) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}

	}
	//전화번호 수정
	public void updatePhone() {
		member mem = new member();
		String pho = "";
		String id = memberService.memberInfo.getMemberId();
		System.out.println("수정 할 전화번호 >");
		pho = sc.nextLine();
		mem.setMemberId(id);
		mem.setMemberPhone(pho);

		System.out.println("정말 수정 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = customerDAO.getInstance().updatePhone(mem);
			if (result == 1) {
			System.out.println("수정이 완료되었습니다.");
				
			} else {
				System.out.println("수정을 실패하였습니다.");
			}
		} else if (menu == 2) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}
	}
}
