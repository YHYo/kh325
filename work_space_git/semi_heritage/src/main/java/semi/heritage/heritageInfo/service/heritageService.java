package semi.heritage.heritageInfo.service;

import java.sql.Connection;
import java.util.List;

import static semi.heritage.common.jdbc.JDBCTemplate.*;
import semi.heritage.common.util.PageInfo;
import semi.heritage.heritageInfo.dao.heritageDao;
import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageMainVO;
import semi.heritage.heritageInfo.vo.heritageVO;
import semi.heritage.heritageInfo.vo.heritageVideo;


public class heritageService {
	
		private heritageDao dao = new heritageDao();
		private Connection conn = null;

		public heritageService() {
			conn = getConnection();
		}

		public int insert(heritageVO heritageVO) {
			Connection conn = getConnection();
			int result = dao.insert(conn, heritageVO);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			close(conn);
			return result;
		}
		
		public int insertImage(heritageImage heritageimage) {
			Connection conn = getConnection();
			int result = dao.insertImage(conn, heritageimage);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			close(conn);
			return result;
		}
		
		public int insertVideo(heritageVideo heritagevideo) {
			Connection conn = getConnection();
			int result = dao.insertVideo(conn, heritagevideo);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			close(conn);
			return result;
		}
		
		//이름으로 검색한 문화재 갯수
		public int getheritageMainVOCount(String ccbaMnm) {
			Connection conn = getConnection();
			int result = dao.getheritageMainVOCount(conn, ccbaMnm);
			close(conn);
			return result;
		}
	
		// 메인 인기문화명소
		public List<heritageMainVO> mainByFavorite() {
			Connection conn = getConnection();
			List<heritageMainVO> list = dao.mainByFavorite(conn);
			close(conn);
			return list;
		}
	
		// 메인 검색
		public List<heritageMainVO> selectByHeritageName(String ccbaMnm, PageInfo pageInfo) {
			Connection conn = getConnection();
			List<heritageMainVO> list = dao.selectByHeritageName(conn, ccbaMnm, pageInfo);
			close(conn);
			return list;
		}
		
		// 메인 검색
		public heritageVO findHertiageByNo(int hertiageNo){
			Connection conn = getConnection();
			heritageVO hv = dao.findHertiageByNo(conn, hertiageNo);
			return hv;
		}
}
