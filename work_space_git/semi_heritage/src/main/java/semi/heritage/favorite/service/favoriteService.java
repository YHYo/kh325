package semi.heritage.favorite.service;

import java.sql.Connection;
import java.util.List;
import static semi.heritage.common.jdbc.JDBCTemplate.*;
import semi.heritage.favorite.dao.favoriteDao;
import semi.heritage.favorite.vo.favoritePalaceVO;
import semi.heritage.favorite.vo.favoriteVO;

public class favoriteService {

	private favoriteDao dao = new favoriteDao();
	private Connection conn = null;
	
	public favoriteService() {
		conn = getConnection();
	}

	// 찜이 많이 된 일반 문화재순 정렬
	public List<favoriteVO> sortedByFavorite() {
		return dao.sortedByFavorite(conn);
	}

	public List<favoriteVO> CountFavoriteByNo(int no){
		return dao.CountFavoriteByNo(conn, no);
	}

}
