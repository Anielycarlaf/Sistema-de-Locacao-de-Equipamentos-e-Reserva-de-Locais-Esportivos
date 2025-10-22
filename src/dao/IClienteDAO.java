package dao;

import java.util.List;
import model.Cliente;

public interface IClienteDAO {
    void adicionar(Cliente c);
    List<Cliente> listar();
    boolean atualizar(int id, String novoNome, String novoDocumento, String novoTelefone, String novoEmail);
    boolean remover(int id);
}
