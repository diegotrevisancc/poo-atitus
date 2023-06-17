package oop_paradigm.services;

import oop_paradigm.entities.Produto;
import oop_paradigm.entities.produto.Bebida;

import java.util.ArrayList;
import java.util.List;

public class BebidasService implements ProdutoService {
    private List<Bebida> bebidasAvaiable;

    public BebidasService() {
        this.bebidasAvaiable = new ArrayList<>(
                List.of(
                        new Bebida(1, "Café", 1.50, false),
                        new Bebida(2, "Água", 0.50, false),
                        new Bebida(3, "Cerveja", 1.50, true)
                )
        );
    }
    @Override
    public List<Produto> findAll() {
        return new ArrayList<>(this.bebidasAvaiable);
    }

    @Override
    public Produto findById(int id) {
        for(Bebida bebida : this.bebidasAvaiable) {
            if (bebida.getId() == id) {
                return (Produto) bebida;
            }
        }
        return null;
    }
}
