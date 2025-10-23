package dao;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioDAOImpl implements IFuncionarioDAO {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Funcionario f) {
        f.setId(proximoId++);
        funcionarios.add(f);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarios;
    }

    @Override
    public boolean atualizar(int id, String nome, String cargo, String telefone, String email, boolean autorizado) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                f.setNome(nome);
                f.setCargo(cargo);
                f.setTelefone(telefone);
                f.setEmail(email);
                f.setAutorizadoManutencao(autorizado);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return funcionarios.removeIf(f -> f.getId() == id);
    }
}
