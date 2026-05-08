/*Soma de Números*/
import java.util.ArrayList;
import java.util.List;

public class Exercicio2 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }

        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        System.out.println("A soma dos números é: " + soma);
    }
}
