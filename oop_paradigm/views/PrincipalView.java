package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.Venda;
import oop_paradigm.services.VendaService;
import java.util.Random;

public class PrincipalView  {
    public static VendaService vendaService = null;
    private boolean venda = true;
    public void criarViewPrincipal() {
        System.out.println("Bem-vindo a pastelaria do Fernando!");
        System.out.println("Por favor, nos informe seu nome: ");
        String nome = Aplicacao.scanner.nextLine();

        Cliente cliente = new Cliente(new Random().nextInt(), nome);
        Venda venda = new Venda(cliente);
        PrincipalView.vendaService = new VendaService(venda);

        System.out.println("Beleza, " + cliente.getName());
        while(this.venda) {
            System.out.println("Selecione uma opção");
            System.out.println("1 - Comprar");
            System.out.println("2 - Carrinho");
            System.out.println("3 - Pagamento");
            System.out.println("4 - Sair");
            int opcao = Integer.parseInt(Aplicacao.scanner.nextLine());
            switch(opcao) {
                case 1:
                    new ProdutosView().criarVerProdutosView();
                    Util.limparTela();
                    break;
                case 2:
                    new CarrinhoView().criarCarrinhoView();
                    Util.limparTela();
                    break;
                case 3:
                    new PagamentoView().criarPagamentoView();
                    this.venda = false;
                    Util.limparTela();
                    break;
                case 4:
                    this.venda = false;
                    break;
            }
        }
        System.out.println("Até a próxima!");
    }
}
