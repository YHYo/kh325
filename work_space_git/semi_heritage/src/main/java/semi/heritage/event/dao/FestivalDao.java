package semi.heritage.event.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.event.vo.Festival;



public class FestivalDao {

	// 행사 목록 전체조회
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
				String eventName	= rs.getString(count++);
				
			
				Festival info = new Festival(seqNo, siteCode, subtitle, subContent, sDate, eDate, groupName, contact, subDesc, subPath, subDesc_2, subDesc_3, mainImageTemp, sido, gugun, subDate, eventName);
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
	
	
	//- 월로 통일해서 나열 -> 7월이면 7월에 해당하는 --> < 행사구분명 / 프로그램명 / 장소 = 시도 - 구군 - 위치  / 기간 = 시작일자 - 종료일자 / 행사링크 > 쿼리
	//- 상세정보 없이 리스트만 출력 후 링크로 보내주기 
	// 월별로 조회 
	public List<Festival> selectByMonth(Connection conn , String eventMonth) {
		List<Festival> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT en.eventname, EI.subtitle, EI.sido ,EI.gugun, EI.subDesc ,EI.sDate, EI.EDate, EI.subPath "
					+ " FROM EVENT_INFO EI,  EVENT_NAME EN "
					+ " WHERE EI.siteCode = EN.siteCode "
					+ " AND EI.sDate Like ? "
					+ " ORDER BY EI.sDate ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eventMonth + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int count = 1;
				String eventname	= rs.getString(count++);
				String subtitle	= rs.getString(count++);
				String sido	   = rs.getString(count++);
				String gugun	    = rs.getString(count++);
				String subDesc	    = rs.getString(count++);
				String sDate	   = rs.getString(count++);
				String EDate		= rs.getString(count++);
				String subPath		= rs.getString(count++);
				
				Festival info = new Festival(eventname, subtitle, sido, gugun, subDesc, sDate, EDate, subPath);
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
