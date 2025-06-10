package controller;

public class VerificadorExpressao {
	 public static boolean verificarBalanceamento(String expressao) {
	        Pilha pilha = new Pilha(expressao.length());

	        for (char c : expressao.toCharArray()) {
	            if (c == '(' || c == '[' || c == '{') {
	                pilha.push(c);
	            } else if (c == ')' || c == ']' || c == '}') {
	                if (pilha.isEmpty()) return false;
	                char topo = (char) pilha.pop();
	                if ((c == ')' && topo != '(') || (c == ']' && topo != '[') || (c == '}' && topo != '{')) {
	                    return false;
	                }
	            }
	        }

	        return pilha.isEmpty();
	    }
}
