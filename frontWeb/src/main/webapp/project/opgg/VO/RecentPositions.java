package project.opgg.VO;

public class RecentPositions {
	private int top;
	private int jungle;
	private int mid;
	private int bot;
	private int sup;
	public RecentPositions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecentPositions(int top, int jungle, int mid, int bot, int sup) {
		this.top = top;
		this.jungle = jungle;
		this.mid = mid;
		this.bot = bot;
		this.sup = sup;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getJungle() {
		return jungle;
	}
	public void setJungle(int jungle) {
		this.jungle = jungle;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getBot() {
		return bot;
	}
	public void setBot(int bot) {
		this.bot = bot;
	}
	public int getSup() {
		return sup;
	}
	public void setSup(int sup) {
		this.sup = sup;
	}
	
}
