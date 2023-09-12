package project.opgg.VO;

public class RecentGameHistory {
	private String chamId;
	private String pos;
	private int kill;
	private int death;
	private int assist;
	private String kda;
	private String isWin;
	public RecentGameHistory(String chamId, String pos, int kill, int death, int assist, String kda, String isWin) {
		this.chamId = chamId;
		this.pos = pos;
		this.kill = kill;
		this.death = death;
		this.assist = assist;
		this.kda = kda;
		this.isWin = isWin;
	}
	public String getChamId() {
		return chamId;
	}
	public void setChamId(String chamId) {
		this.chamId = chamId;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
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
	public String getKda() {
		return kda;
	}
	public void setKda(String kda) {
		this.kda = kda;
	}
	public String getIsWin() {
		return isWin;
	}
	public void setIsWin(String isWin) {
		this.isWin = isWin;
	}
	
}
