#include <stdlib.h>

typedef struct CelulaPilha CelulaPilha;
typedef struct CelulaLista CelulaLista;

typedef struct CelulaPilha{
    int elemento;
    CelulaPilha *prox;
}CelulaPilha;

typedef struct CelulaLista{
    CelulaPilha *topo; 
    CelulaLista *prox;
} CelulaLista;

typedef struct Lista{
    CelulaLista *inicio;
    CelulaLista *fim;
} Lista;

CelulaLista *maiorPilha(CelulaLista *i){
    CelulaLista *maiorCelula = NULL;
    int maior = 0;
    while (i != NULL)
    {
        int atual = 0;
        CelulaPilha *j = i->topo;
        while (j != NULL)
        {
            atual++;
            j = j->prox;
        }
        if(atual > maior){
            maior = atual;
            maiorCelula = i;
        }
        i = i->prox;
        j = NULL;
    }
    i = NULL;
    return maiorCelula;
}


