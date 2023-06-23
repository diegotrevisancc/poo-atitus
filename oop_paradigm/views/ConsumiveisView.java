package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.Produto;
import oop_paradigm.entities.Venda;
import oop_paradigm.services.ProdutoService;

import java.util.List;

public abstract class ConsumiveisView {
    private Cliente cliente;
    private Venda venda;

    private ProdutoService service = null;

    public ConsumiveisView() {
        this.cliente = PrincipalView.vendaService.getVenda().getCliente();
        this.venda = PrincipalView.vendaService.getVenda();
    }

    public void criarConsumiveisView(ProdutoService produtoService) {
        this.service = produtoService;
        List<Produto> consumivel = this.service.findAll();

        for (int i = 1; i <= consumivel.size(); i++) {
            System.out.println(i + " - " + consumivel.get(i - 1));
        }

        System.out.println("Insira o número da bebida que deseja inserir no carrinho ou aperte 0 para sair dessa tela");
        int opcao = Integer.parseInt(Aplicacao.scanner.nextLine());
        if (opcao != 0 && (opcao >= 1 && opcao <= this.service.findAll().size())) {
            this.consumivelEspecificoView(opcao);
        } else {
            System.out.println("Opção Inválida!");
        }

        System.out.println("Aperte enter para voltar");
        Aplicacao.scanner.nextLine();
    }

    public abstract void consumivelEspecificoView(int opcao);

    protected Cliente getCliente() {
        return cliente;
    }

    protected Venda getVenda() {
        return venda;
    }
}
