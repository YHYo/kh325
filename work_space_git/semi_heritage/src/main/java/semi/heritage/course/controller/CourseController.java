package semi.heritage.course.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.course.service.CourseService;
import semi.heritage.course.vo.Course;
import semi.heritage.member.vo.Member;

@WebServlet("/course/main")
public class CourseController extends MyHttpServlet {
	private static final long serialVersionUID = 1L;
//	private CourseService service = new CourseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int uNo = 0;
//		Map<String, String> placeNum = new HashMap<>();
//		Course course = new Course();
//		String place1 = "";
//	
//		Member loginMember = new Member();
//		try {
//			loginMember = getSessionMember(req);
//			System.out.println(loginMember.toString());
//			uNo = loginMember.getUno();
//			place1 = req.getParameter("p1");
//			System.out.println("place1 : " + place1);
//			placeNum.put("place1", place1);
//			System.out.println("placeNum : " + placeNum.toString());
//		} catch (Exception e) {
//			
//		}
//		System.out.println("uNo = " + uNo);
//		
//		int stampUser = service.findUser(uNo);
//		System.out.println("stampUser : " + stampUser);
//		
//		if(stampUser > 0) {
//			
//			course = service.findStampByUno(uNo);
//			System.out.println("controller 회원스탬프 조회 : " + course.toString());
//			int updateResult = service.updateCourse(course, uNo, placeNum);
//			System.out.println("updateResult : " + updateResult);
//			course = service.findStampByUno(uNo);
//			System.out.println("controller 업데이트 후 스탬프 조회 : " + course.toString());
//		}
//		if(stampUser == 0){
//			int newUser = service.newCourse(uNo);
//			System.out.println("newUser : " + newUser);
//			if(newUser > 0) {
//				course = service.findStampByUno(uNo);
//				
//			}
//			
//		}
//		
//		
//		
//		System.out.println("course =" + course.toString());
//		req.setAttribute("course", course);
//		//---------------------------------
//		String url = "/course/main?";
//		if(place1 != null) {
//			url = url + "p1=Y";
//		}
		 
		//---------------------------------
		
		/* int result = service.updateCourse(course, uNo, placeNum); */
		/*
		 * if(result > 0) { sendCommonPage("스탬프가 성공적으로 찍혔습니다!", url, req, resp); }
		 */
		
		req.getRequestDispatcher("/views/course/spCourse1.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doGet(req, resp);
	}


	@Override
	public String getServletName() {
		return "CourseMainServlet";
	}

}
