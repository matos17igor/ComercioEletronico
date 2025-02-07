package com.mycompany.comercioeletronico.models;

public class CupomValorMinimo extends Cupom {

    private double valorMinimo;

    public CupomValorMinimo(String codigo, double percentualDesconto, double valorMinimo) {
        super(codigo, percentualDesconto);
        this.valorMinimo = valorMinimo;
    }

    @Override
    public boolean podeSerAplicado(double valorTotal) {
        return valorTotal >= valorMinimo;
    }

}
