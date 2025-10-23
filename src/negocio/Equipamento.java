package com.sistemaesportivo.negocio;

import com.sistemaesportivo.model.Equipamento;
import java.util.List;

public interface EquipamentoNegocio {
    Equipamento cadastrar(Equipamento equipamento);
    Equipamento atualizar(Equipamento equipamento);
    boolean remover(Long id);
    Equipamento buscarPorId(Long id);
    List<Equipamento> listarTodos();
    boolean marcarIndisponivel(Long id);
    boolean marcarDisponivel(Long id);
}
