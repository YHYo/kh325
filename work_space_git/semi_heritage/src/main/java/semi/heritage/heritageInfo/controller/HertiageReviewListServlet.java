package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.service.HeritageReviewService;
import semi.heritage.board.vo.HertiageReview;
import semi.heritage.common.util.MyHttpServlet;




@WebServlet("/HertiageReviewList.do") //마이페이지에서 리뷰리스트 보여주는 서블릿
public class HertiageReviewListServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getServletName() {
		return "HertiageReviewList";
	}
	
	private HeritageReviewService hrservice = new HeritageReviewService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hreviewCount = 0;
		int hertiageNo = Integer.parseInt(req.getParameter("hertiageNo"));

		
		List<HertiageReview> hlist = hrservice.getHertiageReview_ByNo(hertiageNo);
		hreviewCount = hrservice.getHertiageReview_Count(hertiageNo);
		
		
		req.setAttribute("hlist", hlist);
		req.setAttribute("hreviewCount", hreviewCount);
		req.getRequestDispatcher("/views/member/myPageReview.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
