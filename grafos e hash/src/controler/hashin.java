package controler;
import java.util.*;

public class hashin<K, V> {
	private static final int TAMANHO_INICIAL = 10;
    private List<Entry<K, V>>[] tabela;

    @SuppressWarnings("unchecked")
    public hashin() {
        tabela = new LinkedList[TAMANHO_INICIAL];
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(K chave) {
        return Math.abs(chave.hashCode() % tabela.length);
    }

    public void inserir(K chave, V valor) {
        int indice = hash(chave);
        for (Entry<K, V> entrada : tabela[indice]) {
            if (entrada.chave.equals(chave)) {
                entrada.valor = valor;
                return;
            }
        }
        tabela[indice].add(new Entry<>(chave, valor));
    }

    public V buscar(K chave) {
        int indice = hash(chave);
        for (Entry<K, V> entrada : tabela[indice]) {
            if (entrada.chave.equals(chave)) {
                return entrada.valor;
            }
        }
        return null;
    }

    public boolean remover(K chave) {
        int indice = hash(chave);
        Iterator<Entry<K, V>> it = tabela[indice].iterator();
        while (it.hasNext()) {
            if (it.next().chave.equals(chave)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private static class Entry<K, V> {
        K chave;
        V valor;

        Entry(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        public String toString() {
            return chave + "=" + valor;
        }
    }

    public void imprimirTabela() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.println(i + ": " + tabela[i]);
        }
    }
}
