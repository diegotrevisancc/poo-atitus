package oop_paradigm.services;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.ItemVenda;
import oop_paradigm.entities.Produto;
import oop_paradigm.entities.Venda;

import java.util.ArrayList;
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

        ArrayList<ItemVenda> carrinho = (ArrayList<ItemVenda>)this.venda.getItens();
        boolean jaExiste = false;
        int posicao = 0;
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i).getProduto().getNome() == item.getProduto().getNome()) {
                jaExiste = true;
                posicao = i;

            }
        }

        if (jaExiste) {
            int quantidadeAtual = carrinho.get(posicao).getQuantidade();
            int novaQuantidade = quantidadeAtual + item.getQuantidade();

            carrinho.remove(posicao);
            item.setQuantidade(novaQuantidade);

            carrinho.add(item);
            this.venda.setItens(carrinho);

        } else {
            this.venda.setItem(item);
        }
    }

    public double getPrecoTotal() {
        double total = 0;
        for (ItemVenda item : this.venda.getItens()) {
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total;
    }

    public void removerDoCarrinho(int posicao) {
        posicao -= 1;
        this.venda.getItens().remove(posicao);
    }


    public Venda getVenda() {
        return this.venda;
    }

}
