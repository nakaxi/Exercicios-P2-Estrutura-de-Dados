package controller;

public class Quicky {
	
	public long[] menuqk(int[] vtq, int ini, int fim) {
		long[] lq = new long[3];
		int vtqd[] = new int[fim + 1];
		int vtqm[] = new int[fim + 1];
		for (int c = 0; c <= fim; c++) {
			vtqd[c] = vtq[c];
			vtqm[c] = vtq[c];
		}
		long tempoInicial = System.nanoTime();
		quick(vtq, ini, fim);
		long tempoFinal = System.nanoTime();
		long tempoTotal = tempoFinal - tempoInicial;
		for (int k = 0; k< vtq.length; k++) {
			System.out.print(vtq[k] + "/");
		}	
		System.out.println("\ntempo de execução do quick = " + tempoTotal + " nano segundos");
		System.out.println("--- quick realiazado ---");
		lq[0] = tempoTotal;
		//decresce ----------------------------------------------
		long tempoIniciald = System.nanoTime();
		quickd(vtqd, ini, fim);
		long tempoFinald = System.nanoTime();
		long tempoTotald = tempoFinald - tempoIniciald;
		for (int k = 0; k< vtqd.length; k++) {
			System.out.print(vtqd[k] + "/");
		}	
		System.out.println("\ntempo de execução do quick decrescente = " + tempoTotald + " nano segundos");
		System.out.println("--- quick decrescente realiazado ---");
		lq[1] = tempoTotald;
		//do meio -----------------------------------------------
		long tempoInicialm = System.nanoTime();
		quickm(vtqm, ini, fim);
		long tempoFinalm = System.nanoTime();
		long tempoTotalm = tempoFinalm - tempoInicialm;
		for (int k = 0; k< vtqm.length; k++) {
			System.out.print(vtqm[k] + "/");
		}	
		System.out.println("\ntempo de execução do quick com pivo no meio = " + tempoTotalm + " nano segundos");
		System.out.println("--- quick com pivo no meio realiazado ---");
		lq[2] = tempoTotalm;
		return lq;
	}
	
	// cresce ---
	public void quick(int[] vtq, int ini, int fim) {
		if (ini < fim) {
			int div = cresce(vtq, ini, fim);
			quick(vtq, ini, div - 1);
			quick(vtq, div, fim);
		}
	}
	
	public int cresce(int [] vtq, int ini, int fim) {
		int pivo = vtq[fim];
		int i = ini;
		int j = fim;
		int aux;
		do {
			while(i < j && vtq[i] <= pivo) {
				i++;
			}
			while(i < j && vtq[j] > pivo) {
				j--;
			}
			if (i < j) {
				aux = vtq[i];
				vtq [i] = vtq[j];
				vtq [j] = aux;
			}
		} while (i < j);
		return i;
	}
	
	// desce ---
	public void quickd(int[] vtqd, int ini, int fim) {
		if (ini < fim) {
			int div = naocresce(vtqd, ini, fim);
			quickd(vtqd, ini, div - 1);
			quickd(vtqd, div, fim);
		}
	}
	
	public int naocresce(int [] vtqd, int ini, int fim) {
		int pivo = vtqd[fim];
		int i = ini;
		int j = fim;
		int aux;
		do {
			while(i < j && vtqd[i] >= pivo) {
				i++;
			}
			while(i < j && vtqd[j] < pivo) {
				j--;
			}
			if (i < j) {
				aux = vtqd[i];
				vtqd [i] = vtqd[j];
				vtqd [j] = aux;
			}
		} while (i < j);
		return i;
	}
	
	// meio ---
	public void quickm(int[] vtqm, int ini, int fim) {
		if (ini < fim) {
			int div = crescem(vtqm, ini, fim);
			quickm(vtqm, ini, div - 1);
			quickm(vtqm, div, fim);
		}
	}
	
	public int crescem(int [] vtqm, int ini, int fim) {
		int meio = ini + (fim - ini) / 2;
	    int pivo = vtqm[meio];
		int i = ini;
		int j = fim;
		int aux;
		while (i <= j){
			while(vtqm[i] < pivo) {
				i++;
			}
			while(vtqm[j] > pivo) {
				j--;
			}
			if (i <= j) {
				aux = vtqm[i];
				vtqm [i] = vtqm[j];
				vtqm [j] = aux;
				i++;
				j--;
			}
		}
		return i;
	}
}
