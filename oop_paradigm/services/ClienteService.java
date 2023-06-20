package oop_paradigm.services;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class ClienteService {
    Cliente cliente;

    public ClienteService(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean validarMaioridade() {
        boolean formatoValido = false;
        String dataDeNascimento = "";
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
}
