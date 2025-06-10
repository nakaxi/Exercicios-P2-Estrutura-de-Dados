package view;
import controler.*;
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		int opc = 0;
		int opcg = 0;
		int opch = 0;
		int opchb = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - grafo \n 2 - hash \n 3 - hash aberto \n 9 - fim"));
			switch(opc) {
			
			case 1:
				grafin grafo = new grafin();
				while(opcg != 9) {
					opcg = Integer.parseInt(JOptionPane.showInputDialog("Grafo:\n" +
							"1 - Adicionar aresta\n" +
							"2 - Remover aresta\n" +
							"3 - Verificar se aresta existe\n" +
							"4 - Imprimir grafo\n" +
							"5 - Busca em largura (BFS)\n" +
							"6 - Busca em profundidade (DFS)\n" +
							"9 - Voltar\""));
					switch (opcg) {
	                case 1: {
	                    int origem = Integer.parseInt(JOptionPane.showInputDialog("Origem da aresta:"));
	                    int destino = Integer.parseInt(JOptionPane.showInputDialog("Destino da aresta:"));
	                    grafo.adicionarAresta(origem, destino);
	                    System.out.println("Aresta adicionada entre " + origem + " e " + destino);
	                    break;
	                }
	                case 2: {
	                    int origem = Integer.parseInt(JOptionPane.showInputDialog("Origem da aresta a remover:"));
	                    int destino = Integer.parseInt(JOptionPane.showInputDialog("Destino da aresta a remover:"));
	                    grafo.removerAresta(origem, destino);
	                    System.out.println("Aresta removida entre " + origem + " e " + destino);
	                    break;
	                }
	                case 3: {
	                    int origem = Integer.parseInt(JOptionPane.showInputDialog("Origem:"));
	                    int destino = Integer.parseInt(JOptionPane.showInputDialog("Destino:"));
	                    boolean existe = grafo.existeAresta(origem, destino);
	                    System.out.println("Aresta existe? " + existe);
	                    break;
	                }
	                case 4: {
	                    System.out.println("Grafo atual:");
	                    grafo.imprimirGrafo();
	                    break;
	                }
	                case 5: {
	                    int inicio = Integer.parseInt(JOptionPane.showInputDialog("Vértice de início para BFS:"));
	                    grafo.bfs(inicio);
	                    break;
	                }
	                case 6: {
	                    int inicio = Integer.parseInt(JOptionPane.showInputDialog("Vértice de início para DFS:"));
	                    grafo.dfs(inicio);
	                    break;
	                }
	                case 9: {
	                	System.out.println("------- fechando grafo -------");
	                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
	                    break;
	                }
	                default: {
	                    JOptionPane.showMessageDialog(null, "Opção inválida.");
	                }
	            }

	        } while (opc != 9);
				
			case 2:
		        hashin<String, String> hash = new hashin<>();
		        do {
		            opch = Integer.parseInt(JOptionPane.showInputDialog(
		                "Hash Table (com encadeamento):\n" +
		                "1 - Inserir (chave e valor)\n" +
		                "2 - Buscar valor pela chave\n" +
		                "3 - Remover entrada pela chave\n" +
		                "4 - Imprimir tabela\n" +
		                "9 - Voltar"
		            ));

		            switch (opch) {
		                case 1: {
		                    String chave = JOptionPane.showInputDialog("Digite a chave:");
		                    String valor = JOptionPane.showInputDialog("Digite o valor:");
		                    hash.inserir(chave, valor);
		                    System.out.println("Inserido: " + chave + " = " + valor);
		                    break;
		                }
		                case 2: {
		                    String chave = JOptionPane.showInputDialog("Digite a chave a buscar:");
		                    String valor = hash.buscar(chave);
		                    if (valor != null) {
		                        System.out.println("Valor encontrado: " + valor);
		                    } else {
		                        System.out.println("Chave não encontrada.");
		                    }
		                    break;
		                }
		                case 3: {
		                    String chave = JOptionPane.showInputDialog("Digite a chave a remover:");
		                    boolean removido = hash.remover(chave);
		                    if (removido) {
		                        System.out.println("Removido com sucesso.");
		                    } else {
		                        System.out.println("Chave não encontrada.");
		                    }
		                    break;
		                }
		                case 4: {
		                    System.out.println("Tabela Hash:");
		                    hash.imprimirTabela();
		                    break;
		                }
		                case 9: {
		                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
		                    break;
		                }
		                default: {
		                    JOptionPane.showMessageDialog(null, "Opção inválida.");
		                }
		            }

		        } while (opc != 9);
				break;
				
			case 3:
				 hashinaberto<String, String> hashab = new hashinaberto<>();
			        do {
			            opchb = Integer.parseInt(JOptionPane.showInputDialog(
			                "Hash Aberto (Endereçamento Aberto):\n" +
			                "1 - Inserir (chave e valor)\n" +
			                "2 - Buscar valor pela chave\n" +
			                "3 - Remover entrada pela chave\n" +
			                "4 - Imprimir tabela\n" +
			                "9 - Voltar"
			            ));

			            switch (opchb) {
			                case 1: {
			                    String chave = JOptionPane.showInputDialog("Digite a chave:");
			                    String valor = JOptionPane.showInputDialog("Digite o valor:");
			                    hashab.inserir(chave, valor);
			                    System.out.println("Inserido: " + chave + " = " + valor);
			                    break;
			                }
			                case 2: {
			                    String chave = JOptionPane.showInputDialog("Digite a chave a buscar:");
			                    String valor = hashab.buscar(chave);
			                    if (valor != null) {
			                        System.out.println("Valor encontrado: " + valor);
			                    } else {
			                        System.out.println("Chave não encontrada.");
			                    }
			                    break;
			                }
			                case 3: {
			                    String chave = JOptionPane.showInputDialog("Digite a chave a remover:");
			                    boolean removido = hashab.remover(chave);
			                    if (removido) {
			                        System.out.println("Removido com sucesso.");
			                    } else {
			                        System.out.println("Chave não encontrada.");
			                    }
			                    break;
			                }
			                case 4: {
			                    System.out.println("Tabela Hash (Endereçamento Aberto):");
			                    hashab.imprimirTabela();
			                    break;
			                }
			                case 9: {
			                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
			                    break;
			                }
			                default: {
			                    JOptionPane.showMessageDialog(null, "Opção inválida.");
			                }
			            }

			        } while (opc != 9);
				break;
				
			case 9:
				JOptionPane.showMessageDialog(null, "fim");
				break;
				
			default: 
				JOptionPane.showMessageDialog(null, "Opção inválida.");
			break;
			}
		}
	}

}
