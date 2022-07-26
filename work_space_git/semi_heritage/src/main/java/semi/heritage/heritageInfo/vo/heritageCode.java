package semi.heritage.heritageInfo.vo;

import java.io.Serializable;

public class heritageCode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int no;
	private String ccbaKdcd;		// 종목코드
	private String ccbaCtcd;		// 시도코드
	private String ccbaAsno;		// 지정번호
	
	public heritageCode() {
		super();

	}

	public heritageCode(int no, String ccbaKdcd, String ccbaCtcd, String ccbaAsno) {
		super();
		this.no = no;
		this.ccbaKdcd = ccbaKdcd;
		this.ccbaCtcd = ccbaCtcd;
		this.ccbaAsno = ccbaAsno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "heritageVO2 [no=" + no + ", ccbaKdcd=" + ccbaKdcd + ", ccbaCtcd=" + ccbaCtcd + ", ccbaAsno=" + ccbaAsno
				+ "]";
	}
	
	

	
	
}
