package Aula05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    
    public static void main(String[] args){

        int opcao, indice = 0;
        List<String> carrinho = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        double dinheiroDisponivel, valorTotal = 0;

        System.out.println("""
                Senhor dos pasteis
                1 - Cachorro Quente R$ 4,00
                2 - X-Salada R$ 4,50
                3 - Cerveja R$ 5,00
                4 - Refrigerante R$ 3,50
                5 - Visualizar carrinho
                6 - Sair """);

        do{
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            System.out.println();

            switch(opcao){
                case 1 -> {
                    carrinho.add("[" + indice + "] Cachorro Quente - R$ 4,00");
                    System.out.println("[" + indice + "] Cachorro Quente adicionado ao carrinho");
                    valorTotal += 4;
                    indice++;
                }
                case 2 -> {
                    carrinho.add("[" + indice + "] X-Salada - R$ 4,50");
                    System.out.println("[" + indice + "] X-Salada adicionado ao carrinho");
                    valorTotal += 4.5;
                    indice++;
                }
                case 3 -> {
                    carrinho.add("[" + indice + "] Cerveja - R# 5,00");
                    System.out.println("[" + indice + "] Cerveja adicionado ao carrinho");
                    valorTotal += 5;
                    indice++;
                }
                case 4 -> {
                    carrinho.add("[" + indice + "] Refrigerante - R$ 3,50");
                    System.out.println("[" + indice + "] Refrigerante adicionado ao carrinho");
                    valorTotal += 3.5;
                    indice++;
                }
                case 5 -> {
                    System.out.println("Seu carrinho: ");
                    for (String i : carrinho) {
                        if(i != null){
                            System.out.println(i);
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Saindo...");
                    System.out.println("Obrigado pela preferência!");
                }
                default -> System.out.println("Opção inválida!");
            }

            
        }while(opcao != 6);
        
        // Mostrar carrinho
        System.out.println();
        System.out.println("Seu carrinho: ");
        for (String i : carrinho) {
            if(i != null){
                System.out.println(i);
            }
        }

        // Mostrar valor total
        System.out.println();
        System.out.printf("Valor total: R$ %.2f",valorTotal);
        System.out.println();

        // Verificar se tem dinheiro suficiente
        System.out.print("Digite o valor que você tem: ");
        dinheiroDisponivel = scan.nextDouble();

        if(dinheiroDisponivel >= valorTotal){
            System.out.println("Compra realizada com sucesso!");
        }else{
            System.out.println("Você não tem dinheiro suficiente!");
            do {
                System.out.println("Escolha um produto para remover: ");
                opcao = scan.nextInt();
                switch(opcao){
                    case 1 -> {
                        if(itemInCarrinho("Cachorro Quente - R$ 4,00", carrinho)){
                            carrinho.remove("Cachorro Quente - R$ 4,00");
                            System.out.println("Cachorro Quente removido do carrinho");
                            valorTotal -= 4;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                    }
                    case 2 -> {
                        if(itemInCarrinho("X-Salada - R$ 4,50", carrinho)){
                            carrinho.remove("X-Salada - R$ 4,50");
                            System.out.println("X-Salada removido do carrinho");
                            valorTotal -= 4.5;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                    }
                    case 3 -> {
                        if(itemInCarrinho("Cerveja - R# 5,00", carrinho)){
                            carrinho.remove("Cerveja - R# 5,00");
                            System.out.println("Cerveja removido do carrinho");
                            valorTotal -= 5;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                    }
                    case 4 -> {
                        if(itemInCarrinho("Refrigerante - R$ 3,50", carrinho)){
                            carrinho.remove("Refrigerante - R$ 3,50");
                            System.out.println("Refrigerante removido do carrinho");
                            valorTotal -= 3.5;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                    }
                    case 5 -> {
                        System.out.println("Seu carrinho: ");
                        for (String i : carrinho) {
                            if(i != null){
                                System.out.println(i);
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("Saindo...");
                        System.out.println("Obrigado pela preferência!");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }while(dinheiroDisponivel < valorTotal);

        }
        
    }
    
    public static boolean itemInCarrinho(String indice, List<String> carrinho){

        for (String i : carrinho) {
            if(i != null){
                if(i.contains(indice)){
                    return true;
                }
            }
        }
        return false;
    }

    
}


