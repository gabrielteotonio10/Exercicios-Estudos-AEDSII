#include <stdio.h>
#include <stdlib.h>

typedef struct CelulaDupla {
    int elemento;
    struct CelulaDupla* prox;
    struct CelulaDupla* ant;
} CelulaDupla;

// Função auxiliar para criar nova célula
CelulaDupla* novaCelula(int elemento) {
    CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
    if (nova == NULL) {
        printf("Erro ao alocar memória!\n");
        exit(1);
    }
    nova->elemento = elemento;
    nova->prox = NULL;
    nova->ant = NULL;
    return nova;
}

CelulaDupla* intercalarReverso(CelulaDupla* c1, CelulaDupla* c2) {
    // cria célula cabeça (vazia)
    CelulaDupla* intercalada = (CelulaDupla*) malloc(sizeof(CelulaDupla));
    intercalada->elemento = 0;
    intercalada->prox = NULL;
    intercalada->ant = NULL;

    CelulaDupla* resposta = intercalada;

    // ir até o final das duas listas
    while (c1 != NULL && c1->prox != NULL)
        c1 = c1->prox;
    while (c2 != NULL && c2->prox != NULL)
        c2 = c2->prox;

    // intercalar de trás pra frente
    while (c1 != NULL || c2 != NULL) {
        if (c1 != NULL) {
            CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
            nova->elemento = c1->elemento;
            nova->prox = NULL;
            nova->ant = intercalada;
            intercalada->prox = nova;
            intercalada = intercalada->prox;
            c1 = c1->ant;
        }
        if (c2 != NULL) {
            CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
            nova->elemento = c2->elemento;
            nova->prox = NULL;
            nova->ant = intercalada;
            intercalada->prox = nova;
            intercalada = intercalada->prox;
            c2 = c2->ant;
        }
    }

    // remove célula cabeça e ajusta início
    CelulaDupla* resultado = resposta->prox;
    if (resultado != NULL)
        resultado->ant = NULL;
    free(resposta);

    return resultado;
}
