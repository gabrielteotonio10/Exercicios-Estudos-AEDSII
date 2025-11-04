#include <stdlib.h>

typedef struct Celula
{
    int numero;
    Celula *prox;
} Celula;

typedef struct CelulaMatriz
{
    int numero;
    CelulaMatriz *prox, *ant;
    CelulaMatriz *sup, *inf;
} CelulaMatriz;

typedef struct No
{
    int numero;
    No *esq, *dir;
} No;

Celula *enconrarRepetidos(No *raiz, CelulaMatriz *inicio)
{
    // Considerando que exista uma célula cabeça criada aqui 
    Celula *ordenada = (Celula *)malloc(sizeof(Celula));
    ordenada->numero = -1;
    ordenada->prox = NULL;
    // Capturando a matriz
    for (CelulaMatriz *i = inicio; i != NULL; i = i->prox)
    {
        for (CelulaMatriz *j = i; j != NULL; j = j->inf)
        {
            // Ordenando o que foi capturado
            Celula *resposta = ordenada;
            for (; resposta->prox != NULL && resposta->prox->numero > j->numero; resposta = resposta->prox)
                ;
            Celula *tmp = (Celula *)malloc(sizeof(Celula));
            tmp->numero = j->numero;
            tmp->prox = resposta->prox;
            resposta->prox = tmp;
            tmp = NULL;
        }
    }
    // Capturando árvore
    ordenada = capturandoArvore(raiz, ordenada);
    return ordenada;
}

Celula *capturandoArvore(No *i, Celula *ordenada)
{
    if (i != NULL)
    {
        Celula *resposta = ordenada;
        for (; resposta->prox != NULL && resposta->prox->numero > i->numero; resposta = resposta->prox)
            ;
        Celula *tmp = (Celula *)malloc(sizeof(Celula));
        tmp->numero = i->numero;
        tmp->prox = resposta->prox;
        resposta->prox = tmp;
        tmp = NULL;
        ordenada = capturandoArvore(i->esq, ordenada);
        ordenada = capturandoArvore(i->dir, ordenada);
    }
    return ordenada;
}
