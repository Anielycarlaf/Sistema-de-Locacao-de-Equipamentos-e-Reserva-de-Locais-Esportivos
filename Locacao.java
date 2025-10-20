import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

public class Locacao {
    private int id;
    private Cliente cliente;
    private Map<Equipamento, Integer> equipamentosLocados; // quantidade
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucaoPrevista;
    private LocalDateTime dataDevolucaoReal;
    private double multa;
    private String status; // ativo, atrasado, devolvido
    private Pagamento pagamento;
    private Reserva reservaVinculada; // opcional: locação pode vir de uma reserva

    public Locacao() {}

    public Locacao(int id, Cliente cliente, Map<Equipamento, Integer> equipamentosLocados,
                   LocalDateTime dataEmprestimo, LocalDateTime dataDevolucaoPrevista,
                   LocalDateTime dataDevolucaoReal, double multa, String status,
                   Pagamento pagamento, Reserva reservaVinculada) {
        this.id = id;
        this.cliente = cliente;
        this.equipamentosLocados = equipamentosLocados;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.multa = multa;
        this.status = status;
        this.pagamento = pagamento;
        this.reservaVinculada = reservaVinculada;
    }

    public int getId() { 
        return id;
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente;
    }

    public Map<Equipamento, Integer> getEquipamentosLocados() { 
        return equipamentosLocados;
    }
    public void setEquipamentosLocados(Map<Equipamento, Integer> equipamentosLocados) {
        this.equipamentosLocados = equipamentosLocados;
    
    }
    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucaoPrevista() { 
        return dataDevolucaoPrevista; 
    }
    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) { 
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDateTime getDataDevolucaoReal() { 
        return dataDevolucaoReal;
    }
    public void setDataDevolucaoReal(LocalDateTime dataDevolucaoReal) { 
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public double getMulta() { 
        return multa;
    }
    public void setMulta(double multa) { 
        this.multa = multa;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Pagamento getPagamento() { 
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento; 
    }

    public Reserva getReservaVinculada() { 
        return reservaVinculada;
    }
    public void setReservaVinculada(Reserva reservaVinculada) { 
        this.reservaVinculada = reservaVinculada;
    }
     public static void gerarRelatorioClientesMaisAtivos(List<Locacao> locacoes, List<Reserva> reservas) {
        Map<Cliente, Integer> contadorClientes = new HashMap<>();

        // Contabiliza locações
        for (Locacao loc : locacoes) {
            contadorClientes.merge(loc.getCliente(), 1, Integer::sum);
        }

        // Contabiliza reservas
        for (Reserva res : reservas) {
            contadorClientes.merge(res.getCliente(), 1, Integer::sum);
        }

        // Ordena os clientes por número de atividades (reservas + locações)
        List<Map.Entry<Cliente, Integer>> ranking = new ArrayList<>(contadorClientes.entrySet());
        ranking.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\n===== CLIENTES MAIS ATIVOS =====");
        int posicao = 1;
        for (Map.Entry<Cliente, Integer> entry : ranking) {
            System.out.println(posicao + "º - " + entry.getKey().getNome() + " → " + entry.getValue() + " atividades");
            posicao++;
        }

        if (ranking.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        }
        System.out.println("==================================");
    }
}
public static void gerarRelatorioPorPeriodo(List<Locacao> locacoes, LocalDateTime inicio, LocalDateTime fim) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n===== RELATÓRIO DE LOCAÇÕES =====");
        System.out.println("Período: " + fmt.format(inicio) + " até " + fmt.format(fim));
        System.out.println("==================================");

        int totalLocacoes = 0;
        double totalMultas = 0.0;

        for (Locacao loc : locacoes) {
            if (loc.getDataEmprestimo().isAfter(inicio) && loc.getDataEmprestimo().isBefore(fim)) {
                totalLocacoes++;
                totalMultas += loc.getMulta();

                System.out.println("\nID: " + loc.getId());
                System.out.println("Cliente: " + loc.getCliente().getNome());
                System.out.println("Data Empréstimo: " + fmt.format(loc.getDataEmprestimo()));
                System.out.println("Data Prevista: " + fmt.format(loc.getDataDevolucaoPrevista()));
                System.out.println("Status: " + loc.getStatus());
                System.out.println("Multa: R$ " + String.format("%.2f", loc.getMulta()));
            }
        }

        System.out.println("\n----------------------------------");
        System.out.println("Total de locações no período: " + totalLocacoes);
        System.out.println("Total arrecadado em multas: R$ " + String.format("%.2f", totalMultas));
        System.out.println("==================================");
    }
}
}

