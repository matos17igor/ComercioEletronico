package com.mycompany.comercioeletronico.models;

public class Alimentos extends Produto {

    private String dataValidade;

    public Alimentos(int id, String nome, double preco, String dataValidade) {
        super(id, nome, preco);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

}
    
