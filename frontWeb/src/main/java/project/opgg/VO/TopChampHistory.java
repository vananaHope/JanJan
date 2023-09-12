package project.opgg.VO;

public class TopChampHistory {
	private String chamid;
	private int chamWinRatio;
	private int totGame;
	private int totWin;
	private int totLose;
	private double avgKda;
	public TopChampHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopChampHistory(String chamid, int chamWinRatio, int totGame, int totWin, int totLose, double avgKda) {
		super();
		this.chamid = chamid;
		this.chamWinRatio = chamWinRatio;
		this.totGame = totGame;
		this.totWin = totWin;
		this.totLose = totLose;
		this.avgKda = avgKda;
	}
	public String getChamid() {
		return chamid;
	}
	public void setChamid(String chamid) {
		this.chamid = chamid;
	}
	public int getChamWinRatio() {
		return chamWinRatio;
	}
	public void setChamWinRatio(int chamWinRatio) {
		this.chamWinRatio = chamWinRatio;
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
	public int getTotLose() {
		return totLose;
	}
	public void setTotLose(int totLose) {
		this.totLose = totLose;
	}
	public double getAvgKda() {
		return avgKda;
	}
	public void setAvgKda(double avgKda) {
		this.avgKda = avgKda;
	}
	
}
