package dao;

import java.util.ArrayList;
import java.util.List;
import model.LocalEsportivo;

public class LocalEsportivoDAOImpl implements ILocalEsportivoDAO {
    private List<LocalEsportivo> locais = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(LocalEsportivo l) {
        l.setId(proximoId++);
        locais.add(l);
    }

    @Override
    public List<LocalEsportivo> listar() {
        return locais;
    }

    @Override
    public boolean atualizar(int id, String nome, String tipo, int capacidade, String recursos, double valorReserva) {
        for (LocalEsportivo l : locais) {
            if (l.getId() == id) {
                l.setNome(nome);
                l.setTipo(tipo);
                l.setCapacidade(capacidade);
                l.setRecursos(recursos);
                l.setValorReserva(valorReserva);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return locais.removeIf(l -> l.getId() == id);
    }
}
