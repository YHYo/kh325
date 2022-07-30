package semi.heritage.heritageInfo.controller;

import java.util.List;

import semi.heritage.common.util.PageInfo;
import semi.heritage.heritageInfo.api.heritageImageApi;
//import semi.heritage.heritageInfo.api.heritageImageApi;
import semi.heritage.heritageInfo.api.heritageInfoDetail;
import semi.heritage.heritageInfo.api.heritageVideoApi;
import semi.heritage.heritageInfo.service.heritageService;
import semi.heritage.heritageInfo.vo.heritageImage;
import semi.heritage.heritageInfo.vo.heritageMainVO;
import semi.heritage.heritageInfo.vo.heritageVO;
import semi.heritage.heritageInfo.vo.heritageVideo;

public class heritageController {

	private heritageService hService = new heritageService();

	int threadCount = 0;
	int threadMaxCount = 10;

	// 문화재 DB INSERT
	public void initHeritage() {
		while (true) {
			while (threadCount > threadMaxCount) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
				}
			}
			new Thread(new Runnable() {
				@Override
				public void run() {
					threadCount++;
					List<heritageVO> list = heritageInfoDetail.callCurrentHeritageListByXML();

					if (list == null || list.isEmpty()) {
						return;
					}

					for (heritageVO heritagevo : list) {
						hService.insert(heritagevo);
					}
					threadCount--;
				}
			}).start();
			;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	// 문화재이미지 DB INSERT
	public void initHeritageImage() {

		while (true) {
			List<heritageImage> list = heritageImageApi.callCurrentHeritageImageByXML();

			if (list == null || list.isEmpty()) {
				continue;
			}

			for (heritageImage heritageimage : list) {
				hService.insertImage(heritageimage);
			}
		}
	}

	// 문화재동영상 DB INSERT
	public void initHeritageVideo() {

		while (true) {
			List<heritageVideo> list = heritageVideoApi.callCurrentHeritageVideoByXML();

			if (list == null || list.isEmpty()) {
				continue;
			}

			for (heritageVideo heritagevideo : list) {
				hService.insertVideo(heritagevideo);
			}
		}
	}
	
	// 메인 검색
	public List<heritageMainVO> selectByHeritageName(String ccbaMnm, PageInfo pageInfo){
		return hService.selectByHeritageName(ccbaMnm, pageInfo);
	}
	
	// 메인 인기문화명소
	public List<heritageMainVO> mainByFavorite(){
		return hService.mainByFavorite();
	}
}
