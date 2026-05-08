/*PriorityQueue com Números Aleatórios*/
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Exercicio4 {
    public static void main(String[] args) {
        Random random = new Random();
        Queue<Integer> fila = new PriorityQueue<>();

        System.out.print("Números adicionados: [");
        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(100) + 1;
            fila.offer(numero);
            System.out.print(numero + (i < 9 ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("Fila interna: " + fila);
        System.out.println("\nRemovendo em ordem:");

        while (!fila.isEmpty()) {
            System.out.print(fila.poll());
            if (!fila.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("\nResposta: Os números não saem na ordem em que foram adicionados.");
        System.out.println("Eles saem em ordem crescente porque PriorityQueue ordena os elementos pelo menor prioridade/valor primeiro.");
    }
}
