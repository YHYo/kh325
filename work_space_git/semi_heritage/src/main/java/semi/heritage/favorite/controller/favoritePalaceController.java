package semi.heritage.favorite.controller;

import java.util.List;

import semi.heritage.favorite.service.favoritePalaceService;
import semi.heritage.favorite.vo.favoritePalaceVO;

public class favoritePalaceController {
	
	favoritePalaceService fps = new favoritePalaceService();

	public List<favoritePalaceVO> sortedByFavoritePalace(){
		return fps.sortedByFavoritePalace();
	}
	
	public static void main(String[] args) {
		favoritePalaceController fps = new favoritePalaceController();
		fps.sortedByFavoritePalace();
	}
}
