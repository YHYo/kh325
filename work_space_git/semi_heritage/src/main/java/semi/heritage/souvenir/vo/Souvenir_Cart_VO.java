package semi.heritage.souvenir.vo;

public class Souvenir_Cart_VO {
	int souv_cart_no;
	int uNo;
	int souv_pro_no;
	String status;

	public Souvenir_Cart_VO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Souvenir_Cart_VO(int souv_cart_no, int uNo, int souv_pro_no, String status) {
		super();
		this.souv_cart_no = souv_cart_no;
		this.uNo = uNo;
		this.souv_pro_no = souv_pro_no;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Souvenir_Cart_VO [souv_cart_no=" + souv_cart_no + ", uNo=" + uNo + ", souv_pro_no=" + souv_pro_no
				+ ", status=" + status + "]";
	}

	public int getSouv_cart_no() {
		return souv_cart_no;
	}

	public void setSouv_cart_no(int souv_cart_no) {
		this.souv_cart_no = souv_cart_no;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getSouv_pro_no() {
		return souv_pro_no;
	}

	public void setSouv_pro_no(int souv_pro_no) {
		this.souv_pro_no = souv_pro_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
