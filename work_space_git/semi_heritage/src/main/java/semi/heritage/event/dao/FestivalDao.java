package semi.heritage.event.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.event.vo.Festival;



public class FestivalDao {

	// 전체조회
	public List<Festival> selectAll(Connection conn) {
		List<Festival> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM EVENT_INFO ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				int count = 1;
				int seqNo = rs.getInt(count++);
				String subtitle	= rs.getString(count++);
				String subContent	= rs.getString(count++);
				String sDate	   = rs.getString(count++);
				String eDate	    = rs.getString(count++);
				String groupName	= rs.getString(count++);
				String contact	   = rs.getString(count++);
				String subDesc	    = rs.getString(count++);
				String subPath	   = rs.getString(count++);
				String subDesc_2	= rs.getString(count++);
				String subDesc_3	= rs.getString(count++);
				String mainImageTemp		= rs.getString(count++);
				String sido		= rs.getString(count++);
				String gugun		= rs.getString(count++);
				String subDate		= rs.getString(count++);
				String siteCode	= rs.getString(count++);
			
				Festival info = new Festival(seqNo, siteCode, subtitle, subContent, sDate, eDate, groupName, contact, subDesc, subPath, subDesc_2, subDesc_3, mainImageTemp, sido, gugun, subDate);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int insert(Connection conn, Festival festival) {
		try {
			String sql = "INSERT INTO " + " EVENT_INFO( seqNo, subtitle, subContent, sDate, eDate, "
					+ "				groupName, contact, subDesc, subPath, subDesc_2, "
					+ "				subDesc_3, mainImageTemp, sido, gugun, subDate,siteCode) " + " VALUES(?, ?, ?, "
					+ "		   ?, ?, ?, " + "        ?, ?, ?, " + "		   ?, ?, ?, " + "        ?, ?, ?, ?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			int cnt = 1;
			pstmt.setInt(cnt++, festival.getSeqNo());
			pstmt.setString(cnt++, festival.getSubTitle());
			pstmt.setString(cnt++, festival.getSubContent());
			pstmt.setString(cnt++, festival.getsDate());
			pstmt.setString(cnt++, festival.geteDate());
			pstmt.setString(cnt++, festival.getGroupName());
			pstmt.setString(cnt++, festival.getContact());
			pstmt.setString(cnt++, festival.getSubDesc());
			pstmt.setString(cnt++, festival.getSubPath());
			pstmt.setString(cnt++, festival.getSubDesc_2());
			pstmt.setString(cnt++, festival.getSubDesc_3());
			pstmt.setString(cnt++, festival.getMainImageT());
			pstmt.setString(cnt++, festival.getSido());
			pstmt.setString(cnt++, festival.getGugun());
			pstmt.setString(cnt++, festival.getSubDate());
			pstmt.setString(cnt++, festival.getSiteCode());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	

}
