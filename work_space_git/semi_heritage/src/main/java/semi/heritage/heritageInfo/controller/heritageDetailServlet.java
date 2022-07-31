package semi.heritage.heritageInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.heritageInfo.service.heritageService;
import semi.heritage.heritageInfo.vo.heritageVO;



//@WebServlet()
public class heritageDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	private heritageService service = new heritageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hertiageNo = Integer.parseInt(req.getParameter("hertiageNo"));

		heritageVO hertiage = service.findHertiageByNo(hertiageNo);

		if(hertiage == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		req.setAttribute("hertiage", hertiage);
		req.getRequestDispatcher("/views/board/view.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
