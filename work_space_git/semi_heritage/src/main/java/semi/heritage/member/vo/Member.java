package semi.heritage.member.vo;


public class 
Member {
	private int uno;
	private String uemail;
	private String upw;
	private String uname;
	private String upn;
	private String uadr;
	private String originalPhoto;
	private String renamedPhoto;
	private String introduce;
	private String twt;
	private String insta;
	private String facebook;
	private String status;
	
	public Member() {
		super();
	
	}

	public Member(int uno, String uemail, String upw, String uname, String upn, String uadr, String originalPhoto,
			String renamedPhoto, String introduce, String twt, String insta, String facebook, String status) {
		super();
		this.uno = uno;
		this.uemail = uemail;
		this.upw = upw;
		this.uname = uname;
		this.upn = upn;
		this.uadr = uadr;
		this.originalPhoto = originalPhoto;
		this.renamedPhoto = renamedPhoto;
		this.introduce = introduce;
		this.twt = twt;
		this.insta = insta;
		this.facebook = facebook;
		this.status = status;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpn() {
		return upn;
	}

	public void setUpn(String upn) {
		this.upn = upn;
	}

	public String getUadr() {
		return uadr;
	}

	public void setUadr(String uadr) {
		this.uadr = uadr;
	}

	public String getOriginalPhoto() {
		return originalPhoto;
	}

	public void setOriginalPhoto(String originalPhoto) {
		this.originalPhoto = originalPhoto;
	}

	public String getRenamedPhoto() {
		return renamedPhoto;
	}

	public void setRenamedPhoto(String renamedPhoto) {
		this.renamedPhoto = renamedPhoto;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getTwt() {
		return twt;
	}

	public void setTwt(String twt) {
		this.twt = twt;
	}

	public String getInsta() {
		return insta;
	}

	public void setInsta(String insta) {
		this.insta = insta;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [uno=" + uno + ", uemail=" + uemail + ", upw=" + upw + ", uname=" + uname + ", upn=" + upn
				+ ", uadr=" + uadr + ", originalPhoto=" + originalPhoto + ", renamedPhoto=" + renamedPhoto
				+ ", introduce=" + introduce + ", twt=" + twt + ", insta=" + insta + ", facebook=" + facebook
				+ ", status=" + status + "]";
	}
	
	
}

	