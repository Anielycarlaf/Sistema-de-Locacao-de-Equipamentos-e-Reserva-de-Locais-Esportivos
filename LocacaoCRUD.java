import java.util.ArrayList;
import java.util.List;
package dao;
import model.*;


public class LocacaoCRUD {
    private List<Locacao> locacoes = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(Locacao l) {
        l.setId(proximoId++);
        locacoes.add(l);
    }

    public List<Locacao> listar() {
        return locacoes;
    }

    public boolean atualizarStatus(int id, String novoStatus, double novaMulta) {
        for (Locacao l : locacoes) {
            if (l.getId() == id) {
                l.setStatus(novoStatus);
                l.setMulta(novaMulta);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return locacoes.removeIf(l -> l.getId() == id);
    }
}
