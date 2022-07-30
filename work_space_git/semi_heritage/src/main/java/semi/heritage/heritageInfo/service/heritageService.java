package semi.heritage.heritageInfo.service;

import java.sql.Connection;
import java.util.List;


import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageMainVO;
import semi.heritage.heritageInfo.vo.heritageVO;
import semi.heritage.heritageInfo.vo.heritageVideo;
import semi.heritage.common.util.PageInfo;
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
		
		// 메인 인기문화명소
		public List<heritageMainVO> mainByFavorite() {
			return dao.mainByFavorite(conn);
		}
		
		// 메인 검색
		public List<heritageMainVO> selectByHeritageName(String ccbaMnm, PageInfo pageInfo) {
			return dao.selectByHeritageName(conn, ccbaMnm, pageInfo);
		}
}
