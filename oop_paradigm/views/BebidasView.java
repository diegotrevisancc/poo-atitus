package oop_paradigm.views;

import oop_paradigm.entities.produto.Bebida;
import oop_paradigm.services.BebidasService;
import oop_paradigm.services.ClienteService;

import static oop_paradigm.views.PrincipalView.vendaService;


public class BebidasView extends ConsumiveisView {
    public BebidasService service = new BebidasService();

    public BebidasView() {
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
