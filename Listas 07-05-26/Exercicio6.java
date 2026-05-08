/*Agenda de Contatos*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();
        List<String> telefones = new ArrayList<>();
        int opcao;

        do {
            System.out.println("--- AGENDA DE CONTATOS ---");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Buscar contato");
            System.out.println("3 - Remover contato");
            System.out.println("4 - Listar todos");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    nomes.add(nome);
                    telefones.add(telefone);
                    System.out.println("Contato adicionado.\n");
                    break;
                case 2:
                    System.out.print("Nome para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    int posBusca = nomes.indexOf(nomeBusca);
                    if (posBusca >= 0) {
                        System.out.println("Telefone: " + telefones.get(posBusca) + "\n");
                    } else {
                        System.out.println("Contato não encontrado.\n");
                    }
                    break;
                case 3:
                    System.out.print("Nome para remover: ");
                    String nomeRemocao = scanner.nextLine();
                    int posRemocao = nomes.indexOf(nomeRemocao);
                    if (posRemocao >= 0) {
                        nomes.remove(posRemocao);
                        telefones.remove(posRemocao);
                        System.out.println("Contato removido.\n");
                    } else {
                        System.out.println("Contato não encontrado.\n");
                    }
                    break;
                case 4:
                    System.out.println("Lista de contatos:");
                    for (int i = 0; i < nomes.size(); i++) {
                        System.out.printf("%d - %s - %s%n", i + 1, nomes.get(i), telefones.get(i));
                    }
                    if (nomes.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    }
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
