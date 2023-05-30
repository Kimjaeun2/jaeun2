package jaeun.admin;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import jaeun.member.memberService;

public class CartService {

	public static Admin cartInfo = null;
	Scanner sc = new Scanner(System.in);
	AdminService adminSE = new AdminService();
	Admin admin = new Admin();

	// 장바구니 확인
	public void serCart() {
		List<Admin> list = memberService.memberInfo.getList();
		if (list.size() != 0) {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				System.out.print("상품이름 : " + list.get(i).getProductName());
				System.out.print("	상품가격 : " + list.get(i).getProductPrice());
				System.out.println("	상품 담은 갯수 : " + list.get(i).getAmount());
				System.out.println(list.get(i).getProductName() + "의 총 가격 : "
						+ (list.get(i).getProductPrice() * list.get(i).getAmount()) + "원");
				System.out.println();
				sum += (list.get(i).getProductPrice() * list.get(i).getAmount());
			}
			System.out.println("총 구매가격 : " + sum + "원");
			// 장바구니 메뉴
			System.out.println("1. 장바구니 뺴기 | 2. 구매하기 | 9. 뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("물품을 선택해주세요");
				String proId = sc.nextLine();
				Admin product = productDAO.getInstance().getProduct(proId);
				System.out.println("뺄 갯수를 입력해주세요");
				product.setAmount(Integer.parseInt(sc.nextLine()));
				for (int i = 0; i < list.size(); i++) {
					if (product.getProductName().equals(list.get(i).getProductName())) {
						if (product.getAmount() < list.get(i).getAmount()) {
							list.get(i).setAmount(list.get(i).getAmount() - product.getAmount());
							System.out.println("남은갯수 : " + list.get(i).getAmount() + "개");
						} else {
							System.out.println("담으신 물품보다 많은 수량입니다.");
						}
					} else {
						System.out.println("장바구니에 담지 않은 상품입니다");
					}
				}
			} else if (menu == 2) {

				for (int i = 0; i < list.size(); i++) {
					admin.setMemberId(list.get(i).getMemberId());
					admin.setProductName(list.get(i).getProductName());
					admin.setProductPrice(list.get(i).getProductPrice());
					admin.setAmount(list.get(i).getAmount());
					admin.setProductTotal(list.get(i).getProductPrice() * list.get(i).getAmount());
					CartDAO.getInstance().insertRecipt(admin);
				}
				System.out.println("총 구매금액 : " + sum);
				System.out.println("구매 완료");
				list.clear();
			} else if (menu == 9) {
				return;
			} else {
				System.out.println("잘못된 메뉴 입니다.");
				serCart();
			}

		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}

	// 구매내역 확인
	public void getRecipt() {
		String id = memberService.memberInfo.getMemberId();
		List<Admin> listRe = CartDAO.getInstance().getRecipt(id);
		if (listRe.size() == 0) {
			System.out.println("구매내역이 없습니다.");
			return;
		} else {
			for (int i = 0; i < listRe.size(); i++) {
				System.out.print("구매 날짜 : " + listRe.get(i).getReciptDate());
				System.out.print("	상품 명 : " + listRe.get(i).getProductName());
				System.out.print("	상품 구매 갯수 : " + listRe.get(i).getAmount());
				System.out.println("	상품 구매 가격 : " + listRe.get(i).getProductTotal());
			}
		}
		System.out.println("1. 상품 후기 등록 | 9. 뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			boolean proCo = false;
			Admin pro = new Admin();
			String nick = memberService.memberInfo.getMemberNick();
			System.out.println("상품 이름을 적어주세요");
			pro.setProductName(sc.nextLine());

			for (int i = 0; i < listRe.size(); i++) {
				if (pro.getProductName().equals(listRe.get(i).getProductName())) {
					proCo = true;
				}
			}
			if (proCo == true) {
				System.out.println("후기 작성 > ");
				pro.setComments(sc.nextLine());
				pro.setMemberNick(nick);

				CartDAO.getInstance().insertCommnets(pro);
			} else if(proCo == false){
				System.out.println("구매하신 상품이 아닙니다.");
			}
		} else if (menu == 9) {
			return;
		} else {
			System.out.println("번호를 확인해주세요");
		}
	}
}
