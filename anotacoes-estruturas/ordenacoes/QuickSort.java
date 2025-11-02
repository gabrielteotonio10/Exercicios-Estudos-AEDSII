package ordenacoes;

import java.util.Arrays;

public class QuickSort {
    static int array[] = { 4, 7, 12, 7, 8, 90, 23, 1, 5, 0, 4, 0, 123, 5, 46 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        int n = array.length;
        quicksort(0, n - 1);
        System.out.println(Arrays.toString(array));
    }

    static void quicksort(int esq, int dir) {
        System.out.println(Arrays.toString(array));
        int i = esq, j = dir;
        int pivo = array[(dir + esq) / 2];
        while (i <= j) {
            while (array[i] < pivo)
                i++;
            while (array[j] > pivo)
                j--;
            if (i <= j) {
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(esq, j);
        if (i < dir)
            quicksort(i, dir);
    }
}
