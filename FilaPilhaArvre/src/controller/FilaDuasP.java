package controller;

import javax.swing.JOptionPane;

public class FilaDuasP {
	private Pilha pilha1;
    private Pilha pilha2;

    public FilaDuasP(int capacidade) {
        pilha1 = new Pilha(capacidade);
        pilha2 = new Pilha(capacidade);
    }

    public void enfileirar(Object elemento) {
        pilha1.push(elemento);
    }

    public Object desenfileirar() {
        if (pilha2.isEmpty()) {
            while (!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop());
            }
        }
        if (pilha2.isEmpty()) throw new RuntimeException("Fila vazia");
        return pilha2.pop();
    }
    
    public static void executar() {
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade da fila (duas pilhas):"));
        FilaDuasP fila = new FilaDuasP(capacidade);
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Fila com Duas Pilhas:\n" +
                "1 - Enfileirar\n" +
                "2 - Desenfileirar\n" +
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
                
                case 9: 
                	System.out.println("------ finalizando fila de duas pilha  ------");
                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;
                
                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida.");      
            }
        } while (opc != 9);
    }
}
