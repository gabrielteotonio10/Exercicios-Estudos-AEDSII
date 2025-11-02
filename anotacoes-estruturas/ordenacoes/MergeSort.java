package ordenacoes;

public class MergeSort {
    static int array[] = { 4, 7, 12, 7, 8, 90, 23, 1, 5, 0, 4, 0, 123, 5, 46 };

    public static void main(String[] args) {
        int n = array.length;
        mergesort(0, n);
    }

    static void mergesort(int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(esq, meio);
            mergesort(meio + 1, dir);
            intercalar(esq, meio, dir);
        }
    }

    static void intercalar(int esq, int meio, int dir) {
        int n1, n2, i, j, k;

        // Definir tamanho dos dois subarrays
        n1 = meio - esq + 1; 
        n2 = dir - meio; 

        int[] a1 = new int[n1 + 1]; 
        int[] a2 = new int[n2 + 1]; 

        // Inicializar primeiro subarray
        for (i = 0; i < n1; i++) {
            a1[i] = array[esq + i];
        }

        // Inicializar segundo subarray
        for (j = 0; j < n2; j++) {
            a2[j] = array[meio + j + 1];
        }

        // Sentinela no final dos dois arrays
        a1[i] = a2[j] = 0x7FFFFFFF;

        // Intercalacao propriamente dita
        for (i = j = 0, k = esq; k <= dir; k++) {
            array[k] = (a1[i] <= a2[j]) ? a1[i++] : a2[j++];
        }
    }
}
