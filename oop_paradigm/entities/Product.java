package oop_paradigm.entities;

public class Product {
	
	private int id;
	private String name;
	private double price;
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product Number: " + this.id + "|Name: " + this.name + "|Price: $" + this.price;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;
		if (this.id == other.getId()) {
			return true;
		}
		return false;
	}
	
}
