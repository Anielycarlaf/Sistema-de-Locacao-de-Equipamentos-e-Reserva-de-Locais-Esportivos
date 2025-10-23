package dao;

import java.util.ArrayList;
import java.util.List;
import model.Equipamento;

public class EquipamentoDAOImpl implements IEquipamentoDAO {
    private List<Equipamento> equipamentos = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Equipamento e) {
        e.setId(proximoId++);
        equipamentos.add(e);
    }

    @Override
    public List<Equipamento> listar() {
        return equipamentos;
    }

    @Override
    public boolean atualizar(int id, String nome, String tipo, int quantidade, double valorLocacao, String condicao) {
        for (Equipamento e : equipamentos) {
            if (e.getId() == id) {
                e.setNome(nome);
                e.setTipo(tipo);
                e.setQuantidade(quantidade);
                e.setValorLocacao(valorLocacao);
                e.setCondicao(condicao);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return equipamentos.removeIf(e -> e.getId() == id);
    }
}
