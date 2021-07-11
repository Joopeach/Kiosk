package domain;

public class Cart {

	// �ʵ�
	private int num;
	private String title;
	private int cups;
	private int price;
	
	// ������
	public Cart() { }

	public Cart(int num, String title, int cups, int price) {
		this.num = num;
		this.title = title;
		this.cups = cups;
		this.price = price;
	}

	// get/set
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
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
