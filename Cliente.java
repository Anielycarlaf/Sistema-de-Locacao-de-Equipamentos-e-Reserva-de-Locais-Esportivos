import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String documento;
    private String telefone;
    private String email;
    private List<Reserva> historicoReservas;
    private List<Locacao> historicoLocacoes;

    public Cliente() {}

    public Cliente(int id, String nome, String documento, String telefone, String email,
                   List<Reserva> historicoReservas, List<Locacao> historicoLocacoes) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.historicoReservas = historicoReservas;
        this.historicoLocacoes = historicoLocacoes;
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

    public String getDocumento() { 
        return documento; 
    }
    public void setDocumento(String documento) { 
        this.documento = documento;
    }

    public String getTelefone() { 
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { 
        this.email = email;
    }

    public List<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }
    public void setHistoricoReservas(List<Reserva> historicoReservas) {
        this.historicoReservas = historicoReservas;
    }

    public List<Locacao> getHistoricoLocacoes() {
        return historicoLocacoes;
    }
    public void setHistoricoLocacoes(List<Locacao> historicoLocacoes) {
        this.historicoLocacoes = historicoLocacoes;
    }
}


