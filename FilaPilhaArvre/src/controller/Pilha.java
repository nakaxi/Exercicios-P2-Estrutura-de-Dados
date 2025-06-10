package controller;

import javax.swing.JOptionPane;

public class Pilha {
	private Object[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new Object[capacidade];
        topo = -1;
    }

    public void push(Object elemento) {
        if (topo == elementos.length - 1) throw new RuntimeException("Pilha cheia");
        elementos[++topo] = elemento;
    }

    public Object pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return elementos[topo--];
    }

    public Object peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }
    
    public static void executar() {
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade da pilha:"));
        Pilha pilha = new Pilha(capacidade);
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Pilha:\n" +
                "1 - Inserir (push)\n" +
                "2 - Remover (pop)\n" +
                "3 - Topo (peek)\n" +
                "4 - Está vazia? (isEmpty)\n" +
                "5 - Tamanho (size)\n" +
                "9 - Voltar"
            ));

            switch (opc) {
                case 1: 
                    String valor = JOptionPane.showInputDialog("Informe o valor a ser inserido:");
                    try {
                        pilha.push(valor);
                        System.out.println("Valor inserido: " + valor);
                    } catch (RuntimeException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                
                case 2: 
                    try {
                        Object removido = pilha.pop();
                        System.out.println("Valor removido: " + removido);
                    } catch (RuntimeException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                
                case 3: 
                    try {
                        Object topo = pilha.peek();
                        System.out.println("Topo da pilha: " + topo);
                    } catch (RuntimeException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                
                case 4: 
                    System.out.println("A pilha está vazia? " + pilha.isEmpty());
                    break;
                
                case 5: 
                    System.out.println("Tamanho da pilha: " + pilha.size());
                    break;
                
                case 9: 
                	System.out.println("------- finalizando pilha  -------");
                	JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;
                
                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                
            }
        } while (opc != 9);
    }
}
