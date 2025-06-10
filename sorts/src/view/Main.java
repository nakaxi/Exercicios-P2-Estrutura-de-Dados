package view;

import javax.swing.JOptionPane;
import controller.*;

public class Main {

	public static void main(String[] args) {
		int opc = 0; 
		String menuprincipal =  "1 - quick sort\n" +
								"2 - merge sort\n" +
								"3 - bubble sort\n" +
								"4 - comparador\n" +
								"9 - finalizar programa";
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menuprincipal));
			switch (opc) {
			case 1:
				Quicky qk = new Quicky();
				int ini;
				int fim;
				int q = Integer.parseInt(JOptionPane.showInputDialog("digite o tamanho do vetor"));
				int[] vtq = new int[q];
				for (int i = 0; i < q; i++) {
					vtq[i] = Integer.parseInt(JOptionPane.showInputDialog("digite um valor"));
				}
				ini = 0;
				fim = q - 1;
				qk.menuqk(vtq, ini, fim);
				break;
			case 2:
				Merger mg = new Merger();
				int m = Integer.parseInt(JOptionPane.showInputDialog("digite o tamanho do vetor"));
				int[] vtm = new int[m];
				int[] aux = new int[m];
				for (int i = 0; i < m; i++) {
					vtm[i] = Integer.parseInt(JOptionPane.showInputDialog("digite um valor"));
				}
				int inicio = 0;
				int fin = m - 1;
				mg.menu(vtm, inicio, fin, aux);
				break;
			case 3:
				SortearBolhas sb = new SortearBolhas();
				int b = Integer.parseInt(JOptionPane.showInputDialog("digite o tamanho do vetor"));
				int[] vtb = new int[b];
				for (int i = 0; i < b; i++) {
					vtb[i] = Integer.parseInt(JOptionPane.showInputDialog("digite um valor"));
				}
				sb.bolahs(vtb);
				break;
			case 4:
				Comparador cp = new Comparador();
				int c = Integer.parseInt(JOptionPane.showInputDialog("digite o tamanho do vetor"));
				int[] vtc = new int[c];
				int[] auxc = new int[c];
				for (int i = 0; i < c; i++) {
					vtc[i] = Integer.parseInt(JOptionPane.showInputDialog("digite um valor"));
				}
				cp.menu(vtc, c, auxc);
				break;
			case 9:
				System.out.println("--- programa finalizado ---");
				JOptionPane.showMessageDialog(null, "finalizando programa...");
				break;
			default: JOptionPane.showMessageDialog(null, "op��o invalida...");
			}	
		} while(opc != 9);

	}

}
