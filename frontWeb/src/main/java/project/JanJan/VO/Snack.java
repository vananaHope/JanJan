package project.JanJan.VO;

public class Snack {
	/*SNACK_NAME VARCHAR2(50) PRIMARY KEY,
CATEGORY_NAME VARCHAR2(50),
SNACK_PRICE NUMBER,
SNACK_IMG VARCHAR2(100),
SNACK_DES VARCHAR2(100),
SALE_YN VARCHAR2(10),
	 * 
	 * */
	private String snack_name;
	private String category_name;
	private int snack_price;
	private String snack_img;
	private String snack_des;
	private String sale_YN;
	private String expdate;
	public Snack() {
		// TODO Auto-generated constructor stub
	}
	public Snack(String snack_name, String category_name, int snack_price, String snack_img, String snack_des,
			String sale_YN, String expdate) {
		this.snack_name = snack_name;
		this.category_name = category_name;
		this.snack_price = snack_price;
		this.snack_img = snack_img;
		this.snack_des = snack_des;
		this.sale_YN = sale_YN;
		this.expdate = expdate;
	}
	public String getSnack_name() {
		return snack_name;
	}
	public void setSnack_name(String snack_name) {
		this.snack_name = snack_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getSnack_price() {
		return snack_price;
	}
	public void setSnack_price(int snack_price) {
		this.snack_price = snack_price;
	}
	public String getSnack_img() {
		return snack_img;
	}
	public void setSnack_img(String snack_img) {
		this.snack_img = snack_img;
	}
	public String getSnack_des() {
		return snack_des;
	}
	public void setSnack_des(String snack_des) {
		this.snack_des = snack_des;
	}
	public String getSale_YN() {
		return sale_YN;
	}
	public void setSale_YN(String sale_YN) {
		this.sale_YN = sale_YN;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	
}
