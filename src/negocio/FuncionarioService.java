import model.Funcionario;
import model.Equipamento;
import model.Local;

public class FuncionarioService {

    // REQ26 — apenas funcionários autorizados
    public boolean registrarManutencaoEquipamento(Funcionario f, Equipamento e, String descricao) {
        if (!f.isAutorizadoManutencao()) {
            System.out.println("Erro: funcionário " + f.getNome() + " não possui autorização para registrar manutenções.");
            return false;
        }

        e.setEmManutencao(true);
        System.out.println("Manutenção registrada em " + e.getNome() + ": " + descricao);
        return true;
    }

    public boolean registrarManutencaoLocal(Funcionario f, Local l, String descricao) {
        if (!f.isAutorizadoManutencao()) {
            System.out.println("Erro: funcionário " + f.getNome() + " não possui autorização para registrar manutenções.");
            return false;
        }

        l.setEmManutencao(true);
        System.out.println("Manutenção registrada no local " + l.getNome() + ": " + descricao);
        return true;
    }
}
