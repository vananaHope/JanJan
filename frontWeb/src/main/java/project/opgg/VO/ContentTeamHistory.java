package project.opgg.VO;

public class ContentTeamHistory {
	private int gameid;
	private String gamecode;
	private String teamcolor;
	private String iswin;
	private String userid;
	private int kill;
	private int death;
	private int assist;
	private int damage;
	private String utier;
	private String chamimg;
	private String runeimg;
	private String spellimg;
	private String itemimg;


	public ContentTeamHistory(int gameid, String gamecode, String teamcolor, String iswin, String userid, int kill,
			int death, int assist, int damage, String utier, String chamimg, String runeimg, String spellimg,
			String itemimg) {
		this.gameid = gameid;
		this.gamecode = gamecode;
		this.teamcolor = teamcolor;
		this.iswin = iswin;
		this.userid = userid;
		this.kill = kill;
		this.death = death;
		this.assist = assist;
		this.damage = damage;
		this.utier = utier;
		this.chamimg = chamimg;
		this.runeimg = runeimg;
		this.spellimg = spellimg;
		this.itemimg = itemimg;
	}
	
	public String getTeamcolor() {
		return teamcolor;
	}

	public void setTeamcolor(String teamcolor) {
		this.teamcolor = teamcolor;
	}

	public String getIswin() {
		return iswin;
	}

	public void setIswin(String iswin) {
		this.iswin = iswin;
	}

	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public String getGamecode() {
		return gamecode;
	}
	public void setGamecode(String gamecode) {
		this.gamecode = gamecode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getKill() {
		return kill;
	}
	public void setKill(int kill) {
		this.kill = kill;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getUtier() {
		return utier;
	}
	public void setUtier(String utier) {
		this.utier = utier;
	}
	public String getChamimg() {
		return chamimg;
	}
	public void setChamimg(String chamimg) {
		this.chamimg = chamimg;
	}
	public String getRuneimg() {
		return runeimg;
	}
	public void setRuneimg(String runeimg) {
		this.runeimg = runeimg;
	}
	public String getSpellimg() {
		return spellimg;
	}
	public void setSpellimg(String spellimg) {
		this.spellimg = spellimg;
	}
	public String getItemimg() {
		return itemimg;
	}
	public void setItemimg(String itemimg) {
		this.itemimg = itemimg;
	}
	
	
	
}
