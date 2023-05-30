package jaeun.member;

import java.util.Scanner;

public class memberService {

	public static member memberInfo = null;
	Scanner sc = new Scanner(System.in);

	public void insertMember() {

		member member = new member();
		String id = "";
		String nick = "";

		// 회원가입
		System.out.println("====회원가입====");

		System.out.println("이름 입력 > ");
		String name = sc.nextLine();
		if(name.length()<=0) {
			System.out.println("정보를 입력해주세요");
			return;
		}else {
			member.setMemberName(name);
		}
		

		while (true) {
			System.out.println("ID 입력 > ");
			id = sc.nextLine();
			if (id.length() <= 0) {
				System.out.println("정보를 입력해주세요");
				return;
			} else {
				member mb = memberDAO.getInstance().login(id);

				if (mb != null) {
					System.out.println("존재하는 아이디 입니다.");
				} else if (mb == null) {
					System.out.println("사용 가능한 아이디 입니다.");
					break;
				}
			}
		}

		System.out.println("PW 입력 > ");
		String pw = sc.nextLine();
		if(pw.length() <= 0) {
			System.out.println("정보를 입력해주세요");
			return;
		}else {
			member.setMemberPw(pw);
		}

		while (true) {
			System.out.println("닉네임 설정 > ");
			nick = sc.nextLine();
			if (nick.length() <= 0) {
				System.out.println("정보를 입력해주세요");
			} else {
				member mb = memberDAO.getInstance().login2(nick);

				if (mb != null) {
					System.out.println("이미 사용중인 닉네임 입니다.");
				} else if (mb == null) {
					System.out.println("사용 가능한 닉네임 입니다.");
					break;
				}
			}
		}

		System.out.println("이메일 입력 > ");
		member.setMemberEma(sc.nextLine());

		System.out.println("주소 입력 > ");
		member.setMemberAddr(sc.nextLine());

		System.out.println("핸드폰 번호 입력 > ");
		member.setMemberPhone(sc.nextLine());

		
		member.setMemberId(id);
		member.setMemberNick(nick);

		int result = memberDAO.getInstance().insertMember(member);

		if (result > 0) {
			System.out.println("🎆🎆회원 가입을 축하드립니다🎆🎆");
		} else {
			System.out.println("회원가입을 다시 해주세요");
		}

	}

	// 로그인
	public void login() {
		member member = null;

		System.out.println("==== 로그인 ====");
		System.out.println("ID >");
		String id = sc.nextLine();

		System.out.println("PW >");
		String pw = sc.nextLine();

		member = memberDAO.getInstance().login(id);

		if (member != null) {
			if (member.getMemberPw().equals(pw)) {
				System.out.println("🎊" + member.getMemberNick() + "님 환영합니다🎊");
				memberInfo = member;
			} else {
				System.out.println("비밀번호를 다시 입력해주세요");
				login();
			}
		} else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}

}
