package semi.heritage.favorite.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.favorite.vo.favoriteVO;

public class favoriteDao {

	public List<favoriteVO> sortedByFavorite(Connection conn) {
		List<favoriteVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ROWNUM, FV.*"
					   + " FROM(SELECT no from favorite group by no order by COUNT(uno) desc) FV"
					   + " WHERE ROWNUM BETWEEN 1 AND 10";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				int no = rs.getInt(count++);

				favoriteVO favRank = new favoriteVO(rowNum, no);
				list.add(favRank);
				
				no = list.get(0).getNo();
				System.out.println(no);
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
