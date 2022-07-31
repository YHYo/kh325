package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageMainVO;

@WebServlet("/index.do")
public class HeritageMainFavoriteServlet extends  MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
	private HeritageService service = new HeritageService();

	@Override
	public String getServletName() {
		return "heritageMainFavoriteServlet";
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget 호출 ");
		List<HeritageMainVO> list = null;
		
		list = service.mainByFavorite();
		System.out.println("list");
		System.out.println(list);
		if(list == null) {
			list = new ArrayList<HeritageMainVO>();
		}
		
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/main/index.jsp").forward(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
