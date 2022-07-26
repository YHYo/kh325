package semi.heritage.palace.service;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import semi.heritage.palace.dao.Palace_Jongmyo_Sangse_Movie_Dao;
import semi.heritage.palace.vo.Palace_Jongmyo_Sangse_movie;


public class Palace_Jongmyo_Sangse_Movie_Service {
	private Palace_Jongmyo_Sangse_Movie_Dao pjsm_dao = new Palace_Jongmyo_Sangse_Movie_Dao();
	private Connection conn = null;
	
	public Palace_Jongmyo_Sangse_Movie_Service() {
		conn = getConnection();
	}
	
	public List<Palace_Jongmyo_Sangse_movie> selectAll() {
		return pjsm_dao.selectAll(conn);
	}
	
	public int insert(Palace_Jongmyo_Sangse_movie pjs) {
		Connection conn2 = getConnection();
		int result = pjsm_dao.insert(conn2, pjs);
		if(result > 0) {
			commit(conn2);
		}else {
			rollback(conn2);
		}
		close(conn2);
		return result;
	}
}
