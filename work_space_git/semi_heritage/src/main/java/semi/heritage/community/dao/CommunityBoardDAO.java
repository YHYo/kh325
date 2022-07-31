package semi.heritage.community.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import semi.heritage.common.util.PageInfo;
import semi.heritage.community.vo.communityBoard;
import semi.heritage.community.vo.communityReply;

public class communityBoardDAO {
	
	// 게시물의 갯수를 가져오는 쿼리문
	public int getBoardCount(Connection conn, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM ? WHERE STATUS='Y'";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			if(type.equals("F")) {
				pstmt.setString(1, "FREE_BOARD");
			}
			if(type.equals("T")) {
				pstmt.setString(1, "TO_BOARD");
			}
			if(type.equals("H")) {
				pstmt.setString(1, "HIS_BOARD");
			}
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

	// 게시물의 리스트를 가져오는 메소드(게시물 목록)
	public List<communityBoard> findAll(Connection conn, PageInfo pageInfo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<communityBoard> list = new ArrayList<communityBoard>();
		String query = "SELECT RNUM, NO, TITLE, uName, CREATE_DATE, ORIGINAL_FILE, READCOUNT, STATUS "
				+ "FROM ( "
				+ "    SELECT ROWNUM AS RNUM, NO, TITLE, uName, CREATE_DATE, ORIGINAL_FILE, READCOUNT, STATUS "
				+ "    FROM ( "
				+ "        SELECT FB.NO, FB.TITLE, U.uName, FB.CREATE_DATE, FB.ORIGINAL_FILE, FB.READCOUNT, FB.STATUS "
				+ "        FROM FREE_BOARD FB JOIN UserInfo U ON(FB.UNO = U.uNo) "
				+ "        WHERE FB.STATUS = 'Y' ORDER BY FB.NO DESC " + "    )" + ") "
				+ "WHERE RNUM BETWEEN ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				communityBoard board = new communityBoard();
				board.setRowNum(rs.getInt("RNUM"));
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setuName(rs.getString("UNAME"));
				board.setCreate_date((rs.getDate("CREATE_DATE")));
				board.setOriginal_file((rs.getString("ORIGINAL_FILE")));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setStatus(rs.getString("STATUS"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	// 게시물의 갯수를 가져오는 쿼리문
	// searchMap : key=탐색할 컨텐츠, value=키워드
	// 탐색 가능 컨텐츠 : title&writer, title, writer
	public int getBoardCount(Connection conn, Map<String, String> searchMap, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) "
				+ "FROM ? B "
				+ "JOIN USERINFO U ON(B.UNO = U.UNO) "
				+ "WHERE 1=1 AND B.STATUS = 'Y' ";

		if (searchMap.containsKey("title&writer")) { 
			query += "AND (FB.TITLE LIKE ? OR U.UNAME LIKE ?) ";
		}
		if (searchMap.containsKey("title")) { 
			query += "AND FB.TITLE LIKE ? ";
		}
		if (searchMap.containsKey("writer")) {
			query += "AND U.UNAME LIKE ? ";
		}

		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			int count = 1;
			if(type.equals("F")) {
				pstmt.setString(count++, "FREE_BOARD");
			}
			if(type.equals("T")) {
				pstmt.setString(count++, "TO_BOARD");
			}
			if(type.equals("H")) {
				pstmt.setString(count++, "HIS_BOARD");
			}

			if (searchMap.containsKey("title&writer")) {
				pstmt.setString(count++, "%" + searchMap.get("title&writer") + "%");
				pstmt.setString(count++, "%" + searchMap.get("title&writer") + "%");
			}
			if (searchMap.containsKey("title")) {
				pstmt.setString(count++, "%" + searchMap.get("title") + "%");
			}
			if (searchMap.containsKey("writer")) {
				pstmt.setString(count++, "%" + searchMap.get("writer") + "%");
			}
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

	// 게시물의 리스트를 가져오는 메소드
	public List<communityBoard> findAll(Connection conn, PageInfo pageInfo, Map<String, String> searchMap) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<communityBoard> list = new ArrayList<communityBoard>();
		String queryBefore = "SELECT RNUM, NO, TITLE, UNAME, CREATE_DATE, ORIGINAL_FILE, READCOUNT, STATUS "
				+ "FROM ( "
				+ "    SELECT ROWNUM AS RNUM, NO, TITLE, UNAME, CREATE_DATE, ORIGINAL_FILE, READCOUNT, STATUS "
				+ "    FROM ( "
				+ "      SELECT  FB.NO, FB.TITLE, U.UNAME, FB.CREATE_DATE, FB.ORIGINAL_FILE, FB.READCOUNT, FB.STATUS "
				+ "        FROM FREE_BOARD FB JOIN USERINFO U ON(FB.UNO = U.UNO) "
				+ "        WHERE 1 = 1 "
				+ "        AND FB.STATUS = 'Y'";

		String queryAfter = "  ORDER BY FB.NO DESC " + "    ) " + ") " + " WHERE RNUM BETWEEN ? and ? ";

		if (searchMap.containsKey("title&writer")) {
			queryBefore += "AND (FB.TITLE LIKE ? OR U.UNAME LIKE ?)";
		}
		if (searchMap.containsKey("title")) {
			queryBefore += "AND FB.FREE_TITLE LIKE ? ";
		}
		if (searchMap.containsKey("writer")) {
			queryBefore += "AND U.UNAME LIKE ? ";
		}

		String query = queryBefore + queryAfter;

		try {
			pstmt = conn.prepareStatement(query);

			int count = 1;
			if (searchMap.containsKey("title&writer")) {
				pstmt.setString(count++, "%" + searchMap.get("title&writer") + "%");
				pstmt.setString(count++, "%" + searchMap.get("title&writer") + "%");
			}
			if (searchMap.containsKey("title")) {
				pstmt.setString(count++, "%" + searchMap.get("title") + "%");
			}
			if (searchMap.containsKey("writer")) {
				pstmt.setString(count++, "%" + searchMap.get("writer") + "%");
			}

			pstmt.setInt(count++, pageInfo.getStartList());
			pstmt.setInt(count++, pageInfo.getEndList());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				communityBoard board = new communityBoard();
				board.setRowNum(rs.getInt("RNUM"));
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setuName(rs.getString("UNAME"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setOriginal_file(rs.getString("ORIGINAL_FILE"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setStatus(rs.getString("STATUS"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	// 글쓰기 기능
	public int insertBoard(Connection conn, communityBoard board) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO FREE_BOARD VALUES(SEQ_FREE_NO.NEXTVAL,?,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getuNo());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, ""); // 게시글 타입
			pstmt.setString(5, board.getOriginal_file());
			pstmt.setString(6, board.getRenamed_file());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// - 상세 게시글을 조회 
	public communityBoard findBoardByNo(Connection conn, int boardNo, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		communityBoard board = null;
		String query = "SELECT B.NO, B.TITLE, U.UNAME, B.READCOUNT, B.ORIGINAL_FILE, B.RENAMED_FILE, "
				+ "B.CONTENT, B.CREATE_DATE, B.MODIFY_DATE B.REPLY_COUNT "
				+ "FROM ? B "
				+ "JOIN USERINFO U ON(B.UNO = U.UNO) "
				+ "WHERE B.STATUS = 'Y' AND B.NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			if(type.equals("F")) {
				pstmt.setString(1, "FREE_BOARD");
			}
			if(type.equals("T")) {
				pstmt.setString(1, "TO_BOARD");
			}
			if(type.equals("H")) {
				pstmt.setString(1, "HIS_BOARD");
			}
			pstmt.setInt(2, boardNo);
			System.out.println(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new communityBoard();
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setuName(rs.getString("UNAME"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setOriginal_file(rs.getString("ORIGINAL_FILE"));
				board.setRenamed_file(rs.getString("RENAMED_FILE"));
				board.setContent(rs.getString("FREE_CONTENT"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setModify_date(rs.getDate("MODIFY_DATE"));
				board.setReply_count(getReplyCount(conn, boardNo));
				board.setReplies(getRepliesByNo(conn, boardNo)); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return board;
	}

	// 게시글 조회수 올려주는 쿼리
	public int updateReadCount(Connection conn, communityBoard board, String type) {
		PreparedStatement pstmt = null;
		String query = "UPDATE ? SET READCOUNT=? WHERE NO=?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			if(type.equals("F")) {
				pstmt.setString(1, "FREE_BOARD");
			}
			if(type.equals("T")) {
				pstmt.setString(1, "TO_BOARD");
			}
			if(type.equals("H")) {
				pstmt.setString(1, "HIS_BOARD");
			}
			pstmt.setInt(2, board.getReadCount() + 1);
			pstmt.setInt(3, board.getNo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 게시글 삭제(실제로는 안보여주기 기능) 를 위한 쿼리
	public int updateStatus(Connection conn, int boardNo, String status) {
		PreparedStatement pstmt = null;
		String query = "UPDATE FREE_BOARD SET STATUS=? WHERE NO=?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, boardNo);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	// - 게시글 수정
	public int updateBoard(Connection conn, communityBoard board) {
		PreparedStatement pstmt = null;
		String query = "UPDATE FREE_BOARD SET TITLE=?,CONTENT=?,ORIGINAL_FILE=?,RENAMED_FILE=?,MODIFY_DATE=SYSDATE WHERE NO=?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getOriginal_file());
			pstmt.setString(4, board.getRenamed_file());
			pstmt.setInt(5, board.getNo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 리플을 가져오는 메소드
	public List<communityReply> getRepliesByNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<communityReply> list = new ArrayList<communityReply>();
		String query = "SELECT FR.NO, FR.BOARD_NO, FR.CONTENT, U.UNAME, FR.CREATE_DATE, FR.MODIFY_DATE "
				+ "FROM FREE_REPLY FR "
				+ "JOIN USERINFO U ON(FR.UNO = U.UNO) "
				+ "WHERE FR.STATUS='Y' AND BOARD_NO= ? "
				+ "ORDER BY FR.NO DESC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				communityReply reply = new communityReply();
				reply.setNo(rs.getInt("NO"));
				reply.setBoard_no(rs.getInt("BOARD_NO"));
				reply.setContent(rs.getString("CONTENT"));
				reply.setuName(rs.getString("UNAME"));
				reply.setCreate_date(rs.getDate("CREATE_DATE"));
				reply.setModify_date(rs.getDate("MODIFY_DATE"));
				list.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;

	}

	// 리플 쓰기 기능
	public int insertReply(Connection conn, communityReply reply) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO FREE_REPLY VALUES(SEQ_FREE_RNO.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reply.getNo());
			pstmt.setInt(2, reply.getuNo());
			pstmt.setString(3, reply.getContent());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// - 리플 삭제 기능
	public int deleteReply(Connection conn, int replyNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FREE_REPLY WHERE NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 리플 개수 올려주는 쿼리
	public int replyCount(Connection conn, String type, communityBoard board) {
		PreparedStatement pstmt = null;
		String query = "UPDATE FREE_BOARD B"
				+ "SET B.REPLY_COUNT = (SELECT COUNT(NO) FROM FREE_REPLY WHERE BOARD_NO = ?) "
				+ "WHERE B.NO = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getNo());
			pstmt.setInt(2, board.getNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 게시물의 갯수를 가져오는 쿼리문
	public int getReplyCount(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT REPLY_COUNT FROM FREE_BOARD WHERE NO = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				communityBoard board = new communityBoard();
				board.setReply_count(rs.getInt("REPLY_COUNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public static void main(String[] args) {
		Connection conn = getConnection();
		communityBoardDAO dao = new communityBoardDAO();
		communityBoard board = new communityBoard();
		
//		findBoardByNo(Connection conn, int boardNo, String type)
//
//
//		// 게시물 갯수
//		int count = dao.getBoardCount(conn);
//		System.out.println("게시물 갯수 : " + count);
//		System.out.println("--------------------------------------------");
//
//		// 일반 게시판 리스트
//		PageInfo info = new PageInfo(1, 10, count, 10);
//		List<communityBoard> list = dao.findAll(conn, info);
//		for (communityBoard b : list) {
//			System.out.println(b.toString());
//		}
//		System.out.println("--------------------------------------------\n");
//
//		// 게시물 갯수- 탐색
//		Map<String, String> searchMap = new HashMap<String, String>();
//		searchMap.put("title&writer", "백길동");
//		searchMap.put("writer", "자유");
//		int count = dao.getBoardCount(conn, searchMap);
//		System.out.println("게시물 갯수 : " + count);
//		System.out.println("--------------------------------------------");
//
//		// 일반 게시판 리스트 - 탐색
//		info = new PageInfo(1, 10, count, 10);
//		list = dao.findAll(conn, info, searchMap);
//		for (communityBoard b : list) {
//			System.out.println(b.toString());
//		}
//		System.out.println("--------------------------------------------\n");
//		
//		// 일반 게시판 글쓰기
//		communityBoard board = new communityBoard();
//		board.setuNo(1);
//		board.setTitle("자바에서 작성한 글 입니다.");
//		board.setContent("자바에서 올린 글 내용입니다.");
//		board.setOriginal_file("");
//		board.setRenamed_file("");
//		int result = dao.insertFreeBoard(conn, board); 
//		System.out.println("글올리기 결과 : " + result);
//		System.out.println("--------------------------------------------\n");
//		
//		
//		// 게시물 갯수
//		count = dao.getBoardCount(conn);
//		System.out.println("게시물 갯수 : " + count);
//		System.out.println("--------------------------------------------");
//		
//		// 일반 게시판 리스트
//		info = new PageInfo(1, 10, count, 10);
//		list = dao.findAll(conn, info);
//		for (communityBoard b : list) {
//			System.out.println(b.toString());
//		}
//		System.out.println("--------------------------------------------\n");
	}
}
