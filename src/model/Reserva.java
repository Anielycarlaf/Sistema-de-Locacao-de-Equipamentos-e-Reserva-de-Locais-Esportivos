import java.time.LocalDateTime;
import java.util.List;
package model;
public class Reserva {
    private int id;
    private Cliente cliente;
    private Local local;
    private List<Equipamento> equipamentos;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String status; // ativa, cancelada, concluída
    private Pagamento pagamento;

    public Reserva() {}

    public Reserva(int id, Cliente cliente, Local local, List<String> participantes,
                   List<Equipamento> equipamentos, LocalDateTime dataHoraInicio,
                   LocalDateTime dataHoraFim, String status, Pagamento pagamento) {
        this.id = id;
        this.cliente = cliente;
        this.local = local;
        this.participantes = participantes;
        this.equipamentos = equipamentos;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = status;
        this.pagamento = pagamento;
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

    public Local getLocal() {
        return local;
    }
    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos; 
    }
    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos; 
    }

    public LocalDateTime getDataHoraInicio() { 
        return dataHoraInicio;
    }
    public void setDataHoraInicio(LocalDateTime dataHoraInicio) { 
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }
    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
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
}

