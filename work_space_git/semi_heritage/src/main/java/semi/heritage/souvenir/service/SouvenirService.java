package semi.heritage.souvenir.service;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.commit;
import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;
import static semi.heritage.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semi.heritage.member.vo.Member;
import semi.heritage.souvenir.dao.SouvenirDao;
import semi.heritage.souvenir.vo.SouvenirBuyVO;
import semi.heritage.souvenir.vo.SouvenirCartVO;
import semi.heritage.souvenir.vo.SouvenirPayVO;
import semi.heritage.souvenir.vo.SouvenirProductVO;

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

	public SouvenirProductVO findProductByNo(int productNo) {
		Connection conn = getConnection();
		SouvenirProductVO sp = dao.findProductByNo(conn, productNo);
		return sp;
	}

	// 테스트
//	public SouvenirProductVO findProductByName(String productName) {
//		Connection conn = getConnection();
//		SouvenirProductVO sp = dao.findProductByName(conn, productName);
//		return sp;
//	}

	public SouvenirCartVO findCartByNo(int seqNo) {
		Connection conn = getConnection();
		SouvenirCartVO sc = dao.findCartBySeqNo(conn, seqNo);
		return sc;
	}

	// cart
	public List<SouvenirCartVO> getCartList(int uNo) {
		Connection conn = getConnection();
		List<SouvenirCartVO> list = dao.selectCartByUNO(conn, uNo);
		close(conn);
		return list;
	}

	public int insertCart(SouvenirProductVO cart, int userno) {
		Connection conn = getConnection();
		int result = dao.insertCart(conn, cart, userno);

		if (result > 0) {

			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteCart(int seqNo) {
		Connection conn = getConnection();
		int result = dao.deleteCart(conn, seqNo, "Y");

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return result;
	}

	//링크 복사 기능
	public SouvenirProductVO copyLinkCart(int productNo) {
		Connection conn = getConnection();
		SouvenirProductVO link = dao.findProductByNo(conn, productNo);
		
		return link;
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

		System.out.println("구매목록" + list);
		return list;
	}

	public int updateBuyING(int uNo) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.updateBuyING(conn, uNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

//	public int delete(int no) {
//		Connection conn = getConnection();
//		int result = dao.updateStatus(conn, no, "N");
//		
//		if(result > 0) {
//			commit(conn);
//		}else {
//			rollback(conn);
//		}
//		close(conn);
//		return result;
//	}

}
