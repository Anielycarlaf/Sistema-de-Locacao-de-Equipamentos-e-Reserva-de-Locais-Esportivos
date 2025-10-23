package com.sistemaesportivo.negocio;

import com.sistemaesportivo.model.Local;
import java.util.List;

public interface LocalNegocio {
    Local cadastrar(Local local);
    Local atualizar(Local local);
    boolean remover(Long id);
    Local buscarPorId(Long id);
    List<Local> listarTodos();
    boolean verificarDisponibilidade(Long id, String horario);
}
