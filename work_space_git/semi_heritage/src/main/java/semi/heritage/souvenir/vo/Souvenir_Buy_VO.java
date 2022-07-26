package semi.heritage.souvenir.vo;

import java.util.Date;

public class Souvenir_Buy_VO {
	int souv_buy_no;
	int uno;
	int souv_pro_no;
	int souv_pay_no;
	int souv_buy_total_price;
	Date souv_buy_date;

	public Souvenir_Buy_VO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Souvenir_Buy_VO(int souv_buy_no, int uno, int souv_pro_no, int souv_pay_no, int souv_buy_total_price,
			Date souv_buy_date) {
		super();
		this.souv_buy_no = souv_buy_no;
		this.uno = uno;
		this.souv_pro_no = souv_pro_no;
		this.souv_pay_no = souv_pay_no;
		this.souv_buy_total_price = souv_buy_total_price;
		this.souv_buy_date = souv_buy_date;
	}

	@Override
	public String toString() {
		return "Souvenir_Buy_VO [souv_buy_no=" + souv_buy_no + ", uno=" + uno + ", souv_pro_no=" + souv_pro_no
				+ ", souv_pay_no=" + souv_pay_no + ", souv_buy_total_price=" + souv_buy_total_price + ", souv_buy_date="
				+ souv_buy_date + "]";
	}

	public int getSouv_buy_no() {
		return souv_buy_no;
	}

	public void setSouv_buy_no(int souv_buy_no) {
		this.souv_buy_no = souv_buy_no;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public int getSouv_pro_no() {
		return souv_pro_no;
	}

	public void setSouv_pro_no(int souv_pro_no) {
		this.souv_pro_no = souv_pro_no;
	}

	public int getSouv_pay_no() {
		return souv_pay_no;
	}

	public void setSouv_pay_no(int souv_pay_no) {
		this.souv_pay_no = souv_pay_no;
	}

	public int getSouv_buy_total_price() {
		return souv_buy_total_price;
	}

	public void setSouv_buy_total_price(int souv_buy_total_price) {
		this.souv_buy_total_price = souv_buy_total_price;
	}

	public Date getSouv_buy_date() {
		return souv_buy_date;
	}

	public void setSouv_buy_date(Date souv_buy_date) {
		this.souv_buy_date = souv_buy_date;
	}

}
