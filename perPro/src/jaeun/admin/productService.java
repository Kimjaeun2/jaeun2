package jaeun.admin;

import java.util.List;
import java.util.Scanner;

import jaeun.member.memberService;

public class productService {
	public static Admin productInfo = null;
	Scanner sc = new Scanner(System.in);
	memberService ms = new memberService();

	// 상품 전체 조회
	public void getproductList() {
		List<Admin> list = productDAO.getInstance().getproductList();
		for (int i = 0; i < list.size(); i++) {
			System.out.print("상품 번호 : " + list.get(i).getProductNum());
			System.out.print("     상품 이름 : " + list.get(i).getProductName());
			System.out.println("     상품 가격 : " + list.get(i).getProductPrice());

		}
		System.out.println("1. 물건 상세보기 | 9. 뒤로가기");
		int Select = Integer.parseInt(sc.nextLine());
		if (Select == 1) {
			getProduct();
		} else if (Select == 9) {
			return;
		}
	}

	// 상품 상세 조회
	public void getProduct() {
		System.out.println("상품 이름 입력 >");
		String proId = sc.nextLine();

		Admin ad = productDAO.getInstance().getProduct(proId);

		if (ad == null) {
			System.out.println("없는 상품 입니다.");
			getproductList();
		} else {
			System.out.println("상품번호 : " + ad.getProductNum());
			System.out.println("상품 이름 : " + ad.getProductName());
			System.out.println("상품 가격 : " + ad.getProductPrice());
			System.out.println("상품 정보 : " + ad.getProductExplain());
			// 장바구니
			if (memberService.memberInfo.getMemberAuth().equals("N")) {
				System.out.println("1. 장바구니 담기 | 2. 상품 후기 확인 |9. 뒤로가기");
				int menu = Integer.parseInt(sc.nextLine());
				if (menu == 1) {
					String id = memberService.memberInfo.getMemberId();
					ad.setMemberId(id);

					// 갯수 추가 기능
					System.out.println("몇개를 구매 하시겠습니까?");
					ad.setAmount(Integer.parseInt(sc.nextLine()));

					List<Admin> list = memberService.memberInfo.getList();
					boolean check = false;

					for (int i = 0; i < list.size(); i++) {
						if (ad.getProductName().equals(list.get(i).getProductName())) {
							list.get(i).setAmount(list.get(i).getAmount() + ad.getAmount());
							check = true;
						}

					}

					if (check == false) {
						list.add(ad);
					}

					memberService.memberInfo.setList(list);
					System.out.println("장바구니에 담았습니다");
				} else if (menu == 2) {
					List<Admin> listCo = CartDAO.getInstance().getComments(proId);
					for (int i = 0; i < listCo.size(); i++) {
						System.out.println(listCo.get(i).getMemberNick() + "    " + listCo.get(i).getComments());
					}
				} else if (menu == 9) {
					getproductList();
				} else {
					System.out.println("번호를 확인해주세요");
				}
			}else {
				System.out.println("9. 뒤로가기");
				int menu = Integer.parseInt(sc.nextLine());
				if(menu == 9) {
					getproductList();
				}else {
					System.out.println("번호를 확인해주세요");
				}
						
			}
		}
	}

	// 상품 등록
	public void insertPro() {
		Admin ad = new Admin();

		System.out.println("상품 이름 >");
		ad.setProductName(sc.nextLine());

		System.out.println("상품 가격 >");
		ad.setProductPrice(Integer.parseInt(sc.nextLine()));

		System.out.println("상품 설명 >");
		ad.setProductExplain(sc.nextLine());

		int result = productDAO.getInstance().insertPro(ad);
		if (result > 0) {
			System.out.println("상품등록 완료");
		} else {
			System.out.println("상품등록 실패");
		}
	}

	// 상품 정보 수정
	public void updateName() {
		Admin admin = new Admin();
		String name = "";
		System.out.println("상품 품번 >");
		String num = sc.nextLine();
		System.out.println("수정 할 이름 >");
		name = sc.nextLine();
		admin.setProductNum(num);
		admin.setProductName(name);

		System.out.println("정말 수정 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = productDAO.getInstance().updateName(admin);
			if (result == 1) {
				System.out.println("수정이 완료되었습니다.");

			} else {
				System.out.println("상품 번호를 확인해주세요");
			}
		} else if (menu == 2) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}

	}

	// 가격
	public void updatePrice() {
		Admin admin = new Admin();
		int price = 0;
		System.out.println("상품 이름 >");
		String name = sc.nextLine();
		System.out.println("수정 할 가격 >");
		price = Integer.parseInt(sc.nextLine());
		admin.setProductName(name);
		admin.setProductPrice(price);

		System.out.println("정말 수정 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = productDAO.getInstance().updatePrice(admin);
			if (result == 1) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("상품 이름을 확인해주세요");
			}
		} else if (menu == 2) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}

	}

	// 정보
	public void updateExplain() {
		Admin admin = new Admin();
		String explain = "";
		System.out.println("상품 이름 >");
		String name = sc.nextLine();
		System.out.println("수정 할 이름 >");
		explain = sc.nextLine();
		admin.setProductName(name);
		admin.setProductExplain(explain);

		System.out.println("정말 수정 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = productDAO.getInstance().updateName(admin);
			if (result == 1) {
				System.out.println("수정이 완료되었습니다.");

			} else {
				System.out.println("상품 이름을 확인해주세요");
			}
		} else if (menu == 2) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}

	}

	// 상품 삭제
	public void deletePro() {
		System.out.println("상품 이름 입력 >");
		String proId = sc.nextLine();

		System.out.println("정말 삭제 하시겠습니까?");
		System.out.println("1. 예 | 2. 아니요");
		int menu = Integer.parseInt(sc.nextLine());

		if (menu == 1) {
			int result = productDAO.getInstance().deletePro(proId);
			CartDAO.getInstance().deleteComment(proId);
			if (result > 0) {
				System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("상품 이름을 확인해주세요");
			}
		} else if (menu == 2) {
			System.out.println("삭제가 취소되었습니다.");
			return;
		}
	}

	// 상품 후기 확인
	public void comments() {
		System.out.println("상품이름 입력");
		String proNa = sc.nextLine();

		List<Admin> ad = CartDAO.getInstance().getComments(proNa);

		if (ad.size() == 0) {
			System.out.println("없는 상품 입니다.");
		} else {
			for (int i = 0; i < ad.size(); i++) {
				System.out.println(ad.get(i).getMemberNick() + "   " + ad.get(i).getComments());

			}
		}

	}

	public void deleteMember() {
		System.out.println("회원 정보 삭제");
		String id = memberService.memberInfo.getMemberId();
		System.out.println("비밀번호 입력>");
		String pw = sc.nextLine();
		if (memberService.memberInfo.getMemberPw().equals(pw)) {
			System.out.println("정말 삭제하시겠습니까?");
			System.out.println("1. 삭제 | 2. 취소");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				int result = productDAO.getInstance().deleteMember(id);
				productDAO.getInstance().deleteCart(id);

				if (result > 0) {
					System.out.println("회원 정보 삭제완료");
					memberService.memberInfo = null;
					ms.login();
				} else {
					System.out.println("회원 정보 삭제 실패");
				}
			} else if (menu == 2) {
				return;
			} else {
				System.out.println("번호를 확인해주세요");
			}
		} else {
			System.out.println("비밀번호가 일치하지 않습니다");
		}

	}

}
