package ordenacoes;

import java.util.Arrays;

public class Buble {
    static int array[] = { 4, 7, 12, 7, 8, 90, 23, 1, 5, 0, 4, 0, 123, 5, 46 };

    public static void main(String[] args) {
        int n = array.length - 1;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < n - 1; i++) {
            boolean teste = false;
            for (int j = n; j > (i + 1); j--) {
                if (array[j] < array[j - 1]) {
                    teste = true;
                    int aux = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = aux;
                }
            }
            if (!teste)
                break;
        }
        System.out.println(Arrays.toString(array));
    }
}