package prova2Exercicios.pratica;

import java.util.Scanner;

public class tecladoQuebrado {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String entrada = sc.nextLine();
        String concertada = "";
        for(int i = 0; i < entrada.length(); i++){
            if(entrada.charAt(i) != '['){
                if(entrada.charAt(i) != ']') 
                    concertada += entrada.charAt(i);
            }
            else{
                i++;
                while (entrada.charAt(i) != ']' && i < entrada.length()) {
                    i++;
                }
            }
        }
        System.out.println(concertada);
    }
}