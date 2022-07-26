package semi.heritage.palace.controller;

import java.util.List;

import semi.heritage.palace.api.Palace_Jongmyo_Sangse_Movie_API;
import semi.heritage.palace.service.Palace_Jongmyo_Sangse_Movie_Service;
import semi.heritage.palace.vo.Palace_Jongmyo_Sangse_movie;


public class Palace_Jongmyo_Sangse_Movie_Controller {
	private Palace_Jongmyo_Sangse_Movie_Service pjsm_service = new Palace_Jongmyo_Sangse_Movie_Service();
	
	public void initPalace_Jongmyo_Sangse_Movie() {
		
		while(true) {
			List<Palace_Jongmyo_Sangse_movie> list = Palace_Jongmyo_Sangse_Movie_API.callPalaceJongmyoSangseListByXML();
			
			if(list == null || list.isEmpty()) {
				continue;
			}
			for(Palace_Jongmyo_Sangse_movie pjs : list) {
				pjsm_service.insert(pjs);
			}
		}
	}
	
	public List<Palace_Jongmyo_Sangse_movie> selectAll(){
		return pjsm_service.selectAll();
	}

}
