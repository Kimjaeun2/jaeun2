package jaeun.admin;

import java.util.ArrayList;
import java.util.List;

import jaeun.DAO.DAO;import jdk.jshell.spi.ExecutionControl.ExecutionControlException;

public class CartDAO extends DAO{
	private static CartDAO cartDao = null;
	
	private CartDAO() {
		
	}
	public static CartDAO getInstance() {
		if(cartDao == null) {
			cartDao = new CartDAO();
		}
		return cartDao;
	}
	
	//장바구니 담기 
	public int insertRecipt(Admin ad) {
		int result = 0;
		try {
			conn();
			String sql = "Insert Into recipt values(sysdate, ?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ad.getMemberId());
			pstmt.setString(2, ad.getProductName());
			pstmt.setInt(3, ad.getProductPrice());
			pstmt.setInt(4, ad.getAmount());
			pstmt.setInt(5, ad.getProductTotal());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//장바구니 확인
	public Admin serCart(String carSer) {
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM cart WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carSer);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ad = new Admin();
				ad.setMemberId(rs.getString("member_id"));
				ad.setProductName(rs.getString("product_name"));
				ad.setProductPrice(rs.getInt("product_price"));
				ad.setAmount(rs.getInt("amount"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return ad;
	}
	//구매내역 확인
	
	public List<Admin> getRecipt(String memId) {
		List<Admin> listRe = new ArrayList<>();
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROm recipt WHERE member_id = ? ORDER BY recipt_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ad = new Admin();
				ad.setReciptDate(rs.getDate("recipt_date"));
				ad.setMemberId(rs.getString("member_id"));
				ad.setProductName(rs.getString("product_name"));
				ad.setProductPrice(rs.getInt("product_price"));
				ad.setAmount(rs.getInt("amount"));
				ad.setProductTotal(rs.getInt("product_total"));
				
				listRe.add(ad);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return listRe;
	}
	//상품 후기 등록
	public int insertCommnets(Admin ad) {
		int result = 0;
		try {
			conn();
			String sql = "Insert Into comments values(?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ad.getProductName());
			pstmt.setString(2, ad.getMemberNick());
			pstmt.setString(3, ad.getComments());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//장바구니 확인
	public Admin serchComments(String carSer) {
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM cart WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carSer);
			
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
	//후기 보기
	public List<Admin> getComments(String proNa) {
		List<Admin> listCo = new ArrayList<>();
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROm comments WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proNa);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ad = new Admin();
				ad.setProductName(rs.getString("product_name"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setComments(rs.getString("comments"));
				
				listCo.add(ad);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return listCo;
	}
	//후기 삭제
	public int deleteComment(String id) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM recipt WHERE product_name = ?";
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
	
}
