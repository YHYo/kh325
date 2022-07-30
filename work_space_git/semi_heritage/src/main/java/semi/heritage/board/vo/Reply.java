package semi.heritage.board.vo;

import java.util.Date;

public class Reply {
	private int no;
	private int board_no;
	private int writer_no;
	private String writer_id;
	private String content;
	private String status;
	private Date create_date;
	private Date modify_date;

	public Reply() {
		super();
	}

	public Reply(int no, int board_no, int writer_no, String writer_id, String content, String status, Date create_date,
			Date modify_date) {
		super();
		this.no = no;
		this.board_no = board_no;
		this.writer_no = writer_no;
		this.writer_id = writer_id;
		this.content = content;
		this.status = status;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "Reply [no=" + no + ", board_no=" + board_no + ", writer_no=" + writer_no + ", writer_id=" + writer_id
				+ ", content=" + content + ", status=" + status + ", create_date=" + create_date + ", modify_date="
				+ modify_date + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getWriter_no() {
		return writer_no;
	}

	public void setWriter_no(int writer_no) {
		this.writer_no = writer_no;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

}
