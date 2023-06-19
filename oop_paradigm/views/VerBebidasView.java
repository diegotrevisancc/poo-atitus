package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;
import oop_paradigm.entities.ItemVenda;
import oop_paradigm.entities.Produto;
import oop_paradigm.entities.Venda;
import oop_paradigm.entities.produto.Bebida;
import oop_paradigm.services.BebidasService;
import oop_paradigm.services.VendaService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class VerBebidasView {
    BebidasService service = new BebidasService();
    Venda venda = null;
    Cliente cliente = null;

    private boolean validarFormatoDataDeNascimento(String dataDeNascimento) {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(dataDeNascimento).matches();
    }

    private int calcularIdade(Date dataDeNascimento) {
        Calendar calNascimento = Calendar.getInstance();
        calNascimento.setTime(dataDeNascimento);

        Calendar calAtual = Calendar.getInstance();

        int anoNascimento = calNascimento.get(Calendar.YEAR);
        int mesNascimento = calNascimento.get(Calendar.MONTH);
        int diaNascimento = calNascimento.get(Calendar.DAY_OF_MONTH);

        int anoAtual = calAtual.get(Calendar.YEAR);
        int mesAtual = calAtual.get(Calendar.MONTH);
        int diaAtual = calAtual.get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - anoNascimento;

        if (mesAtual < mesNascimento || (mesAtual == mesNascimento && diaAtual < diaNascimento)) {
            idade--;
        }
        return idade;
    }

    private boolean validarMaioridade() {
        boolean formatoValido = false;
        String dataDeNascimento = "";
        Aplicacao.scanner.nextLine();
        while (!formatoValido) {
            System.out.println("Insira sua data de nascimento no formato dd/mm/yyyy ");
            dataDeNascimento = Aplicacao.scanner.nextLine();
            formatoValido = validarFormatoDataDeNascimento(dataDeNascimento);
        }
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataNascimentoDate = formatoData.parse(dataDeNascimento);
            this.cliente.setDataDeNascimento(dataNascimentoDate);
            int idade = calcularIdade(dataNascimentoDate);
            this.cliente.setIdade(idade);
            if (idade >= 18) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void adicionarBebidaAoCarrinho(int opcao) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a quantidade: ");
        int quantidade = sc.nextInt();
        Bebida bebida = this.service.findAllBebidas().get(opcao);
        ItemVenda item = new ItemVenda(new Random().nextInt(), bebida, quantidade);

        VendaService vs = new VendaService(this.venda);
        vs.adicionarAoCarrinho(item);
        sc.close();
    }


    public boolean criarBebidasView(Cliente cliente, Venda venda) {
        this.cliente = cliente;
        this.venda = venda;
        List<Produto> bebidas = this.service.findAll();
        boolean maiorDeIdade = false;
        for (int i = 1; i <= this.service.findAll().size(); i++) {
            System.out.println(i + " - " + bebidas.get(i - 1));
        }

        System.out.println("Insira o número da bebida que deseja inserir no carrinho ou aperte 0 para sair dessa tela");
        int opcao = Aplicacao.scanner.nextInt() - 1;

        if (opcao != 0 && (opcao >= 1 && opcao < this.service.findAll().size())) {

            boolean alcoolica = this.service.findAllBebidas().get(opcao).getAlcoolica();

            if (!alcoolica) {
                adicionarBebidaAoCarrinho(opcao);
            } else {
                if (this.cliente.getDataDeNascimento() == null) {
                    maiorDeIdade = validarMaioridade();
                } else {
                    maiorDeIdade = this.cliente.getIdade() >= 18;
                }

                if (maiorDeIdade) {
                    adicionarBebidaAoCarrinho(opcao);
                } else {
                    System.out.println("Você não tem idade para isso");
                }
            }
        }
        System.out.println("Aperte enter para voltar");
        Aplicacao.scanner.nextLine();
        //String voltar = Aplicacao.scanner.nextLine();
        return false;
    }
}
