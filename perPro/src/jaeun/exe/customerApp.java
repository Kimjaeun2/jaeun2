package jaeun.exe;

import java.util.Scanner;

import jaeun.admin.AdminService;
import jaeun.admin.AnnounService;
import jaeun.admin.CartService;
import jaeun.admin.productService;
import jaeun.member.customerService;
import jaeun.member.memberService;

public class customerApp {
	Scanner sc = new Scanner(System.in);
	memberService ms = new memberService();
	productService ps = new productService();
	customerService cs = new customerService();
	CartService csv = new CartService();
	AnnounService as = new AnnounService();

	public customerApp() {
		customerRun();
	}

	private void menu() {
		System.out.println("1. 상품 목록 | 2. 장바구니 | 3. 게시판 | 4. 회원 정보 관리 | 9. 로그아웃");
	}

	private void customerRun() {
		boolean tru = true;
		while (tru) {
			menu();
			String selectNo = sc.nextLine();
			if (selectNo.equals("1")) {
				ps.getproductList();
			} else if (selectNo.equals("2")) {
				csv.serCart();
			} else if (selectNo.equals("3")) {
				Announs();
			} else if (selectNo.equals("4")) {
				customerInfo();
			} else if (selectNo.equals("9")) {
				tru = false;
				System.out.println("안녕히 가세요");
				memberService.memberInfo = null;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}

		}
	}

	private void customerInfo() {

		boolean tru = true;
		while (tru) {
			System.out.println("1. 내정보 조회 | 2. 구매내역 조회 | 3. 정보수정 | 4. 회원 탈퇴 | 9. 이전 페이지");
			String selectNo = sc.nextLine();
			if (selectNo.equals("1")) {
				cs.getAdmin();
			} else if (selectNo.equals("2")) {
				csv.getRecipt();
			} else if (selectNo.equals("3")) {
				customerFix();
			} else if (selectNo.equals("4")) {
				ps.deleteMember();
			} else if (selectNo.equals("9")) {
				tru = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}

		}
	}

	private void customerFix() {

		boolean tru = true;
		while (tru) {
			System.out.println("1. 비밀번호 수정 | 2. 닉네임 수정 | 3. 이메일 수정 | 4. 주소 수정 | 5. 전화번호 수정 | 9. 이전 페이지");
			String selectNo = sc.nextLine();
			if (selectNo.equals("1")) {
				cs.updatePw();
			} else if (selectNo.equals("2")) {
				cs.updateNic();
			} else if (selectNo.equals("4")) {
				cs.updateEma();
			} else if (selectNo.equals("5")) {
				cs.updateAddr();
			} else if (selectNo.equals("6")) {
				cs.updatePhone();
			} else if (selectNo.equals("9")) {
				tru = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}

		}
	}

	public void Announs() {
		boolean tre = true;
		while (tre) {
			System.out.println("1. 자유게시판 | 2. 건의 사항 | 3. 공지사항 | 9. 뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				as.getAnnoun();
				freeAnn();
			} else if (menu == 2) {
				as.getSecAnnoun();
				secAnn();
			} else if (menu == 3) {
				as.getNoticeAnnoun();
				NotAnn();
			} else if (menu == 9) {
				tre = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
	}

	private void freeAnn() {
		boolean tre = true;
		while (tre) {
			System.out.println("1. 게시글 선택 | 2. 글 쓰기| 9. 뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				as.serchAnnoun();
			} else if (menu == 2) {
				as.insertAnn();
			} else if (menu == 9) {
				tre = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
	}

	private void secAnn() {
		boolean tre = true;
		while (tre) {
			System.out.println("1. 게시글 선택 | 2. 글 쓰기| 9. 뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				if (memberService.memberInfo.getMemberAuth().equals("A")) {
					as.serchSecAnnoun();
				} else {
					System.out.println("권한이 없습니다.");
				}

			} else if (menu == 2) {
				as.secretAnn();
			} else if (menu == 9) {
				tre = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
	}

	// 공지사항
	private void NotAnn() {
		boolean tre = true;
		while (tre) {
			System.out.println("1. 게시글 선택 | 2. 글 쓰기| 9. 뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				as.SerchNoticeAnnoun();
			} else if (menu == 2) {
				if (memberService.memberInfo.getMemberAuth().equals("A")) {
					as.insertNoticeAnn();
				} else {
					System.out.println("권한이 없습니다.");
				}
			} else if (menu == 9) {
				tre = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
	}

}
