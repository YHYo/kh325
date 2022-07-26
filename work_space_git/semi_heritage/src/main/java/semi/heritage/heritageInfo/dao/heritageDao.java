package semi.heritage.heritageInfo.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semi.heritage.heritageInfo.vo.heritageVO;
import semi.heritage.heritageInfo.vo.heritageImage;



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
			String sql = "INSERT INTO heritageImage(imageNo, imageUrl, ccimDesc, sn, ccbaKdcd, ccbaCtcd, ccbaAsno) VALUES(SEQ_HERITAGE_Image.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			
			pstmt.setString(cnt++, heritageimage.getImageUrl());
			pstmt.setString(cnt++, heritageimage.getCcimDesc());
			pstmt.setInt(cnt++, heritageimage.getSn());
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
	
	
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		heritageDao dao = new heritageDao();
		
	}
}


