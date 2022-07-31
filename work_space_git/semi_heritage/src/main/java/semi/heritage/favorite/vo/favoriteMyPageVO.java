package semi.heritage.favorite.vo;

public class favoriteMyPageVO {

	private int hfavNum;
	private String ccmaName;
	private String ccbaMnm1;
	private String ccbaLcad;
	private String imageUrl;
	private String content;
	
	public favoriteMyPageVO() {
		super();
	}

	public favoriteMyPageVO(int hfavNum, String ccmaName, String ccbaMnm1, String ccbaLcad, String imageUrl,
			String content) {
		super();
		this.hfavNum = hfavNum;
		this.ccmaName = ccmaName;
		this.ccbaMnm1 = ccbaMnm1;
		this.ccbaLcad = ccbaLcad;
		this.imageUrl = imageUrl;
		this.content = content;
	}

	public int getHfavNum() {
		return hfavNum;
	}

	public void setHfavNum(int hfavNum) {
		this.hfavNum = hfavNum;
	}

	public String getCcmaName() {
		return ccmaName;
	}

	public void setCcmaName(String ccmaName) {
		this.ccmaName = ccmaName;
	}

	public String getCcbaMnm1() {
		return ccbaMnm1;
	}

	public void setCcbaMnm1(String ccbaMnm1) {
		this.ccbaMnm1 = ccbaMnm1;
	}

	public String getCcbaLcad() {
		return ccbaLcad;
	}

	public void setCcbaLcad(String ccbaLcad) {
		this.ccbaLcad = ccbaLcad;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "favoriteMyPageVO [hfavNum=" + hfavNum + ", ccmaName=" + ccmaName + ", ccbaMnm1=" + ccbaMnm1
				+ ", ccbaLcad=" + ccbaLcad + ", imageUrl=" + imageUrl + ", content=" + content + "]";
	}
	
	
	
}
