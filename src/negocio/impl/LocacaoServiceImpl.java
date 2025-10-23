import java.util.List;
import model.Locacao;
import dao.LocacaoDAO;
import negocio.ILocacaoService;

public class LocacaoServiceImpl implements ILocacaoService {
    private LocacaoDAO locacaoDAO = new LocacaoDAO();
    private ClienteServiceImpl clienteService = new ClienteServiceImpl();

    @Override
    public boolean registrarLocacao(Locacao locacao) {
        if (clienteService.clientePossuiPendencias(locacao.getCliente().getId())) {
            System.out.println("Cliente com pendência. Empréstimo bloqueado.");
            return false;
        }
        locacaoDAO.inserir(locacao);
        return true;
    }

    @Override
    public boolean registrarDevolucao(int idLocacao) {
        Locacao locacao = locacaoDAO.buscarPorId(idLocacao);
        if (locacao == null) return false;
        locacao.setDevolvido(true);
        locacaoDAO.atualizar(locacao);
        return true;
    }

    @Override
    public List<Locacao> listarLocacoes() {
        return locacaoDAO.listarTodos();
    }
}
