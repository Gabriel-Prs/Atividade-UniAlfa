/*Cadastro até "fim"*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();

        System.out.println("Digite nomes (digite fim para encerrar):");
        while (true) {
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            nomes.add(nome);
        }

        System.out.println("Nomes cadastrados:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        scanner.close();
    }
}
