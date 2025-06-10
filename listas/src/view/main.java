package view;
import javax.swing.*;

public class main {
	public static void main(String[] args) {
        String menuPrincipal = "Escolha uma lista:\n"
                + "1 - simples\n"
                + "2 - dupla\n"
                + "3 - circular\n"
                + "4 - duplacircular\n"
                + "9 - sair";
        // lembrar de fzr mais isso, ajuda dms na organizacao
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opc) {
                case 1: ListaSimples.executar(); break;
                case 2: ListaDupla.executar(); break;
                case 3: ListaCircular.executar(); break;
                case 4: ListaDuplaCircular.executar(); break;
                case 9: JOptionPane.showMessageDialog(null, "Encerrando..."); break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida."); break;
            }
        } while (opc != 9);
    }
}

class ListaSimples {
    static class No {
        int valor;
        No prox;
        No(int v) { valor = v; }
    }
    static No head;

    static void adicionar(int valor) {
        No novo = new No(valor);
        if (head == null) head = novo;
        else {
            No temp = head;
            while (temp.prox != null) temp = temp.prox;
            temp.prox = novo;
        }
    }

    static void remover(int valor) {
        if (head == null) return;
        if (head.valor == valor) {
            head = head.prox;
            return;
        }
        No temp = head;
        while (temp.prox != null && temp.prox.valor != valor) temp = temp.prox;
        if (temp.prox != null) temp.prox = temp.prox.prox;
    }

    static boolean buscar(int valor) {
        for (No temp = head; temp != null; temp = temp.prox)
            if (temp.valor == valor) return true;
        return false;
    }

    static String imprimir() {
        StringBuilder sb = new StringBuilder();
        for (No temp = head; temp != null; temp = temp.prox)
            sb.append(temp.valor).append(" ");
        return sb.toString();
    }

    static void inverter() {
        No prev = null, atual = head, prox;
        while (atual != null) {
            prox = atual.prox;
            atual.prox = prev;
            prev = atual;
            atual = prox;
        }
        head = prev;
    }

    static void executar() {
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Lista Simples:\n1 - adicionar\n2 - remover\n3 - buscar\n4 - imprimir\n5 - inverter\n0 - voltar"));
            switch (opc) {
                case 1 -> adicionar(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 2 -> remover(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 3 -> JOptionPane.showMessageDialog(null, buscar(Integer.parseInt(JOptionPane.showInputDialog("Valor:"))) ? "Encontrado" : "Não encontrado");
                case 4 -> JOptionPane.showMessageDialog(null, imprimir());
                case 5 -> inverter();
            }
        } while (opc != 0);
    }
}

class ListaDupla {
    static class No {
        int valor;
        No ant, prox;
        No(int v) { valor = v; }
    }
    static No head, tail;

    static void adicionar(int valor) {
        No novo = new No(valor);
        if (head == null) head = tail = novo;
        else {
            tail.prox = novo;
            novo.ant = tail;
            tail = novo;
        }
    }

    static void remover(int valor) {
        for (No temp = head; temp != null; temp = temp.prox) {
            if (temp.valor == valor) {
                if (temp == head) head = temp.prox;
                if (temp == tail) tail = temp.ant;
                if (temp.ant != null) temp.ant.prox = temp.prox;
                if (temp.prox != null) temp.prox.ant = temp.ant;
                break;
            }
        }
    }

    static boolean buscar(int valor) {
        for (No temp = head; temp != null; temp = temp.prox)
            if (temp.valor == valor) return true;
        return false;
    }

    static String imprimirFrente() {
        StringBuilder sb = new StringBuilder();
        for (No temp = head; temp != null; temp = temp.prox)
            sb.append(temp.valor).append(" ");
        return sb.toString();
    }

    static String imprimirTras() {
        StringBuilder sb = new StringBuilder();
        for (No temp = tail; temp != null; temp = temp.ant)
            sb.append(temp.valor).append(" ");
        return sb.toString();
    }

    static void adicionarPosicao(int valor, int pos) {
        No novo = new No(valor);
        if (pos <= 0 || head == null) {
            novo.prox = head;
            if (head != null) head.ant = novo;
            head = novo;
            if (tail == null) tail = novo;
            return;
        }
        No temp = head;
        for (int i = 0; i < pos - 1 && temp.prox != null; i++) temp = temp.prox;
        novo.prox = temp.prox;
        if (temp.prox != null) temp.prox.ant = novo;
        temp.prox = novo;
        novo.ant = temp;
        if (novo.prox == null) tail = novo;
    }

