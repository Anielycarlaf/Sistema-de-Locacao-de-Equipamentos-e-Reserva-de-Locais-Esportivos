import java.util.List;
import model.Reserva;
import dao.ReservaDAO;
import negocio.IReservaService;

public class ReservaServiceImpl implements IReservaService {
    private ReservaDAO reservaDAO = new ReservaDAO();
    private LocalServiceImpl localService = new LocalServiceImpl();
    private EquipamentoServiceImpl equipamentoService = new EquipamentoServiceImpl();
    private ClienteServiceImpl clienteService = new ClienteServiceImpl();

    @Override
    public boolean criarReserva(Reserva reserva) {
        // REQ25: bloqueio de clientes com pendências
        if (clienteService.clientePossuiPendencias(reserva.getCliente().getId())) {
            System.out.println("Cliente possui pendências e não pode reservar.");
            return false;
        }

        // REQ23: verificar capacidade do local
        if (!localService.verificarCapacidadeDisponivel(reserva.getLocal().getId(), reserva.getQtdPessoas())) {
            System.out.println("Capacidade do local excedida.");
            return false;
        }

        // REQ24: verificar estoque de equipamentos
        if (!equipamentoService.verificarEstoqueDisponivel(
                reserva.getEquipamento().getId(), reserva.getQuantidadeEquipamento())) {
            System.out.println("Quantidade de equipamentos excede o estoque.");
            return false;
        }

        reservaDAO.inserir(reserva);
        return true;
    }

    @Override
    public void cancelarReserva(int idReserva) {
        reservaDAO.remover(idReserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaDAO.listarTodos();
    }
}
