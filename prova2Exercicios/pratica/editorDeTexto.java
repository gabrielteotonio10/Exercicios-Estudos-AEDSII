package prova2Exercicios.pratica;

import java.util.Scanner;

public class editorDeTexto {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = sc.nextLine();
        int erro = 0;
        String codifcado = "";
        String aux = "";
        for (int i = 0; i < entrada.length(); i++) {
            aux = "";
            if (entrada.charAt(i) == '[') {
                boolean teste = false;
                erro = i;
                i++;
                while (i < entrada.length() && entrada.charAt(i) != ']' && !teste) {
                    if (entrada.charAt(i) == '[') {
                        teste = true;
                    }
                    if (entrada.charAt(i) != '[' && entrada.charAt(i) != ']')
                        aux += entrada.charAt(i);
                    i++;
                }
                if (teste) {
                    i = erro;
                } else {
                    aux += codifcado;
                    codifcado = aux;
                }
            } else {
                if (entrada.charAt(i) != '[' && entrada.charAt(i) != ']')
                    codifcado += entrada.charAt(i);
            }
        }
        System.out.println(codifcado);
    }

}