    static void executar() {
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Lista Dupla:\n1 - adicionar\n2 - remover\n3 - buscar\n4 - imprimir frente\n5 - imprimir trás\n6 - adicionar na posição\n0 - voltar"));
            switch (opc) {
                case 1 -> adicionar(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 2 -> remover(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 3 -> JOptionPane.showMessageDialog(null, buscar(Integer.parseInt(JOptionPane.showInputDialog("Valor:"))) ? "Encontrado" : "Não encontrado");
                case 4 -> JOptionPane.showMessageDialog(null, imprimirFrente());
                case 5 -> JOptionPane.showMessageDialog(null, imprimirTras());
                case 6 -> {
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Valor:"));
                    int pos = Integer.parseInt(JOptionPane.showInputDialog("Posição:"));
                    adicionarPosicao(valor, pos);
                }
            }
        } while (opc != 0);
    }
}

class ListaCircular {
    static class No {
        int valor;
        No prox;
        No(int v) { valor = v; }
    }
    static No tail;

    static void adicionar(int valor) {
        No novo = new No(valor);
        if (tail == null) {
            tail = novo;
            tail.prox = tail;
        } else {
            novo.prox = tail.prox;
            tail.prox = novo;
            tail = novo;
        }
    }

    static void remover(int valor) {
        if (tail == null) return;
        No atual = tail.prox, ant = tail;
        do {
            if (atual.valor == valor) {
                if (atual == tail) tail = ant;
                ant.prox = atual.prox;
                if (atual == ant) tail = null; // único elemento
                break;
            }
            ant = atual;
            atual = atual.prox;
        } while (atual != tail.prox);
    }

    static boolean buscar(int valor) {
        if (tail == null) return false;
        No temp = tail.prox;
        do {
            if (temp.valor == valor) return true;
            temp = temp.prox;
        } while (temp != tail.prox);
        return false;
    }

    static String imprimir() {
        if (tail == null) return "";
        StringBuilder sb = new StringBuilder();
        No temp = tail.prox;
        do {
            sb.append(temp.valor).append(" ");
            temp = temp.prox;
        } while (temp != tail.prox);
        return sb.toString();
    }

    static void rotacionar(int k) {
        for (int i = 0; i < k; i++) {
            tail = tail.prox;
        }
    }

    static void executar() {
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Lista Circular:\n1 - adicionar\n2 - remover\n3 - buscar\n4 - imprimir\n5 - rotacionar\n0 - voltar"));
            switch (opc) {
                case 1 -> adicionar(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 2 -> remover(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 3 -> JOptionPane.showMessageDialog(null, buscar(Integer.parseInt(JOptionPane.showInputDialog("Valor:"))) ? "Encontrado" : "Não encontrado");
                case 4 -> JOptionPane.showMessageDialog(null, imprimir());
                case 5 -> rotacionar(Integer.parseInt(JOptionPane.showInputDialog("K posições:")));
            }
        } while (opc != 0);
    }
}

class ListaDuplaCircular {
    static class No {
        int valor;
        No ant, prox;
        No(int v) { valor = v; }
    }
    static No head;

    static void adicionar(int valor) {
        No novo = new No(valor);
        if (head == null) {
            head = novo;
            head.prox = head;
            head.ant = head;
        } else {
            No tail = head.ant;
            tail.prox = novo;
            novo.ant = tail;
            novo.prox = head;
            head.ant = novo;
        }
    }

    static void remover(int valor) {
        if (head == null) return;
        No temp = head;
        do {
            if (temp.valor == valor) {
                if (temp.prox == temp) {
                    head = null;
                } else {
                    temp.ant.prox = temp.prox;
                    temp.prox.ant = temp.ant;
                    if (temp == head) head = temp.prox;
                }
                break;
            }
            temp = temp.prox;
        } while (temp != head);
    }

    static boolean buscar(int valor) {
        if (head == null) return false;
        No temp = head;
        do {
            if (temp.valor == valor) return true;
            temp = temp.prox;
        } while (temp != head);
        return false;
    }

    static String imprimirHorario() {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        No temp = head;
        do {
            sb.append(temp.valor).append(" ");
            temp = temp.prox;
        } while (temp != head);
        return sb.toString();
    }

    static String imprimirAntiHorario() {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        No temp = head.ant;
        do {
            sb.append(temp.valor).append(" ");
            temp = temp.ant;
        } while (temp != head.ant);
        return sb.toString();
    }

    static void trocarPrimeiroPorUltimo() {
        if (head == null || head.prox == head) return;
        head = head.ant;
    }

    static void executar() {
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Lista Dupla Circular:\n1 - adicionar\n2 - remover\n3 - buscar\n4 - imprimir horário\n5 - imprimir anti-horário\n6 - trocar primeiro por último\n0 - voltar"));
            switch (opc) {
                case 1 -> adicionar(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 2 -> remover(Integer.parseInt(JOptionPane.showInputDialog("Valor:")));
                case 3 -> JOptionPane.showMessageDialog(null, buscar(Integer.parseInt(JOptionPane.showInputDialog("Valor:"))) ? "Encontrado" : "Não encontrado");
                case 4 -> JOptionPane.showMessageDialog(null, imprimirHorario());
                case 5 -> JOptionPane.showMessageDialog(null, imprimirAntiHorario());
                case 6 -> trocarPrimeiroPorUltimo();
            }
        } while (opc != 0);
    }
}
