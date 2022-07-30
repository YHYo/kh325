package semi.heritage.souvenir.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.souvenir.vo.SouvenirBuyVO;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;
import semi.heritage.souvenir.vo.SouvenirPayVO;
import semi.heritage.souvenir.vo.SouvenirProductVO;

public class SouvenirDao {

	// 상품 정보
	// 전체 출력
	public List<SouvenirProductVO> selectProductAll(Connection conn) {
		List<SouvenirProductVO> list = new ArrayList<>();
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

				SouvenirProductVO info = new SouvenirProductVO(souv_pro_no, souv_pro_name, souv_pro_price,
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
	public List<SouvenirProductVO> selectByCategory(Connection conn, String souv_pro_category) {
		List<SouvenirProductVO> list = new ArrayList<>();
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

				SouvenirProductVO info = new SouvenirProductVO(souv_pro_no, souv_pro_name, souv_pro_price,
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

	// 장바구니 추가
	public int insertCart(Connection conn, Souvenir_Cart_VO cart) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO SOUV_CART VALUES(to_char(SYSDATE,'YYYYMMDDHH24'),?,?,?,?,?,DEFAULT, DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cart.getuNo());
			pstmt.setInt(2, cart.getSOUV_PRO_NO());
			pstmt.setString(3, cart.getSOUV_PRO_NAME());
			pstmt.setInt(4, cart.getSOUV_PRO_PRICE());
			pstmt.setString(5, cart.getSOUV_PRO_CATEGORY());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 장바구니 출력
	public List<Souvenir_Cart_VO> selectCartByUNO(Connection conn, int uNo) {
		List<Souvenir_Cart_VO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// uNo번의 회원이 가진 장바구니의 제품명, 제품가격, 제품카테고리 출력 (구매 / 삭제한 품목 제외. 구매/삭제시 STATUS들이 Y로 변경)
			String sql = "SELECT SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_CATEGORY "
					+ "FROM SOUV_CART WHERE UNO=?  AND BUY_STATUS='N' AND DELETE_STATUS='N' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + uNo + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				String SOUV_PRO_NAME = rs.getString(count++);
				int SOUV_PRO_PRICE = rs.getInt(count++);
				String SOUV_PRO_CATEGORY = rs.getString(count++);
//				String BUY_STATUS = rs.getString(count++);
//				String DELETE_STATUS = rs.getString(count++);

				Souvenir_Cart_VO info = new Souvenir_Cart_VO(uNo, SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_CATEGORY
//						,BUY_STATUS, DELETE_STATUS
						);
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

	// 장바구니 삭제
	public int deleteCart(Connection conn, int uNo, String status) {
		PreparedStatement pstmt = null;
		String query = "UPDATE SOUV_CART SET DELETE_STATUS = 'Y' WHERE NO = ?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, status);
			pstmt.setInt(1, uNo);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	// 결제정보 출력
	public List<SouvenirPayVO> selectPayByUNO(Connection conn, int uNo) {
		List<SouvenirPayVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 카트랑 회원정보에서 정보 끌어오기(회원번호 300인사람의 장바구니, 상품 회원정보 끌어오기)
			// 회원번호, 이름, 주소, 전번, 이메일 / 상품번호, 상품이름, 상품별 각각 가격, 총가격, 배송비포함가격
//			String sql = "SELECT UI.uno,ui.uname,ui.uadr, ui.upn, ui.uemail, sc.souv_pro_no, sc.souv_pro_name, sc.souv_pro_price, SUM(sc.souv_pro_price)OVER() AS \"총가격\", SUM(sc.souv_pro_price)OVER()+3000 AS \"배송비포함\" "
//					+ "FROM SOUV_CART SC, USERINFO UI " 
//					+ "WHERE UI.uNo=sc.uno AND sc.uno=?";
			
			String sql = "SELECT UI.uno, ui.uname, ui.uadr, ui.upn, ui.uemail, "
					+ "sc.souv_pro_no, sc.souv_pro_name, sc.souv_pro_price, "
					+ "SUM(sc.souv_pro_price)OVER() AS \"총가격\", SUM(sc.souv_pro_price)OVER()+3000 AS \"배송비포함\" "
					+ "FROM SOUV_CART SC, USERINFO UI "
					+ "WHERE UI.uNo=sc.uno AND sc.uno=2 AND sc.BUY_STATUS='N' AND sc.DELETE_STATUS='N' ";
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

				SouvenirPayVO info = new SouvenirPayVO(uNo, uname, uadr, upn, uemail, souv_pro_no, souv_pro_name,
						souv_pro_price, total_price, bsb_total_price);
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
	public List<SouvenirBuyVO> selectBuyByUNO(Connection conn, int uNo) {
		List<SouvenirBuyVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 회원번호 uNo번인 사람이 결제완료한 구매 정보
			// 주문번호, 순번, 상품번호, 상품이름, 상품가격, 결제가격(상품총가격+배송비)
//			String sql = "SELECT SOUV_CART_NO||uno AS \"주문번호\", uno, souv_pro_no, souv_pro_name, souv_pro_price, SUM(souv_pro_price)OVER()+3000 AS \"결제금액\"  "
//					+ "FROM souv_cart SC\r\n" + "WHERE  status = 'Y' AND uno=? ";
			
			String sql = "SELECT SOUV_CART_NO||uno AS \"주문번호\", rownum, souv_pro_no, souv_pro_name, souv_pro_price, "
					+ "SUM(souv_pro_price)OVER()+3000 AS \"결제금액\"  "
					+ "FROM souv_cart SC\r\n"
					+ "WHERE BUY_STATUS='Y' AND uno=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + uNo + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				int orderNum = rs.getInt(count++);
				int souv_pro_no = rs.getInt(count++);
				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
				int bsb_total_price = rs.getInt(count++);
				int rownum = rs.getInt(count++);

				SouvenirBuyVO info = new SouvenirBuyVO(orderNum, uNo, souv_pro_no, souv_pro_name, souv_pro_price, bsb_total_price, rownum);
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
