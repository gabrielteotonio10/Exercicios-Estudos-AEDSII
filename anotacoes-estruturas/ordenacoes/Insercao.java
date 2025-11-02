package ordenacoes;

public class Insercao {
    static int array[] = { 4, 7, 12, 7, 8, 90, 23, 1, 5, 0, 4, 0, 123, 5, 46 };

    public static void main(String[] args) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int aux = array[i];
            while (j >= 0 && array[j] > aux) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }
}