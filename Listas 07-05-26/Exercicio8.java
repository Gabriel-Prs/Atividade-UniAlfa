import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite números (0 para encerrar):");
        while (true) {
            int valor = scanner.nextInt();
            if (valor == 0) {
                break;
            }
            numeros.add(valor);
        }

        List<Integer> listaFinal = new ArrayList<>();
        for (Integer numero : numeros) {
            if (!listaFinal.contains(numero)) {
                listaFinal.add(numero);
            }
        }

        System.out.println("Lista final: " + listaFinal);
        scanner.close();
    }
}
