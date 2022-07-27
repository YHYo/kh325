package semi.heritage.heritageInfo.vo;

public class heritageVideo {

	private int videoNo;
	private String videoUrl;
	private int sn;
	private String ccbaKdcd;
	private String ccbaCtcd;
	private String ccbaAsno;
	
	public heritageVideo() {
		super();
	}

	public heritageVideo(int videoNo, String videoUrl, int sn, String ccbaKdcd, String ccbaCtcd, String ccbaAsno) {
		super();
		this.videoNo = videoNo;
		this.videoUrl = videoUrl;
		this.sn = sn;
		this.ccbaKdcd = ccbaKdcd;
		this.ccbaCtcd = ccbaCtcd;
		this.ccbaAsno = ccbaAsno;
	}

	public int getVideoNo() {
		return videoNo;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
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
		return "heritageVideo [videoNo=" + videoNo + ", videoUrl=" + videoUrl + ", sn=" + sn + ", ccbaKdcd=" + ccbaKdcd
				+ ", ccbaCtcd=" + ccbaCtcd + ", ccbaAsno=" + ccbaAsno + "]";
	}
	
	
	
}
