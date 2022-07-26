package semi.heritage.souvenir.vo;

public class Souvenir_Cart_VO {
	int uNo;
	String SOUV_PRO_NAME;
	String SOUV_PRO_PRICE;
	String SOUV_PRO_CATEGORY;

	public Souvenir_Cart_VO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Souvenir_Cart_VO(int uNo, String sOUV_PRO_NAME, String sOUV_PRO_PRICE, String sOUV_PRO_CATEGORY) {
		super();
		this.uNo = uNo;
		SOUV_PRO_NAME = sOUV_PRO_NAME;
		SOUV_PRO_PRICE = sOUV_PRO_PRICE;
		SOUV_PRO_CATEGORY = sOUV_PRO_CATEGORY;
	}

	@Override
	public String toString() {
		return "Souvenir_Cart_VO [uNo=" + uNo + ", SOUV_PRO_NAME=" + SOUV_PRO_NAME + ", SOUV_PRO_PRICE="
				+ SOUV_PRO_PRICE + ", SOUV_PRO_CATEGORY=" + SOUV_PRO_CATEGORY + "]";
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getSOUV_PRO_NAME() {
		return SOUV_PRO_NAME;
	}

	public void setSOUV_PRO_NAME(String sOUV_PRO_NAME) {
		SOUV_PRO_NAME = sOUV_PRO_NAME;
	}

	public String getSOUV_PRO_PRICE() {
		return SOUV_PRO_PRICE;
	}

	public void setSOUV_PRO_PRICE(String sOUV_PRO_PRICE) {
		SOUV_PRO_PRICE = sOUV_PRO_PRICE;
	}

	public String getSOUV_PRO_CATEGORY() {
		return SOUV_PRO_CATEGORY;
	}

	public void setSOUV_PRO_CATEGORY(String sOUV_PRO_CATEGORY) {
		SOUV_PRO_CATEGORY = sOUV_PRO_CATEGORY;
	}

}
