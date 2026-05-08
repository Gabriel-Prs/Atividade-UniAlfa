/*Fila de Impressão com Cancelamento*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Documento {
    private static int contadorId = 1;
    private int id;
    private String nomeDocumento;
    private String usuario;

    public Documento(String nomeDocumento, String usuario) {
        this.id = contadorId++;
        this.nomeDocumento = nomeDocumento;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return id + "-" + nomeDocumento + "(" + usuario + ")";
    }
}

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Documento> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("--- FILA DE IMPRESSÃO ---");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Imprimir próximo");
            System.out.println("3 - Cancelar documento");
            System.out.println("4 - Ver fila");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do documento: ");
                    String nomeDoc = scanner.nextLine();
                    System.out.print("Usuário: ");
                    String usuario = scanner.nextLine();
                    Documento doc = new Documento(nomeDoc, usuario);
                    fila.add(doc);
                    System.out.println("Documento #" + doc.getId() + " adicionado: " + doc.getNomeDocumento() + " (" + doc.getUsuario() + ")\n");
                    break;
                case 2:
                    if (fila.isEmpty()) {
                        System.out.println("Fila vazia. Nenhum documento para imprimir.\n");
                    } else {
                        Documento proximo = fila.poll();
                        System.out.println("Imprimindo: " + proximo + "\n");
                    }
                    break;
                case 3:
                    if (fila.isEmpty()) {
                        System.out.println("Fila vazia. Nenhum documento para cancelar.\n");
                        break;
                    }
                    System.out.print("ID do documento a cancelar: ");
                    int idCancelar = scanner.nextInt();
                    scanner.nextLine();
                    boolean encontrado = false;
                    for (Documento d : fila) {
                        if (d.getId() == idCancelar) {
                            fila.remove(d);
                            System.out.println("Documento #" + idCancelar + " cancelado: " + d.getNomeDocumento() + " (" + d.getUsuario() + ")\n");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Documento #" + idCancelar + " não encontrado na fila.\n");
                    }
                    break;
                case 4:
                    System.out.print("Fila: [");
                    boolean primeiro = true;
                    for (Documento d : fila) {
                        if (!primeiro) {
                            System.out.print(", ");
                        }
                        System.out.print(d);
                        primeiro = false;
                    }
                    System.out.println("]\n");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
