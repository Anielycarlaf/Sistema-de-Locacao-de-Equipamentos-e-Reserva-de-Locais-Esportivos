import java.math.BigDecimal;
import java.time.LocalDate;
package model;
public class Pagamento {

    public enum StatusPagamento {
        PENDENTE,
        CONCLUIDO
    }

    public enum MetodoPagamento {
        DINHEIRO,
        CARTAO,
        PIX,
        TRANSFERENCIA
    }

    // Atributos
    private Long idPagamento;
    private Long idCliente;
    private BigDecimal valorTotal;
    private LocalDate dataPagamento;
    private MetodoPagamento metodoPagamento;
    private StatusPagamento statusPagamento;
    private BigDecimal multa;
    private String justificativaMulta;

    // Construtor
    public Pagamento(Long idCliente, BigDecimal valorTotal, MetodoPagamento metodoPagamento) {
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.metodoPagamento = metodoPagamento;
        this.statusPagamento = StatusPagamento.PENDENTE;
        this.multa = BigDecimal.ZERO;
    }

    // Métodos
    public void confirmarPagamento() {
        this.statusPagamento = StatusPagamento.CONCLUIDO;
        this.dataPagamento = LocalDate.now();
    }

    public void aplicarMulta(BigDecimal percentual, String justificativa) {
        if (percentual != null && percentual.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal valorMulta = valorTotal.multiply(percentual);
            this.multa = valorMulta;
            this.valorTotal = valorTotal.add(valorMulta);
            this.justificativaMulta = justificativa;
        }
    }

    public String gerarResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== PAGAMENTO ===");
        sb.append("\nCliente: ").append(idCliente);
        sb.append("\nValor total: R$ ").append(valorTotal);
        sb.append("\nMétodo: ").append(metodoPagamento);
        sb.append("\nStatus: ").append(statusPagamento);

        if (multa.compareTo(BigDecimal.ZERO) > 0) {
            sb.append("\nMulta: R$ ").append(multa);
            sb.append("\nJustificativa: ").append(justificativaMulta);
        }

        if (dataPagamento != null) {
            sb.append("\nData do pagamento: ").append(dataPagamento);
        }

        return sb.toString();
    }

    // Getters e Setters
    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public String getJustificativaMulta() {
        return justificativaMulta;
    }

    public void setJustificativaMulta(String justificativaMulta) {
        this.justificativaMulta = justificativaMulta;
    }
}

