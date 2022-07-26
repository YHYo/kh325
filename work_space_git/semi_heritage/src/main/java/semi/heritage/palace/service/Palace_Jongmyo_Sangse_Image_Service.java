package semi.heritage.palace.service;

import static semi.heritage.common.jdbc.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import semi.heritage.palace.dao.Palace_Jongmyo_Sangse_Image_Dao;
import semi.heritage.palace.vo.Palace_Jongmyo_Sangse_image;



public class Palace_Jongmyo_Sangse_Image_Service {
	private Palace_Jongmyo_Sangse_Image_Dao pjsi_dao = new Palace_Jongmyo_Sangse_Image_Dao();
	private Connection conn = null;
	
	public Palace_Jongmyo_Sangse_Image_Service() {
		conn = getConnection();
	}
	
	public List<Palace_Jongmyo_Sangse_image> selectAll() {
		return pjsi_dao.selectAll(conn);
	}
	
	public int insert(Palace_Jongmyo_Sangse_image pjs) {
		Connection conn2 = getConnection();
		int result = pjsi_dao.insert(conn2, pjs);
		if(result > 0) {
			commit(conn2);
		}else {
			rollback(conn2);
		}
		close(conn2);
		return result;
	}
}
