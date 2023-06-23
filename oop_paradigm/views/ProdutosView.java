package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.services.BebidasService;
import oop_paradigm.services.ComidaService;

public class ProdutosView {
    private boolean comprar = true;

    public void criarVerProdutosView() {
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
                    BebidasView bebidasView = new BebidasView();
                    bebidasView.criarConsumiveisView(new BebidasService());
                    break;
                case 2:
                    ComidasView comidasView = new ComidasView();
                    comidasView.criarConsumiveisView(new ComidaService());
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
            System.out.println(PrincipalView.vendaService.getPrecoTotal());
        }
    }
}
