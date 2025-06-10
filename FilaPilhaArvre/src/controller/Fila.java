package controller;

import javax.swing.JOptionPane;

public class Fila {
	 private Object[] elementos;
	    private int frente, tras, tamanho;

	    public Fila(int capacidade) {
	        elementos = new Object[capacidade];
	        frente = 0;
	        tras = 0;
	        tamanho = 0;
	    }

	    public void enfileirar(Object elemento) {
	        if (tamanho == elementos.length) throw new RuntimeException("Fila cheia");
	        elementos[tras] = elemento;
	        tras = (tras + 1) % elementos.length;
	        tamanho++;
	    }

	    public Object desenfileirar() {
	        if (isEmpty()) throw new RuntimeException("Fila vazia");
	        Object elemento = elementos[frente];
	        frente = (frente + 1) % elementos.length;
	        tamanho--;
	        return elemento;
	    }

	    public Object primeiro() {
	        if (isEmpty()) throw new RuntimeException("Fila vazia");
	        return elementos[frente];
	    }

	    public boolean isEmpty() {
	        return tamanho == 0;
	    }

	    public int size() {
	        return tamanho;
	    }
	    
	    public static void executar() {
	        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade da fila:"));
	        Fila fila = new Fila(capacidade);
	        int opc;

	        do {
	            opc = Integer.parseInt(JOptionPane.showInputDialog(
	                "Fila:\n" +
	                "1 - Enfileirar\n" +
	                "2 - Desenfileirar\n" +
	                "3 - Primeiro da fila\n" +
	                "4 - Está vazia?\n" +
	                "5 - Tamanho da fila\n" +
	                "9 - Voltar"
	            ));

	            switch (opc) {
	                case 1: 
	                    String valor = JOptionPane.showInputDialog("Informe o valor a ser enfileirado:");
	                    try {
	                        fila.enfileirar(valor);
	                        System.out.println("Valor enfileirado: " + valor);
	                    } catch (RuntimeException e) {
	                        System.out.println("Erro: " + e.getMessage());
	                    }
	                    break;
	                
	                case 2: 
	                    try {
	                        Object removido = fila.desenfileirar();
	                        System.out.println("Valor desenfileirado: " + removido);
	                    } catch (RuntimeException e) {
	                        System.out.println("Erro: " + e.getMessage());
	                    }
	                    break;
	                
	                case 3: 
	                    try {
	                        Object primeiro = fila.primeiro();
	                        System.out.println("Primeiro da fila: " + primeiro);
	                    } catch (RuntimeException e) {
	                        System.out.println("Erro: " + e.getMessage());
	                    }
	                    break;
	                
	                case 4: 
	                    System.out.println("A fila está vazia? " + fila.isEmpty());
	                    break;
	                
	                case 5: 
	                    System.out.println("Tamanho da fila: " + fila.size());
	                    break;
	                
	                case 9: 
	                	System.out.println("-------- finalizando fila  --------");
	                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
	                    break;
	                
	                default: 
	                    JOptionPane.showMessageDialog(null, "Opção inválida.");   
	            }
	        } while (opc != 9);
	    }
}
