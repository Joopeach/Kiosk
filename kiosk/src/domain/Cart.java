package domain;

public class Cart {

	// 필드
	private String title;
	private int cups;
	private int price;
	
	// 생성자
	public Cart() { }

	public Cart(String title, int cups, int price) {
		this.title = title;
		this.cups = cups;
		this.price = price;
	}

	// get/set
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
