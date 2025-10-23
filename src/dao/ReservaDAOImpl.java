package dao;

import java.util.ArrayList;
import java.util.List;
import model.Reserva;

public class ReservaDAOImpl implements IReservaDAO {
    private List<Reserva> reservas = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Reserva r) {
        r.setId(proximoId++);
        reservas.add(r);
    }

    @Override
    public List<Reserva> listar() {
        return reservas;
    }

    @Override
    public boolean atualizarStatus(int id, String novoStatus) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                r.setStatus(novoStatus);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return reservas.removeIf(r -> r.getId() == id);
    }
}
