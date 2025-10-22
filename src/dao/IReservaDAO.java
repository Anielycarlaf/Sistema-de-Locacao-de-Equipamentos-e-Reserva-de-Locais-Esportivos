package dao;

import java.util.List;
import model.Reserva;

public interface IReservaDAO {
    void adicionar(Reserva r);
    List<Reserva> listar();
    boolean atualizarStatus(int id, String novoStatus);
    boolean remover(int id);
}
