package semi.heritage.community.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import semi.heritage.common.util.PageInfo;
import semi.heritage.community.dao.communityBoardDAO;
import semi.heritage.community.vo.communityBoard;
import semi.heritage.community.vo.communityReply;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

public class communityBoardService {
	private communityBoardDAO dao = new communityBoardDAO();
	
	public int getBoardCount(Map<String, String> searchMap, String type) {
		Connection conn = getConnection();
		int result = dao.getBoardCount(conn, searchMap, type);
		close(conn);
		return result;
	}
	

	public List<communityBoard> getBoardList(PageInfo pageinfo, Map<String, String> searchMap, String type) {
		Connection conn = getConnection();
		
		List<communityBoard> list = dao.findAll(conn, pageinfo, searchMap);
		close(conn);
		return list;
	}
	

	public int save(communityBoard board) {
		Connection conn = getConnection();
		int result = 0;
		
		if(board.getNo() != 0 ) {
			result = dao.updateBoard(conn, board);
		} else {
			result = dao.insertBoard(conn, board);
		}
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public communityBoard findBoardByNo(int no, boolean hasRead, String type) {
		Connection conn = getConnection();
		communityBoard board = dao.findBoardByNo(conn, no, type);
		
		// 조회수 증가 로직
		if(hasRead == true && board != null) {
			int result = dao.updateReadCount(conn, board, type);
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		close(conn);
		return board;
	}
	
	public int delete(int no) {
		Connection conn = getConnection();
		int result = dao.updateStatus(conn, no, "N");
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int saveReply(communityReply reply) {
		Connection conn = getConnection();
		int result = dao.insertReply(conn, reply);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deleteReply(int replyNo) {
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, replyNo);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
