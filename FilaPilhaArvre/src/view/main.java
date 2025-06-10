package view;

import controller.*;
import javax.swing.*;

public class main {

	public static void main(String[] args) {
	    int opc;
	    String menuPrincipal = "Escolha uma lista:\n"
                + "1 - pilha\n"
                + "2 - verificador de expressao\n"
                + "3 - fila\n"
                + "4 - fila de duas pilhas\n"
                + "5 - arvore binaria\n"
                + "9 - sair";
	    do {
	    	opc = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opc) {
            case 1: Pilha.executar(); break;
            case 2: 
            	String expressao = JOptionPane.showInputDialog("Digite a expressão para verificar:");
            	boolean balanceada = VerificadorExpressao.verificarBalanceamento(expressao);
                if (balanceada) {
                    System.out.println("Expressão balanceada!");
                } else {
                    System.out.println("Expressão NÃO está balanceada.");
                }
            	break;
            case 3: Fila.executar(); break;
            case 4: FilaDuasP.executar(); break;
            case 5: ArBin.executar(); break;
            case 9: JOptionPane.showMessageDialog(null, "Encerrando..."); break;
            default: JOptionPane.showMessageDialog(null, "Opção inválida."); break;
            }
	    } while (opc != 9);
	}
}
