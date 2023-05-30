package jaeun.admin;

import jaeun.DAO.DAO;
import jaeun.member.member;

public class AdminDAO extends DAO{
	private static AdminDAO adDao = null;
	
	private AdminDAO() {
		
	}
	
	public static AdminDAO getInstance() {
		if(adDao == null) {
			adDao = new AdminDAO();
		}
		return adDao;
	}
	
	//회원 검색
	public Admin getAdmin(String adId) {
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ad = new Admin();
				ad.setMemberName(rs.getString("member_name"));
				ad.setMemberId(rs.getString("member_id"));
				ad.setMemberPw(rs.getString("member_pw"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setMemberEma(rs.getString("member_ema"));
				ad.setMemberAddr(rs.getString("member_addr"));
				ad.setMemberPhone(rs.getString("member_phone"));
				ad.setMemberAuth(rs.getString("memebr_auth"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return ad;
	}
}
