package semi.heritage.event.service;

import static semi.heritage.common.jdbc.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import semi.heritage.event.dao.FestivalDao;
import semi.heritage.event.vo.Festival;



public class FestivalService {
	private FestivalDao dao = new FestivalDao();
	private Connection conn = null;
	
	public FestivalService() {
		conn = getConnection();
	}

	public List<Festival> selectAll(){
		return dao.selectAll(conn);
		
	}

	public int insert(Festival festival) {
		Connection conn2 = getConnection();
		int result = dao.insert(conn2, festival);
		if (result > 0) {
			commit(conn2);
		} else {
			rollback(conn2);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		close(conn2);
		return result;
	}
}
