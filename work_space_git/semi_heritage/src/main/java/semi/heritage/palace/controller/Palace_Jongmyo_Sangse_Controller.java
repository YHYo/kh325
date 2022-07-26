package semi.heritage.palace.controller;

import java.util.List;

import semi.heritage.palace.api.Palace_Jongmyo_Sangse_API;
import semi.heritage.palace.service.Palace_Jongmyo_Sangse_Service;
import semi.heritage.palace.vo.Palace_Jongmyo_Sangse;

public class Palace_Jongmyo_Sangse_Controller {
	private Palace_Jongmyo_Sangse_Service pjss = new Palace_Jongmyo_Sangse_Service();
	
	public void initPalace_Jongmyo_Sangse() {
		
		while(true) {
			List<Palace_Jongmyo_Sangse> list = Palace_Jongmyo_Sangse_API.callPalaceJongmyoSangseListByXML();
			
			if(list == null || list.isEmpty()) {
				continue;
			}
			for(Palace_Jongmyo_Sangse pjs : list) {
				pjss.insert(pjs);
			}
		}
	}
	
	public List<Palace_Jongmyo_Sangse> selectAll(){
		return pjss.selectAll();
	}

}
