package semi.heritage.favorite.controller;

import java.util.List;

import semi.heritage.favorite.service.favoriteService;
import semi.heritage.favorite.vo.favoriteMyPageVO;
import semi.heritage.favorite.vo.favoritePalaceVO;
import semi.heritage.favorite.vo.favoriteVO;

public class favoriteController {
	
	favoriteService fs = new favoriteService();
	
	// 찜 insert
	public int insert(int uNo, int no) {
		return fs.insert(uNo, no);
	}

	// 찜 delete
	public int delete(int uNo, int no) {
		return fs.delete(uNo, no);
	}
	
	public List<favoriteMyPageVO> selectAll(int uNo) {
		return fs.selectAll(uNo);
	}
	
	// 문화재 번호로 찜 개수 구하기
	public int CountFavoriteByNo(int no){
		return fs.CountFavoriteByNo(no);
	}
	

}
