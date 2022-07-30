package semi.heritage.souvenir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.MyHttpServlet;
import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.member.model.vo.Member;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService service = new BoardService();
	
	@Override
	public String getServletName() {
		return "BoardDelete";
	}
	
	//http://localhost/06_HelloMVC2/board/delete?boardNo=65
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			Board board = service.findBoardByNo(boardNo, false);
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
			
			int result = service.delete(boardNo);
			
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
