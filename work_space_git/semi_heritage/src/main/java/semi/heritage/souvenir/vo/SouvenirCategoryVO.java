package semi.heritage.souvenir.vo;

public class SouvenirCategoryVO {
	private String cPath;
	private String cName;
	private String cSebu;

	public SouvenirCategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SouvenirCategoryVO(String cPath, String cName, String cSebu) {
		super();
		this.cPath = cPath;
		this.cName = cName;
		this.cSebu = cSebu;
	}

	@Override
	public String toString() {
		return "SouvenirCategoryVO [cPath=" + cPath + ", cName=" + cName + ", cSebu=" + cSebu + "]";
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

}
