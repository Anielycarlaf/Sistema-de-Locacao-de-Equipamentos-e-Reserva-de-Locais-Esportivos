package com.sistemaesportivo.service.impl;

import com.sistemaesportivo.model.Equipamento;
import com.sistemaesportivo.negocio.EquipamentoNegocio;
import com.sistemaesportivo.negocio.impl.EquipamentoNegocioImpl;
import com.sistemaesportivo.repository.EquipamentoRepository;
import com.sistemaesportivo.service.EquipamentoService;
import java.util.List;

public class EquipamentoServiceImpl implements EquipamentoService {

    private final EquipamentoNegocio equipamentoNegocio;

    public EquipamentoServiceImpl(EquipamentoRepository equipamentoRepo) {
        this.equipamentoNegocio = new EquipamentoNegocioImpl(equipamentoRepo);
    }

    @Override
    public Equipamento cadastrar(Equipamento equipamento) {
        return equipamentoNegocio.cadastrar(equipamento);
    }

    @Override
    public Equipamento atualizar(Equipamento equipamento) {
        return equipamentoNegocio.atualizar(equipamento);
    }

    @Override
    public boolean remover(Long id) {
        return equipamentoNegocio.remover(id);
    }

    @Override
    public Equipamento buscarPorId(Long id) {
        return equipamentoNegocio.buscarPorId(id);
    }

    @Override
    public List<Equipamento> listarTodos() {
        return equipamentoNegocio.listarTodos();
    }

    @Override
    public boolean marcarIndisponivel(Long id) {
        return equipamentoNegocio.marcarIndisponivel(id);
    }

    @Override
    public boolean marcarDisponivel(Long id) {
        return equipamentoNegocio.marcarDisponivel(id);
    }
}
