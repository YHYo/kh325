package semi.heritage.souvenir.dao;

import static com.kh.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import semi.heritage.souvenir.vo.Souvenir_Pay_VO;


public class Souvenir_Pay_Dao {

	//결제정보는 저장 안하고, 회원정보에서/ 장바구니에서/ 끌어오고, 카듣정보는 직접 입력하게
	//
	public int insert(Connection conn, int uNo, Date souv_pay_date, int souv_pay_card) {
		try {
			String sql = "INSERT INTO SOUV_PAY VALUES(SOUV_PAY_NO.NEXTVAL,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uNo);
			pstmt.setDate(2, souv_pay_date);
			pstmt.setInt(3, souv_pay_card);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Souvenir_Pay_VO findMemberById(Connection conn, int uno, int SOUV_CART_NO) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM  WHERE ID=? AND STATUS='Y'";
		
		try {
			pstmt = conn.prepareStatement(query); // 기본 쿼리 셋팅
			pstmt.setString(1, id); // ? 구간을 문자열로 채워주는 코드
			rs = pstmt.executeQuery(); // 실제 DB에 쿼리를 요청하는 코드
			
			if(rs.next()) { // 결과가 있는 경우
				Souvenir_Pay_VO sp = new Souvenir_Pay_VO();
				
				int souv_pay_no;
				int uno;
				Date souv_pay_date;
				int souv_pay_card;
				sp.setNo(rs.getInt("no"));
				sp.setId(rs.getString("id"));
				sp.setPassword(rs.getString("password"));
				sp.setRole(rs.getString("role"));
				sp.setName(rs.getString("name"));
				sp.setPhone(rs.getString("phone"));
				sp.setEmail(rs.getString("email"));
				sp.setAddress(rs.getString("address"));
				sp.setHobby(rs.getString("hobby"));
				sp.setStatus(rs.getString("status"));
				sp.setEnroll_date(rs.getDate("enroll_date"));
				sp.setModify_date(rs.getDate("modify_date"));
				return sp;
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
