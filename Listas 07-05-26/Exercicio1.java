/*Lista de Cores*/
import java.util.ArrayList;
import java.util.List;

public class Exercicio1 {
    public static void main(String[] args) {
        List<String> cores = new ArrayList<>();
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Roxo");

        for (String cor : cores) {
            System.out.println(cor);
        }
    }
}
