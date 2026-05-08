/*Call Center com Níveis de Atendimento*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Chamada {
    private static int contadorId = 1;
    private int id;
    private String descricao;
    private int nivelAtual;

    public Chamada(String descricao) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.nivelAtual = 1;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void escalarNivel() {
        if (nivelAtual < 3) {
            nivelAtual++;
        }
    }

    @Override
    public String toString() {
        return "Chamada #" + id + ": " + descricao;
    }
}

public class Exercicio8 {
    public static void main(String[] args) {
        Random random = new Random();
        Queue<Chamada> nivel1 = new LinkedList<>();
        Queue<Chamada> nivel2 = new LinkedList<>();
        Queue<Chamada> nivel3 = new LinkedList<>();

        // Adicionando 5 chamadas no Nível 1
        nivel1.add(new Chamada("Problema com internet"));
        nivel1.add(new Chamada("Erro no sistema"));
        nivel1.add(new Chamada("Banco de dados lento"));
        nivel1.add(new Chamada("Email não funciona"));
        nivel1.add(new Chamada("Computador travando"));

        int resolvidasNivel1 = 0;
        int resolvidasNivel2 = 0;
        int resolvidasNivel3 = 0;

        System.out.println("=== SIMULAÇÃO CALL CENTER ===\n");

        while (!nivel1.isEmpty() || !nivel2.isEmpty() || !nivel3.isEmpty()) {
            Chamada chamada = null;

            // Pegar chamada da fila mais baixa disponível
            if (!nivel1.isEmpty()) {
                chamada = nivel1.poll();
            } else if (!nivel2.isEmpty()) {
                chamada = nivel2.poll();
            } else if (!nivel3.isEmpty()) {
                chamada = nivel3.poll();
            }

            if (chamada != null) {
                System.out.println("Atendendo " + chamada);
                boolean resolvida = false;
                Queue<Chamada> filaEscalada = null;

                while (!resolvida) {
                    int nivel = chamada.getNivelAtual();
                    System.out.print("  Nível " + nivel + ": ");

                    double chance = random.nextDouble();
                    if (nivel == 1 && chance < 0.7) {
                        System.out.println("RESOLVIDA");
                        resolvidasNivel1++;
                        resolvida = true;
                        if (filaEscalada != null) filaEscalada.remove(chamada);
                    } else if (nivel == 2 && chance < 0.5) {
                        System.out.println("RESOLVIDA");
                        resolvidasNivel2++;
                        resolvida = true;
                        if (filaEscalada != null) filaEscalada.remove(chamada);
                    } else if (nivel == 3) {
                        System.out.println("RESOLVIDA");
                        resolvidasNivel3++;
                        resolvida = true;
                        if (filaEscalada != null) filaEscalada.remove(chamada);
                    } else {
                        System.out.println("NÃO RESOLVIDA → escalando para Nível " + (nivel + 1));
                        chamada.escalarNivel();
                        // Mover para próxima fila
                        if (nivel == 1) {
                            nivel2.add(chamada);
                            filaEscalada = nivel2;
                        } else if (nivel == 2) {
                            nivel3.add(chamada);
                            filaEscalada = nivel3;
                        }
                        // Para nível 3, não move, pois sempre resolve
                    }
                }
                System.out.println();
            }
        }

        System.out.println("=== ESTATÍSTICAS FINAIS ===");
        System.out.println("Chamadas resolvidas no Nível 1: " + resolvidasNivel1);
        System.out.println("Chamadas resolvidas no Nível 2: " + resolvidasNivel2);
        System.out.println("Chamadas resolvidas no Nível 3: " + resolvidasNivel3);
        System.out.println("Total de chamadas: " + (resolvidasNivel1 + resolvidasNivel2 + resolvidasNivel3));
    }
}
