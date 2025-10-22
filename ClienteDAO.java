import java.util.*;

public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    // CREATE
    public void adicionarCliente(String nome, String documento, String telefone, String email) {
        Cliente c = new Cliente(proximoId++, nome, documento, telefone, email);
        clientes.add(c);
        System.out.println("Cliente adicionado: " + c);
    }

    // READ
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    // UPDATE
    public void atualizarCliente(int id, String novoNome, String novoTelefone) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNome(novoNome);
                c.setTelefone(novoTelefone);
                System.out.println("Cliente atualizado: " + c);
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    // DELETE
    public void removerCliente(int id) {
        clientes.removeIf(c -> c.getId() == id);
        System.out.println("Cliente removido com sucesso!");
    }
}
