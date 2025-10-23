import java.util.List;
import model.Funcionario;
import model.Equipamento;
import model.Local;

public interface IFuncionarioService {
    boolean registrarManutencaoEquipamento(Funcionario funcionario, Equipamento equipamento);
    boolean registrarManutencaoLocal(Funcionario funcionario, Local local);
    Funcionario buscarFuncionarioPorId(int id);
    List<Funcionario> listarFuncionarios();
}
