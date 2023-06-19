package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.Venda;
import oop_paradigm.services.VendaService;

public class VerProdutosView {
    public void criarVerProdutosView(Cliente cliente, Venda venda) {
        while (true) {
            Util.limparTela();
            System.out.println("Quais produtos você deseja ver?");
            System.out.println("1 - Bebidas");
            System.out.println("2 - Comidas");
            System.out.println("3 - Voltar");
            System.out.print("Opção: ");
            int option = Aplicacao.scanner.nextInt();
            switch (option) {
                case 1:
                    new VerBebidasView().criarBebidasView(cliente, venda);
                    break;
                case 2:
                    break;
                case 3:
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
            System.out.println(new VendaService(venda).getPrecoTotal(venda));
        }
    }
}
