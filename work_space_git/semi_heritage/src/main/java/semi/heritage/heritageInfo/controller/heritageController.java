package semi.heritage.heritageInfo.controller;

import java.util.List;

//import semi.heritage.heritageInfo.api.heritageImageApi;
import semi.heritage.heritageInfo.api.heritageInfoDetail;
import semi.heritage.heritageInfo.service.heritageService;
import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageVO;


public class heritageController {
	
	private heritageService hService = new heritageService();
	
	int threadCount = 0;
	int threadMaxCount = 10;

	public void initHeritage() {
		while(true) {
			while(threadCount > threadMaxCount) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {}
			}
			new Thread(new Runnable() {
				@Override
				public void run() {
					threadCount++;
					List<heritageVO> list = heritageInfoDetail.callCurrentHeritageListByXML();
					
					if(list == null || list.isEmpty()) {
						return;
					}
					
					for(heritageVO heritagevo : list) {
						hService.insert(heritagevo);
					}
					threadCount--;
				}
			}).start();;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
//	public void initHeritageImage() {
//		
//		while(true) {
//			List<heritageImage> list = heritageImageApi.callCurrentHeritageImageByXML();
//		
//			if(list == null || list.isEmpty()) {
//				continue;
//			}
//			
//			for(heritageImage heritageimage : list) {
//				hService.insertImage(heritageimage);
//			}
//		}
//	}
}
