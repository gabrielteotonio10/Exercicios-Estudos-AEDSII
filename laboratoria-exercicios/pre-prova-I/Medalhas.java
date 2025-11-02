package exercicios;
import java.util.Scanner;

class Atributos {
    protected String nome;
    protected int ouro;
    protected int prata;
    protected int bronze;

    Atributos() {
        this.nome = "";
        this.ouro = 0;
        this.prata = 0;
        this.bronze = 0;
    }

    Atributos(String nome, int ouro, int prata, int bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}

public class Medalhas {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        Atributos a[] = new Atributos[quantidade];

        for (int i = 0; i < quantidade; i++) {
            String linha = scanner.nextLine();
            int ouro = 0, prata = 0, bronze = 0;
            int x = 0;

            // nome do país (até achar número)
            while (x < linha.length() && !(linha.charAt(x) >= '0' && linha.charAt(x) <= '9')) {
                x++;
            }

            // pular espaços
            while (x < linha.length() && linha.charAt(x) == ' ') x++;

            // ler ouro
            while (x < linha.length() && linha.charAt(x) != ' ') {
                ouro = ouro * 10 + (linha.charAt(x) - '0');
                x++;
            }

            while (x < linha.length() && linha.charAt(x) == ' ') x++;

            // ler prata
            while (x < linha.length() && linha.charAt(x) != ' ') {
                prata = prata * 10 + (linha.charAt(x) - '0');
                x++;
            }

            while (x < linha.length() && linha.charAt(x) == ' ') x++;

            // ler bronze
            while (x < linha.length()) {
                bronze = bronze * 10 + (linha.charAt(x) - '0');
                x++;
            }

            a[i] = new Atributos(linha, ouro, prata, bronze);
        }

        // insertion sort
        for (int i = 1; i < quantidade; i++) {
            Atributos atual = a[i];
            int j = i - 1;

            while (j >= 0 && (
                atual.ouro > a[j].ouro ||
                (atual.ouro == a[j].ouro && atual.prata > a[j].prata) ||
                (atual.ouro == a[j].ouro && atual.prata == a[j].prata && atual.bronze > a[j].bronze)
            )) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = atual;
        }

        // saída formatada
        for (int i = 0; i < quantidade; i++) {
            System.out.println(a[i].nome);
        }
    }
}
