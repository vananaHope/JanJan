package project.opgg.VO;

public class HistoryAvg {
	private int totGame;
	private int totWin;
	private double avgKill;
	private double avgDeath;
	private double avgAssist;
	private double avgKda;
	private int killInvolvement;
	
	public HistoryAvg() {
		
	}

	public HistoryAvg(int totGame, int totWin, double avgKill, double avgDeath, double avgAssist, double avgKda,
			int killInvolvement) {
		super();
		this.totGame = totGame;
		this.totWin = totWin;
		this.avgKill = avgKill;
		this.avgDeath = avgDeath;
		this.avgAssist = avgAssist;
		this.avgKda = avgKda;
		this.killInvolvement = killInvolvement;
	}

	public int getTotGame() {
		return totGame;
	}

	public void setTotGame(int totGame) {
		this.totGame = totGame;
	}

	public int getTotWin() {
		return totWin;
	}

	public void setTotWin(int totWin) {
		this.totWin = totWin;
	}

	public double getAvgKill() {
		return avgKill;
	}

	public void setAvgKill(double avgKill) {
		this.avgKill = avgKill;
	}

	public double getAvgDeath() {
		return avgDeath;
	}

	public void setAvgDeath(double avgDeath) {
		this.avgDeath = avgDeath;
	}

	public double getAvgAssist() {
		return avgAssist;
	}

	public void setAvgAssist(double avgAssist) {
		this.avgAssist = avgAssist;
	}

	public double getAvgKda() {
		return avgKda;
	}

	public void setAvgKda(double avgKda) {
		this.avgKda = avgKda;
	}

	public int getKillInvolvement() {
		return killInvolvement;
	}

	public void setKillInvolvement(int killInvolvement) {
		this.killInvolvement = killInvolvement;
	}
	
	
}
