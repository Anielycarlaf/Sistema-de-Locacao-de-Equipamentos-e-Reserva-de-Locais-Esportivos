package com.sistemaesportivo.negocio.impl;

import com.sistemaesportivo.negocio.ClienteNegocio;
import com.sistemaesportivo.model.Cliente;
import com.sistemaesportivo.repository.ClienteRepository;
import java.util.List;

public class ClienteNegocioImpl implements ClienteNegocio {
    private final ClienteRepository clienteRepo;

    public ClienteNegocioImpl(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepo.update(cliente);
    }

    @Override
    public boolean removerCliente(Long id) {
        if (temPendencias(id)) {
            throw new IllegalStateException("Cliente possui pendências e não pode ser removido");
        }
        return clienteRepo.deleteById(id);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepo.findAll();
    }

    @Override
    public boolean temPendencias(Long clienteId) {
        // Regra simulada — depois pode verificar reservas ou pagamentos em aberto.
        return false;
    }
}
