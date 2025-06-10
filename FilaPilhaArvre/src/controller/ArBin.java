package controller;

import javax.swing.JOptionPane;

public class ArBin {
	private ArBinO raiz;
	private ArBinO inserir(ArBinO atual, ArBinO novoNo){
		if (atual == null)
			return novoNo;
		else if (novoNo.valor < atual.valor)
			atual.esq = inserir(atual.esq, novoNo);
		else
			atual.dir = inserir(atual.dir, novoNo);
		return atual;
		}
	
	public void inserirNo(ArBinO novoNo){
		raiz = inserir(raiz, novoNo);
	}
	
	public void exibir() {
		System.out.println("--Exibindo elementos da árvore--");
		int c = exibirArvore(raiz, 0);
		System.out.println("Quantidade de elementos da árvore = " + c);
	}
		
	private int exibirArvore(ArBinO atual, int c) {
		if(atual != null){
			c = exibirArvore(atual.esq, c);
			System.out.println(atual.valor);
			c++;
			c = exibirArvore(atual.dir, c);
		} 
		return c;
	}

	public void exibirvalor(int v) {
		System.out.println("--Exibindo elementos da busca--");
		exibirArvorevalor(raiz, v);
	}
	
	private int exibirArvorevalor(ArBinO atual, int v) {
		int c = 0;
		if(atual != null && atual.valor != v && c == 0){
			c = exibirArvorevalor(atual.esq, v);
		}
		if(atual != null && atual.valor != v && c == 0){
			c = exibirArvorevalor(atual.dir, v);
		}
		if (c != 0) {
			System.out.println(atual.valor);
		}
		if(atual != null && atual.valor == v && c == 0) {
			System.out.println(atual.valor);
			c++;
		}
		return c;
	}
	
	public void remover(int valor) {
		raiz = remover(raiz, valor);
	}

	private ArBinO remover(ArBinO atual, int valor) {
		if (atual == null) return null;
		if (valor < atual.valor) {
			atual.esq = remover(atual.esq, valor);
		}else if (valor > atual.valor) {
			atual.dir = remover(atual.dir, valor);
			} else {
				if (atual.esq == null) return atual.dir;
				else if (atual.dir == null) return atual.esq;
				ArBinO sucessor = encontrarMenor(atual.dir);
				atual.valor = sucessor.valor;
				atual.dir = remover(atual.dir, sucessor.valor);
			}
		return atual;
	}

	private ArBinO encontrarMenor(ArBinO atual) {
		while (atual.esq != null) atual = atual.esq;
		return atual;
	}

	public void preOrdem() {
		System.out.println("-- Pré-Ordem --");
		preOrdem(raiz);
		System.out.println();
	}

	private void preOrdem(ArBinO no) {
		if (no != null) {
			System.out.print(no.valor + " ");
			preOrdem(no.esq);
			preOrdem(no.dir);
		}
	}

	public void emOrdem() {
		System.out.println("-- Em Ordem --");
		emOrdem(raiz);
		System.out.println();
	}

	private void emOrdem(ArBinO no) {
		if (no != null) {
			emOrdem(no.esq);
			System.out.print(no.valor + " ");
			emOrdem(no.dir);
		}
	}

	public void posOrdem() {
		System.out.println("-- Pós-Ordem --");
		posOrdem(raiz);
		System.out.println();
	}

	private void posOrdem(ArBinO no) {
		if (no != null) {
			posOrdem(no.esq);
			posOrdem(no.dir);
			System.out.print(no.valor + " ");
		}
	}
	
	public int altura() {
	    return altura(raiz);
	}
	
	private int altura(ArBinO no) {
	    if (no == null) {
	        return 0;
	    }
	    int alturaEsq = altura(no.esq);
	    int alturaDir = altura(no.dir);
	    return 1 + Math.max(alturaEsq, alturaDir);
	}
    
    public static void executar() {
    	ArBin arvore = new ArBin();
    	String menubar = "Arvore Binaria:\n" +
				"1 - adicionar\n" +
				"2 - buscar\n" +
				"3 - remover\n" +
				"4 - pré-ordem\n" +
				"5 - em ordem\n" +
				"6 - pós-ordem\n" +
				"7 - exibir e altura" +
				"9 - voltar";
        int z, x, v;
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menubar));
            switch (opc) {
                case 1: 
                	z = Integer.parseInt(JOptionPane.showInputDialog(null,"digite qnts numeros vão ser inseridos"));
                	while (z > 0) {
                		x = Integer.parseInt(JOptionPane.showInputDialog(null,"digite o numero a ser inserido"));
                		arvore.inserirNo(new ArBinO(x));
        			z--;
        			}
                	break;
        		
                case 2:
                	v = Integer.parseInt(JOptionPane.showInputDialog(null,"digite o valor a ser encontrado"));
            		arvore.exibirvalor(v);
            		break;
            		
                case 3: 
					v = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser removido:"));
					arvore.remover(v);
					JOptionPane.showMessageDialog(null, "Valor removido (se existente).");
					break;
				
				case 4: 
					arvore.preOrdem(); 
					break;
					
				case 5: 
					arvore.emOrdem(); 
					break;
				
				case 6: 
					arvore.posOrdem(); 
					break;
				
                case 7:
                    int h = arvore.altura();
                    System.out.println("Altura da árvore: " + h);
                	break;
                	
            	case 9:
                	System.out.println("---- finalizando da arvore binaria ----");
                	JOptionPane.showMessageDialog(null,"voltando ao menu principal");
                	break;
                	
            	default:
            		JOptionPane.showMessageDialog(null,"Opção inválida. Tente novamente.");
            }
        } while (opc != 9);
    }
}
