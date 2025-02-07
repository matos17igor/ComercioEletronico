package com.mycompany.comercioeletronico.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class CupomTest {
    private CupomQuantidadeLimitada cupomLimitado;
    private CupomValorMinimo cupomMinimo;
    
    @BeforeEach
    void setUp(){
        cupomLimitado = new CupomQuantidadeLimitada("CUPOM10", 10, 2);
        cupomMinimo = new CupomValorMinimo("CUPOM20", 20, 500);
    }
    
    @Test
    public void testAplicarCupomQuantidadeLimitada() {
        assertTrue(cupomLimitado.podeSerAplicado(100));
        assertTrue(cupomLimitado.podeSerAplicado(100));
        assertFalse(cupomLimitado.podeSerAplicado(100));
    }
    
    @Test
    public void testCupomValorMinimo(){
        assertFalse(cupomMinimo.podeSerAplicado(400));
        assertTrue(cupomMinimo.podeSerAplicado(500));
    }
}
