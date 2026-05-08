/*Filas usando LinkedList*/
import java.util.LinkedList;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("--- FILA DE ATENDIMENTO ---");
            System.out.println("1 - Adicionar pessoa à fila");
            System.out.println("2 - Chamar próxima pessoa");
            System.out.println("3 - Exibir quantidade na fila");
            System.out.println("4 - Exibir fila completa");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da pessoa: ");
                    String nome = scanner.nextLine();
                    fila.addLast(nome);
                    System.out.println("Pessoa adicionada à fila.\n");
                    break;
                case 2:
                    if (fila.isEmpty()) {
                        System.out.println("A fila está vazia.\n");
                    } else {
                        String proximo = fila.removeFirst();
                        System.out.println("Chamando: " + proximo + "\n");
                    }
                    break;
                case 3:
                    System.out.println("Pessoas na fila: " + fila.size() + "\n");
                    break;
                case 4:
                    System.out.println("Fila completa: " + fila);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
