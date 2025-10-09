public class RegrasRestricoes {

    // Não permitir a reserva de local acima da capacidade máxima cadastrada
    public static boolean validarCapacidade(Local local, int participantes) {
        if (participantes > local.getCapacidade()) {
            System.out.println(" Erro: O número de participantes excede a capacidade máxima do local (" + local.getCapacidade() + ").");
            return false;
        }
        return true;
    }

    // Não permitir reserva de equipamentos em quantidade superior ao estoque disponível
    public static boolean validarQuantidadeEquipamentos(Equipamento equipamento, int quantidadeSolicitada) {
        if (quantidadeSolicitada > equipamento.getQuantidadeDisponivel()) {
            System.out.println(" Erro: Quantidade solicitada de " + equipamento.getNome() + " excede o estoque disponível (" + equipamento.getQuantidadeDisponivel() + ").");
            return false;
        }
        return true;
    }

    // Bloquear reservas e empréstimos para clientes com pendências de devolução ou pagamento
    public static boolean validarClienteHabilitado(Cliente cliente) {
        if (cliente.temPendencias()) {
            System.out.println(" Erro: Cliente " + cliente.getNome() + " possui pendências de devolução ou pagamento.");
            return false;
        }
        return true;
    }

    // Apenas funcionários autorizados podem registrar manutenção em equipamentos e locais
    public static boolean validarPermissaoManutencao(Funcionario funcionario) {
        if (!funcionario.isAutorizadoManutencao()) {
            System.out.println(" Erro: Funcionário " + funcionario.getNome() + " não possui permissão para registrar manutenções.");
            return false;
        }
        return true;
    }
}
