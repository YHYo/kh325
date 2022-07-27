package semi.heritage.heritageInfo.vo;

public class heritageImage {

	private int imageNo;
	private String imageUrl;
	private String ccimDesc;
	private int sn;
	private String ccbaKdcd;
	private String ccbaCtcd;
	private String ccbaAsno;
	
	public heritageImage() {
		super();
	}

	public heritageImage(int imageNo, String imageUrl, String ccimDesc, int sn, String ccbaKdcd, String ccbaCtcd,
			String ccbaAsno) {
		super();
		this.imageNo = imageNo;
		this.imageUrl = imageUrl;
		this.ccimDesc = ccimDesc;
		this.sn = sn;
		this.ccbaKdcd = ccbaKdcd;
		this.ccbaCtcd = ccbaCtcd;
		this.ccbaAsno = ccbaAsno;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCcimDesc() {
		return ccimDesc;
	}

	public void setCcimDesc(String ccimDesc) {
		this.ccimDesc = ccimDesc;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getCcbaKdcd() {
		return ccbaKdcd;
	}

	public void setCcbaKdcd(String ccbaKdcd) {
		this.ccbaKdcd = ccbaKdcd;
	}

	public String getCcbaCtcd() {
		return ccbaCtcd;
	}

	public void setCcbaCtcd(String ccbaCtcd) {
		this.ccbaCtcd = ccbaCtcd;
	}

	public String getCcbaAsno() {
		return ccbaAsno;
	}

	public void setCcbaAsno(String ccbaAsno) {
		this.ccbaAsno = ccbaAsno;
	}

	@Override
	public String toString() {
		return "heritageImage [imageNo=" + imageNo + ", imageUrl=" + imageUrl + ", ccimDesc=" + ccimDesc + ", sn=" + sn
				+ ", ccbaKdcd=" + ccbaKdcd + ", ccbaCtcd=" + ccbaCtcd + ", ccbaAsno=" + ccbaAsno + "]" + "\n";
	}
	
	
	
}
	
	