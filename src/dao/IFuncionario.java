package dao;

import java.util.List;
import model.Funcionario;

public interface IFuncionarioDAO {
    void adicionar(Funcionario f);
    List<Funcionario> listar();
    boolean atualizar(int id, String nome, String cargo, String telefone, String email, boolean autorizado);
    boolean remover(int id);
}
