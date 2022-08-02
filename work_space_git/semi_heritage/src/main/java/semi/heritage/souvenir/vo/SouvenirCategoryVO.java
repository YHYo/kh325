package semi.heritage.souvenir.vo;

public class SouvenirCategoryVO {
	private String cPath;
	private String cName;
	private String cSebu;
	private String cKeyword;

	public SouvenirCategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SouvenirCategoryVO(String cPath, String cName, String cSebu, String cKeyword) {
		super();
		this.cPath = cPath;
		this.cName = cName;
		this.cSebu = cSebu;
		this.cKeyword = cKeyword;
	}

	@Override
	public String toString() {
		return "SouvenirCategoryVO [cPath=" + cPath + ", cName=" + cName + ", cSebu=" + cSebu + ", cKeyword=" + cKeyword
				+ "]";
	}

	public String getcPath() {
		return cPath;
	}

	public void setcPath(String cPath) {
		this.cPath = cPath;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcSebu() {
		return cSebu;
	}

	public void setcSebu(String cSebu) {
		this.cSebu = cSebu;
	}

	public String getcKeyword() {
		return cKeyword;
	}

	public void setcKeyword(String cKeyword) {
		this.cKeyword = cKeyword;
	}

	

}
