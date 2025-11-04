typedef struct Celula{
    int elemento;
    struct Celula *prox;  
}Celula;

Celula *inicio;
Celula *fim;

void Meiose(){
    Celula *i = inicio;
    while (i != NULL)
    {
        int x = i->elemento / 2;
        i->elemento = x;
        Celula *tmp = (Celula*) malloc(sizeof(Celula));
        tmp->elemento = x;
        tmp->prox = i->prox;
        i->prox = tmp;
        tmp = NULL;
        i = i->prox->prox;
    }
}

23 - 35 - 67 - 2 - 8 - 43 -97
P: 2
