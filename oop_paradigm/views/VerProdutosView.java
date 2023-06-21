package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.ItemVenda;
import oop_paradigm.entities.Produto;
import oop_paradigm.entities.Venda;
import oop_paradigm.services.VendaService;

import java.util.Random;

public class VerProdutosView {
    private boolean comprar = true;
    public void criarVerProdutosView(VendaService vendaService) {
        while (this.comprar) {
            Util.limparTela();
            System.out.println("Quais produtos você deseja ver?");
            System.out.println("1 - Bebidas");
            System.out.println("2 - Comidas");
            System.out.println("3 - Voltar");
            System.out.print("Opção: ");
            int option = Integer.parseInt(Aplicacao.scanner.nextLine());
            switch (option) {
                case 1:
                    new VerBebidasView().criarBebidasView(vendaService);
                    break;
                case 2:
                    break;
                case 3:
                    this.comprar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            System.out.println(vendaService.getPrecoTotal());
        }
    }
}
