import java.util.List;
import model.Equipamento;
import dao.EquipamentoDAO;
import negocio.IEquipamentoService;

public class EquipamentoServiceImpl implements IEquipamentoService {
    private EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

    @Override
    public boolean verificarEstoqueDisponivel(int idEquipamento, int quantidade) {
        Equipamento eq = equipamentoDAO.buscarPorId(idEquipamento);
        return eq != null && eq.getQuantidadeEstoque() >= quantidade;
    }

    @Override
    public Equipamento buscarEquipamentoPorId(int id) {
        return equipamentoDAO.buscarPorId(id);
    }

    @Override
    public List<Equipamento> listarEquipamentos() {
        return equipamentoDAO.listarTodos();
    }
}
