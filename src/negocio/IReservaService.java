import java.util.List;
import model.Reserva;

public interface IReservaService {
    boolean criarReserva(Reserva reserva);
    void cancelarReserva(int idReserva);
    List<Reserva> listarReservas();
}
