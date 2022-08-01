package semi.heritage.event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.event.service.FestivalService;
import semi.heritage.event.vo.Festival;

@WebServlet("/trtrrr")
public class FestivalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FestivalService service = new FestivalService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String eventMonth = null;
		List<Festival> list = null;

		list = service.selectByMonth(eventMonth);

		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/main/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
