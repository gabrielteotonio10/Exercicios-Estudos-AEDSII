int *vetorOrdenado(int vetA[], int m, int vetB[], int n)
{
    int mn = m + n;
    int *ordenado = malloc(mn * sizeof(int));
    m--;
    n--;
    for (int i = 0; i < mn; i++)
    {
        if (m >= 0 && n >= 0)
        {
            if (vetA[m] < vetB[n])
            {
                ordenado[i] = vetA[m];
                m--;
            }
            else
            {
                ordenado[i] = vetB[n];
                n--;
            }
        }
        else
        {
            if (m >= 0)
            {
                ordenado[i] = vetA[m];
                m--;
            }
            else
            {
                ordenado[i] = vetB[n];
                n--;
            }
        }
    }
    return ordenado;
}