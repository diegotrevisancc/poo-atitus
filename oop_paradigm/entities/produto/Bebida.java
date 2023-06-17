package oop_paradigm.entities.produto;

import oop_paradigm.entities.Produto;

public class Bebida extends Produto {
    private boolean alcoolica;
    public Bebida(int id, String nome, double preco, boolean alcoolica) {
        super(id, nome, preco);
        this.alcoolica = alcoolica;

    }

    public boolean getAlcoolica() {
        return this.alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }
    @Override
    public String toString() {
        return super.getNome() + " R$: " + super.getPreco() + ((this.alcoolica == true) ? " Contem Alcool" : " Não contem alcool");
    }
}
