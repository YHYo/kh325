package semi.heritage.favorite.service;

import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import semi.heritage.favorite.dao.favoritePalaceDao;
import semi.heritage.favorite.vo.favoritePalaceVO;

public class favoritePalaceService {
	
	private favoritePalaceDao dao = new favoritePalaceDao();
	private Connection conn = null;
	
	public favoritePalaceService() {
		conn = getConnection();
	}
	
	// 찜이 많이 된 궁/종묘순 정렬
	public List<favoritePalaceVO> sortedByFavoritePalace() {
		return dao.sortedByFavoritePalace(conn);
	}
}
