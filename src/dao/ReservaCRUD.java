import java.util.ArrayList;
import java.util.List;
package dao;
import model.*;


public class ReservaCRUD {
    private List<Reserva> reservas = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(Reserva r) {
        r.setId(proximoId++);
        reservas.add(r);
    }

    public List<Reserva> listar() {
        return reservas;
    }

    public boolean atualizarStatus(int id, String novoStatus) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                r.setStatus(novoStatus);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return reservas.removeIf(r -> r.getId() == id);
    }
}
