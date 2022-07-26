package semi.heritage.heritageInfo.controller;

import java.util.List;

import semi.heritage.heritageInfo.api.heritageImageApi;
import semi.heritage.heritageInfo.api.heritageList2;
import semi.heritage.heritageInfo.service.heritageService;
import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageCode;

public class heritageController {
	
	private heritageService hService = new heritageService();

	public void initHeritage() {
	
		while(true) {
			List<heritageCode> list = heritageList2.callCurrentHeritageListByXML();
		
			if(list == null || list.isEmpty()) {
				continue;
			}
			
			for(heritageCode heritagevo : list) {
				hService.insert(heritagevo);
			}
		}
	}
	
	public void initHeritageImage() {
		
		while(true) {
			List<heritageImage> list = heritageImageApi.callCurrentHeritageImageByXML();
		
			if(list == null || list.isEmpty()) {
				continue;
			}
			
			for(heritageImage heritageimage : list) {
				hService.insertImage(heritageimage);
			}
		}
	}
}
