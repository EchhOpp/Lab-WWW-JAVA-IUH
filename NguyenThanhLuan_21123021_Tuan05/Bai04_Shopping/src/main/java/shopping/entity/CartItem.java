package shopping.entity;

import java.util.Objects;

public class CartItem {
	private Product product;
	private int quantity;
	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(product, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(product, other.product) && quantity == other.quantity;
	}
	

}
