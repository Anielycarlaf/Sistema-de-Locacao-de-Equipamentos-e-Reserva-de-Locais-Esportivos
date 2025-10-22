import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

package model;


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

    // ===== Getters e Setters =====

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

    // ===== Validação =====
    public boolean validarQuantidade(int quantidadeSolicitada) {
        if (quantidadeSolicitada > quantidade) {
            System.out.println("Erro: Quantidade solicitada de " + nome +
                    " excede o estoque disponível (" + quantidade + ").");
            return false;
        }
        return true;
    }

    // ======= MÉTODO DE RELATÓRIO COMPLETO =======

    /**
     * Gera relatório de equipamentos mais locados no período, com opção de exportar em PDF e CSV.
     */
    public static void gerarRelatorioEquipamentosMaisLocados(
            List<Locacao> locacoes,
            LocalDateTime inicio,
            LocalDateTime fim,
            String tipoFiltro,
            boolean exportarPdf,
            boolean exportarCsv) {

        Map<Equipamento, Integer> contadorEquipamentos = new HashMap<>();

        // Contabiliza o uso de cada equipamento dentro do período
        for (Locacao loc : locacoes) {
            if (loc.getDataEmprestimo().isAfter(inicio) && loc.getDataEmprestimo().isBefore(fim)) {
                for (Map.Entry<Equipamento, Integer> entry : loc.getEquipamentosLocados().entrySet()) {
                    Equipamento eq = entry.getKey();
                    if (tipoFiltro == null || eq.getTipo().equalsIgnoreCase(tipoFiltro)) {
                        contadorEquipamentos.merge(eq, entry.getValue(), Integer::sum);
                    }
                }
            }
        }

        // Agrupa por tipo
        Map<String, List<Map.Entry<Equipamento, Integer>>> agrupadoPorTipo = new HashMap<>();
        for (Map.Entry<Equipamento, Integer> e : contadorEquipamentos.entrySet()) {
            agrupadoPorTipo.computeIfAbsent(e.getKey().getTipo(), k -> new ArrayList<>()).add(e);
        }

        // ===== Impressão no console =====
        System.out.println("\n===== RELATÓRIO DE EQUIPAMENTOS MAIS LOCADOS =====");
        System.out.println("Período: " + inicio + " até " + fim);
        if (tipoFiltro != null)
            System.out.println("Filtro: " + tipoFiltro);
        System.out.println("===============================================");

        agrupadoPorTipo.forEach((tipo, lista) -> {
            System.out.println("\nTipo: " + tipo);
            lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            for (Map.Entry<Equipamento, Integer> entry : lista) {
                Equipamento eq = entry.getKey();
                System.out.printf(" - %-25s | Local: %-15s | Total locado: %d%n",
                        eq.getNome(), eq.getLocalAssociado().getNome(), entry.getValue());
            }
        });
        System.out.println("===============================================");

        // ===== Exportações =====
        if (exportarPdf) exportarRelatorioPdf(agrupadoPorTipo, inicio, fim, tipoFiltro);
        if (exportarCsv) exportarRelatorioCsv(agrupadoPorTipo, inicio, fim, tipoFiltro);
    }

    // ===== Exportar PDF =====
    private static void exportarRelatorioPdf(
            Map<String, List<Map.Entry<Equipamento, Integer>>> dados,
            LocalDateTime inicio,
            LocalDateTime fim,
            String tipoFiltro) {
        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, new java.io.FileOutputStream("relatorio_equipamentos.pdf"));
            documento.open();

            documento.add(new Paragraph("RELATÓRIO DE EQUIPAMENTOS MAIS LOCADOS",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            documento.add(new Paragraph("Período: " + inicio + " até " + fim));
            if (tipoFiltro != null)
                documento.add(new Paragraph("Filtro: " + tipoFiltro));
            documento.add(new Paragraph(" "));

            for (String tipo : dados.keySet()) {
                documento.add(new Paragraph("Tipo: " + tipo,
                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13)));
                PdfPTable tabela = new PdfPTable(3);
                tabela.addCell("Equipamento");
                tabela.addCell("Local");
                tabela.addCell("Total Locado");

                for (Map.Entry<Equipamento, Integer> entry : dados.get(tipo)) {
                    tabela.addCell(entry.getKey().getNome());
                    tabela.addCell(entry.getKey().getLocalAssociado().getNome());
                    tabela.addCell(String.valueOf(entry.getValue()));
                }

                documento.add(tabela);
                documento.add(new Paragraph(" "));
            }

            documento.close();
            System.out.println(" Relatório PDF gerado com sucesso: relatorio_equipamentos.pdf");

        } catch (Exception e) {
            System.err.println("Erro ao gerar PDF: " + e.getMessage());
        }
    }

    // ===== Exportar CSV =====
    private static void exportarRelatorioCsv(
            Map<String, List<Map.Entry<Equipamento, Integer>>> dados,
            LocalDateTime inicio,
            LocalDateTime fim,
            String tipoFiltro) {
        try (FileWriter writer = new FileWriter("relatorio_equipamentos.csv")) {
            writer.append("Tipo;Equipamento;Local;Total Locado\n");

            for (String tipo : dados.keySet()) {
                for (Map.Entry<Equipamento, Integer> entry : dados.get(tipo)) {
                    writer.append(tipo).append(";")
                            .append(entry.getKey().getNome()).append(";")
                            .append(entry.getKey().getLocalAssociado().getNome()).append(";")
                            .append(String.valueOf(entry.getValue())).append("\n");
                }
            }

            System.out.println(" Relatório CSV gerado com sucesso: relatorio_equipamentos.csv");

        } catch (IOException e) {
            System.err.println("Erro ao gerar CSV: " + e.getMessage());
        }
    }
}
