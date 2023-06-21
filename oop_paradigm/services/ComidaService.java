package oop_paradigm.services;

import oop_paradigm.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ComidaService implements ProdutoService {
    private List<Produto> comidasAvaiable;

    public ComidaService() {
        this.comidasAvaiable = new ArrayList<>(
                List.of(
                        new Produto(1, "Pastel de Carne", 4.50),
                        new Produto(2, "Pastel de Frango", 5.50),
                        new Produto(3, "Pastel de Queijo", 4.0)
                )
        );
    }
    @Override
    public List<Produto> findAll() {
        return new ArrayList<>(this.comidasAvaiable);
    }
    @Override
    public Produto findById(int id) {
        for(Produto comida : this.comidasAvaiable) {
            if (comida.getId() == id) {
                return (Produto) comida;
            }
        }
        return null;
    }


}
