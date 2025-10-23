package com.sistemaesportivo.service.impl;

import com.sistemaesportivo.model.Cliente;
import com.sistemaesportivo.negocio.ClienteNegocio;
import com.sistemaesportivo.negocio.impl.ClienteNegocioImpl;
import com.sistemaesportivo.repository.ClienteRepository;
import com.sistemaesportivo.service.ClienteService;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteNegocio clienteNegocio;

    public ClienteServiceImpl(ClienteRepository clienteRepo) {
        this.clienteNegocio = new ClienteNegocioImpl(clienteRepo);
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteNegocio.criarCliente(cliente);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteNegocio.atualizarCliente(cliente);
    }

    @Override
    public boolean removerCliente(Long id) {
        return clienteNegocio.removerCliente(id);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteNegocio.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteNegocio.listarTodos();
    }
}

