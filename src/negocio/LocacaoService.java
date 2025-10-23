import model.Cliente;
import model.Locacao;
import dao.LocacaoDAO;
import java.util.List;

public class LocacaoService {
    private LocacaoDAO locacaoDAO;

    public LocacaoService(LocacaoDAO locacaoDAO) {
        this.locacaoDAO = locacaoDAO;
    }

    // REQ25 — bloquear empréstimos de clientes inadimplentes
    public boolean registrarLocacao(Locacao locacao) {
        Cliente cliente = locacao.getCliente();

        if (cliente.temPendencias()) {
            System.out.println("Erro: cliente possui pendências e não pode realizar locações.");
            return false;
        }

        locacaoDAO.adicionar(locacao);
        System.out.println("Locação registrada com sucesso!");
        return true;
    }

    public List<Locacao> listarLocacoes() {
        return locacaoDAO.listar();
    }
}
