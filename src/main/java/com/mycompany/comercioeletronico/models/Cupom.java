package com.mycompany.comercioeletronico.models;

public abstract class Cupom {

    private String codigo;
    private double percentualDesconto;
    private boolean ativo;

    public Cupom(String codigo, double percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.ativo = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void desativar() {
        ativo = false;
    }

    public abstract boolean podeSerAplicado(double valorTotal);

}
