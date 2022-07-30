package semi.heritage.board.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.board.vo.HertiageReview;


public class HertiageReviewDAO {

	// 문화재 고유번호에 따라 달린 리뷰의 갯수를 가져오는 쿼리문 -> 문화재 고유번호, 리뷰갯수
	public int getHertiageReview_Count(Connection conn , int heritageNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT HR.NO, COUNT(revNo) FROM HertiageReview HR group by ? order by COUNT(revNo) desc";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, heritageNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	// 문화재에 달린 리플을 가져오는 쿼리 -- 문화재 리뷰 리스트 조회 -> 회원 이메일, 문화재리뷰내용 , 리뷰작성날짜
	public List<HertiageReview> getHertiageReview_ByNo(Connection conn, int heritageNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HertiageReview> list = new ArrayList<HertiageReview>();
		String query = "select  U.uEmail , HR.revContents, HR.revDate\r\n"
				+ "			FROM HertiageReview HR, USERINFO U ,HERITAGE H\r\n"
				+ "			WHERE HR.uNo = U.uNo AND  HR.no = H.no\r\n"
				+ "			AND HR.STATUS = 'Y' AND HR.no= ? \r\n" 
				+ "			ORDER BY HR.revNo DESC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, heritageNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				HertiageReview review = new HertiageReview();
				review.setRev_userEmail(rs.getString("rev_userEmail"));
				review.setRevContents(rs.getString("revContents"));
				review.setRevDate(rs.getDate("revDate"));
				list.add(review);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

		
	// 리플 쓰기 기능
	public int insert_HertiageReview(Connection conn, HertiageReview review) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO HertiageReview VALUES(SEQ_revNo.NEXTVAL, ? , DEFAULT,?, ?, DEFAULT, DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getRevContents());
			pstmt.setInt(2, review.getRev_uNo());
			pstmt.setInt(3, review.getRev_no());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 리뷰 수정
		public int update_HertiageReview(Connection conn, HertiageReview hreview) {
			PreparedStatement pstmt = null;
			String query = "UPDATE HertiageReview SET revNo=?,revContents=?,uNo=?,MODIFY_DATE=SYSDATE WHERE NO=?";
			int result = 0;

			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, hreview.getRevNo());
				pstmt.setString(2, hreview.getRevContents());
				pstmt.setInt(3, hreview.getRev_uNo());
				pstmt.setInt(4, hreview.getRev_no());

				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

	// 리플 삭제 기능
	public int delete_HertiageReview(Connection conn, int revNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE HertiageReview WHERE revNo = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, revNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

//	public static void main(String[] args) {
//		Connection conn = getConnection();
//		HertiageReviewDAO dao = new HertiageReviewDAO();
//
////	// 게시물 갯수
//		int count = dao.getHertiageReview_Count(conn, 2);
//		System.out.println("게시물 갯수 : " + count);
//		System.out.println("--------------------------------------------");
//
		// 리뷰를 가지고 오는 쿼리
//		List<HertiageReview> list = dao.getHertiageReview_ByNo(conn, 2);
//		for (HertiageReview b : list) {
//			System.out.println(b.toString());
//		}
//		System.out.println("--------------------------------------------\n");

		// 리뷰 글쓰기
//		HertiageReview hv = new HertiageReview();
//		hv.setRevContents("자바에서 작성한 글 입니다.");
//		hv.setRev_uNo(1);
//		hv.setRev_no(2);
//		int result = dao.insert_HertiageReview(conn, hv); 
//		System.out.println("리뷰쓰기 결과 : " + result);
//		System.out.println("--------------------------------------------\n");

		//		// 리뷰 글삭제
//		int result = dao.delete_HertiageReview(conn, 1); 
//		System.out.println("리뷰삭제 결과 : " + result);
//		System.out.println("--------------------------------------------\n");
//	}
}
