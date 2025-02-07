package com.mycompany.comercioeletronico.models;

import com.mycompany.comercioeletronico.services.GestorVendas;
import com.mycompany.comercioeletronico.exceptions.CupomInvalidoException;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestorVendaTest {
    
    @Test
    void testGerarRelatorioVendas() throws CupomInvalidoException {
        Produto p1 = new Eletronicos(1, "Notebook", 3000, 12);
        Produto p2 = new Roupas(2, "Casaco", 120, "M", "Branco");
        
        Vendas venda1 = new Vendas(1);
        venda1.adicionarProduto(p1);
        
        Vendas venda2 = new Vendas(2);
        venda2.adicionarProduto(p2);
        
        List<Vendas> vendas = new ArrayList<>();
        vendas.add(venda1);
        vendas.add(venda2);
        
        GestorVendas gestor = new GestorVendas();
        
        assertEquals(2, vendas.size());
        assertEquals(3120, venda1.calcularTotal() + venda2.calcularTotal());
    }
    
    @Test
    void testListarCuponsAtivos() {
        CupomQuantidadeLimitada cupom1 = new CupomQuantidadeLimitada("CUPOM10", 10, 5);
        CupomValorMinimo cupom2 = new CupomValorMinimo("CUPOM15", 15, 200);
        CupomQuantidadeLimitada cupom3 = new CupomQuantidadeLimitada("EXPIRED", 5, 1);
        
        cupom3.podeSerAplicado(100);
        cupom3.podeSerAplicado(100);
        
        List<Cupom> cupons = new ArrayList<>();
        cupons.add(cupom1);
        cupons.add(cupom2);
        cupons.add(cupom3);
        
        GestorVendas gestor = new GestorVendas();
        gestor.listarCuponsAtivos(cupons);
        
        assertTrue(cupom1.isAtivo());
        assertTrue(cupom2.isAtivo());
        assertFalse(cupom3.isAtivo());
    }
}
