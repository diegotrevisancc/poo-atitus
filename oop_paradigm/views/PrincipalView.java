package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import java.util.Random;

public class PrincipalView  {
    public void criarViewPrincipal() {
        System.out.println("Bem-vindo a pastelaria do Fernando!");
        System.out.print("Por favor, nos informe seu nome: ");
        String nome = Aplicacao.scanner.next();
        Cliente cliente = new Cliente(new Random().nextInt(), nome);
        System.out.println("Beleza, " + nome);
        System.out.println("Selecione uma opção");
        System.out.println("1 - Produtos");
        System.out.println("2 - Carrinho");
        System.out.println("3 - Pagamento");
        System.out.println("4 - Sair");

        int opcao = Aplicacao.scanner.nextInt();

        switch(opcao) {
            case 1:
                new VerProdutosView().criarVerProdutosView();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
