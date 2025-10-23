import java.util.List;
import model.Locacao;

public interface ILocacaoService {
    boolean registrarLocacao(Locacao locacao);
    boolean registrarDevolucao(int idLocacao);
    List<Locacao> listarLocacoes();
}
