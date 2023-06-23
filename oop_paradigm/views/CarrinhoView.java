package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.ItemVenda;
import java.util.List;

public class CarrinhoView {
    public void criarCarrinhoView() {
        Util.limparTela();
        System.out.println("----Seu Carrinho----");
        List<ItemVenda> items = PrincipalView.vendaService.getVenda().getItens();
        int contador = 1;
        for (ItemVenda item : items) {
            System.out.println(contador + " - " + item.getProduto().getNome() + " Qtd: " + item.getQuantidade());
            contador++;
        }

        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Remover item");
        System.out.println("2 - Sair");

        int opcao = Integer.parseInt(Aplicacao.scanner.nextLine());
        switch (opcao) {
            case 1:
                int itemEscolhido;
                while (true) {
                    System.out.println("Insira o número do item que deseja remover: ");
                    itemEscolhido = Integer.parseInt(Aplicacao.scanner.nextLine());
                    ItemVenda item = items.get(itemEscolhido - 1);
                    if (item != null) {
                        break;
                    }
                }
                PrincipalView.vendaService.removerDoCarrinho(itemEscolhido);
                break;
            case 2:
                break;
            default:
                System.out.println("Opção Inválida");
        }

        System.out.println("Pressione enter para continuar");
        Aplicacao.scanner.nextLine();
    }
}
