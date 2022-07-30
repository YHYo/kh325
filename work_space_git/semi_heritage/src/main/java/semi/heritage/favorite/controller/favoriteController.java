package semi.heritage.favorite.controller;

import java.util.List;

import semi.heritage.favorite.service.favoriteService;
import semi.heritage.favorite.vo.favoritePalaceVO;
import semi.heritage.favorite.vo.favoriteVO;

public class favoriteController {
	
	favoriteService fs = new favoriteService();
	
	public List<favoriteVO> sortedByFavorite(){
		return fs.sortedByFavorite();
	}
	
	public List<favoriteVO> CountFavoriteByNo(int no){
		return fs.CountFavoriteByNo(no);
	}
	

}
