package semi.heritage.favorite.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.favorite.vo.favoriteMyPageVO;
import semi.heritage.favorite.vo.favoriteVO;

public class favoriteDao {

	public int insert(Connection conn, int uNo, int no) {
		
		// 일반 문화재 찜 추가
		try {
			String sql = "INSERT INTO hFavorite VALUES(SEQ_hfavNum.NEXTVAL, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uNo);
			pstmt.setInt(2, no);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}

	// 일반 문화재 찜 삭제
	public int delete(Connection conn, int uNo, int no) {// 즐겨찾기 정보 삽입시 회원번호랑 마번 입력받아서 정보 삭제
		try {
			String sql = "DELETE FROM hFavorite WHERE uNo = ? AND no = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uNo);
			pstmt.setInt(2, no);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 마이페이지에서 찜목록 출력
	public List<favoriteMyPageVO> selectAll(Connection conn, int uNo) {
		List<favoriteMyPageVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT "
					+ "HFV.hfavNum, H.CCMANAME, H.CCBAMNM1, H.CCBALCAD, H.IMAGEURL, H.CONTENT "
					+ "FROM "
					+ "heritage H, hFavorite HFV "
					+ "WHERE "
					+ "H.no = HFV.no AND "
					+ "HFV.uNO = ? "
					+ "order by hfavNum desc"; 
																														
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int hfavNum = rs.getInt("hfavNum");
				String ccmaName = rs.getString("ccmaName");
				String ccbaMnm1 = rs.getString("ccbaMnm1");
				String ccbaLcad = rs.getString("ccbaLcad");
				String imageUrl = rs.getString("imageUrl");
				String content = rs.getString("content");
				favoriteMyPageVO mypage = new favoriteMyPageVO(hfavNum, ccmaName, ccbaMnm1, ccbaLcad, imageUrl, content);
				list.add(mypage);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	// 문화재 번호로 해당 찜 개수 구하기
	public List<favoriteVO> CountFavoriteByNo(Connection conn, int no) {
		List<favoriteVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			String sql = "SELECT COUNT(uno) from favorite group by no having no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int countNum = rs.getInt(count++);

				favoriteVO info = new favoriteVO(countNum);
				list.add(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(list);
		return list;
	}
	
}
