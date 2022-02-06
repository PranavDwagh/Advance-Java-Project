package pojo_DAO_DO;

public class BookPojo {
	
	private int book_id;
	private int book_cost;
	private String book_name;

	public BookPojo()
	{
		//
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getBook_cost() {
		return book_cost;
	}

	public void setBook_cost(int book_cost) {
		this.book_cost = book_cost;
	}

	public String getBook_name() {
		return book_name;
	}

	@Override
	public String toString() {
		return "BookPojo [book_id=" + book_id + ", book_cost=" + book_cost + ", book_name=" + book_name + "]";
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
}
