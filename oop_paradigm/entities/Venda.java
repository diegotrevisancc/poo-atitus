package oop_paradigm.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Venda {
    private int id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private LocalDateTime time;

    public Venda(Cliente cliente) {
        this.itens = new ArrayList<>();
        this.id = 99;
        this.cliente = cliente;
        this.time = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public void setItem(ItemVenda itemVenda) {
        this.itens.add(itemVenda);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
