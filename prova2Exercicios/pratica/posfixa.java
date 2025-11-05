package prova2Exercicios.pratica;

import java.util.Scanner;

public class posfixa {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        for(int x = 0; x < n; x++){
            String entrada = sc.nextLine();
            String posFixo = "";
            String operadores = "";
            for(int j = 0; j < entrada.length(); j++){
                operadores = "";
                if(entrada.charAt(j) == '('){
                    while (j < entrada.length() && entrada.charAt(j) != ')') {
                        if(Character.isAlphabetic(entrada.charAt(j)) || Character.isDigit(entrada.charAt(j))){
                            posFixo += entrada.charAt(j);
                        }
                        else{
                            if(entrada.charAt(j) != ' ' && entrada.charAt(j) != '(')
                                operadores += entrada.charAt(j);
                        }
                        j++;
                    }
                    posFixo += operadores;
                }
                else{
                    while (j < entrada.length() && entrada.charAt(j) != '(') {
                        if(Character.isAlphabetic(entrada.charAt(j)) || Character.isDigit(entrada.charAt(j))){
                            posFixo += entrada.charAt(j);
                        }
                        else{
                            if(entrada.charAt(j) != ' ')
                                operadores += entrada.charAt(j);
                        }
                        j++;
                    }
                    posFixo += operadores;
                    if(j < entrada.length() && entrada.charAt(j) == '('){
                        j--;
                    }
                }
            }
            System.out.println(posFixo);
        }
    }
}