package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAOImpl implements IClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Cliente c) {
        c.setId(proximoId++);
        clientes.add(c);
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }

    @Override
    public boolean atualizar(int id, String nome, String documento, String telefone, String email) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNome(nome);
                c.setDocumento(documento);
                c.setTelefone(telefone);
                c.setEmail(email);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }
}
