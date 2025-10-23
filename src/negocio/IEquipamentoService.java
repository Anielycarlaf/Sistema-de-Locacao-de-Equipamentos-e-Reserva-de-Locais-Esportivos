import java.util.List;
import model.Equipamento;

public interface IEquipamentoService {
    boolean verificarEstoqueDisponivel(int idEquipamento, int quantidade);
    Equipamento buscarEquipamentoPorId(int id);
    List<Equipamento> listarEquipamentos();
}
