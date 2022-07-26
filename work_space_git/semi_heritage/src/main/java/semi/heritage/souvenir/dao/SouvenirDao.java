package semi.heritage.souvenir.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.souvenir.vo.Souvenir_Cart_VO;
import semi.heritage.souvenir.vo.Souvenir_Product_VO;

public class SouvenirDao {

	// 상품 정보
	// 전체 출력
	public List<Souvenir_Product_VO> selectProductAll(Connection conn) {
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
	public List<Souvenir_Product_VO> selectByCategory(Connection conn, String souv_pro_category) {
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

	// 장바구니
	public List<Souvenir_Cart_VO> selectCartByUNO(Connection conn, int uNo) {
		List<Souvenir_Cart_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// uNo번의 회원이 가진 장바구니의 회원번호,제품명, 제품가격, 제품카테고리 출력
			String sql = "SELECT sc.uno, SP.SOUV_PRO_NAME, SP.SOUV_PRO_PRICE, SP.SOUV_PRO_CATEGORY "
					+ "from SOUV_CART SC, SOUV_PRODUCT SP " + "WHERE SC.SOUV_PRO_NO = SP.SOUV_PRO_NO and sc.uno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + uNo + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				int souv_cart_no = rs.getInt(count++);
				int souv_pro_no = rs.getInt(count++);
				String status = rs.getString(count++);

				Souvenir_Cart_VO info = new Souvenir_Cart_VO(souv_cart_no, uNo, souv_pro_no, status);
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
	
	// 결제정보 출력
	
	// 구매정보(결제 후 구매 이력 출력)

}
