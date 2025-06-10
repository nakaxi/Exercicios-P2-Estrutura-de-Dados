package controller;

public class Comparador {
	public void menu (int [] vtc, int c, int [] auxc) {
		c--;
		SortearBolhas sb = new SortearBolhas();
		Merger mg = new Merger();
		Quicky qk = new Quicky();
		long[] lt = new long[6];
		lt[0] = sb.bolahs(vtc);
		long[] lq = new long[3];
		lq = qk.menuqk(vtc, 0, c);
		long[] lm = new long[2];
		lm = mg.menu(vtc, 0, c, auxc);
		lt[1] = lq[0];
		lt[2] = lq[1];
		lt[3] = lq[2];
		lt[4] = lm[0];
		lt[5] = lm[1];
		int[] vetorInt = new int[lt.length];
		for (int i = 0; i < lt.length; i++) {
		    if (lt[i] > Integer.MAX_VALUE || lt[i] < Integer.MIN_VALUE) {
		        System.out.println("Valor fora do intervalo de int: " + lt[i]);
		    } else {
		        vetorInt[i] = (int) lt[i];
		    }
		}
		sb.bolahs(vetorInt);
	}

}
