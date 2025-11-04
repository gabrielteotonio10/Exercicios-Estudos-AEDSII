#include <stdlib.h>
#include <stdbool.h>

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
            if (estaNaArvore(raiz, j->numero))
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
    }
    return ordenada;
}

bool estaNaArvore(No *i, int x)
{
    bool achou = false;
    if (i == NULL)
    {
        achou = false;
    }
    else if (i->numero == x)
    {
        achou = true;
    }
    else if (x > i->numero)
    {
        achou = estaNaArvore(i->dir, x);
    }
    else if (x < i->numero)
    {
        achou = estaNaArvore(i->esq, x);
    }
    return achou;
}