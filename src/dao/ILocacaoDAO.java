package dao;

import java.util.List;
import model.Locacao;

public interface ILocacaoDAO {
    void adicionar(Locacao l);
    List<Locacao> listar();
    boolean atualizarStatus(int id, String novoStatus, double novaMulta);
    boolean remover(int id);
}
