package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.ItemVenda;
import oop_paradigm.entities.Produto;
import oop_paradigm.entities.Venda;
import oop_paradigm.entities.produto.Bebida;
import oop_paradigm.services.BebidasService;
import oop_paradigm.services.ClienteService;
import oop_paradigm.services.VendaService;
import java.util.*;


public class VerBebidasView {
    BebidasService service = new BebidasService();
    Venda venda = null;
    Cliente cliente = null;

    public boolean criarBebidasView(VendaService vendaService) {
        this.cliente = vendaService.getVenda().getCliente();
        this.venda = vendaService.getVenda();

        List<Produto> bebidas = this.service.findAll();
        boolean maiorDeIdade = false;

        for (int i = 1; i <= this.service.findAll().size(); i++) {
            System.out.println(i + " - " + bebidas.get(i - 1));
        }

        System.out.println("Insira o número da bebida que deseja inserir no carrinho ou aperte 0 para sair dessa tela");
        int opcao = Integer.parseInt(Aplicacao.scanner.nextLine());


        if (opcao != 0 && (opcao >= 1 && opcao <= this.service.findAll().size())) {

            opcao -= 1;
            Bebida bebidaEscolhida = this.service.findAllBebidas().get(opcao);
            boolean alcoolica = bebidaEscolhida.getAlcoolica();

            if (!alcoolica) {
                vendaService.adicionarAoCarrinho(bebidaEscolhida);
            } else {
                if (this.cliente.getDataDeNascimento() == null) {
                    maiorDeIdade = new ClienteService(this.cliente).validarMaioridade();
                } else {
                    maiorDeIdade = this.cliente.getIdade() >= 18;
                }

                if (maiorDeIdade) {
                    vendaService.adicionarAoCarrinho(bebidaEscolhida);
                } else {
                    System.out.println("Você não tem idade para isso");
                }
            }
        }
        System.out.println("Aperte enter para voltar");
        Aplicacao.scanner.nextLine();
        return false;
    }
}
