package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Produto;
import oop_paradigm.services.BebidasService;

import java.util.List;

public class VerBebidasView {
    public boolean criarBebidasView() {
        BebidasService bebidasService = new BebidasService();
        List<Produto> bebidas = bebidasService.findAll();
        for (int i = 0; i < bebidasService.findAll().size(); i++) {
            System.out.println(i + " - " + bebidas.get(i));
        }
        System.out.print("Aperte enter para sair");
        String sair = Aplicacao.scanner.nextLine();
        //TO DO - CRIAR UM EVENT LISTENER QUE RECEBA QUALQUER TECLA E RETORNE BOOLEANO
    }
}
