package semi.heritage.souvenir.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.vo.Member;
import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirCartVO;

//@WebServlet("/cart/delete")
public class SouvenirCartDeleteServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private BoardService service = new BoardService();
	private SouvenirService service = new SouvenirService();
	
	@Override
	public String getServletName() {
		return "CartDelete";
	}
	
	//http://localhost/06_HelloMVC2/cart/delete?boardNo=65
	//http://localhost:8081/semi_heritage/cart/delete?uNo=2&cartNo=3
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int cartNo = Integer.parseInt(req.getParameter("cartNo"));
			SouvenirCartVO cart = service.findCartByNo(cartNo);	// 만들어야함
			Member loginMember = getSessionMember(req);
			
			
			int result = service.deleteCart(cartNo);
			
			if(result <= 0 ) {
				sendCommonPage("게시물 삭제에 실패하였습니다. (301)", "/board/list", req, resp);
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("게시물 삭제에 실패하였습니다. (302)", "/board/list", req, resp);
		}
	}
}
