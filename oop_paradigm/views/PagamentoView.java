package oop_paradigm.views;

import oop_paradigm.Aplicacao;
import oop_paradigm.entities.Cliente;

public class PagamentoView {
    public void criarPagamentoView() {
        Cliente cliente = PrincipalView.vendaService.getVenda().getCliente();
        System.out.println("Beleza, vamos acertar as contas " + cliente.getName());
        boolean valorInvalido = true;
        while(valorInvalido) {
            System.out.println("Valor total: R$: " + PrincipalView.vendaService.getPrecoTotal());
            System.out.println("Insira o valor: ");

            double valor = Double.parseDouble(Aplicacao.scanner.nextLine());

            if (valor == PrincipalView.vendaService.getPrecoTotal()) {
                valorInvalido = false;
            } else {
                System.out.println("Insira um valor válido!");
                  try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }

    }
}
