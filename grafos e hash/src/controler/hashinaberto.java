package controler;

public class hashinaberto<K, V> {
    private static final int TAMANHO = 10;
    private Entry<K, V>[] tabela;
    private Entry<K, V> MARCADOR_REMOVIDO = new Entry<>(null, null);

    @SuppressWarnings("unchecked")
    public hashinaberto() {
        tabela = new Entry[TAMANHO];
    }

    private int hash(K chave) {
        return Math.abs(chave.hashCode() % TAMANHO);
    }

    public void inserir(K chave, V valor) {
        int indice = hash(chave);
        int tentativas = 0;

        while (tentativas < TAMANHO) {
            int pos = (indice + tentativas) % TAMANHO;
            if (tabela[pos] == null || tabela[pos] == MARCADOR_REMOVIDO || tabela[pos].chave.equals(chave)) {
                tabela[pos] = new Entry<>(chave, valor);
                return;
            }
            tentativas++;
        }
        System.out.println("Tabela cheia! Não foi possível inserir.");
    }

    public V buscar(K chave) {
        int indice = hash(chave);
        int tentativas = 0;

        while (tentativas < TAMANHO) {
            int pos = (indice + tentativas) % TAMANHO;
            Entry<K, V> entrada = tabela[pos];
            if (entrada == null) return null;
            if (entrada != MARCADOR_REMOVIDO && entrada.chave.equals(chave)) {
                return entrada.valor;
            }
            tentativas++;
        }
        return null;
    }

    public boolean remover(K chave) {
        int indice = hash(chave);
        int tentativas = 0;

        while (tentativas < TAMANHO) {
            int pos = (indice + tentativas) % TAMANHO;
            Entry<K, V> entrada = tabela[pos];
            if (entrada == null) return false;
            if (entrada != MARCADOR_REMOVIDO && entrada.chave.equals(chave)) {
                tabela[pos] = MARCADOR_REMOVIDO;
                return true;
            }
            tentativas++;
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
        for (int i = 0; i < TAMANHO; i++) {
            System.out.println(i + ": " + tabela[i]);
        }
    }
}
