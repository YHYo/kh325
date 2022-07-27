package semi.heritage.heritageInfo.service;

import java.sql.Connection;
import java.util.List;


import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageVO;
import semi.heritage.heritageInfo.vo.heritageVideo;
import semi.heritage.heritageInfo.dao.heritageDao;

import static semi.heritage.common.jdbc.JDBCTemplate.*;


public class heritageService {
	
		private heritageDao dao = new heritageDao();
		private Connection conn = null;

		public heritageService() {
			conn = getConnection();
		}

		public int insert(heritageVO heritageVO) {
			Connection conn2 = getConnection();
			int result = dao.insert(conn2, heritageVO);
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
		
		public int insertImage(heritageImage heritageimage) {
			Connection conn2 = getConnection();
			int result = dao.insertImage(conn2, heritageimage);
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
		
		public int insertVideo(heritageVideo heritagevideo) {
			Connection conn2 = getConnection();
			int result = dao.insertVideo(conn2, heritagevideo);
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
