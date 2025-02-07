package com.mycompany.comercioeletronico.models;
import com.mycompany.comercioeletronico.exceptions.CupomInvalidoException;
import java.util.*;

public class Vendas {
    private int id;
    private List<Produto> produtos;
    private Cupom cupom;
    
    public Vendas(int id){
        this.id = id;
        produtos = new ArrayList<>();
    }
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
    
    public void aplicarCupom(Cupom cupom) throws CupomInvalidoException {
        double valorTotal = calcularTotal();
        if(cupom.podeSerAplicado(valorTotal)){
            this.cupom = cupom;
        } else {
            throw new CupomInvalidoException("Cupom nao pode ser aplicado.");
        }
    }
    
    public double calcularTotal(){
        double total = produtos.stream().mapToDouble(Produto::getPreco).sum();
        if(cupom != null){
            total -= total * (cupom.getPercentualDesconto() / 100);
        }
        return total;
    }
    
    public void exibirResumo(){
        System.out.println("\nResumo da Venda #" + id);
        produtos.forEach(System.out::println);
        if(cupom != null){
            System.out.println("Cupom aplicado: " + cupom.getCodigo() + " - Desconto: " + cupom.getPercentualDesconto() + "%");
        }
        System.out.println("Total: R$" + calcularTotal());
    }
    
}
