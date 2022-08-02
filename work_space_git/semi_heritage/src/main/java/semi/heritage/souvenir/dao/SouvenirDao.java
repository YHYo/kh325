package semi.heritage.souvenir.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.souvenir.vo.SouvenirBuyVO;
import semi.heritage.souvenir.vo.SouvenirCartVO;
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
			String sql = "SELECT * FROM SOUV_PRODUCT ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				SouvenirProductVO product = new SouvenirProductVO();

				product.setSouv_pro_no(rs.getInt(count++));
				product.setSouv_pro_name(rs.getString(count++));
				product.setSouv_pro_price(rs.getInt(count++));
				product.setSouv_pro_category(rs.getString(count++));
				product.setSouv_pro_url(rs.getString(count++));
				list.add(product);

//				SouvenirProductVO info = new SouvenirProductVO(souv_pro_no, souv_pro_name, souv_pro_price,
//						souv_pro_category, souv_pro_url);
//				list.add(info);
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
			String sql = "SELECT * FROM SOUV_PRODUCT WHERE souv_pro_category LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + souv_pro_category + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				SouvenirProductVO product = new SouvenirProductVO();

				product.setSouv_pro_no(rs.getInt(count++));
				product.setSouv_pro_name(rs.getString(count++));
				product.setSouv_pro_price(rs.getInt(count++));
				product.setSouv_pro_category(rs.getString(count++));
				product.setSouv_pro_url(rs.getString(count++));
				list.add(product);

