package prova2Exercicios.pratica;

import java.util.Scanner;

public class paoDeQuejo {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = sc.nextLine();
        while (!entrada.equals("FIM")) {
            int linha = 0, coluna = 0, tam = 0;
            int x = 0;
            while (entrada.charAt(x) != ' ') {
                linha = linha * 10 + (entrada.charAt(x) - '0');
            }
            x++;
            while (x < entrada.length()) {
                coluna = coluna * 10 + (entrada.charAt(x) - '0');
            }
            tam = linha * coluna;
            int m [][] = new int[linha][coluna];
            int posicao = 0;
            for (int i = 0; i < linha; i++) {
                x = 0;
                while (x < entrada.length()) {
                    matriz[posicao] = (entrada.charAt(x) - '0');
                    x += 2;
                    posicao++;
                }
            }
            entrada = sc.nextLine();
        }
    }
}
