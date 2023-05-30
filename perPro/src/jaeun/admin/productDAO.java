package jaeun.admin;

import java.util.ArrayList;
import java.util.List;

import jaeun.DAO.DAO;

public class productDAO extends DAO {
	private static productDAO proDao = null;

	private productDAO() {

	}

	public static productDAO getInstance() {
		if (proDao == null) {
			proDao = new productDAO();
		}
		return proDao;
	}

	// 상품 전체 확인
	public List<Admin> getproductList() {
		List<Admin> list = new ArrayList<>();
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ad = new Admin();
				ad.setProductNum(rs.getString("product_num"));
				ad.setProductName(rs.getString("product_name"));
				ad.setProductPrice(rs.getInt("product_price"));
				ad.setProductExplain(rs.getString("product_explain"));

				list.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 상품 상세 확인
	public Admin getProduct(String proName) {
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM product WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proName);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				ad = new Admin();
				ad.setProductNum(rs.getString("product_num"));
				ad.setProductName(rs.getString("product_name"));
				ad.setProductPrice(rs.getInt("product_price"));
				ad.setProductExplain(rs.getString("product_explain"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return ad;
	}
	//상품 등록
	public int insertPro(Admin ad) {
		int result = 0;
		try {
			conn();
			String sql = "insert into product values(concat(to_char(sysdate, 'yymm'),TRUNC(DBMS_RANDOM.VALUE(1000,9999))),?, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ad.getProductName());
			pstmt.setInt(2, ad.getProductPrice());
			pstmt.setString(3, ad.getProductExplain());
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//상품 정보 수정
	//이름
	public int updateName(Admin admin) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE product SET product_name = ? WHERE product_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getProductName());
			pstmt.setString(2, admin.getProductNum());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//가격
	public int updatePrice(Admin admin) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE product SET product_price = ? WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, admin.getProductPrice());
			pstmt.setString(2, admin.getProductName());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//정보
	public int updateExplain(Admin admin) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE product SET product_explain = ? WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getProductExplain());
			pstmt.setString(2, admin.getProductName());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//상품 삭제
	public int deletePro(String proNa) {
		int result = 0;
		try {
			conn();
			String sql = "delete FROM product WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proNa);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//상품 후기 확인
	public Admin commnets(String proNa) {
		Admin ad = null;
		try {
			conn();
		String sql = "SELECT * FROM product WHERE product_name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, proNa);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			ad = new Admin();
			ad.setProductName(rs.getString("product_name"));
			ad.setMemberNick(rs.getString("member_nick"));
			ad.setComments(rs.getString("comments"));
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return ad;
	}
	
	//회원 탈퇴
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			disconn();
		}
		
		return result;
	}
	
	public int deleteCart(String id) {
		int result = 0;
		try {
			conn();
			String sql2 = "DELETE FROM recipt WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			disconn();
		}
		
		return result;
	}

}
