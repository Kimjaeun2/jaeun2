package jaeun.member;

import jaeun.DAO.DAO;

public class memberDAO extends DAO {
	
	private static memberDAO memberDao = null;
	
	private memberDAO() {
		
	}
	
	public static memberDAO getInstance() {
		if(memberDao == null) {
			memberDao = new memberDAO();
		}
		return memberDao;
	}
	//로그인
	public member login(String id) {
		member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new member();
				member.setMemberName(rs.getString("member_name"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberNick(rs.getString("member_nick"));
				member.setMemberEma(rs.getString("member_ema"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAuth(rs.getString("memebr_auth"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	public member login2 (String nick) {
		member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_nick = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nick);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new member();
				member.setMemberName(rs.getString("member_name"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberNick(rs.getString("member_nick"));
				member.setMemberEma(rs.getString("member_ema"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAuth(rs.getString("memebr_auth"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}

	// 회원가입
	public int insertMember(member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member values(?,?,?,?,?,?,?,'N')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberId());
			pstmt.setString(3, member.getMemberPw());
			pstmt.setString(4, member.getMemberNick());
			pstmt.setString(5, member.getMemberEma());
			pstmt.setString(6, member.getMemberAddr());
			pstmt.setString(7, member.getMemberPhone());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
		
	}

}
