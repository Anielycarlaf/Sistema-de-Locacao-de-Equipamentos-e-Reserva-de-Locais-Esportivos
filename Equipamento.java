public class Equipamento {
    private int id;
    private String nome;
    private String tipo;
    private int quantidade;
    private double valorLocacao;
    private String condicaoAtual;
    private Local localAssociado;
    private String status; 

    public Equipamento() {}

    public Equipamento(int id, String nome, String tipo, int quantidade, double valorLocacao,
                       String condicaoAtual, Local localAssociado, String status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valorLocacao = valorLocacao;
        this.condicaoAtual = condicaoAtual;
        this.localAssociado = localAssociado;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorLocacao() { return valorLocacao; }
    public void setValorLocacao(double valorLocacao) { this.valorLocacao = valorLocacao; }

    public String getCondicaoAtual() { return condicaoAtual; }
    public void setCondicaoAtual(String condicaoAtual) { this.condicaoAtual = condicaoAtual; }

    public Local getLocalAssociado() { return localAssociado; }
    public void setLocalAssociado(Local localAssociado) { this.localAssociado = localAssociado; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Equipamento [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
    }
}
