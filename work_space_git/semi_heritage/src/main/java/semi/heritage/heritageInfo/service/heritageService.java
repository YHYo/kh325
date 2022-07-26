package semi.heritage.heritageInfo.service;

import java.sql.Connection;
import java.util.List;


import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.dao.heritageDao;
import semi.heritage.heritageInfo.vo.heritageCode;

import static semi.heritage.common.jdbc.JDBCTemplate.*;


public class heritageService {
	
		private heritageDao dao = new heritageDao();
		private Connection conn = null;

		public heritageService() {
			conn = getConnection();
		}

		public int insert(heritageCode heritagecode) {
			Connection conn2 = getConnection();
			int result = dao.insertCode(conn2, heritagecode);
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
		
		public int insertImage(heritageImage heritagevo) {
			Connection conn2 = getConnection();
			int result = dao.insertImage(conn2, heritagevo);
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
