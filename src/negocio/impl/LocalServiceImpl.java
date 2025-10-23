package com.sistemaesportivo.negocio.impl;

import com.sistemaesportivo.model.Local;
import com.sistemaesportivo.negocio.LocalNegocio;
import com.sistemaesportivo.repository.LocalRepository;
import java.util.List;

public class LocalNegocioImpl implements LocalNegocio {

    private final LocalRepository localRepo;

    public LocalNegocioImpl(LocalRepository localRepo) {
        this.localRepo = localRepo;
    }

    @Override
    public Local cadastrar(Local local) {

        if(local.getNome() == null || local.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do local é obrigatório");
        }
        return localRepo.save(local);
    }

    @Override
    public Local atualizar(Local local) {
        return localRepo.update(local);
    }

    @Override
    public boolean remover(Long id) {
        return localRepo.deleteById(id);
    }

    @Override
    public Local buscarPorId(Long id) {
        return localRepo.findById(id).orElse(null);
    }

    @Override
    public List<Local> listarTodos() {
        return localRepo.findAll();
    }

    @Override
    public boolean verificarDisponibilidade(Long id, String horario) {
        return true;
    }
}
