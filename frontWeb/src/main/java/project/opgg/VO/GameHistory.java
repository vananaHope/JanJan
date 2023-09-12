package project.opgg.VO;

import java.sql.Timestamp;

public class GameHistory {
	private int gameId;
	private String gameCode;
	private String teamColor;
	private String userId;
	private String champId;
	private String runeId;
	private String spellId;
	private String itemid;
	private String pos;
	private int kill;
	private int death;
	private int assist;
	private String kda;
	private int attack;
	private int damage;
	private String isWin;
	private Timestamp end_time;
	private Timestamp start_time;
	private String chamimg;
	private String runeimg;
	private String spellimg;
	private String itemimg;
	private String tierImg;
	

//   private String item01;
//   private String item02;
//   private int damage;
//   private int attack;

	public String getTierImg() {
		return tierImg;
	}
	public void setTierImg(String tierImg) {
		this.tierImg = tierImg;
	}
	public GameHistory() {}
	public GameHistory(String gameCode) {
		this.gameCode = gameCode;
	}
	public GameHistory(int gameId, String gameCode, String teamColor, String userId, String champId, String runeId,
			String spellId, String itemid, String pos, int kill, int death, int assist, String kda, int attack,
			int damage, String isWin, Timestamp end_time, Timestamp start_time, String chamimg, String runeimg,
			String spellimg, String itemimg, String tierImg) {
		super();
		this.gameId = gameId;
		this.gameCode = gameCode;
		this.teamColor = teamColor;
		this.userId = userId;
		this.champId = champId;
		this.runeId = runeId;
		this.spellId = spellId;
		this.itemid = itemid;
		this.pos = pos;
		this.kill = kill;
		this.death = death;
		this.assist = assist;
		this.kda = kda;
		this.attack = attack;
		this.damage = damage;
		this.isWin = isWin;
		this.end_time = end_time;
		this.start_time = start_time;
		this.chamimg = chamimg;
		this.runeimg = runeimg;
		this.spellimg = spellimg;
		this.itemimg = itemimg;
		this.tierImg = tierImg;
	}
	public GameHistory(int gameId, String gameCode, String teamColor, String userId, String champId, String runeId,
			String spellId, String itemid, String pos, int kill, int death, int assist, String kda, int attack,
			int damage, String isWin, Timestamp end_time, Timestamp start_time) {
		super();
		this.gameId = gameId;
		this.gameCode = gameCode;
		this.teamColor = teamColor;
		this.userId = userId;
		this.champId = champId;
		this.runeId = runeId;
		this.spellId = spellId;
		this.itemid = itemid;
		this.pos = pos;
		this.kill = kill;
		this.death = death;
		this.assist = assist;
		this.kda = kda;
		this.attack = attack;
		this.damage = damage;
		this.isWin = isWin;
		this.end_time = end_time;
		this.start_time = start_time;
	}
	
	
	
	public GameHistory(int gameId, String gameCode, String teamColor, String userId, String champId, String runeId,
			String spellId, String itemid, String pos, int kill, int death, int assist, String kda, int attack,
			int damage, String isWin, Timestamp end_time, Timestamp start_time, String chamimg, String runeimg,
			String spellimg, String itemimg) {
		this.gameId = gameId;
		this.gameCode = gameCode;
		this.teamColor = teamColor;
		this.userId = userId;
		this.champId = champId;
		this.runeId = runeId;
		this.spellId = spellId;
		this.itemid = itemid;
		this.pos = pos;
		this.kill = kill;
		this.death = death;
		this.assist = assist;
		this.kda = kda;
		this.attack = attack;
		this.damage = damage;
		this.isWin = isWin;
		this.end_time = end_time;
		this.start_time = start_time;
		this.chamimg = chamimg;
		this.runeimg = runeimg;
		this.spellimg = spellimg;
		this.itemimg = itemimg;
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
	public String getSpellId() {
		return spellId;
	}

	public void setSpellId(String spellId) {
		this.spellId = spellId;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getRuneId() {
		return runeId;
	}

	public void setRuneId(String runeId) {
		this.runeId = runeId;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getIsWin() {
		return isWin;
	}

	public void setIsWin(String isWin) {
		this.isWin = isWin;
	}

	public String getKda() {
		return kda;
	}

	public void setKda(String kda) {
		this.kda = kda;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public String getTeamColor() {
		return teamColor;
	}

	public void setTeamColor(String teamColor) {
		this.teamColor = teamColor;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChampId() {
		return champId;
	}

	public void setChampId(String champId) {
		this.champId = champId;
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

	public Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

	public Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}

	public String isWin() {
		return isWin;
	}

	public void setWin(String isWin) {
		this.isWin = isWin;
	}
}