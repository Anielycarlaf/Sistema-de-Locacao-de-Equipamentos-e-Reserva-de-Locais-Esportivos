import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Relatorio {



    public class RelatorioService {

        private List<UsoLocal> usosLocais;
        private List<UsoEquipamento> usosEquipamentos;
        private List<Cliente> clientes;

        public RelatorioService(List<UsoLocal> usosLocais, List<UsoEquipamento> usosEquipamentos, List<Cliente> clientes) {
            this.usosLocais = usosLocais;
            this.usosEquipamentos = usosEquipamentos;
            this.clientes = clientes;
        }

        public Map<String, Double> gerarRelatorioUsoLocais(LocalDate inicio, LocalDate fim) {
            return usosLocais.stream()
                    .filter(u -> !u.getData().isBefore(inicio) && !u.getData().isAfter(fim))
                    .collect(Collectors.groupingBy(
                            UsoLocal::getLocal,
                            Collectors.averagingDouble(UsoLocal::getTaxaOcupacao)
                    ));
        }

        public Map<String, Long> gerarRelatorioEquipamentosMaisUsados(LocalDate inicio, LocalDate fim) {
            return usosEquipamentos.stream()
                    .filter(e -> !e.getData().isBefore(inicio) && !e.getData().isAfter(fim))
                    .collect(Collectors.groupingBy(
                            UsoEquipamento::getEquipamento,
                            Collectors.counting()
                    ));
        }

        public Map<String, Long> gerarRelatorioClientesMaisAtivos(LocalDate inicio, LocalDate fim) {
            return clientes.stream()
                    .collect(Collectors.toMap(
                            Cliente::getNome,
                            c -> c.getReservas().stream()
                                    .filter(r -> !r.getData().isBefore(inicio) && !r.getData().isAfter(fim))
                                    .count()
                    ));
        }

        public void exportarRelatorioCSV(Map<String, ? extends Number> dados, String caminhoArquivo) {
            try (FileWriter writer = new FileWriter(caminhoArquivo)) {
                writer.write("Nome,Valor\n");
                for (Map.Entry<String, ? extends Number> entry : dados.entrySet()) {
                    writer.write(entry.getKey() + "," + entry.getValue() + "\n");
                }
                System.out.println("Relatório exportado com sucesso para " + caminhoArquivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void exportarRelatorioPDF(Map<String, ? extends Number> dados, String caminhoArquivo) {
            System.out.println("Exportação em PDF não implementada neste exemplo.");
        }
    }

    class UsoLocal {
        private String local;
        private LocalDate data;
        private double taxaOcupacao;

        public UsoLocal(String local, LocalDate data, double taxaOcupacao) {
            this.local = local;
            this.data = data;
            this.taxaOcupacao = taxaOcupacao;
        }

        public String getLocal() {
            return local;
        }

        public LocalDate getData() {
            return data;
        }

        public double getTaxaOcupacao() {
            return taxaOcupacao;
        }
    }

    class UsoEquipamento {
        private String equipamento;
        private LocalDate data;

        public UsoEquipamento(String equipamento, LocalDate data) {
            this.equipamento = equipamento;
            this.data = data;
        }

        public String getEquipamento() {
            return equipamento;
        }

        public LocalDate getData() {
            return data;
        }
    }

    class Cliente {
        private String nome;
        private List<Reserva> reservas;

        public Cliente(String nome, List<Reserva> reservas) {
            this.nome = nome;
            this.reservas = reservas;
        }

        public String getNome() {
            return nome;
        }

        public List<Reserva> getReservas() {
            return reservas;
        }
    }

    class Reserva {
        private LocalDate data;
        private String local;
        private String equipamento;

        public Reserva(LocalDate data, String local, String equipamento) {
            this.data = data;
            this.local = local;
            this.equipamento = equipamento;
        }

        public LocalDate getData() {
            return data;
        }

        public String getLocal() {
            return local;
        }

        public String getEquipamento() {
            return equipamento;
        }
    }

}
