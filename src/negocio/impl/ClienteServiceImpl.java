import java.util.List;
import model.Cliente;
import dao.ClienteDAO;
import negocio.IClienteService;

public class ClienteServiceImpl implements IClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public boolean clientePossuiPendencias(int idCliente) {
        Cliente cliente = clienteDAO.buscarPorId(idCliente);
        return cliente != null && (cliente.isEmAtraso() || cliente.isComPendencias());
    }

    @Override
    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteDAO.listarTodos();
    }
}
