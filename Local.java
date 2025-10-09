import java.util.List;

public class Local {
    private int id;
    private String nome;
    private String tipo; // ex: quadra de futebol, quadra de tênis, sala de dança...
    private int capacidade;
    private List<String> recursos; // ex: iluminação, vestiário, placar eletrônico
    private double valorReserva;
    private String status; // disponível, reservado, em manutenção

    public Local() {}

    public Local(int id, String nome, String tipo, int capacidade, List<String> recursos,
                 double valorReserva, String status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.recursos = recursos;
        this.valorReserva = valorReserva;
        this.status = status;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNome() {
        return nome; 
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo; 
    }
    public void setTipo(String tipo) {
        this.tipo = tipo; 
    }

    public int getCapacidade() {
        return capacidade; 
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<String> getRecursos() {
        return recursos; 
    }
    public void setRecursos(List<String> recursos) {
        this.recursos = recursos; 
    }

    public double getValorReserva() {
        return valorReserva;
    }
    public void setValorReserva(double valorReserva) { 
        this.valorReserva = valorReserva; 
    }

    public String getStatus() {
        return status; 
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
