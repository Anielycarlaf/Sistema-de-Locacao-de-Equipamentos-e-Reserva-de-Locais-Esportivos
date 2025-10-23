import java.util.List;
import model.Cliente;

public interface IClienteService {
    boolean clientePossuiPendencias(int idCliente);
    Cliente buscarClientePorId(int id);
    List<Cliente> listarClientes();
}
