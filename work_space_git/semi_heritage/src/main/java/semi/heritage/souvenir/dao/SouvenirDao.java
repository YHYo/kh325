package semi.heritage.souvenir.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.souvenir.vo.Souvenir_Buy_VO;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;
import semi.heritage.souvenir.vo.Souvenir_Pay_VO;
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

				String SOUV_PRO_NAME = rs.getString(count++);
				String SOUV_PRO_PRICE = rs.getString(count++);
				String SOUV_PRO_CATEGORY = rs.getString(count++);
				
				Souvenir_Cart_VO info = new Souvenir_Cart_VO(uNo, SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_CATEGORY);
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
	public List<Souvenir_Pay_VO> selectPayByUNO(Connection conn, int uNo) {
		List<Souvenir_Pay_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 카트랑 상품에서 정보 끌어오기(회원번호 300인사람의 장바구니, 상품 회원정보 끌어오기)
			// 회원번호, 이름, 주소, 전번, 이메일 / 상품번호, 상품이름, 상품별 각각 가격, 총가격, 배송비포함가격
			String sql = "SELECT UI.uno,ui.uname,ui.uadr, ui.upn, ui.uemail, sp.souv_pro_no, sp.souv_pro_name, sp.souv_pro_price, SUM(sp.souv_pro_price)OVER(), SUM(sp.souv_pro_price)OVER()+3000 "
					+ "	FROM SOUV_CART SC, SOUV_PRODUCT SP, USERINFO UI "
					+ "	WHERE sc.souv_pro_no=sp.souv_pro_no AND UI.uNo=sc.uno AND ui.uno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + uNo + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				String uname = rs.getString(count++);
				String uadr = rs.getString(count++);
				String upn = rs.getString(count++);
				String uemail = rs.getString(count++);
				int souv_pro_no = rs.getInt(count++);
				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
				int total_price = rs.getInt(count++);
				int bsb_total_price = rs.getInt(count++);


				Souvenir_Pay_VO info = new Souvenir_Pay_VO(uNo, uname, uadr, upn, uemail, souv_pro_no, souv_pro_name, souv_pro_price, total_price, bsb_total_price);
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
	
	// 구매정보(결제 후 구매 이력 출력)
	public List<Souvenir_Buy_VO> selectBuyByUNO(Connection conn, int uNo) {
		List<Souvenir_Buy_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 회원번호 uNo번인 사람이 결제완료한 구매 정보
			// 주문번호, 회원번호, 상품번호, 상품이름, 상품가격, 결제가격(상품총가격+배송비)
			String sql = "SELECT SC.SOUV_CART_NO||UI.uno, ui.uno, sp.souv_pro_no, sp.souv_pro_name, sp.souv_pro_price, SUM(sp.souv_pro_price)OVER()+3000  "
					+ "	FROM USERINFO UI, souv_cart SC, souv_product SP "
					+ "	WHERE UI.uno=sc.uno AND sc.souv_pro_no=sp.souv_pro_no AND sc.status = 'Y' AND UI.uno=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + uNo + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				int orderNum          = rs.getInt(count++);
				int souv_pro_no       = rs.getInt(count++);
				String souv_pro_name  = rs.getString(count++);
				int souv_pro_price    = rs.getInt(count++);
				int bsb_total_price   = rs.getInt(count++);


				Souvenir_Buy_VO info = new Souvenir_Buy_VO(orderNum, uNo, souv_pro_no, souv_pro_name, souv_pro_price, bsb_total_price);
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
