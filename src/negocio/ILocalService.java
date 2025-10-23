import java.util.List;
import model.Local;

public interface ILocalService {
    boolean verificarCapacidadeDisponivel(int idLocal, int capacidadeSolicitada);
    Local buscarLocalPorId(int id);
    List<Local> listarLocais();
}
