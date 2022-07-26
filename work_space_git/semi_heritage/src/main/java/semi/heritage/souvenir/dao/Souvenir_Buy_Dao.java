package semi.heritage.souvenir.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Souvenir_Buy_Dao {
	
	// 구매정보 저장 (구매(주문)번호, 상품번호, 결제번호, 총가격, 회원번호(결제테이블의 날짜)
	// 주문번호, 구매시퀀스(장바구니시퀀스랑 동일), 카테고리, 상품명, 가격 << 보여지는거
//	int souv_buy_no;
//	int uno;
//	int souv_pro_no;
//	int souv_pay_no;
//	int souv_buy_total_price;
//	Date souv_buy_date;
	
	public int insert(Connection conn, int uno, int SOUV_CART_NO) {
		try {
//			String sql = "INSERT INTO SOUV_CART VALUES(SOUV_BUY_NO.NEXTVAL,?,?,?)";
//			String sql = "SELECT  INTO SOUV_CART VALUES(SOUV_BUY_NO.NEXTVAL,?,?,?)";
			String sql = "SELECT * FROM SOUV_CART SC, SOUV_PRODUCT SP "
						+ "WHERE sc.souv_pro_no=sp.souv_pro_no AND SC.uNo=100";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, souv_pay_date);
			pstmt.setInt(2, souv_pay_card);
			pstmt.setInt(2, uNo);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
