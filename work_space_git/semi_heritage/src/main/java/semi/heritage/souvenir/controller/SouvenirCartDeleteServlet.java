package semi.heritage.souvenir.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.vo.Member;
import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;

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
			Souvenir_Cart_VO cart = service.findBoardByNo(cartNo, false);
			Member loginMember = getSessionMember(req);
			
			System.out.println("@@"+loginMember.getRole().equals("ROLE_ADMIN") );
			System.out.println("@@"+loginMember.getId() );
			System.out.println("@@"+board.getWriter_id() );
			
			// 권한 확인 코드, 프로젝트 시에는 없어도 됨
			if(loginMember.getRole().equals("ROLE_ADMIN") == false 
					&& loginMember.getId().equals(board.getWriter_id()) == false) {
				sendCommonPage("권한이 없어 삭제 할 수 없습니다. (300)", "/board/list", req, resp);
				return;
			}
			
			int result = service.delete(cartNo);
			
			if(result <= 0 ) {
				sendCommonPage("게시물 삭제에 실패하였습니다. (301)", "/board/list", req, resp);
				return;
			}
			
			// 파일 삭제
			deleteFile(board.getRenamed_filename());
			sendCommonPage("게시물 삭제에 성공하였습니다.", "/board/list", req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("게시물 삭제에 실패하였습니다. (302)", "/board/list", req, resp);
		}
	}
}
