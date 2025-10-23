package com.sistemaesportivo.negocio;

import com.sistemaesportivo.model.Pagamento;
import java.util.List;

public interface PagamentoNegocio {
    Pagamento registrarPagamento(Pagamento pagamento);
    Pagamento confirmarPagamento(Long pagamentoId);
    List<Pagamento> listarTodos();
}
