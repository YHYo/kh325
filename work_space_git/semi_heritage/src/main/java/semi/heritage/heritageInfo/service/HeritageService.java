package semi.heritage.heritageInfo.service;

import java.sql.Connection;
import java.util.List;

import static semi.heritage.common.jdbc.JDBCTemplate.*;
import semi.heritage.common.util.PageInfo;
import semi.heritage.heritageInfo.dao.HeritageDao;
import semi.heritage.heritageInfo.vo.HeritageImage;
import semi.heritage.heritageInfo.vo.HeritageMainVO;
import semi.heritage.heritageInfo.vo.HeritageVO;
import semi.heritage.heritageInfo.vo.HeritageVideo;


public class HeritageService {
	
		private HeritageDao dao = new HeritageDao();
		private Connection conn = null;

		public HeritageService() {
			conn = getConnection();
		}

		public int insert(HeritageVO heritageVO) {
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
		
		public int insertImage(HeritageImage heritageimage) {
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
		
		public int insertVideo(HeritageVideo heritagevideo) {
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
		public List<HeritageMainVO> mainByFavorite() {
			Connection conn = getConnection();
			List<HeritageMainVO> list = dao.mainByFavorite(conn);
			close(conn);
			return list;
		}
	
		// 메인 검색
		public List<HeritageMainVO> selectByHeritageName(String ccbaMnm, PageInfo pageInfo) {
			Connection conn = getConnection();
			List<HeritageMainVO> list = dao.selectByHeritageName(conn, ccbaMnm, pageInfo);
			close(conn);
			return list;
		}
		
		// 메인 검색
		public HeritageVO findHertiageByNo(int hertiageNo){
			Connection conn = getConnection();
			HeritageVO hv = dao.findHertiageByNo(conn, hertiageNo);
			return hv;
		}
}