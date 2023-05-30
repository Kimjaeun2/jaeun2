package jaeun.admin;

import java.util.ArrayList;
import java.util.List;

import jaeun.DAO.DAO;

public class AnnounDAO extends DAO {
	private static AnnounDAO annDao = null;

	private AnnounDAO() {

	}

	public static AnnounDAO getInstance() {
		if (annDao == null) {
			annDao = new AnnounDAO();
		}
		return annDao;
	}

	// 게시글 보기
	public List<Admin> getAnnoun() {
		List<Admin> list = new ArrayList<>();
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM announ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ad = new Admin();
				ad.setAnnounNum(rs.getInt("announ_num"));
				ad.setMemberId(rs.getString("member_id"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setAnnounFirst(rs.getString("announ_first"));
				ad.setAnnounLast(rs.getString("announ_last"));
				ad.setAnnountDate(rs.getDate("announ_date"));

				list.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 게시글 상세 확인
	public Admin SerchAnnoun(int Number) {
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM announ WHERE announ_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Number);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				ad = new Admin();
				ad.setAnnounNum(rs.getInt("announ_num"));
				ad.setMemberId(rs.getString("member_id"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setAnnounFirst(rs.getString("announ_first"));
				ad.setAnnounLast(rs.getString("announ_last"));
				ad.setAnnountDate(rs.getDate("announ_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return ad;
	}

	// 게시글 작성
	public int insertAnn(Admin admin) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO announ values (free.NEXTVAL, ?,?,?,?,sysDate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getMemberId());
			pstmt.setString(2, admin.getMemberNick());
			pstmt.setString(3, admin.getAnnounFirst());
			pstmt.setString(4, admin.getAnnounLast());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}
	//건의사항 확인
	public List<Admin> getsecAnnoun() {
		List<Admin> list = new ArrayList<>();
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM annsecret";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ad = new Admin();
				ad.setAnnounNum(rs.getInt("announ_num"));
				ad.setMemberId(rs.getString("member_id"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setAnnounFirst(rs.getString("announ_first"));
				ad.setAnnounLast(rs.getString("announ_last"));
				ad.setAnnountDate(rs.getDate("announ_date"));

				list.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	//건의 사항 작성
	public int secretAnn(Admin admin) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO annsecret values (secret.NEXTVAL, ?,?,?,?,sysDate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getMemberId());
			pstmt.setString(2, admin.getMemberNick());
			pstmt.setString(3, admin.getAnnounFirst());
			pstmt.setString(4, admin.getAnnounLast());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}
	//건의사항 상세확인
	public Admin SerchSecAnnoun(int Number) {
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM annsecret WHERE announ_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Number);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				ad = new Admin();
				ad.setAnnounNum(rs.getInt("announ_num"));
				ad.setMemberId(rs.getString("member_id"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setAnnounFirst(rs.getString("announ_first"));
				ad.setAnnounLast(rs.getString("announ_last"));
				ad.setAnnountDate(rs.getDate("announ_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return ad;
	}
	//댓글 작성
	public int insertCOm(Admin admin) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO commnets values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, admin.getAnnounNum());
			pstmt.setString(2, admin.getMemberNick());
			pstmt.setString(3, admin.getAnnounComm());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}
	//댓글 확인
	public List<Admin> SerchComm(int Number) {
		List <Admin> listCo = new ArrayList<>();
		Admin ad = null;
		try {
			conn();
			String sql = "SELECT * FROM commnets WHERE announ_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Number);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ad = new Admin();
				ad.setAnnounNum(rs.getInt("announ_num"));
				ad.setMemberNick(rs.getString("member_nick"));
				ad.setAnnounComm(rs.getString("announ_comm"));
				
				listCo.add(ad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return listCo;
	}
	
	// 공지사항 보기
		public List<Admin> getNoticeAnnoun() {
			List<Admin> list = new ArrayList<>();
			Admin ad = null;
			try {
				conn();
				String sql = "SELECT * FROM notice";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ad = new Admin();
					ad.setAnnounNum(rs.getInt("announ_num"));
					ad.setMemberId(rs.getString("member_id"));
					ad.setMemberNick(rs.getString("member_nick"));
					ad.setAnnounFirst(rs.getString("announ_first"));
					ad.setAnnounLast(rs.getString("announ_last"));
					ad.setAnnountDate(rs.getDate("announ_date"));

					list.add(ad);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconn();
			}
			return list;
		}

		// 공지사항 상세 확인
		public Admin SerchNoticeAnnoun(int Number) {
			Admin ad = null;
			try {
				conn();
				String sql = "SELECT * FROM notice WHERE announ_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Number);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					ad = new Admin();
					ad.setAnnounNum(rs.getInt("announ_num"));
					ad.setMemberId(rs.getString("member_id"));
					ad.setMemberNick(rs.getString("member_nick"));
					ad.setAnnounFirst(rs.getString("announ_first"));
					ad.setAnnounLast(rs.getString("announ_last"));
					ad.setAnnountDate(rs.getDate("announ_date"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconn();
			}

			return ad;
		}

		// 공지사항 작성
		public int insertNoticeAnn(Admin admin) {
			int result = 0;
			try {
				conn();
				String sql = "INSERT INTO notice values (noticef.NEXTVAL, ?,?,?,?,sysDate)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getMemberId());
				pstmt.setString(2, admin.getMemberNick());
				pstmt.setString(3, admin.getAnnounFirst());
				pstmt.setString(4, admin.getAnnounLast());

				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconn();
			}

			return result;
		}
}
