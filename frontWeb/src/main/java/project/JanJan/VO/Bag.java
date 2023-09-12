package project.JanJan.VO;

public class Bag {
	private String cartNum;
	private int cnt;
	private int totalPrice;
	private String productName;
	private String memId;
	
	public Bag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bag(String cartNum, int cnt, int totalPrice, String productName, String memId) {
		super();
		this.cartNum = cartNum;
		this.cnt = cnt;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.memId = memId;
	}

	public Bag(int cnt, int totalPrice, String productName, String memId) {
		super();
		this.cnt = cnt;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.memId = memId;
	}

	public Bag(int cnt, int totalPrice, String productName) {
		super();
		this.cnt = cnt;
		this.totalPrice = totalPrice;
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCartNum() {
		return cartNum;
	}
	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
}