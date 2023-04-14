import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Loja {
    public static int menuPrincipal() {
        List<String> categorias = new ArrayList<String>() {
            {
                add("Comidas");
                add("Bebidas");
                add("Sair");
            }
        };
        System.out.println("Bem-vindo(a) a pastelaria do Fernando");
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione a categoria: ");
        int counter = 1;
        for (int i = 0; i != categorias.size(); i++) {
            System.out.println(counter + " - " + categorias.get(i));
            counter++;
        }
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        return opcao;
    }
    public static boolean itemInCarrinho(String indice, List<String> carrinho) {

        for (String i : carrinho) {
            // Para cada item do carrinho, verifica se o item é igual ao indice
            if (i.contains(indice)) {
                return true; // Se sim, retorna true
            }

        }
        return false;
    }

    public static void mostraCarrinho(List<String> carrinho, double valorTotal) {
        System.out.println("-------------------------");
        System.out.println("Seu carrinho: ");

        for (String i : carrinho) { // For each para mostrar os itens do carrinho

            System.out.println(i); // Mostra cada item do carrinho

        }

        System.out.println("Valor: R$ " + valorTotal); // Mostra o valor total da compra
        System.out.println("-------------------------");
    }

    public static void mostraItensComida() {
        System.out.println("""
                1 - Cachorro Quente R$ 4,00
                2 - X-Salada R$ 4,50
                3 - Pastel de Carne R$ 5,00
                4 - Pastel de Frango R$ 4,50
                5 - Visualizar carrinho
                6 - Sair """);
    }

    public static void mostraItensBebidas() {
        System.out.println("""
                1 - Cerveja R$ 4,50
                2 - Água R$ 10,50
                3 - Refrigerante R$ 5,00
                4 - Visualizar carrinho
                5 - Sair """);
    }

    public static void mostraItens() {
        System.out.println("""
                1 - Cachorro Quente R$ 4,00
                2 - X-Salada R$ 4,50
                3 - Pastel de Carne R$ 5,00
                4 - Pastel de Frango R$ 4,50
                5 - Cerveja R$: 4,50
                6 - Água R$ 10,50
                7 - Refrigerante R$: 4,50
                8 - Visualizar carrinho
                9 - Sair """);
    }

    public static void finalizarCompra(List<String> carrinho, double valorTotal, double dinheiroDisponivel) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        // Mostrar carrinho
        System.out.println();
        mostraCarrinho(carrinho, valorTotal);


        // Verificar se tem dinheiro suficiente
        System.out.print("Digite o valor que você tem: ");
        dinheiroDisponivel = sc.nextDouble();


        if (dinheiroDisponivel >= valorTotal) {
            System.out.println("Compra realizada com sucesso!");
        } else {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            mostraCarrinho(carrinho, valorTotal);
            System.out.println("Você não tem dinheiro suficiente!");
            int opcao = 0;
            while (dinheiroDisponivel < valorTotal && opcao != 9) {
                mostraItens();
                System.out.print("\nEscolha um produto para remover ou [9] para sair: ");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1 -> {
                        if (itemInCarrinho("Cachorro Quente - R$ 4,00", carrinho)) { // Caso o item esteja no carrinho
                            carrinho.remove(carrinho.indexOf("Cachorro Quente - R$ 4,00")); // Remove o item do carrinho pelo índice
                            System.out.println("Cachorro Quente removido do carrinho");
                            valorTotal -= 4;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 2 -> {
                        if (itemInCarrinho("X-Salada - R$ 4,50", carrinho)) {
                            carrinho.remove("X-Salada - R$ 4,50");
                            System.out.println("X-Salada removido do carrinho");
                            valorTotal -= 4.5;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 3 -> {
                        if (itemInCarrinho("Pastel de Carne - R$ 5,00", carrinho)) {
                            carrinho.remove("Pastel de Carne - R$ 5,00");
                            System.out.println("Pastel de carne removido do carrinho");
                            valorTotal -= 5;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 4 -> {
                        if (itemInCarrinho("Pastel de Frango - R$ 4,50", carrinho)) {
                            carrinho.remove("Pastel de Frango - R$ 4,50");
                            System.out.println("Pastel de Frango removido do carrinho");
                            valorTotal -= 3.5;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 5 -> {
                        if (itemInCarrinho("Cerveja - R$ 4,50", carrinho)) {
                            carrinho.remove("Cerveja - R$ 4,50");
                            System.out.println("Cerveja removido do carrinho");
                            valorTotal -= 4.5;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 6 -> {
                        if (itemInCarrinho("Água - R$ 10,50", carrinho)) {
                            carrinho.remove("Água - R$ 4,50");
                            System.out.println("Água removido do carrinho");
                            valorTotal -= 3.5;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 7 -> {
                        if (itemInCarrinho("Refrigerante - R$ 4,50", carrinho)) {
                            carrinho.remove("Refrigerante - R$ 4,50");
                            System.out.println("Refrigerante removido do carrinho");
                            valorTotal -= 3.5;
                        } else {
                            System.out.println("Esse item não está no carrinho!");
                        }
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 8 -> {
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 9 -> {
                        System.out.println("Compra Cancelada!");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }

        }
        sc.close();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int categoriaOpcao = 0;

        while (true) {
            categoriaOpcao = menuPrincipal();
            if (categoriaOpcao <= 0 || categoriaOpcao > 3) {
                System.out.println("Opção inválida");
            } else {
                break;
            }
        }

        int opcao = 0; // Opção do menu
        List<String> carrinho = new ArrayList<>(); // Carrinho de compras
        Scanner scan = new Scanner(System.in); // Scanner para ler opções do menu
        double dinheiroDisponivel = 0, valorTotal = 0; // Dinheiro disponível e valor total da compra

        if (categoriaOpcao == 1) {
            mostraItensComida();

            while (opcao != 6) {
                System.out.print("Escolha uma opção: ");
                opcao = scan.nextInt();
                System.out.println();

                switch (opcao) {
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
                        carrinho.add("Pastel de Carne - R$ 5,00");
                        System.out.println("Pastel de Carne adicionado ao carrinho\n");
                        valorTotal += 5;
                    }
                    case 4 -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        carrinho.add("Pastel de Frango - R$ 4,50");
                        System.out.println("Pastel de Frango adicionado ao carrinho\n");
                        valorTotal += 4.5;
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
                mostraItensComida();
            }
            finalizarCompra(carrinho, valorTotal, dinheiroDisponivel);
            scan.close();
        }else if(categoriaOpcao == 2){
            mostraItensBebidas();

            while (opcao != 5) {
                System.out.print("Escolha uma opção: ");
                opcao = scan.nextInt();
                System.out.println();

                switch (opcao) {
                    case 1 -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        carrinho.add("Cerveja - R$ 4,50");
                        System.out.println("Cerveja adicionado ao carrinho\n");
                        valorTotal += 4.5;
                    }
                    case 2 -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        carrinho.add("Água - R$ 10,50");
                        System.out.println("Àgua adicionado ao carrinho\n");
                        valorTotal += 10.5;
                    }
                    case 3 -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        carrinho.add("Refrigerante - R$ 4,50");
                        System.out.println("Refrigerante adicionado ao carrinho\n");
                        valorTotal += 4.5;
                    }
                    case 4 -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        mostraCarrinho(carrinho, valorTotal);
                    }
                    case 5 -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }
                    default -> {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("Opção inválida!");
                    }
                }
                mostraItensBebidas();
            }
            finalizarCompra(carrinho, valorTotal, dinheiroDisponivel);
            scan.close();
        } else if (categoriaOpcao == 3) {
            System.out.println("Até a próxima");
        } else {
            System.out.println("Opção inválida");
        }
    }




}


