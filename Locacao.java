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
}

