import java.util.*;

public class EquipamentoDAO {
    private List<Equipamento> equipamentos = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(Equipamento e) {
        e = new Equipamento(proximoId++, e.getNome(), e.getTipo(), e.getQuantidade(), e.getValorLocacao(), e.getCondicao());
        equipamentos.add(e);
    }

    public List<Equipamento> listar() {
        return equipamentos;
    }

    public boolean atualizar(int id, String novoNome, int novaQtd, String novaCondicao) {
        for (Equipamento e : equipamentos) {
            if (e.getId() == id) {
                e.setNome(novoNome);
                e.setQuantidade(novaQtd);
                e.setCondicao(novaCondicao);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return equipamentos.removeIf(e -> e.getId() == id);
    }
}
