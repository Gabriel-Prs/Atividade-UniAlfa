/*Processador de Tarefas com Prioridade Personalizado*/
import java.util.PriorityQueue;
import java.util.Queue;

class Tarefa implements Comparable<Tarefa> {
    private String nome;
    private int prioridade;
    private int timestamp;
    private static int contador = 0;

    public Tarefa(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.timestamp = contador++;
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo(Tarefa outra) {
        if (this.prioridade != outra.prioridade) {
            return Integer.compare(this.prioridade, outra.prioridade);
        }
        return Integer.compare(this.timestamp, outra.timestamp);
    }

    @Override
    public String toString() {
        return nome + " (Prioridade: " + prioridade + ")";
    }
}

public class Exercicio6 {
    public static void main(String[] args) {
        Queue<Tarefa> tarefas = new PriorityQueue<>();

        // Adicionando tarefas fora de ordem
        tarefas.add(new Tarefa("Fazer backup", 2));
        tarefas.add(new Tarefa("Reiniciar servidor", 1));
        tarefas.add(new Tarefa("Limpar logs", 3));
        tarefas.add(new Tarefa("Atualizar sistema", 1));
        tarefas.add(new Tarefa("Responder emails", 2));

        System.out.println("Tarefas adicionadas:");
        int contador = 1;
        for (Tarefa t : tarefas) {
            System.out.println(contador + ". " + t);
            contador++;
        }

        System.out.println("\n=== EXECUTANDO TAREFAS ===");
        contador = 1;
        while (!tarefas.isEmpty()) {
            Tarefa tarefa = tarefas.poll();
            System.out.println(contador + ". " + tarefa);
            contador++;
        }
    }
}
