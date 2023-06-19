package oop_paradigm.services;

import oop_paradigm.entities.ItemVenda;
import oop_paradigm.entities.Venda;

public class VendaService {
    private Venda venda;
    public VendaService(Venda venda) {
        this.venda = venda;
    }
    public void adicionarAoCarrinho(ItemVenda itemVenda) {
        this.venda.setItem(itemVenda);
    }

    public double getPrecoTotal(Venda venda) {
        double total = 0;
        for (ItemVenda item : venda.getItens()) {
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total;
    }
}
