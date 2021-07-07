package domain;

public class Product {

	// 琶球
	private int pnum;
	private String ptitle;
	private String pcontents;
	private int pprice;
	private int pstock;
	private String pimage;
	
	// 持失切1
	public Product() { }

	// 持失切2 
	public Product(int pnum, String ptitle, String pcontents, int pprice, int pstock, String pimage) {
		this.pnum = pnum;
		this.ptitle = ptitle;
		this.pcontents = pcontents;
		this.pprice = pprice;
		this.pstock = pstock;
		this.pimage = pimage;
	}
	
	// get, set
	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPcontents() {
		return pcontents;
	}

	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	
	
}
