package controler;
import java.util.*;

public class grafin {
	private Map<Integer, List<Integer>> adjacencia;
	
	public grafin() {
        this.adjacencia = new HashMap<>();
    }
	
    public void adicionarAresta(int origem, int destino) {
        adjacencia.putIfAbsent(origem, new ArrayList<>());
        adjacencia.putIfAbsent(destino, new ArrayList<>());
        adjacencia.get(origem).add(destino);
        adjacencia.get(destino).add(origem);
    }

    public void removerAresta(int origem, int destino) {
        List<Integer> vizinhos = adjacencia.get(origem);
        if (vizinhos != null) {
            vizinhos.remove(Integer.valueOf(destino));
        }
        adjacencia.get(destino).remove(Integer.valueOf(origem));
    }

    public boolean existeAresta(int origem, int destino) {
        List<Integer> vizinhos = adjacencia.get(origem);
        return vizinhos != null && vizinhos.contains(destino);
    }

    public void imprimirGrafo() {
        for (Map.Entry<Integer, List<Integer>> entrada : adjacencia.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
    
    //-------------------------------------------------------------------------------------------------
    
    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();

        visitados.add(inicio);
        fila.add(inicio);

        System.out.println("BFS a partir de " + inicio + ":");

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            System.out.print(atual + " ");

            List<Integer> vizinhos = adjacencia.get(atual);
            if (vizinhos != null) {
                for (int vizinho : vizinhos) {
                    if (!visitados.contains(vizinho)) {
                        visitados.add(vizinho);
                        fila.add(vizinho);
                    }
                }
            }
        }
        System.out.println();
    }

    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("DFS a partir de " + inicio + ":");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(int vertice, Set<Integer> visitados) {
        visitados.add(vertice);
        System.out.print(vertice + " ");

        List<Integer> vizinhos = adjacencia.get(vertice);
        if (vizinhos != null) {
            for (int vizinho : vizinhos) {
                if (!visitados.contains(vizinho)) {
                    dfsRecursivo(vizinho, visitados);
                }
            }
        }
    }
}
