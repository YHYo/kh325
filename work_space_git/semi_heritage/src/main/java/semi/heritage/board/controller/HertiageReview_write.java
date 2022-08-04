package semi.heritage.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.service.HeritageReviewService;
import semi.heritage.board.vo.HertiageReview;
import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.vo.Member;

@WebServlet("/HertiageReview_write.do")
public class HertiageReview_write extends MyHttpServlet{
		private static final long serialVersionUID = 1L;
		private HeritageReviewService service = new HeritageReviewService();

		@Override
		public String getServletName() {
			return "HertiageReview_Write";
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Member loginMember = getSessionMember(req);
				
				if(loginMember.getUemail().equals(req.getParameter("userId")) == false) {
					sendCommonPage("리플 등록 권한이 없습니다. (401)", "views/heritage/heritageDetail.jsp" , req, resp);
					return;
				}
				int revNo = Integer.parseInt(req.getParameter("revNo"));    //리뷰 글번호
				String RevContents = req.getParameter("RevContents");       //리뷰 글내용
				String Rev_userEmail = req.getParameter("Rev_userEmail"); //리뷰를 쓴 글쓴이의 이메일
				int Rev_no = Integer.parseInt(req.getParameter("Rev_no"));  //리뷰 글내용
				
				HertiageReview hreview = new HertiageReview();
				hreview.setRevNo(revNo);
				hreview.setRevContents(RevContents);
				hreview.setRev_userEmail(Rev_userEmail);
				hreview.setRev_no(Rev_no);
				
				int result = service.save(hreview);
				
				if(result > 0) {
					sendCommonPage("리플 등록에 성공하였습니다.", "views/heritage/heritageDetail.jsp", req, resp);
				}else {
					sendCommonPage("리플 등록에 실패하였습니다. (402)", "views/heritage/heritageDetail.jsp", req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}



