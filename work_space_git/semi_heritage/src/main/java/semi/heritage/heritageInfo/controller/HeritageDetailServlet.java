package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.service.HeritageReviewService;
import semi.heritage.board.vo.HertiageReview;
import semi.heritage.favorite.service.favoriteService;
import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageImage;
import semi.heritage.heritageInfo.vo.HeritageVO;
import semi.heritage.heritageInfo.vo.HeritageVideo;



@WebServlet("/heritageDeatil.do")
public class HeritageDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	private HeritageService service = new HeritageService();
	private HeritageReviewService rservice = new HeritageReviewService();
	private favoriteService fservice = new favoriteService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int hertiageNo = Integer.parseInt(req.getParameter("hertiageNo"));
		System.out.println("!!!!");
		int hertiageNo = 1;

		HeritageVO h = service.findHertiageByNo(hertiageNo);
		List<HeritageImage> hi = service.findHeritageImageByNo(hertiageNo);
		HeritageVideo hv = service.findHeritageVideoByNo(hertiageNo);
		List<HertiageReview> list = rservice.getHertiageReview_ByNo(hertiageNo);
		int HertiageReview_Count = rservice.getHertiageReview_Count(hertiageNo);
		int CountFavoriteByNo = fservice.CountFavoriteByNo(hertiageNo);

		if(h == null || hi == null || hv == null || list == null) {
			resp.sendRedirect(req.getContextPath() + "/heritageDeatil.do");
			return;
		}
		if(HertiageReview_Count < 0 ) {
			resp.sendRedirect(req.getContextPath() + "/heritageDeatil.do");
			return;
		}
		if(CountFavoriteByNo < 0 ) {
			resp.sendRedirect(req.getContextPath() + "/heritageDeatil.do");
			return;
		}
		
		req.setAttribute("hertiage", h);
		req.setAttribute("heritageImage", hi);
		req.setAttribute("heritageVideo", hv);
		req.setAttribute("list", list);
		req.setAttribute("HertiageReview_Count", HertiageReview_Count);
		req.setAttribute("CountFavoriteByNo", CountFavoriteByNo);
		req.getRequestDispatcher("/views/heritage/heritageDetail.jsp").forward(req, resp); 
	
		
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	

}
