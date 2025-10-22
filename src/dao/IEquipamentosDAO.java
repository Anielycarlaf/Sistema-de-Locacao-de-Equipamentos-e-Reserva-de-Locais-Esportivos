package dao;

import java.util.List;
import model.Equipamento;

public interface IEquipamentoDAO {
    void adicionar(Equipamento e);
    List<Equipamento> listar();
    boolean atualizar(int id, String nome, String tipo, int quantidade, double valorLocacao, String condicao);
    boolean remover(int id);
}
