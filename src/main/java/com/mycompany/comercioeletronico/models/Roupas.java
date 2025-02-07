package com.mycompany.comercioeletronico.models;

public class Roupas extends Produto {

    private String tamanho;
    private String cor;

    public Roupas(int id, String nome, double preco, String tamanho, String cor) {
        super(id, nome, preco);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

}
