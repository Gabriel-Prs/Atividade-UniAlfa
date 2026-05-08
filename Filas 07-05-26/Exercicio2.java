/*Fila de Supermercado*/
import java.util.LinkedList;
import java.util.Queue;

public class Exercicio2 {
    public static void main(String[] args) {
        Queue<String> clientes = new LinkedList<>();

        clientes.offer("João");
        clientes.offer("Maria");
        clientes.offer("Pedro");
        clientes.offer("Ana");
        clientes.offer("Carlos");

        System.out.println("Fila inicial: " + clientes);
        System.out.println();

        int atendidos = 0;
        while (!clientes.isEmpty()) {
            String atendido = clientes.poll();
            System.out.println("Atendendo: " + atendido);
            atendidos++;
        }

        System.out.println();
        System.out.println("Total de clientes atendidos: " + atendidos);
        System.out.println("Fila final: " + clientes);
    }
}
