import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> descricoes = new ArrayList<>();
        List<Integer> prioridades = new ArrayList<>();
        int opcao;

        do {
            System.out.println("--- GERENCIADOR DE TAREFAS ---");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas por prioridade");
            System.out.println("3 - Marcar tarefa como concluída");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Prioridade (1=Alta, 2=Média, 3=Baixa): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    if (prioridade < 1 || prioridade > 3) {
                        System.out.println("Prioridade inválida. Use 1, 2 ou 3.\n");
                    } else {
                        descricoes.add(descricao);
                        prioridades.add(prioridade);
                        System.out.println("Tarefa adicionada.\n");
                    }
                    break;
                case 2:
                    System.out.println("--- MINHAS TAREFAS ---");
                    printPorPrioridade(descricoes, prioridades, 1, "ALTA");
                    printPorPrioridade(descricoes, prioridades, 2, "MÉDIA");
                    printPorPrioridade(descricoes, prioridades, 3, "BAIXA");
                    break;
                case 3:
                    System.out.print("Descrição da tarefa concluída: ");
                    String descricaoConcluida = scanner.nextLine();
                    int posicao = descricoes.indexOf(descricaoConcluida);
                    if (posicao >= 0) {
                        descricoes.remove(posicao);
                        prioridades.remove(posicao);
                        System.out.println("Tarefa removida.\n");
                    } else {
                        System.out.println("Tarefa não encontrada.\n");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void printPorPrioridade(List<String> descricoes, List<Integer> prioridades, int nivel, String nome) {
        System.out.println("=== PRIORIDADE " + nome + " ===");
        int contador = 1;
        for (int i = 0; i < descricoes.size(); i++) {
            if (prioridades.get(i) == nivel) {
                System.out.printf("%d. %s (Pri: %d)%n", contador, descricoes.get(i), nivel);
                contador++;
            }
        }
        if (contador == 1) {
            System.out.println("Nenhuma tarefa.");
        }
        System.out.println();
    }
}
