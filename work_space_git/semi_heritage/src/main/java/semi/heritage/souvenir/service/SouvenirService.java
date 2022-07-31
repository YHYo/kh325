package semi.heritage.souvenir.service;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.commit;
import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;
import static semi.heritage.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semi.heritage.souvenir.dao.SouvenirDao;
import semi.heritage.souvenir.vo.SouvenirBuyVO;
import semi.heritage.souvenir.vo.SouvenirPayVO;
import semi.heritage.souvenir.vo.SouvenirProductVO;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;

public class SouvenirService {
	SouvenirDao dao = new SouvenirDao();

	// product
	public List<SouvenirProductVO> getProductList() {
		Connection conn = getConnection();
		List<SouvenirProductVO> list = dao.selectProductAll(conn);
		close(conn);
		return list;
	}

	public List<SouvenirProductVO> getProductListByCategory(String souv_pro_category) {
		Connection conn = getConnection();
		List<SouvenirProductVO> list = dao.selectByCategory(conn, souv_pro_category);
		close(conn);
		return list;
	}

	// cart
	public List<Souvenir_Cart_VO> getCartList(int uNo) {
		Connection conn = getConnection();
		List<Souvenir_Cart_VO> list = dao.selectCartByUNO(conn, uNo);
		close(conn);
		return list;
	}

	public int insertCart(Souvenir_Cart_VO cart) {
		Connection conn = getConnection();
		int result = dao.insertCart(conn, cart);

		if (result > 0) {

			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteCart(int no) {
		Connection conn = getConnection();
		int result = dao.deleteCart(conn, no, "Y");

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return result;
	}

	// pay
	public List<SouvenirPayVO> getPayList(int uNo) {
		Connection conn = getConnection();
		List<SouvenirPayVO> list = dao.selectPayByUNO(conn, uNo);
		close(conn);
		return list;
	}

	// buy
	public List<SouvenirBuyVO> getBuyList(int uNo) {
		Connection conn = getConnection();
		List<SouvenirBuyVO> list = dao.selectBuyByUNO(conn, uNo);
		close(conn);
		return list;
	}
}