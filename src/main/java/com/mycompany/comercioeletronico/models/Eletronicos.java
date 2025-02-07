package com.mycompany.comercioeletronico.models;

public class Eletronicos extends Produto {

    private int prazoGarantia;

    public Eletronicos(int id, String nome, double preco, int prazoGarantia) {
        super(id, nome, preco);
        this.prazoGarantia = prazoGarantia;
    }

    public int getPrazoGarantia() {
        return prazoGarantia;
    }
}
