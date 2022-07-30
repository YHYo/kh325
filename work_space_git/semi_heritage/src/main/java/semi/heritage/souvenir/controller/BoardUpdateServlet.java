package semi.heritage.souvenir.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.MyFileRenamePolicy;
import com.kh.common.util.MyHttpServlet;
import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/board/update")
public class BoardUpdateServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService service = new BoardService();
	
	@Override
	public String getServletName() {
		return "BoardUpdate";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		Board board = service.findBoardByNo(boardNo, false);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/views/board/update.jsp").forward(req, resp);
	}
	
	// 1. 파라메터 가져온다.
	// 2. DB CRUD + File 관리★★★★★
	// 3. 결과에 따라 페이지 보내준다. 파라메터와 함께
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String path = getServletContext().getRealPath("/resources/upload/board");
			int maxSize = 104857600; // 100 MB
			String encoding = "UTF-8";
			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encoding, new MyFileRenamePolicy());

			Member loginMember = getSessionMember(req);
			// writer = login No랑 다를때 보안상 튕겨낸다.
			if(loginMember == null 
					|| loginMember.getId().equals(mr.getParameter("writer")) == false) {
				if(loginMember.getRole().equals("ROLE_ADMIN") == false) {
					sendCommonPage("잘못된 접근입니다. (code=201)", "/board/list", req, resp);
					return;
				}
			}
			
			int boardNo = Integer.parseInt(mr.getParameter("boardNo"));
			Board board = service.findBoardByNo(boardNo, false);
			
			// 실제 게시물과 Writer_no가 다를때 보안상 튕겨낸다.
			if(board.getWriter_id().equals(loginMember.getId()) == false) {
				if(loginMember.getRole().equals("ROLE_ADMIN") == false) {
					sendCommonPage("잘못된 접근입니다. (code=202)", "/board/list", req, resp);
					return;
				}
			}
			
			board.setNo(Integer.parseInt(mr.getParameter("boardNo")));
			board.setTitle(mr.getParameter("title"));
			board.setWriter_id(mr.getParameter("writer"));
			board.setWriter_no(loginMember.getNo());
			board.setContent(mr.getParameter("content"));
			
			// 기존꺼 파일이름
			String original_filename = mr.getParameter("original_filename");
			String renamed_filename = mr.getParameter("renamed_filename");
			
			// 재업로드
			String originalReloadFileName = mr.getOriginalFileName("upfile");
			String renamedReloadFileName = mr.getFilesystemName("upfile");
			
			if(originalReloadFileName != null && originalReloadFileName.length() > 0) {
				// 파일수정이 있을때
				try {
					File deleteFile = new File(path, renamed_filename);
					deleteFile.delete();
					System.out.println("renamed_filename : " + renamed_filename);
				} catch (Exception e) {}
				board.setOriginal_filename(originalReloadFileName);
				board.setRenamed_filename(renamedReloadFileName);
			}else {
				// 기존꺼 쓸때
				if(original_filename == null) {
					board.setOriginal_filename("");
					board.setRenamed_filename("");
				}else {
					board.setOriginal_filename(original_filename);
					board.setRenamed_filename(renamed_filename);
				}
			}
			
			int result = service.save(board); // DB에 update
			
			if(result > 0) {
				sendCommonPage("게시글이 정상적으로 업데이트 되었습니다.", "/board/list", req, resp);
			}else {
				sendCommonPage("게시글을 업데이트 할수 없습니다!! (code=202)", "/board/list", req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("게시글을 수정할수 없습니다.(code=203)", "/board/list", req, resp);
		}
	}
}
