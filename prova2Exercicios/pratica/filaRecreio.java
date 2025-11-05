package prova2Exercicios.pratica;

import java.util.Scanner;

public class filaRecreio {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        int resposta [] = new int[n];
        for(int j = 0; j < n; j++){
            int alunos = sc.nextInt();
            sc.nextLine();
            int notas [] = new int[alunos];
            String nota = sc.nextLine();
            int p = 0;
            for(int x = 0; x < alunos; x++){
                notas[x] = 0;
                while (p < nota.length() && Character.isDigit(nota.charAt(p))) {
                    notas[x] = notas[x] * 10 + (nota.charAt(p) - '0');
                    p++;
                }
                p++;
            }
            int trocas = 0;
            for(int i = 0; i < (alunos - 1); i++){
                int maior = i;
                boolean teste = false;
                for(int x = (i + 1); x < alunos; x++){
                    if(notas[x] > notas[maior]){
                        maior = x;
                        if(!teste){
                            trocas++;
                            teste = true;
                        }
                    }
                }
                int aux = notas[i];
                notas[i] = notas[maior];
                notas[maior] = aux;
            }
            resposta[j] = alunos - (trocas * 2);
        }
        for(int i = 0; i < n; i++){
            System.out.println(resposta[i]);
        }
    }
}
