package bookstore.entity;

/**
 * 
 */
public class Book {
	private int id;
	private String title;
	private String image;
	private String price;
	private String quantity;
	public Book(int id, String title, String image, String price, String quantity) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", image=" + image + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
}
