import java.util.ArrayList;
import java.util.List;
package dao;
import model.*;


public class LocalEsportivoCRUD {
    private List<LocalEsportivo> locais = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(LocalEsportivo l) {
        l.setId(proximoId++);
        locais.add(l);
    }

    public List<LocalEsportivo> listar() {
        return locais;
    }

    public boolean atualizar(int id, String novoNome, int novaCapacidade) {
        for (LocalEsportivo l : locais) {
            if (l.getId() == id) {
                l.setNome(novoNome);
                l.setCapacidade(novaCapacidade);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return locais.removeIf(l -> l.getId() == id);
    }
}
