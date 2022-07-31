package semi.heritage.heritageInfo.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semi.heritage.common.util.PageInfo;

import semi.heritage.heritageInfo.vo.heritageVO;
import semi.heritage.heritageInfo.vo.heritageVideo;
import semi.heritage.favorite.vo.favoriteVO;
import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageMainVO;



public class heritageDao {

	public int insert(Connection conn, heritageVO heritagevo) {
		try {
			String sql = "INSERT INTO HERITAGE(sn, no, ccmaName, crltsnoNm, ccbaMnm1, ccbaMnm2, ccbaCtcdNm, ccsiName, ccbaAdmin, ccbaKdcd, ccbaCtcd, ccbaAsno, ccbaCncl, ccbaCpno, longitude, latitude, gcodeName, bcodeName, mcodeName, scodeName, ccbaQuan, ccbaAsdt, ccbaLcad, ccceName, ccbaPoss, imageUrl, content) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, heritagevo.getSn());
			pstmt.setInt(cnt++, heritagevo.getNo());
			pstmt.setString(cnt++, heritagevo.getCcmaName());
			pstmt.setInt(cnt++, heritagevo.getCrltsnoNm());
			pstmt.setString(cnt++, heritagevo.getCcbaMnm1());
			pstmt.setString(cnt++, heritagevo.getCcbaMnm2());
			pstmt.setString(cnt++, heritagevo.getCcbaCtcdNm());
			pstmt.setString(cnt++, heritagevo.getCcsiName());
			pstmt.setString(cnt++, heritagevo.getCcbaAdmin());
			pstmt.setString(cnt++, heritagevo.getCcbaKdcd());
			pstmt.setString(cnt++, heritagevo.getCcbaCtcd());
			pstmt.setString(cnt++, heritagevo.getCcbaAsno());
			pstmt.setString(cnt++, heritagevo.getCcbaCncl());
			pstmt.setString(cnt++, heritagevo.getCcbaCpno());
			pstmt.setString(cnt++, heritagevo.getLongitude());
			pstmt.setString(cnt++, heritagevo.getLatitude());
			pstmt.setString(cnt++, heritagevo.getGcodeName());
			pstmt.setString(cnt++, heritagevo.getBcodeName());
			pstmt.setString(cnt++, heritagevo.getMcodeName());
			pstmt.setString(cnt++, heritagevo.getScodeName());
			pstmt.setString(cnt++, heritagevo.getCcbaQuan());
			pstmt.setString(cnt++, heritagevo.getCcbaAsdt());
			pstmt.setString(cnt++, heritagevo.getCcbaLcad());
			pstmt.setString(cnt++, heritagevo.getCcceName());
			pstmt.setString(cnt++, heritagevo.getCcbaPoss());
			pstmt.setString(cnt++, heritagevo.getImageUrl());
			pstmt.setString(cnt++, heritagevo.getContent());
		
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public int insertImage(Connection conn, heritageImage heritageimage) {
		try {
			String sql = "INSERT INTO heritageImage(imageNo, imageUrl, ccimDesc, sn, no, ccbaKdcd, ccbaCtcd, ccbaAsno) VALUES(SEQ_HERITAGE_Image.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int cnt = 1;
			
			pstmt.setString(cnt++, heritageimage.getImageUrl());
			pstmt.setString(cnt++, heritageimage.getCcimDesc());
			pstmt.setInt(cnt++, heritageimage.getSn());
			pstmt.setInt(cnt++, heritageimage.getNo());
			pstmt.setString(cnt++, heritageimage.getCcbaKdcd());
			pstmt.setString(cnt++, heritageimage.getCcbaCtcd());
			pstmt.setString(cnt++, heritageimage.getCcbaAsno());
		
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int insertVideo(Connection conn, heritageVideo heritagevideo) {
		try {
			String sql = "INSERT INTO heritageVideo(videoNo, videoUrl, sn, no, ccbaKdcd, ccbaCtcd, ccbaAsno) VALUES(SEQ_HERITAGE_Image.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			
			pstmt.setString(cnt++, heritagevideo.getVideoUrl());
			pstmt.setInt(cnt++, heritagevideo.getSn());
			pstmt.setInt(cnt++, heritagevideo.getVideoNo());
			pstmt.setString(cnt++, heritagevideo.getCcbaKdcd());
			pstmt.setString(cnt++, heritagevideo.getCcbaCtcd());
			pstmt.setString(cnt++, heritagevideo.getCcbaAsno());
		
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 메인 페이지 인기 문화재 명소 출력용 (이미지, 이름, 주소, 찜 개수, 리뷰 개수를 찜 개수가 많은 열개를 순서대로 정렬)
	public List<heritageMainVO> mainByFavorite(Connection conn) {
		List<heritageMainVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT "
					+ "ROWNUM, HFV.*, H.ccbaMnm1, H.ccbaCtcdNm, H.ccsiName, H.content, H.IMAGEURL, HR.* "
					+ "FROM"
					+ "(SELECT no, COUNT(uno) from hFavorite group by no order by COUNT(uno) desc) HFV, "
					+ "HERITAGE H, "
					+ "(SELECT NO, COUNT(revNo) FROM HertiageReview group by no order by COUNT(revNo) desc) HR "
					+ "WHERE "
					+ "H.no = HFV.no AND "
					+ "H.no = HR.no AND "
					+ "ROWNUM BETWEEN 1 AND 10";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				int no = rs.getInt(count++);
				int countHfavorite = rs.getInt(count++);
				String ccbaMnm1 = rs.getString(count++);
				String ccbaCtcdNm = rs.getString(count++);
				String ccsiName = rs.getString(count++);
				String content = rs.getString(count++);
				String imageUrl = rs.getString(count++);
				int rNo = rs.getInt(count++);
				int countHreview = rs.getInt(count++);

				heritageMainVO mainByFv = new heritageMainVO(rowNum, no, countHfavorite, ccbaMnm1, ccbaCtcdNm, ccsiName, content, imageUrl, rNo, countHreview);
				list.add(mainByFv);
			}
			System.out.println(list.toString());
			return list;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	
	// 메인페이지에서 이름 키워드로 전체검색시 출력용(이미지, 이름, 주소, 찜 개수를 순번대로 정렬) 
	public List<heritageMainVO> selectByHeritageName(Connection conn, String ccbaMnm, PageInfo pageInfo) {
		List<heritageMainVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ROWNUM, SCH.* "
					+ "FROM "
					+ "(SELECT H.sn, H.ccbaMnm1, H.ccbaCtcdNm, H.ccsiName, H.content, H.IMAGEURL, HFV.* "
					+ "FROM "
					+ "HERITAGE H, "
					+ "(SELECT no, COUNT(uno) from hFavorite group by no) HFV "
					+ "WHERE "
					+ "H.no = HFV.no AND "
					+ "H.ccbaMnm1 like ? "
					+ "ORDER BY H.sn) SCH "
					+ "WHERE "
					+ "ROWNUM BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + ccbaMnm + "%");
			pstmt.setInt(2, pageInfo.getStartList());
			pstmt.setInt(3, pageInfo.getEndList());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				int sn = rs.getInt(count++);
				String ccbaMnm1 = rs.getString(count++);
				String ccbaCtcdNm = rs.getString(count++);
				String ccsiName = rs.getString(count++);
				String content = rs.getString(count++);
				String imageUrl = rs.getString(count++);
				int no = rs.getInt(count++);
				int countHfavorite = rs.getInt(count++);
		
				heritageMainVO info = new heritageMainVO(rowNum, sn, ccbaMnm1, ccbaCtcdNm, ccsiName, content, imageUrl, no, countHfavorite);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(list.toString());
		return list;
	}
	
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		heritageDao dao = new heritageDao();
		
	}
}


