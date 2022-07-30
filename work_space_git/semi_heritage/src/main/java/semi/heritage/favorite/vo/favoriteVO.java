package semi.heritage.favorite.vo;

public class favoriteVO {
	
	private int rowNum;
	private int countNum;
	private int favNum;
	private int uNo;
	private int no;
	
	public favoriteVO() {
		super();
	}

	public favoriteVO(int favNum, int uNo, int no) {
		super();
		this.favNum = favNum;
		this.uNo = uNo;
		this.no = no;
	}
	
	public favoriteVO(int rowNum, int no) {
		super();
		this.rowNum = rowNum;
		this.no = no;
	}
	public favoriteVO(int countNum) {
		super();
		this.countNum = countNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	
	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
	
	public int getFavNum() {
		return favNum;
	}

	public void setFavNum(int favNum) {
		this.favNum = favNum;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String toString1() {
		return "favoriteVO [favNum=" + favNum + ", uNo=" + uNo + ", no=" + no + "]";
	}
	
	@Override
	public String toString() {
		return "favoriteVO [rowNum=" + rowNum + ", no=" + no + "]";
		}
	
	
}
