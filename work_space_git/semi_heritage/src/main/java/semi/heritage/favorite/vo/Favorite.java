package semi.heritage.favorite.vo;

public class Favorite {
	private int uno;
	private String uemail;
	private String upw;
	private String uname;
	private String upn;
	private String uadr;
	private String uphoto;
	private String introduce;

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(int uno, String uemail, String upw, String uname, String upn, String uadr, String uphoto,
			String introduce) {
		super();
		this.uno = uno;
		this.uemail = uemail;
		this.upw = upw;
		this.uname = uname;
		this.upn = upn;
		this.uadr = uadr;
		this.uphoto = uphoto;
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "memberVO [uno=" + uno + ", uemail=" + uemail + ", upw=" + upw + ", uname=" + uname + ", upn=" + upn
				+ ", uadr=" + uadr + ", uphoto=" + uphoto + ", introduce=" + introduce + "]";
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

}
