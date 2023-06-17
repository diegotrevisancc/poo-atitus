package oop_paradigm.views;

import oop_paradigm.Aplicacao;

public class VerProdutosView {
    public void criarVerProdutosView() {
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
                    new VerBebidasView().criarBebidasView();
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
        }
    }
}
