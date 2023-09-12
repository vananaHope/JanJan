package project.opgg.VO;

public class Spell {
	private String spellId;
	private String spellImg;
	public Spell(String spellId, String spellImg) {
		this.spellId = spellId;
		this.spellImg = spellImg;
	}
	public String getSpellId() {
		return spellId;
	}
	public void setSpellId(String spellId) {
		this.spellId = spellId;
	}
	public String getSpellImg() {
		return spellImg;
	}
	public void setSpellImg(String spellImg) {
		this.spellImg = spellImg;
	}
	
}
