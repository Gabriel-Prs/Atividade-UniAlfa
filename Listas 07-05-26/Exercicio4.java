/*Removendo números pequenos*/
import java.util.ArrayList;
import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(15);
        numeros.add(3);
        numeros.add(20);
        numeros.add(8);
        numeros.add(25);
        numeros.add(2);
        numeros.add(30);

        System.out.println("Lista antes da remoção: " + numeros);

        for (int i = numeros.size() - 1; i >= 0; i--) {
            if (numeros.get(i) < 10) {
                numeros.remove(i);
            }
        }

        System.out.println("Lista depois da remoção: " + numeros);
    }
}