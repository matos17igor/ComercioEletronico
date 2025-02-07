package com.mycompany.comercioeletronico.main;
import com.mycompany.comercioeletronico.exceptions.CupomInvalidoException;
import com.mycompany.comercioeletronico.models.*;
import com.mycompany.comercioeletronico.services.GestorVendas;
import java.util.*;

public class ComercioEletronico {

    public static void main(String[] args) throws CupomInvalidoException {
        Produto smartphone = new Eletronicos(1, "Iphone 13", 3300, 12);
        Produto camisa = new Roupas(2, "Camiseta", 65, "M", "Preta");
        Produto chocolate = new Alimentos(3, "KitKat", 12, "2025-10-15");
        
        Cupom cupom10 = new CupomQuantidadeLimitada("CUPOM10", 10, 1);
        Cupom cupom20 = new CupomValorMinimo("CUPOM20", 20, 500);
        
        Vendas venda1 = new Vendas(1);
        venda1.adicionarProduto(smartphone);
        venda1.adicionarProduto(camisa);
        venda1.aplicarCupom(cupom10);
        venda1.exibirResumo();
        
        Vendas venda2 = new Vendas(2);
        venda2.adicionarProduto(camisa);
        venda2.adicionarProduto(camisa);
        venda2.adicionarProduto(chocolate);
        //venda2.aplicarCupom(cupom10);
        venda2.exibirResumo();
        
        
        List<Vendas> vendas = new ArrayList<>();
        vendas.add(venda1);
        vendas.add(venda2);
        
        List<Cupom> cupons = new ArrayList<>();
        cupons.add(cupom10);
        
        GestorVendas gestor = new GestorVendas();
        gestor.gerarRelatorioVendas(vendas);
        gestor.listarCuponsAtivos(cupons);
    }
}
