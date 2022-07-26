package semi.heritage.heritageInfo.vo;

public class heritageDetail {

	private String gcodeName;		// 문화재분류 
	private String bcodeName;		// 문화재분류2
	private String mcodeName; 		// 문화재분류3
	private String scodeName;  	 	// 문화재분류4
	private String ccbaQuan;		// 수량
	private String ccbaAsdt; 		// 지정(등록일)
	private String ccbaLcad;		// 소재지 상세
	private String ccceName;		// 시대
	private String ccbaPoss;		// 소유자
	private String imageUrl;		// 메인노출이미지URL
	private String content;			// 내용
	
	public heritageDetail() {
		super();
	}

	public heritageDetail(String gcodeName, String bcodeName, String mcodeName, String scodeName, String ccbaQuan,
			String ccbaAsdt, String ccbaLcad, String ccceName, String ccbaPoss, String imageUrl, String content) {
		super();
		this.gcodeName = gcodeName;
		this.bcodeName = bcodeName;
		this.mcodeName = mcodeName;
		this.scodeName = scodeName;
		this.ccbaQuan = ccbaQuan;
		this.ccbaAsdt = ccbaAsdt;
		this.ccbaLcad = ccbaLcad;
		this.ccceName = ccceName;
		this.ccbaPoss = ccbaPoss;
		this.imageUrl = imageUrl;
		this.content = content;
	}

	public String getGcodeName() {
		return gcodeName;
	}

	public void setGcodeName(String gcodeName) {
		this.gcodeName = gcodeName;
	}

	public String getBcodeName() {
		return bcodeName;
	}

	public void setBcodeName(String bcodeName) {
		this.bcodeName = bcodeName;
	}

	public String getMcodeName() {
		return mcodeName;
	}

	public void setMcodeName(String mcodeName) {
		this.mcodeName = mcodeName;
	}

	public String getScodeName() {
		return scodeName;
	}

	public void setScodeName(String scodeName) {
		this.scodeName = scodeName;
	}

	public String getCcbaQuan() {
		return ccbaQuan;
	}

	public void setCcbaQuan(String ccbaQuan) {
		this.ccbaQuan = ccbaQuan;
	}

	public String getCcbaAsdt() {
		return ccbaAsdt;
	}

	public void setCcbaAsdt(String ccbaAsdt) {
		this.ccbaAsdt = ccbaAsdt;
	}

	public String getCcbaLcad() {
		return ccbaLcad;
	}

	public void setCcbaLcad(String ccbaLcad) {
		this.ccbaLcad = ccbaLcad;
	}

	public String getCcceName() {
		return ccceName;
	}

	public void setCcceName(String ccceName) {
		this.ccceName = ccceName;
	}

	public String getCcbaPoss() {
		return ccbaPoss;
	}

	public void setCcbaPoss(String ccbaPoss) {
		this.ccbaPoss = ccbaPoss;
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
		return "heritageDetail [gcodeName=" + gcodeName + ", bcodeName=" + bcodeName + ", mcodeName=" + mcodeName
				+ ", scodeName=" + scodeName + ", ccbaQuan=" + ccbaQuan + ", ccbaAsdt=" + ccbaAsdt + ", ccbaLcad="
				+ ccbaLcad + ", ccceName=" + ccceName + ", ccbaPoss=" + ccbaPoss + ", imageUrl=" + imageUrl
				+ ", content=" + content + "]";
	}
	
	
}
