package oop_paradigm.entities;

import java.util.Objects;

public class ItemVenda {

	private double id; 
	private Produto produto;
	private int quantidade;
	
	public ItemVenda(double id, Produto produto, int quantidade) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
		ItemVenda other = (ItemVenda) obj;
		return this.id == other.getId();
	}
	
	@Override
	public String toString() {
		return "ItemVenda [id=" + this.id + ", produto=" + this.produto + ", quantidade=" + this.quantidade + "]";
	}
	
}
