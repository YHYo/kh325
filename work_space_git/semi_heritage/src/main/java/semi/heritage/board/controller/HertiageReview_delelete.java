package semi.heritage.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.service.HeritageReviewService;
import semi.heritage.common.util.MyHttpServlet;

//@WebServlet("/board/HertiageReview_del")
public class HertiageReview_delelete extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private HeritageReviewService service = new HeritageReviewService();

	@Override
	public String getServletName() {
		return " HertiageReview_Delete";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int revNo = Integer.parseInt(req.getParameter("revNo")); //리뷰 글번호 
			
			int result = service.delete(revNo);

			if (result > 0) {
				sendCommonPage("리플 삭제에 성공하였습니다.", "/board/view?Rev_no="+revNo, req, resp);
			} else {
				sendCommonPage("리플 삭제를 실패하였습니다. (501)", "/board/view?Rev_no="+revNo, req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("리플을 삭제할수 없습니다. (505)", "/board/list", req, resp);
		}

	}
}
