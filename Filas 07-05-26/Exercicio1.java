/*Fila de Números*/
import java.util.LinkedList;
import java.util.Queue;

public class Exercicio1 {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        fila.offer(1);
        fila.offer(2);
        fila.offer(3);
        fila.offer(4);
        fila.offer(5);

        while (!fila.isEmpty()) {
            Integer numero = fila.poll();
            System.out.println(numero);
        }
    }
}
