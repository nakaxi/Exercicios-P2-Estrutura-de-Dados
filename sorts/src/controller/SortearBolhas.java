package controller;

import javax.swing.JOptionPane;

public class SortearBolhas {
	public long bolahs(int [] vtb) {
		boolean pronto;
		int aux;
		long tempoInicial = System.nanoTime();
		for (int j = vtb.length; j > 1; j--) {
			pronto = true;
			for (int i = 0; i+1 < j; i++) {
				if (vtb[i] > vtb[i+1]) {
					aux = vtb[i];
					vtb[i] = vtb[i+1];
					vtb[i+1] = aux;
					pronto = false;
				}
			}
			if (pronto == true) {
				System.out.println("parou antes...");
				break;
			}
		}
		long tempoFinal = System.nanoTime();
		long tempoTotal = tempoFinal - tempoInicial;
		for(int k = 0; k < vtb.length; k++) {
			System.out.print(vtb[k] + "/");
		}
		System.out.println("\ntempo de execução do bubble = " + tempoTotal + " nano segundos");
		System.out.println("----- bubble realiazado -----");
		
		return tempoTotal;
	}
}
