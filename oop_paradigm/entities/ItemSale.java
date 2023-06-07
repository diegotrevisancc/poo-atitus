package oop_paradigm.entities;

import java.util.Objects;

public class ItemSale {

	private double id; 
	private Product product;
	private int quantity;
	
	public ItemSale(double id, Product product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemSale other = (ItemSale) obj;
		return this.id == other.getId();
	}
	
	@Override
	public String toString() {
		return "ItemSale [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
}
