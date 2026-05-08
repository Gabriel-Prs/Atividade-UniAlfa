import java.util.ArrayList;
import java.util.List;

public class Exercicio5 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<Double> precos = new ArrayList<>();

        nomes.add("Arroz");
        precos.add(12.50);

        nomes.add("Feijão");
        precos.add(8.75);

        nomes.add("Macarrão");
        precos.add(6.30);

        System.out.println("Relatório de compras:");
        double total = 0.0;

        for (int i = 0; i < nomes.size(); i++) {
            String nome = nomes.get(i);
            double preco = precos.get(i);
            total += preco;
            System.out.printf("Produto %d: %s - R$ %.2f%n", i + 1, nome, preco);
        }

        System.out.printf("Total: R$ %.2f%n", total);
    }
}
