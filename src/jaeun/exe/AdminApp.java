package jaeun.exe;

import java.util.Scanner;
import jaeun.admin.AdminService;
import jaeun.admin.AnnounService;
import jaeun.admin.productService;
import jaeun.member.memberService;

public class AdminApp {
	Scanner sc = new Scanner(System.in);
	AnnounService As = new AnnounService();
	AdminService as = new AdminService();
	productService ps = new productService();

	public AdminApp() {
		run();
	}

	private void menu() {
		System.out.println("1. 전체 회원 조회 | 2. 개인 회원정보 조회 | 3. 상품 관리 | 4. 게시판 관리 | 9. 로그아웃");
	}

	private void run() {
		boolean tru = true;
		while (tru) {
			menu();
			int menuNo = Integer.parseInt(sc.nextLine());

			if (menuNo == 1) {
				as.getMember();
			} else if (menuNo == 2) {
				as.getAdmin();
			}else if (menuNo == 2) {
				selectPro();
			} else if (menuNo == 3) {
				Announs();
			} else if (menuNo == 9) {
				tru = false;
				System.out.println("안녕히 가세요");
				memberService.memberInfo = null;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
	}

	// 상품관리
	private void selectPro() {

		while (true) {
			System.out.println("1. 상품 전체 확인 | 2. 상품 등록 | 3. 상품 수정 |  4. 상품 삭제 | 5. 상품 후기 확인 | 9. 뒤로 가기");
			int menuNo = Integer.parseInt(sc.nextLine());

			if (menuNo == 1) {
				ps.getproductList();

			} else if (menuNo == 2) {
				ps.insertPro();

			} else if (menuNo == 3) {
				ProductFix();

			} else if (menuNo == 4) {
				ps.deletePro();

			} else if (menuNo == 5) {
				ps.comments();

			} else if (menuNo == 9) {
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}

		}
	}

	// 상품수정
	private void ProductFix() {
		while (true) {
			System.out.println("1. 이름 수정 |2. 가격 수정  | 3. 정보 수정 | 9. 뒤로 가기");
			int menuNo = Integer.parseInt(sc.nextLine());

			if (menuNo == 1) {
				ps.updateName();
			} else if (menuNo == 2) {
				ps.updatePrice();
			} else if (menuNo == 3) {
				ps.updateExplain();
			} else if (menuNo == 9) {
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
				As.getAnnoun();
				freeAnn();
			} else if (menu == 2) {
				As.getSecAnnoun();
				secAnn();
			} else if (menu == 3) {
				As.getNoticeAnnoun();
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
				As.serchAnnoun();
			} else if (menu == 2) {
				As.insertAnn();
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
					As.serchSecAnnoun();
				} else {
					System.out.println("권한이 없습니다.");
				}

			} else if (menu == 2) {
				As.secretAnn();
			} else if (menu == 9) {
				tre = false;
				break;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
	}
	private void NotAnn() {
		boolean tre = true;
		while (tre) {
			System.out.println("1. 게시글 선택 | 2. 글 쓰기| 9. 뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				As.SerchNoticeAnnoun();
			} else if (menu == 2) {
				if (memberService.memberInfo.getMemberAuth().equals("A")) {
					As.insertNoticeAnn();
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
