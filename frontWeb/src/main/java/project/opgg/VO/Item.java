package project.opgg.VO;


public class Item {
	private String itemId;
	private String itemDescription1;
	private String itemDescription2;
	private int itemPrice;
	private String itemImg;
	public Item(String itemId, String itemDescription1, String itemDescription2, int itemPrice, String itemImg) {
		this.itemId = itemId;
		this.itemDescription1 = itemDescription1;
		this.itemDescription2 = itemDescription2;
		this.itemPrice = itemPrice;
		this.itemImg = itemImg;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription1() {
		return itemDescription1;
	}
	public void setItemDescription1(String itemDescription1) {
		this.itemDescription1 = itemDescription1;
	}
	public String getItemDescription2() {
		return itemDescription2;
	}
	public void setItemDescription2(String itemDescription2) {
		this.itemDescription2 = itemDescription2;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	
}
