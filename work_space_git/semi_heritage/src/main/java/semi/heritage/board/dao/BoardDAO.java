package semi.heritage.board.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import semi.heritage.board.vo.Board;
import semi.heritage.board.vo.Reply;
import semi.heritage.common.util.PageInfo;

public class BoardDAO {

	// 게시물의 전체 갯수를 가져오는 쿼리문
	public int getBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM BOARD WHERE STATUS='Y'";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
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
	public List<Board> findAll(Connection conn, PageInfo pageInfo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String query = "SELECT RNUM, NO, TITLE, ID, CREATE_DATE, ORIGINAL_FILENAME, READCOUNT, STATUS  " + "FROM ( "
				+ "    SELECT ROWNUM AS RNUM, NO, TITLE, ID, CREATE_DATE, ORIGINAL_FILENAME, READCOUNT, STATUS "
				+ "    FROM ( "
				+ "        SELECT  B.NO, B.TITLE, M.ID, B.CREATE_DATE, B.ORIGINAL_FILENAME, B.READCOUNT, B.STATUS "
				+ "        FROM BOARD B JOIN MEMBER M ON(B.WRITER_NO = M.NO) "
				+ "        WHERE B.STATUS = 'Y' ORDER BY B.NO DESC " + "    ) " + ") " + "WHERE RNUM BETWEEN ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setRowNum(rs.getInt("RNUM"));
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter_id(rs.getString("ID"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setOriginal_filename(rs.getString("ORIGINAL_FILENAME"));
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

	// 검색한 게시물의 갯수를 가져오는 쿼리문
	// searchMap : key=탐색할 컨텐츠, value=키워드
	// - 탐색 가능 컨텐츠 : title, content, writer
	public int getBoardCount(Connection conn, Map<String, String> searchMap) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT  COUNT(*) " + "	FROM BOARD B " + "	JOIN MEMBER M ON(B.WRITER_NO = M.NO) "
				+ "	WHERE 1=1 " + "	AND B.STATUS = 'Y' ";

		if (searchMap.containsKey("title")) {
			query += "AND B.TITLE LIKE ? ";
		}
		if (searchMap.containsKey("content")) {
			query += "AND B.CONTENT LIKE ? ";
		}
		if (searchMap.containsKey("writer")) {
			query += "AND M.ID LIKE ? ";
		}

		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			int count = 1;

			if (searchMap.containsKey("title")) {
				pstmt.setString(count++, "%" + searchMap.get("title") + "%");
			}
			if (searchMap.containsKey("content")) {
				pstmt.setString(count++, "%" + searchMap.get("content") + "%");
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
	public List<Board> findAll(Connection conn, PageInfo pageInfo, Map<String, String> searchMap) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String queryBefore = "SELECT RNUM, NO, TITLE, ID, CREATE_DATE, ORIGINAL_FILENAME, READCOUNT, STATUS  "
				+ "FROM ( "
				+ "    SELECT ROWNUM AS RNUM, NO, TITLE, ID, CREATE_DATE, ORIGINAL_FILENAME, READCOUNT, STATUS "
				+ "    FROM ( "
				+ "        SELECT  B.NO, B.TITLE, M.ID, B.CREATE_DATE, B.ORIGINAL_FILENAME, B.READCOUNT, B.STATUS "
				+ "        FROM BOARD B JOIN MEMBER M ON(B.WRITER_NO = M.NO) " + "		   WHERE 1 = 1  "
				+ "		   AND B.STATUS = 'Y' ";

		String queryAfter = "	   ORDER BY B.NO DESC" + "    ) " + ") " + "WHERE RNUM BETWEEN ? and ?";

		if (searchMap.containsKey("title")) {
			queryBefore += "AND B.TITLE LIKE ? ";
		}
		if (searchMap.containsKey("content")) {
			queryBefore += "AND B.CONTENT LIKE ? ";
		}
		if (searchMap.containsKey("writer")) {
			queryBefore += "AND M.ID LIKE ? ";
		}

		String query = queryBefore + queryAfter;

		try {
			pstmt = conn.prepareStatement(query);

			int count = 1;
			if (searchMap.containsKey("title")) {
				pstmt.setString(count++, "%" + searchMap.get("title") + "%");
			}
			if (searchMap.containsKey("content")) {
				pstmt.setString(count++, "%" + searchMap.get("content") + "%");
			}
			if (searchMap.containsKey("writer")) {
				pstmt.setString(count++, "%" + searchMap.get("writer") + "%");
			}

			pstmt.setInt(count++, pageInfo.getStartList());
			pstmt.setInt(count++, pageInfo.getEndList());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setRowNum(rs.getInt("RNUM"));
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter_id(rs.getString("ID"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setOriginal_filename(rs.getString("ORIGINAL_FILENAME"));
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
	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,?,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getWriter_no());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, "");
			pstmt.setString(5, board.getOriginal_filename());
			pstmt.setString(6, board.getRenamed_filename());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 상세 게시글을 조회 
	public Board findBoardByNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		String query = "SELECT  B.NO, B.TITLE, M.ID, B.READCOUNT, B.ORIGINAL_FILENAME, B.RENAMED_FILENAME, B.CONTENT, B.CREATE_DATE, B.MODIFY_DATE "
				+ "FROM BOARD B "
				+ "JOIN MEMBER M ON(B.WRITER_NO = M.NO) "
				+ "WHERE B.STATUS = 'Y' AND B.NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new Board();
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter_id(rs.getString("ID"));
				board.setReadCount(rs.getInt("READCOUNT"));
				board.setOriginal_filename(rs.getString("ORIGINAL_FILENAME"));
				board.setRenamed_filename(rs.getString("RENAMED_FILENAME"));
				board.setContent(rs.getString("CONTENT"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setModify_date(rs.getDate("MODIFY_DATE"));
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
	public int updateReadCount(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		String query = "UPDATE BOARD SET READCOUNT = ? WHERE NO = ?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getReadCount() + 1);
			pstmt.setInt(2, board.getNo());

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
		String query = "UPDATE BOARD SET STATUS = ? WHERE NO = ?";
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

	// 게시글 수정
	public int updateBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		String query = "UPDATE BOARD SET TITLE=?,CONTENT=?,ORIGINAL_FILENAME=?,RENAMED_FILENAME=?,MODIFY_DATE=SYSDATE WHERE NO=?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getOriginal_filename());
			pstmt.setString(4, board.getRenamed_filename());
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
	public List<Reply> getRepliesByNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<Reply>();
		String query = "SELECT R.NO, R.BOARD_NO, R.CONTENT, M.ID, R.CREATE_DATE, R.MODIFY_DATE "
				+ "FROM REPLY R "
				+ "JOIN MEMBER M ON(R.WRITER_NO = M.NO) "
				+ "WHERE R.STATUS='Y' AND BOARD_NO= ? "
				+ "ORDER BY R.NO DESC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setNo(rs.getInt("NO"));
				reply.setBoard_no(rs.getInt("BOARD_NO"));
				reply.setContent(rs.getString("CONTENT"));
				reply.setWriter_id(rs.getString("ID"));
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
	public int insertReply(Connection conn, Reply reply) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reply.getBoard_no());
			pstmt.setInt(2, reply.getWriter_no());
			pstmt.setString(3, reply.getContent());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 리플 삭제 기능
	public int deleteReply(Connection conn, int replyNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE REPLY WHERE NO = ?";
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

	public static void main(String[] args) {
		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO();

		// 게시물 갯수
		int count = dao.getBoardCount(conn);
		System.out.println("게시물 갯수 : " + count);
		System.out.println("--------------------------------------------");

		// 일반 게시판 리스트
		PageInfo info = new PageInfo(1, 10, count, 10);
		List<Board> list = dao.findAll(conn, info);
		for (Board b : list) {
			System.out.println(b.toString());
		}
		System.out.println("--------------------------------------------\n");

		// 게시물 갯수- 탐색
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("title", "판매");
		searchMap.put("content", "아이폰");
//		searchMap.put("writer", "admin");
		count = dao.getBoardCount(conn, searchMap);
		System.out.println("게시물 갯수 : " + count);
		System.out.println("--------------------------------------------");

		// 일반 게시판 리스트 - 탐색
		info = new PageInfo(1, 10, count, 10);
		list = dao.findAll(conn, info, searchMap);
		for (Board b : list) {
			System.out.println(b.toString());
		}
		System.out.println("--------------------------------------------\n");
		
		// 일반 게시판 글쓰기
		Board board = new Board();
		board.setWriter_no(1);
		board.setTitle("자바에서 작성한 글 입니다.");
		board.setContent("자바에서 올린 글 내용입니다.");
		board.setOriginal_filename("");
		board.setRenamed_filename("");
		int result = dao.insertBoard(conn, board); 
		System.out.println("글올리기 결과 : " + result);
		System.out.println("--------------------------------------------\n");
		
		
		// 게시물 갯수
		count = dao.getBoardCount(conn);
		System.out.println("게시물 갯수 : " + count);
		System.out.println("--------------------------------------------");
		
		// 일반 게시판 리스트
		info = new PageInfo(1, 10, count, 10);
		list = dao.findAll(conn, info);
		for (Board b : list) {
			System.out.println(b.toString());
		}
		System.out.println("--------------------------------------------\n");
	}
}
