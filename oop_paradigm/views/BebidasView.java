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

import static oop_paradigm.views.PrincipalView.vendaService;


public class VerBebidasView extends VerConsumiveisView {
    public BebidasService service = new BebidasService();

    public VerBebidasView() {
        super();
    }

    @Override
    public void consumivelEspecificoView(int opcao) {
        boolean maiorDeIdade = false;
        opcao -= 1;
        Bebida bebidaEscolhida = this.service.findAllBebidas().get(opcao);
        boolean alcoolica = bebidaEscolhida.getAlcoolica();

        if (!alcoolica) {
            vendaService.adicionarAoCarrinho(bebidaEscolhida);
        } else {
            if (super.getCliente().getDataDeNascimento() == null) {
                maiorDeIdade = new ClienteService(super.getCliente()).validarMaioridade();
            } else {
                maiorDeIdade = super.getCliente().getIdade() >= 18;
            }

            if (maiorDeIdade) {
                vendaService.adicionarAoCarrinho(bebidaEscolhida);
            } else {
                System.out.println("Você não tem idade para isso");
            }
        }
    }
}
