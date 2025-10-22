
package model;

public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private String telefone;
    private String email;
    private boolean autorizadoManutencao;

    public Funcionario() {}

    public Funcionario(int id, String nome, String cargo, String telefone,
                       String email, boolean autorizadoManutencao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
        this.autorizadoManutencao = autorizadoManutencao;
    }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isAutorizadoManutencao() { return autorizadoManutencao; }
    public void setAutorizadoManutencao(boolean autorizadoManutencao) { this.autorizadoManutencao = autorizadoManutencao; }

    public boolean podeRegistrarManutencao() {
        if (!autorizadoManutencao) {
            System.out.println("Erro: Funcionário " + nome + " não possui permissão para registrar manutenções.");
            return false;
        }
        return true;
    }
}
