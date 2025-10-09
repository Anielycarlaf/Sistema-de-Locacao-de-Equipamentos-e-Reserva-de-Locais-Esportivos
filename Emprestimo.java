import java.time.LocalDateTime;

public class Emprestimo {
    private int id;
    private Equipamento equipamento;
    private Cliente cliente;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucaoPrevista;
    private LocalDateTime dataDevolucaoReal;
    private String status; // ativo, atrasado, devolvido
    private double multa;

    public Emprestimo() {}

    public Emprestimo(int id, Equipamento equipamento, Cliente cliente,
                      LocalDateTime dataEmprestimo, LocalDateTime dataDevolucaoPrevista,
                      LocalDateTime dataDevolucaoReal, String status, double multa) {
        this.id = id;
        this.equipamento = equipamento;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = status;
        this.multa = multa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDateTime getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(LocalDateTime dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public LocalDateTime getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) { this.dataDevolucaoPrevista = dataDevolucaoPrevista; }

    public LocalDateTime getDataDevolucaoReal() { return dataDevolucaoReal; }
    public void setDataDevolucaoReal(LocalDateTime dataDevolucaoReal) { this.dataDevolucaoReal = dataDevolucaoReal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getMulta() { return multa; }
    public void setMulta(double multa) { this.multa = multa; }

    @Override
    public String toString() {
        return "Emprestimo [id=" + id + ", equipamento=" + equipamento.getNome() + ", cliente=" + cliente.getNome() + "]";
    }
}
