package semi.heritage.souvenir.vo;

public class Souvenir_Cart_VO {

	private String SOUV_CART_NO;
	private int uNo;
	private int SOUV_PRO_NO;
	private String SOUV_PRO_NAME;
	private int SOUV_PRO_PRICE;
	private String SOUV_PRO_CATEGORY;
	private String BUY_STATUS; // Y : 결제완료 / N : 결제안함
	private String DELETE_STATUS; // Y : 장바구니 담김 / N : 삭제

	public Souvenir_Cart_VO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 전체
	public Souvenir_Cart_VO(String sOUV_CART_NO, int uNo, int sOUV_PRO_NO, String sOUV_PRO_NAME, int sOUV_PRO_PRICE,
			String sOUV_PRO_CATEGORY, String bUY_STATUS, String dELETE_STATUS) {
		super();
		this.SOUV_CART_NO = sOUV_CART_NO;
		this.uNo = uNo;
		this.SOUV_PRO_NO = sOUV_PRO_NO;
		this.SOUV_PRO_NAME = sOUV_PRO_NAME;
		this.SOUV_PRO_PRICE = sOUV_PRO_PRICE;
		this.SOUV_PRO_CATEGORY = sOUV_PRO_CATEGORY;
		this.BUY_STATUS = bUY_STATUS;
		this.DELETE_STATUS = dELETE_STATUS;
	}

	// 회원별 장바구니
	public Souvenir_Cart_VO(int uNo, String sOUV_PRO_NAME, int sOUV_PRO_PRICE, String sOUV_PRO_CATEGORY,
			String bUY_STATUS, String dELETE_STATUS) {
		super();
		this.uNo = uNo;
		this.SOUV_PRO_NAME = sOUV_PRO_NAME;
		this.SOUV_PRO_PRICE = sOUV_PRO_PRICE;
		this.SOUV_PRO_CATEGORY = sOUV_PRO_CATEGORY;
		this.BUY_STATUS = bUY_STATUS;
		this.DELETE_STATUS = dELETE_STATUS;
	}

	@Override
	public String toString() {
		return "Souvenir_Cart_VO [SOUV_CART_NO=" + SOUV_CART_NO + ", uNo=" + uNo + ", SOUV_PRO_NO=" + SOUV_PRO_NO
				+ ", SOUV_PRO_NAME=" + SOUV_PRO_NAME + ", SOUV_PRO_PRICE=" + SOUV_PRO_PRICE + ", SOUV_PRO_CATEGORY="
				+ SOUV_PRO_CATEGORY + ", BUY_STATUS=" + BUY_STATUS + ", DELETE_STATUS=" + DELETE_STATUS + "]";
	}

	public String getSOUV_CART_NO() {
		return SOUV_CART_NO;
	}

	public void setSOUV_CART_NO(String sOUV_CART_NO) {
		SOUV_CART_NO = sOUV_CART_NO;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getSOUV_PRO_NO() {
		return SOUV_PRO_NO;
	}

	public void setSOUV_PRO_NO(int sOUV_PRO_NO) {
		SOUV_PRO_NO = sOUV_PRO_NO;
	}

	public String getSOUV_PRO_NAME() {
		return SOUV_PRO_NAME;
	}

	public void setSOUV_PRO_NAME(String sOUV_PRO_NAME) {
		SOUV_PRO_NAME = sOUV_PRO_NAME;
	}

	public int getSOUV_PRO_PRICE() {
		return SOUV_PRO_PRICE;
	}

	public void setSOUV_PRO_PRICE(int sOUV_PRO_PRICE) {
		SOUV_PRO_PRICE = sOUV_PRO_PRICE;
	}

	public String getSOUV_PRO_CATEGORY() {
		return SOUV_PRO_CATEGORY;
	}

	public void setSOUV_PRO_CATEGORY(String sOUV_PRO_CATEGORY) {
		SOUV_PRO_CATEGORY = sOUV_PRO_CATEGORY;
	}

	public String getBUY_STATUS() {
		return BUY_STATUS;
	}

	public void setBUY_STATUS(String bUY_STATUS) {
		BUY_STATUS = bUY_STATUS;
	}

	public String getDELETE_STATUS() {
		return DELETE_STATUS;
	}

	public void setDELETE_STATUS(String dELETE_STATUS) {
		DELETE_STATUS = dELETE_STATUS;
	}

}
