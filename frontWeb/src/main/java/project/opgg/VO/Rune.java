package project.opgg.VO;

import java.util.List;
import java.util.Map;

public class Rune {
	private String runeId;
	private String runeImg;
	public Rune(String runeId, String runeImg) {
		this.runeId = runeId;
		this.runeImg = runeImg;
	}
	public String getRuneId() {
		return runeId;
	}
	public void setRuneId(String runeId) {
		this.runeId = runeId;
	}
	public String getRuneImg() {
		return runeImg;
	}
	public void setRuneImg(String runeImg) {
		this.runeImg = runeImg;
	}
	
	
}
