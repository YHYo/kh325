package semi.heritage.heritageInfo.vo;

public class heritageVideo {

	private int videoNo;
	private String videoUrl;
	private int sn;
	
	public heritageVideo() {
		super();
	}

	public heritageVideo(int videoNo, String videoUrl, int sn) {
		super();
		this.videoNo = videoNo;
		this.videoUrl = videoUrl;
		this.sn = sn;
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

	@Override
	public String toString() {
		return "heritageVideo [videoNo=" + videoNo + ", videoUrl=" + videoUrl + ", sn=" + sn + "]";
	}
	
	
}
