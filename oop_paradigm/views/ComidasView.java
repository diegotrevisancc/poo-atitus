package oop_paradigm.views;

import oop_paradigm.entities.Produto;
import oop_paradigm.services.ComidaService;

public class ComidasView extends ConsumiveisView {
    public ComidaService service = new ComidaService();

    public ComidasView() {
        super();
    }

    @Override
    public void consumivelEspecificoView(int opcao) {
        opcao -= 1;
        Produto comidaEscolhida = this.service.findAll().get(opcao);
        PrincipalView.vendaService.adicionarAoCarrinho(comidaEscolhida);
    }
}
