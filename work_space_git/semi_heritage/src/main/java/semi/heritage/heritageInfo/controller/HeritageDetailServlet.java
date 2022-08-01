package semi.heritage.heritageInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageImage;
import semi.heritage.heritageInfo.vo.HeritageVO;
import semi.heritage.heritageInfo.vo.HeritageVideo;




//@WebServlet()
public class HeritageDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	private HeritageService service = new HeritageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hertiageNo = Integer.parseInt(req.getParameter("hertiageNo"));

		HeritageVO h = service.findHertiageByNo(hertiageNo);
		HeritageImage hi = service.findheritageImageByNo(hertiageNo);
		HeritageVideo hv = service.findheritageVideoByNo(hertiageNo);

		if(h == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		if(hi == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		if(hv == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		req.setAttribute("hertiage", h);
		req.setAttribute("heritageImage", hi);
		req.setAttribute("heritageVideo", hv);
		req.getRequestDispatcher("/views/heritage/heritageDeatil.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
