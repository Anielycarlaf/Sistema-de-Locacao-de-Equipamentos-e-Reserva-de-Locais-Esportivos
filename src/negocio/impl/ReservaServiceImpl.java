package com.sistemaesportivo.service.impl;

import com.sistemaesportivo.model.Reserva;
import com.sistemaesportivo.negocio.ReservaNegocio;
import com.sistemaesportivo.negocio.impl.ReservaNegocioImpl;
import com.sistemaesportivo.repository.ReservaRepository;
import com.sistemaesportivo.repository.EquipamentoRepository;
import com.sistemaesportivo.repository.ClienteRepository;
import com.sistemaesportivo.service.ReservaService;

import java.util.List;

public class ReservaServiceImpl implements ReservaService {

    private final ReservaNegocio reservaNegocio;

    // Injetando dependências (repos já existem no seu projeto)
    public ReservaServiceImpl(ReservaRepository reservaRepo,
                              EquipamentoRepository equipamentoRepo,
                              ClienteRepository clienteRepo) {
        this.reservaNegocio = new ReservaNegocioImpl(reservaRepo, equipamentoRepo, clienteRepo);
    }

    @Override
    public Reserva criarReserva(Reserva reserva) {
        return reservaNegocio.criarReserva(reserva);
    }

    @Override
    public Reserva atualizarReserva(Reserva reserva) {
        return reservaNegocio.atualizarReserva(reserva);
    }

    @Override
    public boolean cancelarReserva(Long id) {
        return reservaNegocio.cancelarReserva(id);
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaNegocio.buscarPorId(id);
    }

    @Override
    public List<Reserva> listarTodas() {
        return reservaNegocio.listarTodas();
    }
}
