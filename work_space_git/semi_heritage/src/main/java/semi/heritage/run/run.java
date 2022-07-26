package semi.heritage.run;

import semi.heritage.event.controller.FestivalController;
import semi.heritage.heritageInfo.controller.heritageController;
import semi.heritage.palace.controller.Palace_Jongmyo_Sangse_Controller;
import semi.heritage.palace.controller.Palace_Jongmyo_Sangse_Image_Controller;
import semi.heritage.palace.controller.Palace_Jongmyo_Sangse_Movie_Controller;

public class run {

		public static void main(String[] args) {
			
//======================================= 문화재 파싱 ====================================================
			heritageController hc = new heritageController();
			hc.initHeritage();
			
//======================================= 궁궐 종묘 파싱 ====================================================
//			Palace_Jongmyo_Controller pjc = new Palace_Jongmyo_Controller();
//			pjc.initPalace_Jongmyo();
			
//			Palace_Jongmyo_Sangse_Controller pjsc = new Palace_Jongmyo_Sangse_Controller();
//			pjsc.initPalace_Jongmyo_Sangse();
//			
//			Palace_Jongmyo_Sangse_Image_Controller pjsIc = new Palace_Jongmyo_Sangse_Image_Controller();
//			pjsIc.initPalace_Jongmyo_Sangse_Image();
//			
//			Palace_Jongmyo_Sangse_Movie_Controller pjsMc = new Palace_Jongmyo_Sangse_Movie_Controller();
//			pjsMc.initPalace_Jongmyo_Sangse_Movie();
//=======================================================================================================	

			
//======================================= 행사 파싱 ====================================================
//			FestivalController fc = new FestivalController();
//			fc.initFestival();
//=======================================================================================================
			
			
	}
}
