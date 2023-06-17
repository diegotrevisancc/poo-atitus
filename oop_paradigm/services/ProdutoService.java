package oop_paradigm.services;

import oop_paradigm.entities.Produto;

import java.util.List;

public interface ProdutoService {
    public List<Produto> findAll();
    public Produto findById(int id);

}
