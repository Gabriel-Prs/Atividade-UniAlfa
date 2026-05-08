/*Sistema de Atendimento com Duas Filas*/
import java.util.LinkedList;
import java.util.Queue;

public class Exercicio5 {
    public static void main(String[] args) {
        Queue<String> filaPrioritaria = new LinkedList<>();
        Queue<String> filaNormal = new LinkedList<>();

        // Adicionando pessoas às filas
        filaPrioritaria.add("Sr. José (80)");
        filaPrioritaria.add("Dona Maria (70)");
        filaPrioritaria.add("Sr. Pedro (65)");

        filaNormal.add("João");
        filaNormal.add("Maria");
        filaNormal.add("Carlos");
        filaNormal.add("Ana");
        filaNormal.add("Marcos");

        int atendidosPrioritarios = 0;
        int atendidosNormais = 0;

        System.out.println("=== INICIANDO ATENDIMENTO ===\n");

        while (!filaPrioritaria.isEmpty() || !filaNormal.isEmpty()) {
            // Atender 2 prioritários
            for (int i = 0; i < 2; i++) {
                if (!filaPrioritaria.isEmpty()) {
                    String pessoa = filaPrioritaria.poll();
                    System.out.println("Atendendo (Prioritário): " + pessoa);
                    atendidosPrioritarios++;
                } else {
                    System.out.println("Atendendo (Prioritário): (fila prioritária vazia)");
                }
            }

            // Atender 1 normal
            if (!filaNormal.isEmpty()) {
                String pessoa = filaNormal.poll();
                System.out.println("Atendendo (Normal): " + pessoa);
                atendidosNormais++;
            } else {
                System.out.println("Atendendo (Normal): (fila normal vazia)");
            }

            System.out.println();
        }

        System.out.println("=== FIM DO ATENDIMENTO ===");
        System.out.println("Total atendidos: " + (atendidosPrioritarios + atendidosNormais));
        System.out.println("- Prioritários: " + atendidosPrioritarios);
        System.out.println("- Normais: " + atendidosNormais);
    }
}
