package semi.heritage.heritageInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageVO;



//@WebServlet()
public class HeritageDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	private HeritageService service = new HeritageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hertiageNo = Integer.parseInt(req.getParameter("hertiageNo"));

		HeritageVO hertiage = service.findHertiageByNo(hertiageNo);

		if(hertiage == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		req.setAttribute("hertiage", hertiage);
		req.getRequestDispatcher("/views/board/view.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
