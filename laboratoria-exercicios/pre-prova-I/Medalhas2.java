package exercicios;
import java.util.Scanner;

class Informacoes {
    String nome;
    int ouro;
    int prata;
    int bronze;

    Informacoes() {
        this.nome = "";
        this.ouro = -1;
        this.prata = -1;
        this.bronze = -1;
    }

    Informacoes(String nome, int ouro, int prata, int bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}

public class Medalhas2 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int N = sc.nextInt();
        sc.nextLine();
        Informacoes pais[] = new Informacoes[N];
        for (int i = 0; i < N; i++) {
            int x = 0;
            String nome = sc.nextLine();
            int ouro=0 , prata= 0, bronze= 0;
            while (x < nome.length() && nome.charAt(x) != ' ')
                x++;
            while (x < nome.length() && nome.charAt(x) == ' ') x++;
            while (x < nome.length() && nome.charAt(x) != ' '){
                ouro= ouro * 10 + (nome.charAt(x) - '0');
                x++;
            }
            while (x < nome.length() && nome.charAt(x) == ' ') x++;
            while (x < nome.length() && nome.charAt(x) != ' '){
                prata= prata * 10 + (nome.charAt(x) - '0');
                x++;
            }
            while (x < nome.length() && nome.charAt(x) == ' ') x++;
            while (x < nome.length() && nome.charAt(x) != ' '){
                bronze= bronze * 10 + (nome.charAt(x) - '0');
                x++;
            }
            pais[i] = new Informacoes(nome, ouro, prata, bronze);
        }

        for(int i=1; i<N; i++){
            int j= i-1;
            Informacoes aux= pais[i];
            while(j >= 0 && (
                (aux.ouro > pais[j].ouro) || (aux.ouro == pais[j].ouro && aux.prata > pais[j].prata) ||
                (aux.ouro == pais[j].ouro && aux.prata == pais[j].prata && aux.bronze == pais[j].bronze)
            )){
                pais[j+1]= pais[j];
                j--;
            }
            pais[j+1]= aux;
        }

        for(int i=0; i<N; i++){
            System.out.println(pais[i].nome);
        }
        sc.close();
    }
}
