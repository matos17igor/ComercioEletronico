package com.mycompany.comercioeletronico.models;

import com.mycompany.comercioeletronico.exceptions.CupomInvalidoException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendaTest {
    private Vendas venda;
    private Produto produto1;
    private Produto produto2;
    private CupomQuantidadeLimitada cupom;
    
    @BeforeEach
    void setUp(){
        venda = new Vendas(1);
        produto1 = new Eletronicos(1, "Iphone", 3300, 12);
        produto2 = new Roupas(2, "Camisa", 65, "M", "Preta");
        cupom = new CupomQuantidadeLimitada("CUPOM10", 10, 1);
        
        venda.adicionarProduto(produto1);
        venda.adicionarProduto(produto2);
    }
    
    @Test
    void testCalculaTotalSemCupom(){
        assertEquals(3365, venda.calcularTotal());
    }
    
    @Test
    void testCalcularTotalComCupom() throws CupomInvalidoException{
        venda.aplicarCupom(cupom);
        assertEquals(3028.5, venda.calcularTotal());
    }
}
