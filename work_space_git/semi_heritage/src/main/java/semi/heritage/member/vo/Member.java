package semi.heritage.member.vo;

public class Member {
	private int uno;
	private String uemail;
	private String upw;
	private String uname;
	private String upn;
	private String uadr;
	private String uphoto;
	private String introduce;
	private String twt;
	private String insta;
	private String facebook;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int uno, String uemail, String upw, String uname, String upn, String uadr, String uphoto,
			String introduce, String twt, String insta, String facebook) {
		super();
		this.uno = uno;
		this.uemail = uemail;
		this.upw = upw;
		this.uname = uname;
		this.upn = upn;
		this.uadr = uadr;
		this.uphoto = uphoto;
		this.introduce = introduce;
		this.twt = twt;
		this.insta = insta;
		this.facebook = facebook;
	}

	@Override
	public String toString() {
		return "Member [uno=" + uno + ", uemail=" + uemail + ", upw=" + upw + ", uname=" + uname + ", upn=" + upn
				+ ", uadr=" + uadr + ", uphoto=" + uphoto + ", introduce=" + introduce + ", twt=" + twt + ", insta="
				+ insta + ", facebook=" + facebook + "]";
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

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
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

}
