package oop_paradigm.entities;

public class Produto {
	
	private int id;
	private String nome;
	private double preco;
	
	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Produto: " + this.id + "|nome: " + this.nome + "|Preco: $" + this.preco;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Produto other = (Produto) obj;
		if (this.id == other.getId()) {
			return true;
		}
		return false;
	}
	
}
