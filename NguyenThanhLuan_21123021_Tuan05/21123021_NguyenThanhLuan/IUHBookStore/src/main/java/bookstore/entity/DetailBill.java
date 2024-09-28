package bookstore.entity;

public class DetailBill {
	private int id;
	private Book book;
	private int quantity;
	public DetailBill(int id, Book book, int quantity) {
		super();
		this.id = id;
		this.book = book;
		this.quantity = quantity;
	}
	
	public DetailBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "DetailBill [id=" + id + ", book=" + book + ", quantity=" + quantity + "]";
	}
	
}
