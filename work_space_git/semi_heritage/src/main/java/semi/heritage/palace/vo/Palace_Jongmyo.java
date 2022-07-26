package semi.heritage.palace.vo;

public class Palace_Jongmyo {

	private String link;

	public Palace_Jongmyo() {
		super();
	}

	public Palace_Jongmyo(String link) {
		super();
		this.link = link;
	}

	@Override
	public String toString() {
		return "Palace_Jongmyo_link [link=" + link + "]";
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
