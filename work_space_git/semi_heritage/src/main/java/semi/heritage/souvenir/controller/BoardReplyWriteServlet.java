package semi.heritage.souvenir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.MyHttpServlet;
import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Reply;
import com.kh.mvc.member.model.vo.Member;

//@WebServlet("/board/reply")
public class BoardReplyWriteServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;

	private BoardService service = new BoardService();
	
	@Override
	public String getServletName() {
		return "BoardReplyWrite";
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Member loginMember = getSessionMember(req);
			
			if(loginMember.getId().equals(req.getParameter("writer")) == false) {
				sendCommonPage("리플 등록 권한이 없습니다. (401)", "/board/list" , req, resp);
				return;
			}
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			Reply reply = new Reply();
			reply.setBoard_no(boardNo);
			reply.setWriter_id(writer);
			reply.setWriter_no(loginMember.getNo());
			reply.setContent(content);
			
			int result = service.saveReply(reply);
			
			if(result > 0) {
				sendCommonPage("리플 등록에 성공하였습니다.", "/board/view?boardNo="+boardNo, req, resp);
			}else {
				sendCommonPage("리플 등록에 실패하였습니다. (402)", "/board/view?boardNo="+boardNo, req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("리플을 정상적으로 등록할수 없습니다. (403)", "/board/list" , req, resp);
		}
	
	}
}
