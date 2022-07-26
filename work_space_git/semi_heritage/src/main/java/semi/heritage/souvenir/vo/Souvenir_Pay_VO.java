package semi.heritage.souvenir.vo;

import java.sql.Date;

public class Souvenir_Pay_VO {
	int souv_pay_no;
	int uno;
	Date souv_pay_date;
	int souv_pay_card;

	public Souvenir_Pay_VO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Souvenir_Pay_VO(int souv_pay_no, int uno, Date souv_pay_date, int souv_pay_card) {
		super();
		this.souv_pay_no = souv_pay_no;
		this.uno = uno;
		this.souv_pay_date = souv_pay_date;
		this.souv_pay_card = souv_pay_card;
	}

	@Override
	public String toString() {
		return "Souvenir_Pay_VO [souv_pay_no=" + souv_pay_no + ", uno=" + uno + ", souv_pay_date=" + souv_pay_date
				+ ", souv_pay_card=" + souv_pay_card + "]";
	}

	public int getSouv_pay_no() {
		return souv_pay_no;
	}

	public void setSouv_pay_no(int souv_pay_no) {
		this.souv_pay_no = souv_pay_no;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public Date getSouv_pay_date() {
		return souv_pay_date;
	}

	public void setSouv_pay_date(Date souv_pay_date) {
		this.souv_pay_date = souv_pay_date;
	}

	public int getSouv_pay_card() {
		return souv_pay_card;
	}

	public void setSouv_pay_card(int souv_pay_card) {
		this.souv_pay_card = souv_pay_card;
	}

}
