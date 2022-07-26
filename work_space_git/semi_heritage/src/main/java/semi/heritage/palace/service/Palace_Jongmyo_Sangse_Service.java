package semi.heritage.palace.service;

import static semi.heritage.common.jdbc.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import semi.heritage.palace.dao.Palace_Jongmyo_Sangse_Dao;
import semi.heritage.palace.vo.Palace_Jongmyo_Sangse;


public class Palace_Jongmyo_Sangse_Service {
	private Palace_Jongmyo_Sangse_Dao sdao1 = new Palace_Jongmyo_Sangse_Dao();
	private Connection conn = null;
	
	public Palace_Jongmyo_Sangse_Service() {
		conn = getConnection();
	}
	
	public List<Palace_Jongmyo_Sangse> selectAll() {
		return sdao1.selectAll(conn);
	}
	
	public int insert(Palace_Jongmyo_Sangse pjs) {
		Connection conn2 = getConnection();
		int result = sdao1.insert(conn2, pjs);
		if(result > 0) {
			commit(conn2);
		}else {
			rollback(conn2);
		}
		close(conn2);
		return result;
	}
}
