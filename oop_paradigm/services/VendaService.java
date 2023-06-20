package oop_paradigm.services;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.ItemVenda;
import oop_paradigm.entities.Produto;
import oop_paradigm.entities.Venda;
import oop_paradigm.views.PrincipalView;

import java.util.Random;

public class VendaService {
    private Venda venda;
    public VendaService(Venda venda) {
        this.venda = venda;
    }

    public void adicionarAoCarrinho(Produto produto) {
        System.out.println("Insira a quantidade: ");
        int quantidade = Integer.parseInt(Aplicacao.scanner.nextLine());

        ItemVenda item = new ItemVenda(new Random().nextInt(), produto, quantidade);

        this.venda.setItem(item);
    }

    public double getPrecoTotal() {
        double total = 0;
        for (ItemVenda item : this.venda.getItens()) {
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total;
    }

    public Venda getVenda() {
        return this.venda;
    }

}
