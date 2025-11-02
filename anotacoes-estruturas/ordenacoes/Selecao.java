package ordenacoes;

public class Selecao {
    static int array[] = { 4, 7, 12, 7, 8, 90, 23, 1, 5, 0, 4, 0, 123, 5, 46 };

    public static void main(String[] args) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (menor > array[j]) {
                    menor = array[j];
                }
            }
            int aux = array[i];
            array[i] = array[menor];
            array[menor] = aux;
        }
    }
}