//				SouvenirProductVO info = new SouvenirProductVO(souv_pro_no, souv_pro_name, souv_pro_price,
//						souv_pro_category, souv_pro_url);
//				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	// 제품번호로 찾기(장바구니 넣을때, 상세보기할때 사용)
	public SouvenirProductVO findProductByNo(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SouvenirProductVO sp = null;
		try {
			String sql = " select * from SOUV_PRODUCT where SOUV_PRO_NO=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = 1;
				sp = new SouvenirProductVO();
				sp.setSouv_pro_no(rs.getInt(count++));
				sp.setSouv_pro_name(rs.getString(count++));
				sp.setSouv_pro_price(rs.getInt(count++));
				sp.setSouv_pro_category(rs.getString(count++));
				sp.setSouv_pro_url(rs.getString(count++));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return sp;
	}

	// 장바구니 추가
	public int insertCart(Connection conn, SouvenirCartVO cart) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO SOUV_CART VALUES(seqNo.NEXTVAL, to_char(SYSDATE,'YYYYMMDDHH24'),?,?,?,?,?,?,DEFAULT, DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cart.getUno());
			pstmt.setInt(2, cart.getSouv_pro_no());
			pstmt.setString(3, cart.getSouv_pro_name());
			pstmt.setInt(4, cart.getSouv_pro_price());
			pstmt.setString(5, cart.getSouv_pro_category());
			pstmt.setString(6, cart.getSouv_pro_url());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 장바구니 출력
	public List<SouvenirCartVO> selectCartByUNO(Connection conn, int uNo) {
		List<SouvenirCartVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// uNo번의 회원이 가진 장바구니의 제품명, 제품가격, 제품카테고리 출력 (구매 / 삭제한 품목 제외. 구매/삭제시 STATUS들이 Y로
			// 변경)
			String sql = "SELECT SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_CATEGORY, SOUV_PRO_URL "
					+ "FROM SOUV_CART WHERE UNO=?  AND BUY_STATUS='N' AND DELETE_STATUS='N' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;

				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
				String souv_pro_category = rs.getString(count++);
				String souv_pro_url = rs.getString(count++);

				SouvenirCartVO info = new SouvenirCartVO(uNo, souv_pro_name, souv_pro_price, souv_pro_category,
						souv_pro_url);
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

	// 장바구니 일련번호(seqNo)를 가져온다. 장바구니 삭제할때 사용

	public SouvenirCartVO findCartBySeqNo(Connection conn, int seqNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SouvenirCartVO sc = null;
		try {
			String sql = "SELECT SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_CATEGORY, SOUV_PRO_URL "
					+ "	FROM SOUV_CART WHERE seqNo=?  AND BUY_STATUS='N' AND DELETE_STATUS='N' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seqNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = 1;
				sc = new SouvenirCartVO();
				sc.setSouv_pro_name(rs.getString(count++));
				sc.setSouv_pro_price(rs.getInt(count++));
				sc.setSouv_pro_category(rs.getString(count++));
				sc.setSouv_pro_url(rs.getString(count++));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return sc;
	}

	// 장바구니 삭제
	public int deleteCart(Connection conn, int seqNo, String status) {
		PreparedStatement pstmt = null;
		String query = "UPDATE SOUV_CART SET DELETE_STATUS = 'Y' WHERE seqNo = ?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, status);
			pstmt.setInt(1, seqNo);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	// 결제정보 출력
	public List<SouvenirPayVO> selectPayByUNO(Connection conn, int userNo) {
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
					+ "sc.souv_pro_no, sc.souv_pro_name, sc.souv_pro_price,  sc.SOUV_PRO_URL, "
					+ "SUM(sc.souv_pro_price)OVER(), SUM(sc.souv_pro_price)OVER()+3000 "
					+ "FROM SOUV_CART SC, USERINFO UI "
					+ "WHERE UI.uNo=sc.uno AND sc.uno=? AND sc.BUY_STATUS='N' AND sc.DELETE_STATUS='N' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;
				
				int uNo = rs.getInt(count++);
				String uname = rs.getString(count++);
				String uadr = rs.getString(count++);
				String upn = rs.getString(count++);
				String uemail = rs.getString(count++);
				int souv_pro_no = rs.getInt(count++);
				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
				String souv_pro_url = rs.getString(count++);
				int total_price = rs.getInt(count++);
				int bsb_total_price = rs.getInt(count++);

				SouvenirPayVO info = new SouvenirPayVO(uNo, uname, uadr, upn, uemail, souv_pro_no, souv_pro_name,
						souv_pro_price, total_price, bsb_total_price, souv_pro_url);
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

			String sql = "SELECT SOUV_CART_NO||uNo, rownum, SOUV_PRO_NO, SOUV_PRO_NAME, SOUV_PRO_PRICE, SOUV_PRO_URL, "
					+ "SUM(SOUV_PRO_PRICE)OVER()+3000 " + "FROM SOUV_CART SC "
					+ "WHERE BUY_STATUS='Y' AND uNo=? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;
				
				String orderNum = rs.getString(count++);
				int rownum = rs.getInt(count++);
				int souv_pro_no = rs.getInt(count++);
				String souv_pro_name = rs.getString(count++);
				int souv_pro_price = rs.getInt(count++);
				String souv_pro_url = rs.getString(count++);
				int bsb_total_price = rs.getInt(count++);
				

				SouvenirBuyVO info = new SouvenirBuyVO(orderNum, uNo, souv_pro_no, souv_pro_name, souv_pro_price,
						bsb_total_price, rownum, souv_pro_url);
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

	public static void main(String[] args) {
		Connection conn = getConnection();
		SouvenirDao dao = new SouvenirDao();

//		SouvenirProductVO product = dao.findProductByNo(conn, 8);		//됨
//		System.out.println(product.toString().replace(",",",\n"));

//		List<SouvenirProductVO> productAll = dao.selectProductAll(conn);	// 됨
//		System.out.println("=============전체 상품 출력===========");
//		for (SouvenirProductVO p : productAll) {
//			System.out.println(p.toString().replace(",", ",\n"));
//		}
		
//		List<SouvenirProductVO> productCate = dao.selectByCategory(conn, "패션/잡화"); //됨
//		System.out.println("=============카테고리로 검색===========");
//		for (SouvenirProductVO p : productCate) {
//			System.out.println(p.toString().replace(",", ",\n"));
//		}
		
//		SouvenirCartVO ic = new SouvenirCartVO(); // 장바구니 추가.. 안됨
//		ic.setUno(100);
//		ic.setSouv_pro_no(100);
//		ic.setSouv_pro_name("테스트");
//		ic.setSouv_pro_price(9999999);
//		ic.setSouv_pro_category("테스트카테고리");
//		ic.setSouv_pro_url("테스트url");
//		int result = dao.insertCart(conn, ic);
//		if(result == 1) {
//			System.out.println("성공");
//			System.out.println(ic.toString().replace(",",",\n"));
//		}else {
//			System.out.println("실패");
//		}
		
//		List<SouvenirCartVO> showCart = dao.selectCartByUNO(conn,3);	// 나옴
//		System.out.println("=============회원번호 3의 장바구니===========");
//		for (SouvenirCartVO sc : showCart) {
//			System.out.println(sc.toString().replace(",", ",\n"));
//		}
//		
//		SouvenirCartVO cart = dao.findCartBySeqNo(conn, 11);		// 안됨 왜지?
//		System.out.println(cart.toString().replace(",",",\n"));

			
//		int deleteCart = dao.deleteCart(conn, 10, "Y");			// 이것도,,, ㅗㅗㅗㅗㅗㅗ
//		System.out.println("삭제 결과 : " + deleteCart );
//		if(deleteCart == 1) {
//			System.out.println("탈퇴 업데이트 성공");
//			SouvenirCartVO delete = dao.findCartBySeqNo(conn, 10);
//			System.out.println(delete.toString());
//		}else {
//			System.out.println("탈퇴 업데이트 실패");
//		}
		
		List<SouvenirPayVO> selectPayByUNO = dao.selectPayByUNO(conn, 2);
		System.out.println("=============회원번호2의 결제정보===========");	// 왜안뜨냐,,
		for (SouvenirPayVO p : selectPayByUNO) {
			System.out.println(p.toString().replace(",", ",\n"));
		}
	
		
//		List<SouvenirBuyVO> selectBuyByUNO = dao.selectBuyByUNO(conn, 1);
//		System.out.println("=============회원번호1의 구매정보===========");	// String 으로 바꾸니까 됨
//		for (SouvenirBuyVO p : selectBuyByUNO) {
//		System.out.println(p.toString().replace(",", ",\n"));
//	}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
