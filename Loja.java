import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    
    public static void main(String[] args) throws InterruptedException, IOException{

        int opcao = 0; // Opção do menu
        List<String> carrinho = new ArrayList<>(); // Carrinho de compras
        Scanner scan = new Scanner(System.in); // Scanner para ler opções do menu
        double dinheiroDisponivel, valorTotal = 0; // Dinheiro disponível e valor total da compra

        // Mostra itens da loja
        mostraItens();

        while(opcao != 6){
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            System.out.println();

            switch(opcao){
                case 1 -> { 
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    carrinho.add("Cachorro Quente - R$ 4,00");
                    System.out.println("Cachorro Quente adicionado ao carrinho\n");
                    valorTotal += 4;
                }
                case 2 -> { 
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    carrinho.add("X-Salada - R$ 4,50");
                    System.out.println("X-Salada adicionado ao carrinho\n");
                    valorTotal += 4.5;
                }
                case 3 -> {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    carrinho.add("Cerveja - R# 5,00");
                    System.out.println("Cerveja adicionado ao carrinho\n");
                    valorTotal += 5;
                }
                case 4 -> {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    carrinho.add("Refrigerante - R$ 3,50");
                    System.out.println("Refrigerante adicionado ao carrinho\n");
                    valorTotal += 3.5;
                }
                case 5 -> {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    mostraCarrinho(carrinho, valorTotal);
                }
                case 6 -> {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }
                default -> { 
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
                System.out.println("Opção inválida!"); 
                }
            }
            // Mostra itens da loja
            mostraItens();
        }
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        // Mostrar carrinho
        System.out.println();
        mostraCarrinho(carrinho, valorTotal);


        // Verificar se tem dinheiro suficiente
        System.out.print("Digite o valor que você tem: ");
        dinheiroDisponivel = scan.nextDouble();

        
        if(dinheiroDisponivel >= valorTotal){
            System.out.println("Compra realizada com sucesso!");
        }else{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            mostraCarrinho(carrinho, valorTotal);
            System.out.println("Você não tem dinheiro suficiente!");
            mostraItens();
            opcao = 0;
            while(dinheiroDisponivel < valorTotal && opcao != 6){
                System.out.print("\nEscolha um produto para remover ou [6] para sair: ");
                opcao = scan.nextInt();
                switch(opcao){
                    case 1 -> { 
                        if(itemInCarrinho("Cachorro Quente - R$ 4,00", carrinho)){ // Caso o item esteja no carrinho
                            carrinho.remove(carrinho.indexOf("Cachorro Quente - R$ 4,00")); // Remove o item do carrinho pelo índice 
                            System.out.println("Cachorro Quente removido do carrinho");
                            valorTotal -= 4;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 2 -> {
                        if(itemInCarrinho("X-Salada - R$ 4,50", carrinho)){
                            carrinho.remove("X-Salada - R$ 4,50");
                            System.out.println("X-Salada removido do carrinho");
                            valorTotal -= 4.5;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 3 -> {
                        if(itemInCarrinho("Cerveja - R# 5,00", carrinho)){
                            carrinho.remove("Cerveja - R# 5,00");
                            System.out.println("Cerveja removido do carrinho");
                            valorTotal -= 5;
                        } else{
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 4 -> {
                        if(itemInCarrinho("Refrigerante - R$ 3,50", carrinho)){
                            carrinho.remove("Refrigerante - R$ 3,50");
                            System.out.println("Refrigerante removido do carrinho");
                            valorTotal -= 3.5;
                        } else{  
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 5 -> {   
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 6 -> {
                        System.out.println("Compra Cancelada!");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }
            
        }
        scan.close();
    }
    
    public static boolean itemInCarrinho(String indice, List<String> carrinho){

        for (String i : carrinho) {
            // Para cada item do carrinho, verifica se o item é igual ao indice
            if(i.contains(indice)){
                return true; // Se sim, retorna true
            }

        }
        return false;
    }

    public static void mostraCarrinho(List<String> carrinho, double valorTotal){
        System.out.println("-------------------------");
        System.out.println("Seu carrinho: ");

        for (String i : carrinho) { // For each para mostrar os itens do carrinho
            
            System.out.println(i); // Mostra cada item do carrinho

        }

        System.out.println("Valor: R$ " + valorTotal); // Mostra o valor total da compra
        System.out.println("-------------------------");
    }

    public static void mostraItens() {
         System.out.println("""
            1 - Cachorro Quente R$ 4,00
            2 - X-Salada R$ 4,50
            3 - Cerveja R$ 5,00
            4 - Refrigerante R$ 3,50
            5 - Visualizar carrinho
            6 - Sair """);
    }

    
}


