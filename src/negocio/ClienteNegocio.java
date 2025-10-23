package com.sistemaesportivo.negocio;

import com.sistemaesportivo.model.Cliente;
import java.util.List;

public interface ClienteNegocio {
    Cliente criarCliente(Cliente cliente);
    Cliente atualizarCliente(Cliente cliente);
    boolean removerCliente(Long id);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    boolean temPendencias(Long clienteId);
}
