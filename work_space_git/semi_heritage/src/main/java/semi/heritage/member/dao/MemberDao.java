package semi.heritage.member.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import semi.heritage.member.vo.Member;

public class MemberDao {

	Member memver = new Member();

	// 회원가입
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO USERINFO VALUES(SEQ_UNO.NEXTVAL,?, ?, ?, "
				+ "DEFAULT, DEFAULT,DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUemail());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 회원정보 수정
	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String query = "UPDATE USERINFO SET uemail=?, upw=?, uname=?, upn=?, uadr=?, "
				+ "originalPhoto=?, renamedPhoto=?, introduce=?,"
				+ " twt=?, insta=?, facebook=? WHERE UNO=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUemail());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUpn());
			pstmt.setString(5, member.getUadr());
			pstmt.setString(6, member.getOriginalPhoto());
			pstmt.setString(6, member.getRenamedPhoto());
			pstmt.setString(7, member.getIntroduce());
			pstmt.setString(8, member.getTwt());
			pstmt.setString(9, member.getInsta());
			pstmt.setString(10, member.getFacebook());
			pstmt.setInt(11, member.getUno());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 탈퇴하기
	public int updateStatus(Connection conn, int uNo, String status) {
		PreparedStatement pstmt = null;
		String query = "UPDATE USERINFO SET STATUS=? WHERE uNO=?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status); // Y,N (STATUS IN ('Y', 'N'))
			pstmt.setInt(2, uNo);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 로그인을 위한 아이디 검색 (탈퇴했는지 안했는지 알아봄)
	public Member findMemberById(Connection conn, String uemail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = " SELECT * FROM USERINFO WHERE uemail=? AND STATUS='Y' ";

		try {
			pstmt = conn.prepareStatement(query); // 기본 쿼리 셋팅
			pstmt.setString(1, uemail); // ? 구간을 문자열로 채워주는 코드
			rs = pstmt.executeQuery(); // 실제 DB에 쿼리를 요청하는 코드

			if (rs.next()) { // 결과가 있는 경우
				Member m = new Member();
				m.setUno(rs.getInt("uNo"));
				m.setUemail(rs.getString("uEmail"));
				m.setUpw(rs.getString("uPW"));
				m.setUname(rs.getString("uName"));
				m.setUpn(rs.getString("uPN"));
				m.setUadr(rs.getString("uAdr"));
				m.setOriginalPhoto(rs.getString("ORIGINAL_PHOTO"));
				m.setRenamedPhoto(rs.getString("RENAMED_PHOTO"));
				m.setIntroduce(rs.getString("introduce"));
				m.setTwt(rs.getString("twt"));
				m.setInsta(rs.getString("insta"));
				m.setFacebook(rs.getString("facebook"));
				m.setStatus(rs.getString("STATUS"));

				return m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

}
