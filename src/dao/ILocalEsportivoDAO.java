package dao;

import java.util.List;
import model.LocalEsportivo;

public interface ILocalEsportivoDAO {
    void adicionar(LocalEsportivo l);
    List<LocalEsportivo> listar();
    boolean atualizar(int id, String nome, String tipo, int capacidade, String recursos, double valorReserva);
    boolean remover(int id);
}
