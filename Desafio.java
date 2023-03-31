import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean programa = true;
        double carteira = 0;
        while(programa) {
            System.out.println("Buteco\n 1- Pasteis\n 2- Bebidas do Bem\n 3- Cachaça braba\n 4- Toca fitas(jukebox)\n 5- Estou indo embora......");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("1- Pastel de Carne --> R$:5.00");
                    System.out.println("2- Pastel de Frango --> R$:4.00");
                    System.out.println("3- Pastel de Carne com ovo --> R$:5.50");
                    System.out.println("4- Pastel de Frango com ovo --> R$:5.00");
                    int escolhaDoPastel = sc.nextInt();
                    switch (escolhaDoPastel) {
                        case 1:
                            carteira+=5.00;
                            break;
                        case 2:
                            carteira+=4.00;
                            break;
                        case 3:
                            carteira+=5.50;
                            break;
                        case 4:
                            carteira+=5.00;
                            break;
                        default:
                            System.out.println("Inválida");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("1- Guaraná --> R$:3.29");
                    System.out.println("2- Coca-cola --> R$:8.00");
                    System.out.println("3- Água da torneira --> R$:1.50");
                    System.out.println("4- Água com gás --> R$:3.00");
                    int escolhaDaBebidaDoBem = sc.nextInt();
                    switch (escolhaDaBebidaDoBem) {
                        case 1:
                            carteira+=3.29;
                            break;
                        case 2:
                            carteira+=8.00;
                            break;
                        case 3:
                            carteira+=1.50;
                            break;
                        case 4:
                            carteira+=3.00;
                            break;
                        default:
                            System.out.println("Inválida");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("1- Chico Mineiro Ouro --> R$24.90");
                    System.out.println("2- Cachaça Do Brejo --> R$:25.00");
                    System.out.println("3- Corote de Morango --> R$:3.00");
                    System.out.println("4- Garoa(Alcool de posto de gasolina) --> R$:4.87");
                    int escolhaDaCachacaBraba = sc.nextInt();
                    switch (escolhaDaCachacaBraba) {
                        case 1:
                            carteira+=24.90;
                            break;
                        case 2:
                            carteira+=25.00;
                            break;
                        case 3:
                            carteira+=3.00;
                            break;
                        case 4:
                            carteira+=4.87;
                            break;
                        default:
                            System.out.println("Inválida");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1- Evidências --> R$00.50");
                    System.out.println("2- Dormi Na Praça --> R$:1.80");
                    System.out.println("3- A Carta --> R$:0.30");
                    System.out.println("4- Boate Azul --> R$:1.00");
                    int escolhaJukebox = sc.nextInt();
                    switch (escolhaJukebox) {
                        case 1:
                            carteira+=0.50;
                            break;
                        case 2:
                            carteira+=1.80;
                            break;
                        case 3:
                            carteira+=0.30;
                            break;
                        case 4:
                            carteira+=1;
                            break;
                    }
                    break;
                case 5:
                    programa = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            System.out.printf("Gasto na carteira atual R$:%.2f", carteira);
        }
    sc.close();
    }
}