/*Menu de Atendimento*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um nome, 'atender', 'fila' ou 'sair': ");
            String comando = scanner.nextLine().trim();

            if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando...");
                break;
            } else if (comando.equalsIgnoreCase("fila")) {
                System.out.println("Fila atual: " + fila);
            } else if (comando.equalsIgnoreCase("atender")) {
                if (fila.isEmpty()) {
                    System.out.println("A fila está vazia. Nenhum cliente para atender.");
                } else {
                    String atendido = fila.poll();
                    System.out.println("Atendendo: " + atendido);
                }
            } else if (comando.isEmpty()) {
                System.out.println("Por favor, digite um nome ou um comando válido.");
            } else {
                fila.offer(comando);
                System.out.println(comando + " entrou na fila.");
            }
        }

        scanner.close();
    }
}
