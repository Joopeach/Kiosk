package domain;

public class Kitchen_Order {
	
	private int onum;
	private int pnum;
	private int num;
	private int pquantity;
	private int oprice;
	private String otime;
	private String osituation;
	
	public Kitchen_Order(int onum, int pnum, int num, int pquantity, int oprice, String otime, String osituation) {
		
		this.onum = onum;
		this.pnum = pnum;
		this.num = num;
		this.pquantity = pquantity;
		this.oprice = oprice;
		this.otime = otime;
		this.osituation = osituation;
	}

	public int getOnum() {
		return onum;
	}

	public void setOnum(int onum) {
		this.onum = onum;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public int getOprice() {
		return oprice;
	}

	public void setOprice(int oprice) {
		this.oprice = oprice;
	}

	public String getOtime() {
		return otime;
	}

	public void setOtime(String otime) {
		this.otime = otime;
	}

	public String getOsituation() {
		return osituation;
	}

	public void setOsituation(String osituation) {
		this.osituation = osituation;
	}
	

}
