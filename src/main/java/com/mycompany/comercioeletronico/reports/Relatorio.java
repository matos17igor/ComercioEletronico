package com.mycompany.comercioeletronico.reports;
import com.mycompany.comercioeletronico.models.Vendas;
import com.mycompany.comercioeletronico.models.Cupom;
import java.util.*;

public interface Relatorio {
    void gerarRelatorioVendas(List<Vendas> vendas);
    void listarCuponsAtivos(List<Cupom> cupons);
}


