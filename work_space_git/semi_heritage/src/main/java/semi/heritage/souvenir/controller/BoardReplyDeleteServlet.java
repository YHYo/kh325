package semi.heritage.souvenir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.MyHttpServlet;
import com.kh.mvc.board.model.service.BoardService;

//@WebServlet("/board/replydel")
public class BoardReplyDeleteServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;

	private BoardService service = new BoardService();

	@Override
	public String getServletName() {
		return " BoardReplyDelete";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int replyNo = Integer.parseInt(req.getParameter("replyNo"));
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			int result = service.deleteReply(replyNo);
			
			if(result > 0) {
				sendCommonPage("리플 삭제에 성공하였습니다.", "/board/view?boardNo="+boardNo, req, resp);
			}else {
				sendCommonPage("리플 삭제를 실패하였습니다. (501)", "/board/view?boardNo="+boardNo, req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("리플을 삭제할수 없습니다. (505)", "/board/list", req, resp);
		}
	}
}
