import java.util.Scanner;

public class GridLargada {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (scanner.hasNextLine()) {
            int N = scanner.nextInt();
            scanner.nextLine();

            String largada = scanner.nextLine();
            int vetorLargada[] = new int[N];
            int j = 0;
            for (int i = 0; i < largada.length(); i++) {
                if (largada.charAt(i) != ' ') {
                    vetorLargada[j] = largada.charAt(i) - '0';
                    j++;
                }
            }

            String chegada = scanner.nextLine();
            int vetorChegada[] = new int[N];
            j = 0;
            for (int i = 0; i < chegada.length(); i++) {
                if (chegada.charAt(i) != ' ') {
                    vetorChegada[j] = chegada.charAt(i) - '0';
                    j++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int x = 0; x < N; x++) {
                    if (vetorChegada[i] == vetorLargada[x]) {
                        vetorChegada[i] = x;
                        x = N;
                    }
                }
            }

            int contador = 0;
            for (int i = 1; i < vetorChegada.length; i++) {
                int x = i - 1;
                int aux = vetorChegada[i];
                while (x >= 0 && aux < vetorChegada[x]) {
                    vetorChegada[x + 1] = vetorChegada[x];
                    contador++;
                    x--;
                }
                vetorChegada[x + 1] = aux;
            }

            System.out.println(contador);
        }
    }
}