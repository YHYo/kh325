package semi.heritage.palace.controller;

import java.util.List;

import semi.heritage.palace.api.Palace_Jongmyo_Sangse_Image_API;
import semi.heritage.palace.service.Palace_Jongmyo_Sangse_Image_Service;
import semi.heritage.palace.vo.Palace_Jongmyo_Sangse_image;


public class Palace_Jongmyo_Sangse_Image_Controller {
	private Palace_Jongmyo_Sangse_Image_Service pjsi_service = new Palace_Jongmyo_Sangse_Image_Service();
	
	public void initPalace_Jongmyo_Sangse_Image() {
		
		while(true) {
			List<Palace_Jongmyo_Sangse_image> list = Palace_Jongmyo_Sangse_Image_API.callPalaceJongmyoSangseListByXML();
			
			if(list == null || list.isEmpty()) {
				continue;
			}
			for(Palace_Jongmyo_Sangse_image pjs : list) {
				pjsi_service.insert(pjs);
			}
		}
	}
	
	public List<Palace_Jongmyo_Sangse_image> selectAll(){
		return pjsi_service.selectAll();
	}

}
