package com.mycompany.comercioeletronico.models;

public class CupomQuantidadeLimitada extends Cupom {

    private int maximoUtilizacoes;
    private int utilizacoesAtuais;

    public CupomQuantidadeLimitada(String codigo, double percentualDesconto, int maximoUtilizacoes) {
        super(codigo, percentualDesconto);
        this.maximoUtilizacoes = maximoUtilizacoes;
        utilizacoesAtuais = 0;
    }

    @Override
    public boolean podeSerAplicado(double valorTotal) {
        if (utilizacoesAtuais < maximoUtilizacoes) {
            utilizacoesAtuais++;
            return true;
        } else {
            desativar();
            return false;
        }
    }
}
