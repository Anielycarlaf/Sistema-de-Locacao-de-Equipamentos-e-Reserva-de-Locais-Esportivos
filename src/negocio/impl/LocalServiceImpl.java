import java.util.List;
import model.Local;
import dao.LocalDAO;
import negocio.ILocalService;

public class LocalServiceImpl implements ILocalService {
    private LocalDAO localDAO = new LocalDAO();

    @Override
    public boolean verificarCapacidadeDisponivel(int idLocal, int capacidadeSolicitada) {
        Local local = localDAO.buscarPorId(idLocal);
        return local != null && capacidadeSolicitada <= local.getCapacidadeMaxima();
    }

    @Override
    public Local buscarLocalPorId(int id) {
        return localDAO.buscarPorId(id);
    }

    @Override
    public List<Local> listarLocais() {
        return localDAO.listarTodos();
    }
}
