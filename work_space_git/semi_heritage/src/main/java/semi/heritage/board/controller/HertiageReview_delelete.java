package semi.heritage.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.service.HeritageReviewService;
import semi.heritage.board.vo.HertiageReview;
import semi.heritage.common.util.MyHttpServlet;

@WebServlet("/HertiageReview_delelete.do")
public class HertiageReview_delelete extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private HeritageReviewService service = new HeritageReviewService();

	@Override
	public String getServletName() {
		return " HertiageReview_Delete";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hreviewCount = 0;
		
		try {
			int revNo = Integer.parseInt(req.getParameter("revNo")); //리뷰 글번호 
			List<HertiageReview> hlist = service.getHertiageReview_ByNo(revNo);
			hreviewCount = service.getHertiageReview_Count(revNo);
			
			int result = service.delete(revNo);

			if (result > 0) {
				sendCommonPage("리플 삭제에 성공하였습니다. (500)", "views/member/myPageLike.jsp", req, resp);
			} else {
				sendCommonPage("리플 삭제를 실패하였습니다. (501)", "views/member/myPageLike.jsp", req, resp);
			}

			req.setAttribute("hlist", hlist);
			req.setAttribute("hreviewCount", hreviewCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
