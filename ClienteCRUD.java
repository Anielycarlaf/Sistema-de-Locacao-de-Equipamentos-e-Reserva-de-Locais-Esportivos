import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(Cliente c) {
        c.setId(proximoId++);
        clientes.add(c);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public boolean atualizar(int id, String novoNome, String novoTelefone) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNome(novoNome);
                c.setTelefone(novoTelefone);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }
}
