package com.sistemaesportivo.service.impl;

import com.sistemaesportivo.model.Pagamento;
import com.sistemaesportivo.negocio.PagamentoNegocio;
import com.sistemaesportivo.negocio.impl.PagamentoNegocioImpl;
import com.sistemaesportivo.repository.PagamentoRepository;
import com.sistemaesportivo.repository.ReservaRepository;
import com.sistemaesportivo.service.PagamentoService;
import java.util.List;

public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoNegocio pagamentoNegocio;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepo, ReservaRepository reservaRepo) {
        this.pagamentoNegocio = new PagamentoNegocioImpl(pagamentoRepo, reservaRepo);
    }

    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        return pagamentoNegocio.registrarPagamento(pagamento);
    }

    @Override
    public Pagamento confirmarPagamento(Long id) {
        return pagamentoNegocio.confirmarPagamento(id);
    }

    @Override
    public List<Pagamento> listarTodos() {
        return pagamentoNegocio.listarTodos();
    }
}
