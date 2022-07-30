package semi.heritage.souvenir.service;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.commit;
import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;
import static semi.heritage.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semi.heritage.souvenir.dao.SouvenirDao;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;

public class Souvenir_Cart_Service {
	private SouvenirDao dao = new SouvenirDao();
	
	public List<Souvenir_Cart_VO> getCartList(int uNo) {
		Connection conn = getConnection();
		List<Souvenir_Cart_VO> list = dao.selectCartByUNO(conn, uNo);
		close(conn);
		return list;
	}
	
	public int insertCart(Souvenir_Cart_VO cart) {
		Connection conn = getConnection();
		int result = dao.insertCart(conn, cart);
		
		if(result > 0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	
	public int deleteCart(int no) {
		Connection conn = getConnection();
		int result = dao.deleteCart(conn, no, "Y");
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	
}


















