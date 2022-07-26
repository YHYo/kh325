package semi.heritage.palace.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.palace.vo.Palace_Jongmyo_Sangse_image;


public class Palace_Jongmyo_Sangse_Image_Dao {

	// result
	public List<Palace_Jongmyo_Sangse_image> selectAll(Connection conn) {
		List<Palace_Jongmyo_Sangse_image> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM Palace_Jongmyo_Image_Sangse ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;

				// 13개
				int serial_number = rs.getInt(count++);
				int gung_number = rs.getInt(count++);
				int detail_code = rs.getInt(count++);

				String imageIndex = rs.getString(count++);
				String imageContentsKor = rs.getString(count++);
				String imageContentsEng = rs.getString(count++);
				String imageContentsChi = rs.getString(count++);
				String imageContentsJpa = rs.getString(count++);
				String imageExplanationKor = rs.getString(count++);
				String imageExplanationEng = rs.getString(count++);
				String imageExplanationChi = rs.getString(count++);
				String imageExplanationJpa = rs.getString(count++);
				String imageUrl = rs.getString(count++);

				Palace_Jongmyo_Sangse_image info = new Palace_Jongmyo_Sangse_image(serial_number, gung_number,
						detail_code, imageIndex, imageContentsKor, imageContentsEng, imageContentsChi, imageContentsJpa,
						imageExplanationKor, imageExplanationEng, imageExplanationChi, imageExplanationJpa, imageUrl);
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

	public int insert(Connection conn, Palace_Jongmyo_Sangse_image pjs) {
		try {
			String sql = "INSERT INTO "
					+ " Palace_Jongmyo_Image_Sangse( "
					+ "						serial_number, gung_number, detail_code, "
					+ "						imageIndex, "
					+ "						imageContentsKor, imageContentsEng, imageContentsChi, imageContentsJpa,"
					+ "						imageExplanationKor, imageExplanationEng, imageExplanationChi, imageExplanationJpa, "
					+ "						imageUrl) "
					+ " VALUES(				?, ?, ?, "
					+ "						?, "
					+ "						?, ?, ?, ?, "
					+ "						?, ?, ?, ?, "
					+ "						?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			int cnt = 1;
			
			pstmt.setInt(cnt++, pjs.getSerial_number());
			pstmt.setInt(cnt++, pjs.getGung_number());
			pstmt.setInt(cnt++, pjs.getDetail_code());

			pstmt.setString(cnt++, pjs.getImageIndex());
			pstmt.setString(cnt++, pjs.getImageContentsKor());
			pstmt.setString(cnt++, pjs.getImageContentsEng());
			pstmt.setString(cnt++, pjs.getImageContentsChi());
			pstmt.setString(cnt++, pjs.getImageContentsJpa());
			pstmt.setString(cnt++, pjs.getImageExplanationKor());
			pstmt.setString(cnt++, pjs.getImageExplanationEng());
			pstmt.setString(cnt++, pjs.getImageExplanationChi());
			pstmt.setString(cnt++, pjs.getImageExplanationJpa());
			pstmt.setString(cnt++, pjs.getImageUrl());



			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
