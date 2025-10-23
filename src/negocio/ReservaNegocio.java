package com.sistemaesportivo.negocio;

import com.sistemaesportivo.model.Reserva;
import java.util.List;

public interface ReservaNegocio {
    Reserva criarReserva(Reserva reserva);
    Reserva atualizarReserva(Reserva reserva);
    boolean cancelarReserva(Long id);
    Reserva buscarPorId(Long id);
    List<Reserva> listarTodas();
}
