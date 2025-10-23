import model.Cliente;
import model.Local;
import model.Equipamento;
import model.Reserva;
import dao.ReservaDAO;
import java.util.List;
import java.util.Map;

public class ReservaService {
    private ReservaDAO reservaDAO;

    public ReservaService(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    // REQ23 e REQ24 — validações antes de criar a reserva
    public boolean criarReserva(Reserva reserva) {
        Local local = reserva.getLocal();
        Cliente cliente = reserva.getCliente();

        // REQ23: verificar capacidade máxima do local
        if (reserva.getQuantidadePessoas() > local.getCapacidadeMaxima()) {
            System.out.println("Erro: capacidade máxima do local excedida.");
            return false;
        }

        // REQ24: verificar estoque de equipamentos
        for (Map.Entry<Equipamento, Integer> entry : reserva.getEquipamentosReservados().entrySet()) {
            Equipamento eq = entry.getKey();
            int quantidade = entry.getValue();

            if (quantidade > eq.getQuantidadeDisponivel()) {
                System.out.println("Erro: quantidade de " + eq.getNome() + " superior ao estoque disponível.");
                return false;
            }
        }

        // REQ25: checar pendências do cliente
        if (cliente.temPendencias()) {
            System.out.println("Erro: cliente possui pendências e não pode fazer reservas.");
            return false;
        }

        reservaDAO.adicionar(reserva);
        System.out.println("Reserva criada com sucesso!");
        return true;
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listar();
    }
}
