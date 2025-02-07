package com.mycompany.comercioeletronico.services;

import com.mycompany.comercioeletronico.reports.Relatorio;
import com.mycompany.comercioeletronico.models.Vendas;
import com.mycompany.comercioeletronico.models.Cupom;
import java.util.List;

public class GestorVendas implements Relatorio {

    @Override
    public void gerarRelatorioVendas(List<Vendas> vendas) {
        double totalArrecadado = vendas.stream().mapToDouble(Vendas::calcularTotal).sum();
        System.out.println("\n=== Relatorio de Vendas ===");
        System.out.println("Total de vendas realizadas: " + vendas.size());
        System.out.println("Total arrecadado: " + totalArrecadado);
    }

    @Override
    public void listarCuponsAtivos(List<Cupom> cupons) {
        System.out.println("Cupons ativos:");
        cupons.stream().filter(Cupom::isAtivo).forEach(c-> System.out.println("Codigo: " + c.getCodigo()+ ", Desconto: " + c.getPercentualDesconto() + "%"));
    }

}
