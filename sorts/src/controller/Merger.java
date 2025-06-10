package controller;

public class Merger {
	public long[] menu(int[] vtm, int inicio, int fin, int[] aux) {
		long[] lm = new long[2];
		int[] v = new int[fin + 1]; 
		for (int c = 0; c < fin + 1; c++) {
			v[c] = vtm[c];
		}
		long tempoInicial = System.nanoTime();
		int inv = merge(vtm, inicio, fin, aux);
		long tempoFinal = System.nanoTime();
		long tempoTotal = tempoFinal - tempoInicial;
		for (int k = 0; k< vtm.length; k++) {
			System.out.print(vtm[k] + "/");
		}	
		System.out.println("\ntempo de execução do merge = " + tempoTotal + " nano segundos");
		System.out.println("Número de inversões = " + inv);
		System.out.println("--- merge realiazado ---");
		lm[0] = tempoTotal;
		lm[1] = mergeit(v);
		return lm;
	}
	
	public int merge(int[] vtm, int inicio, int fin, int[] aux) {
		int meio = (fin + inicio) / 2;
		int cont = 0;
		if (inicio < fin) {
			cont += merge(vtm, inicio, meio, aux); 
			cont += merge(vtm, meio+1, fin, aux);
			cont += junta(vtm, inicio, meio, fin, aux);
		}
		return cont;
	}
	
	public int junta (int[] vtm, int inicio, int meio, int fin, int[] aux) {
		 int i = inicio; 
		 int j = meio+1; 
		 int k= 0; 
		 int cont= 0;
		 while (i <= meio && j <= fin) {
			 if (vtm[i] <= vtm[j]) {
				 aux[k] = vtm[i];
				 k++;
				 i++;
			 } else {
				 aux[k] = vtm[j];
				 k++;
				 j++;
				 cont += (meio - i + 1);
			}
		 }
		 
		 while (i <= meio) {
			 aux[k] = vtm[i];
			 k++;
			 i++;
		 }
		 
		 while (j <= fin) {
			 aux[k] = vtm[j];
			 k++;
			 j++;
		 }
		 
		 i = inicio;
		 k = 0;
		 while (i <= fin) {
			vtm[i] = aux[k];
		 	i++;
		 	k++;
		 }
		 return cont;
	}
	
	// iterativo
	public long mergeit(int[] v) {
		long tempoInicialit = System.nanoTime();
        int n = v.length;
        int[] aux = new int[n];

        for (int tamanho = 1; tamanho < n; tamanho *= 2) {
            for (int inicio = 0; inicio < n - 1; inicio += 2 * tamanho) {
                int meio = Math.min(inicio + tamanho - 1, n - 1);
                int fim = Math.min(inicio + 2 * tamanho - 1, n - 1);
                juntait(v, inicio, meio, fim, aux);
            }
        }
        long tempoFinalit = System.nanoTime();
        long tempoTotalit = tempoFinalit - tempoInicialit;

        System.out.println("Ordenado (iterativo):");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "/");
        }
        System.out.println("\ntempo de execução do merge iterativo = " + tempoTotalit + " nano segundos");
        System.out.println("--- merge iterativo realiazado ---");
        return tempoTotalit;
    }

    private void juntait(int[] v, int inicio, int meio, int fim, int[] aux) {
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (v[i] <= v[j]) {
                aux[k++] = v[i++];
            } else {
                aux[k++] = v[j++];
            }
        }
        while (i <= meio) aux[k++] = v[i++];
        while (j <= fim) aux[k++] = v[j++];

        for (int t = 0; t < k; t++) {
            v[inicio + t] = aux[t];
        }
    }
}
