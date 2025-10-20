public class Equipamento {
    private int id;
    private String nome;
    private String tipo; // ex: raquete, bola, apito
    private int quantidade;
    private double valorLocacao;
    private String condicaoAtual; // ex: bom, danificado
    private Local localAssociado; 
    private String status; // disponível, emprestado, reservado, em manutenção

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

    public int getQuantidade() { 
        return quantidade; 
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorLocacao() { 
        return valorLocacao;
    }
    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public String getCondicaoAtual() {
        return condicaoAtual; 
    }
    public void setCondicaoAtual(String condicaoAtual) { 
        this.condicaoAtual = condicaoAtual; 
    }

    public Local getLocalAssociado() {
        return localAssociado;
    }
    public void setLocalAssociado(Local localAssociado) {
        this.localAssociado = localAssociado; 
    }

    public String getStatus() { 
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public boolean validarQuantidade(int quantidadeSolicitada) {
        if (quantidadeSolicitada > quantidade) {
            System.out.println("Erro: Quantidade solicitada de " + nome +
                               " excede o estoque disponível (" + quantidade + ").");
            return false;
        }
        return true;
    }
    public static void gerarRelatorioEquipamentosMaisLocados(List<Locacao> locacoes,
                                                             LocalDateTime inicio,
                                                             LocalDateTime fim) {
        Map<Equipamento, Integer> contadorEquipamentos = new HashMap<>();

        // Contabiliza o uso de cada equipamento dentro do período
        for (Locacao loc : locacoes) {
            if (loc.getDataEmprestimo().isAfter(inicio) && loc.getDataEmprestimo().isBefore(fim)) {
                for (Map.Entry<Equipamento, Integer> entry : loc.getEquipamentosLocados().entrySet()) {
                    Equipamento eq = entry.getKey();
                    int qtd = entry.getValue();
                    contadorEquipamentos.merge(eq, qtd, Integer::sum);
                }
            }
        }

        // Ordena os equipamentos pelo número total de locações (decrescente)
        List<Map.Entry<Equipamento, Integer>> ranking = new ArrayList<>(contadorEquipamentos.entrySet());
        ranking.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\n===== RELATÓRIO: EQUIPAMENTOS MAIS LOCADOS =====");
        System.out.println("Período: " + inicio + " até " + fim);
        System.out.println("===============================================");

        if (ranking.isEmpty()) {
            System.out.println("Nenhum equipamento foi locado nesse período.");
        } else {
            int posicao = 1;
            for (Map.Entry<Equipamento, Integer> entry : ranking) {
                Equipamento eq = entry.getKey();
                System.out.println(posicao + "º - " + eq.getNome());
                System.out.println("Tipo: " + eq.getTipo());
                System.out.println("Local: " + eq.getLocalAssociado().getNome());
                System.out.println("Total de unidades locadas: " + entry.getValue());
                System.out.println("-----------------------------------------------");
                posicao++;
            }
        }

        System.out.println("===============================================");
    }
}
}

