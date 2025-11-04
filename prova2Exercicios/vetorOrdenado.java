package prova2Exercicios;

public class vetorOrdenado {
    public static int[] vetorOrdenadoo(int vetA[], int vetB[]) {
        int m = vetA.length, n = vetB.length;
        int mn = m + n;
        int ordenado[] = new int[mn];
        m--;
        n--;
        for (int i = 0; i < mn; i++) {
            if (m >= 0 && n >= 0) {
                if (vetA[m] < vetB[n]) {
                    ordenado[i] = vetA[m];
                    m--;
                } else {
                    ordenado[i] = vetB[n];
                    n--;
                }
            } else {
                if (m >= 0) {
                    ordenado[i] = vetA[m];
                    m--;
                }
                else{
                    ordenado[i] = vetB[n];
                    n--;
                }
            }
        }
        return ordenado;
    }
}
