package semi.heritage.souvenir.controller;

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

/**
 * 파일 첨부 없이 일반적인 게시글 등록 용도
 */

@WebServlet("/board/write")
public class BoardWriteServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	
	@Override
	public String getServletName() {
		return "BoardWrite";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Member loginMember = getSessionMember(req);
			if(loginMember != null) {
				// 정상 흐름
				req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {}
		sendCommonPage("로그인 이후 사용할수 있습니다.", "/", req, resp);
	}
	
	// 1. 사용자의 파라메터를 읽어온다. -> multi form으로 읽어온다.
	// 2. 사용자의 파라메터를 기준으로 필요시 DB CRUD 한다.
	//     -> 파일의 경우 지정된 경로에 따로 저장한다.
	// 3. DB 저장 결과에 따라 페이지를 정하여 보내준다. //  실패-> 실패뜨게끔, 성공-> list로 이동하게끔
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 파일과 멀티 파라메터 읽어오는 방법을 추가해야함
			
			// 1. 저장 경로 지정
			String path = getServletContext().getRealPath("/resources/upload/board");
			// 2. 파일사이즈 지정
			int maxSize = 104857600; // 100 MB
			// 3. 문자열 인코딩 설정
			String encoding = "UTF-8";
			// 4. 멀티파라메터 처리 객체 생성 - cos.jar 활용
//			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encoding, new DefaultFileRenamePolicy());
			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encoding, new MyFileRenamePolicy());
			// 멀티 파라메터 선언 끝!
			System.out.println(path);
			
			Member loginMember = getSessionMember(req);
			// 세션이 풀렸거나 실제 글쓴사람과 세션이 일치하지 않은 경우 = 보안적인 요구사항
			System.out.println(mr.getParameter("writer"));
			if(loginMember == null 
					|| loginMember.getId().equals(mr.getParameter("writer")) == false) {
				sendCommonPage("잘못된 접근입니다. (code=101)", "/board/list", req, resp);
				return;
			}
			
			Board board = new Board();
			board.setTitle(mr.getParameter("title").strip()); // white space 정리, null 방지
			board.setWriter_id(mr.getParameter("writer").strip());
			board.setWriter_no(loginMember.getNo());
			board.setContent(mr.getParameter("content").trim());
			board.setOriginal_filename(mr.getOriginalFileName("upfile"));
			board.setRenamed_filename(mr.getFilesystemName("upfile"));
			System.out.println(board);
			
			int result = service.save(board); // DB에 게시글 저장
			
			if(result > 0) {
				sendCommonPage("게시글이 정상적으로 등록되었습니다.", "/board/list", req, resp);
				return;
			}else {
				sendCommonPage("게시글 등록에 실패하였습니다. (code=102)", "/board/list", req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("정상적으로 처리할수 없습니다. (code=103)",  "/board/list", req, resp);
		}
	}
}








