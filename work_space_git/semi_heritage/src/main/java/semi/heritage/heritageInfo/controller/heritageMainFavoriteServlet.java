package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.heritageInfo.service.heritageService;
import semi.heritage.heritageInfo.vo.heritageMainVO;

@WebServlet("/index")
public class heritageMainFavoriteServlet extends  MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
	private heritageService service = new heritageService();

	@Override
	public String getServletName() {
		return "heritageMainFavoriteServlet";
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<heritageMainVO> list = null;
		
		
		
		list = service.mainByFavorite();

		
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
