package jaeun.admin;

import java.util.List;
import java.util.Scanner;

import jaeun.member.memberService;

public class AnnounService {
	public static Admin announInfo = null;
	Scanner sc = new Scanner(System.in);
	memberService ms = new memberService();

	// 전체 게시물 보기
	public void getAnnoun() {
		List<Admin> list = AnnounDAO.getInstance().getAnnoun();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("번호    " + "게시글 제목");
			System.out.println(" " + list.get(i).getAnnounNum() + "     " + list.get(i).getAnnounFirst());
			;
		}
	}

	// 게시글 작성
	public void insertAnn() {
		Admin ad = new Admin();
		String id = memberService.memberInfo.getMemberId();
		String nick = memberService.memberInfo.getMemberNick();
		ad.setMemberId(id);
		ad.setMemberNick(nick);

		System.out.println("게시글 제목 입력>");
		ad.setAnnounFirst(sc.nextLine());
		System.out.println("게시글 내용 입력>");
		ad.setAnnounLast(sc.nextLine());

		int result = AnnounDAO.getInstance().insertAnn(ad);

		if (result > 0) {

			System.out.println("게시글 작성이 완료되었습니다.");
		} else
			System.out.println("게시글 작성을 실패 하셨습니다.");
	}

	// 자유게시판 상세 보기
	public void serchAnnoun() {
		System.out.println("게시글 번호 선택 > ");
		int number = Integer.parseInt(sc.nextLine());
		Admin num = AnnounDAO.getInstance().SerchAnnoun(number);

		System.out.print("게시글 제목 :" + num.getAnnounFirst());
		System.out.println("		작성자 : " + num.getMemberNick());
		System.out.println();
		System.out.println(num.getAnnounLast());
		System.out.println("작성일 " + num.getAnnountDate());
		// 댓글 확인
		System.out.println("1. 댓글확인 | 9. 뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			List<Admin> ListCo = AnnounDAO.getInstance().SerchComm(number);
			System.out.println(ListCo.size());
			for (int i = 0; i < ListCo.size(); i++) {
				System.out.println(ListCo.get(i).getMemberNick() + "		" + ListCo.get(i).getAnnounComm());
			}

			// 댓글 쓰기
			System.out.println("1. 댓글쓰기 | 9. 뒤로가기");
			String nick = memberService.memberInfo.getMemberNick();
			int minmenu = Integer.parseInt(sc.nextLine());
			if (minmenu == 1) {
				System.out.println("댓글 입력>");
				num.setMemberNick(nick);
				num.setAnnounComm(sc.nextLine());

				int result = AnnounDAO.getInstance().insertCOm(num);
				if (result > 0) {
					System.out.println("댓글 작성 완료");
				} else {
					System.out.println("댓글 작성 실패");
				}

			} else if (minmenu == 9) {
				return;
			}

		} else if (menu == 9) {
			return;
		} else {
			System.out.println("잘못된 메뉴 입니다.");
		}
	}

	// 건의 사항 전체조회
	public void getSecAnnoun() {
		List<Admin> list = AnnounDAO.getInstance().getsecAnnoun();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("번호    " + "게시글 제목");
			System.out.println(" " + list.get(i).getAnnounNum() + "     " + list.get(i).getAnnounFirst());
			;
		}
	}

	// 건의사항 작성
	public void secretAnn() {
		Admin ad = new Admin();
		String id = memberService.memberInfo.getMemberId();
		String nick = memberService.memberInfo.getMemberNick();
		ad.setMemberId(id);
		ad.setMemberNick(nick);

		System.out.println("게시글 제목 입력>");
		ad.setAnnounFirst(sc.nextLine());
		System.out.println("게시글 내용 입력>");
		ad.setAnnounLast(sc.nextLine());

		int result = AnnounDAO.getInstance().secretAnn(ad);

		if (result > 0) {

			System.out.println("게시글 작성이 완료되었습니다.");
		} else
			System.out.println("게시글 작성을 실패 하셨습니다.");
	}

	// 건의사항 상세보기
	public void serchSecAnnoun() {

		System.out.println("게시글 번호 선택 > ");
		int number = Integer.parseInt(sc.nextLine());
		Admin num = AnnounDAO.getInstance().SerchSecAnnoun(number);

		System.out.print("게시글 제목 :" + num.getAnnounFirst());
		System.out.println("		작성자 : " + num.getMemberNick());
		System.out.println();
		System.out.println(num.getAnnounLast());
		System.out.println("작성일 " + num.getAnnountDate());
		System.out.println("9. 뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 9) {
			return;
		} else {
			System.out.println("잘못된 메뉴 입니다.");
		}
	}

	// 건의 사항 전체조회
	public void getNoticeAnnoun() {
		List<Admin> list = AnnounDAO.getInstance().getNoticeAnnoun();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("번호    " + "게시글 제목");
			System.out.println(" " + list.get(i).getAnnounNum() + "     " + list.get(i).getAnnounFirst());
			;
		}
	}

	// 건의사항 작성
	public void insertNoticeAnn() {
		Admin ad = new Admin();
		String id = memberService.memberInfo.getMemberId();
		String nick = memberService.memberInfo.getMemberNick();
		ad.setMemberId(id);
		ad.setMemberNick(nick);

		System.out.println("게시글 제목 입력>");
		ad.setAnnounFirst(sc.nextLine());
		System.out.println("게시글 내용 입력>");
		ad.setAnnounLast(sc.nextLine());

		int result = AnnounDAO.getInstance().insertNoticeAnn(ad);

		if (result > 0) {

			System.out.println("게시글 작성이 완료되었습니다.");
		} else
			System.out.println("게시글 작성을 실패 하셨습니다.");
	}

	// 건의사항 상세보기
	public void SerchNoticeAnnoun() {

		System.out.println("게시글 번호 선택 > ");
		int number = Integer.parseInt(sc.nextLine());
		Admin num = AnnounDAO.getInstance().SerchNoticeAnnoun(number);

		System.out.print("게시글 제목 :" + num.getAnnounFirst());
		System.out.println("		작성자 : " + num.getMemberNick());
		System.out.println();
		System.out.println(num.getAnnounLast());
		System.out.println("작성일 " + num.getAnnountDate());
		System.out.println("9. 뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 9) {
			return;
		} else {
			System.out.println("잘못된 메뉴 입니다.");
		}
	}
}
