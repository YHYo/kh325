package semi.heritage.souvenir.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.souvenir.vo.Souvenir_Product_VO;

public class Souvenir_Product_Dao {


	// 전체 출력
	public List<Souvenir_Product_VO> selectAll(Connection conn) {
		List<Souvenir_Product_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM SOUVENIR_PRODUCT ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;

				int souv_pro_no = rs.getInt(count++);
				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
				String souv_pro_category = rs.getString(count++);

				Souvenir_Product_VO info = new Souvenir_Product_VO(souv_pro_no, souv_pro_name, souv_pro_price,
						souv_pro_category);
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

	// 카테고리 클릭시 클릭한 버튼의 매개변수값을 받아와 넣어준다
	public List<Souvenir_Product_VO> selectByHorseName(Connection conn, String souv_pro_category) {
		List<Souvenir_Product_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM SOUVENIR_PRODUCT WHERE souv_pro_category = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + souv_pro_category + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				int souv_pro_no = rs.getInt(count++);
				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
//				String souv_pro_category = rs.getString(count++);

				Souvenir_Product_VO info = new Souvenir_Product_VO(souv_pro_no, souv_pro_name, souv_pro_price,
						souv_pro_category);
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

}
