package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.Venda;

import java.util.Random;

public class PrincipalView  {
    public void criarViewPrincipal() {
        System.out.println("Bem-vindo a pastelaria do Fernando!");
        System.out.println("Por favor, nos informe seu nome: ");
        String nome = Aplicacao.scanner.nextLine();
        Cliente cliente = new Cliente(new Random().nextInt(), nome);
        Venda venda = new Venda(cliente.getName());
        System.out.println("Beleza, " + nome);
        System.out.println("Selecione uma opção");
        System.out.println("1 - Comprar");
        System.out.println("2 - Carrinho"); /*Dar a opção de remover itens do carrinho */
        System.out.println("3 - Pagamento"); /* Inserção simples de valor */
        System.out.println("4 - Sair");
        int opcao = Integer.parseInt(Aplicacao.scanner.nextLine());
        switch(opcao) {
            case 1:
                new VerProdutosView().criarVerProdutosView(cliente, venda);
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
