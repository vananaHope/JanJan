package project.opgg.VO;

public class Champion {
	private String chamId;
	private String chamImg;
	public Champion(String chamId, String chamImg) {
		this.chamId = chamId;
		this.chamImg = chamImg;
	}
	public String getChamId() {
		return chamId;
	}
	public void setChamId(String chamId) {
		this.chamId = chamId;
	}
	public String getChamImg() {
		return chamImg;
	}
	public void setChamImg(String chamImg) {
		this.chamImg = chamImg;
	}
	
	
	
	
}
