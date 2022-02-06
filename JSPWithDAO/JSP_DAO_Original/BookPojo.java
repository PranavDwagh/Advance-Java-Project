package study.dao;

public class BookPojo {
	
	private int bid,bcost;
	private String bname;
	
	public BookPojo()
	{
		
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBcost() {
		return bcost;
	}

	public void setBcost(int bcost) {
		this.bcost = bcost;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public BookPojo(int bid, int bcost, String bname) {
		super();
		this.bid = bid;
		this.bcost = bcost;
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "BookPojo [bid=" + bid + ", bcost=" + bcost + ", bname=" + bname + "]";
	}

	
	
}
