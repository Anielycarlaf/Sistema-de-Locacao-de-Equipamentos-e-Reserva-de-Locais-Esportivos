package dao;

import java.util.ArrayList;
import java.util.List;
import model.Locacao;

public class LocacaoDAOImpl implements ILocacaoDAO {
    private List<Locacao> locacoes = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Locacao l) {
        l.setId(proximoId++);
        locacoes.add(l);
    }

    @Override
    public List<Locacao> listar() {
        return locacoes;
    }

    @Override
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

    @Override
    public boolean remover(int id) {
        return locacoes.removeIf(l -> l.getId() == id);
    }
}
