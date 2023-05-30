package jaeun.member;

import jaeun.DAO.DAO;
import jaeun.admin.Admin;

public class customerDAO extends DAO{
	
	private static customerDAO cusDao = null;
	private customerDAO() {
		
	}
	
	public static customerDAO getInstance() {
		if(cusDao == null) {
			cusDao = new customerDAO();
		}
		return cusDao;
	}
	
	public member getAdmin(String adId) {
		member ad = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ad = new member();
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
	
	//사용자로 로그인 했을 때의 기능
	//2. 내 정보 수정 - 2-1비밀번호
	public int updatePw(member member) {
		int result = 0;
		try{
			conn();
			String sql = "UPDATE member set member_pw = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//닉네임 변경
	public int updateNic(member member) {
		int result = 0;
		try{
			conn();
			String sql = "UPDATE member set member_nick = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberNick());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//이메일 변경
	public int updateEma(member member) {
		int result = 0;
		try{
			conn();
			String sql = "UPDATE member set member_ema = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberEma());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//주소 변경
	public int updateAddr(member member) {
		int result = 0;
		try{
			conn();
			String sql = "UPDATE member set member_addr = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberAddr());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//전화번호 변경
	public int updatePhone(member member) {
		int result = 0;
		try{
			conn();
			String sql = "UPDATE member set member_phone = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPhone());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
}
