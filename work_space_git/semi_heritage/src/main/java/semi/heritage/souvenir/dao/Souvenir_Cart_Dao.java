package semi.heritage.souvenir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.souvenir.vo.Souvenir_Product_VO;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

public class Souvenir_Cart_Dao {
	
	// 장바구니 추가
	// uNo는 로그인한 정보에서 회원번호 가져옴. SOUV_PRO_NO는 클릭한 상품번호 가져옴
	public int insert(Connection conn, int uNo, int SOUV_PRO_NO) {
		try {
			String sql = "INSERT INTO SOUV_CART VALUES(SOUV_CART_NO.NEXTVAL,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uNo);
			pstmt.setInt(2, SOUV_PRO_NO);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 장바구니 하나 삭제
	// uNo는 로그인한 정보에서 회원번호 가져옴. SOUV_PRO_NO는 장바구니 삭제 클릭한 상품번호 가져옴
	public int delete(Connection conn, int uNo, int SOUV_PRO_NO) {
		try {
			String sql = "DELETE FROM SOUV_CART WHERE uNo = ? AND SOUV_PRO_NO = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uNo);
			pstmt.setInt(2, SOUV_PRO_NO);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 장바구니 전체 삭제
	public int deleteAll(Connection conn) {
		try {
			String sql = "DELETE FROM SOUV_CART ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	// 장바구니 목록 전체 출력 (상품명, 카테고리, 가격)
	public List<Souvenir_Product_VO> selectAll(Connection conn) {
		List<Souvenir_Product_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql ="SELECT SP.SOUV_PRO_NAME, SP.SOUV_PRO_PRICE, SP.SOUV_PRO_CATEGORY "
					+ "from SOUV_CART SC, SOUVENIR_PRODUCT SP "
					+ "WHERE SC.SOUV_PRO_NO = SP.SOUV_PRO_NO ";
																														
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				String SOUV_PRO_NAME = rs.getString("SOUV_PRO_NAME");
				int SOUV_PRO_PRICE = rs.getInt("SOUV_PRO_PRICE");
				String SOUV_PRO_CATEGORY = rs.getString("SOUV_PRO_CATEGORY");
				Souvenir_Product_VO sc = new Souvenir_Product_VO(SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_CATEGORY);
				list.add(sc);
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

	
	
}
