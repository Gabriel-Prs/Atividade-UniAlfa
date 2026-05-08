import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio10 {
    private static final String ARQUIVO_TAREFAS = "tarefas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tarefas = carregarTarefas();
        int opcao;

        do {
            System.out.println("--- LISTA DE TAREFAS ---");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Listar tarefas");
            System.out.println("4 - Concluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    tarefas.add(descricao);
                    System.out.println("Tarefa adicionada.\n");
                    break;
                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa para remover.\n");
                        break;
                    }
                    listarTarefas(tarefas);
                    System.out.print("Número da tarefa a remover: ");
                    int indiceRemover = scanner.nextInt();
                    scanner.nextLine();
                    if (indiceRemover >= 1 && indiceRemover <= tarefas.size()) {
                        tarefas.remove(indiceRemover - 1);
                        System.out.println("Tarefa removida.\n");
                    } else {
                        System.out.println("Índice inválido.\n");
                    }
                    break;
                case 3:
                    listarTarefas(tarefas);
                    break;
                case 4:
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa para concluir.\n");
                        break;
                    }
                    listarTarefas(tarefas);
                    System.out.print("Número da tarefa concluída: ");
                    int indiceConcluir = scanner.nextInt();
                    scanner.nextLine();
                    if (indiceConcluir >= 1 && indiceConcluir <= tarefas.size()) {
                        tarefas.remove(indiceConcluir - 1);
                        System.out.println("Tarefa concluída e removida.\n");
                    } else {
                        System.out.println("Índice inválido.\n");
                    }
                    break;
                case 5:
                    salvarTarefas(tarefas);
                    System.out.println("Tarefas salvas. Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static List<String> carregarTarefas() {
        List<String> tarefas = new ArrayList<>();
        File arquivo = new File(ARQUIVO_TAREFAS);
        if (!arquivo.exists()) {
            return tarefas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    tarefas.add(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }

        return tarefas;
    }

    private static void salvarTarefas(List<String> tarefas) {
        try (FileWriter writer = new FileWriter(ARQUIVO_TAREFAS)) {
            for (String tarefa : tarefas) {
                writer.write(tarefa + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    private static void listarTarefas(List<String> tarefas) {
        System.out.println("Tarefas:");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.\n");
            return;
        }
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, tarefas.get(i));
        }
        System.out.println();
    }
}
