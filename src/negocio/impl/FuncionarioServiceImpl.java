import java.util.List;
import model.Funcionario;
import model.Equipamento;
import model.Local;
import dao.FuncionarioDAO;
import negocio.IFuncionarioService;

public class FuncionarioServiceImpl implements IFuncionarioService {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    public boolean registrarManutencaoEquipamento(Funcionario funcionario, Equipamento equipamento) {
        if (!funcionario.isAutorizadoManutencao()) {
            System.out.println("Funcionário não autorizado para manutenção de equipamentos.");
            return false;
        }
        System.out.println("Manutenção registrada para o equipamento: " + equipamento.getNome());
        return true;
    }

    @Override
    public boolean registrarManutencaoLocal(Funcionario funcionario, Local local) {
        if (!funcionario.isAutorizadoManutencao()) {
            System.out.println("Funcionário não autorizado para manutenção de locais.");
            return false;
        }
        System.out.println("Manutenção registrada para o local: " + local.getNome());
        return true;
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioDAO.buscarPorId(id);
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listarTodos();
    }
}
