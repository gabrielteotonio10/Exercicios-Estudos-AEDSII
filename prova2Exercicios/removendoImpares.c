void removerImpar(Matriz *primeira)
{
    for (CelulaMat *i = primeira->inicio; i != NULL; i = i->prox)
    {
        for (CelulaMat *j = i; j != NULL; j = j->inf)
        {
            Celula *lista = j->primeiro;

            while (lista->prox != NULL)
            {
                if (lista->prox->numero % 2 != 0)
                {
                    // Caso 1: só um elemento na lista
                    if (j->primeiro->prox == j->ultimo)
                    {
                        j->ultimo = NULL;
                        j->primeiro->prox = NULL;
                        j->ultimo = j->primeiro;
                        break; // lista acabou
                    }
                    // Caso 2: último elemento é ímpar
                    else if (lista->prox == j->ultimo)
                    {
                        j->ultimo = NULL; 
                        j->ultimo = lista;
                        lista->prox = NULL;
                    }
                    // Caso 3: elemento no meio
                    else
                    {
                        Celula *tmp = lista->prox;
                        lista->prox = tmp->prox;
                        tmp = NULL;
                    }
                }
                else
                {
                    lista = lista->prox; // avança apenas se não removeu
                }
            }
        }
    }
}


void remocerImpar(Matriz *primeira)
{
    for (CelulaMat *i = primeira->inicio; i != NULL; i = i->prox)
    {
        for (CelulaMat *j = i; j != NULL; j = j->inf)
        {
            Celula *lista = j->primeiro;
            while (lista->prox != NULL)
            {
                if (lista->prox->numero % 2 != 0)
                {
                    // Caso 1: só um elemento na lista
                    if (j->primeiro->prox == j->ultimo)
                    {
                        j->primeiro->prox = NULL;
                        j->ultimo = j->primeiro;
                        lista = lista->prox;
                    }
                    // Caso 2: último elemento é ímpar
                    else if (lista->prox == j->ultimo)
                    {
                        j->ultimo = lista;
                        lista->prox = NULL;
                        lista = lista->prox;
                    }
                    // Caso 3: elemento no meio
                    else
                    {
                        lista->prox = lista->prox->prox;
                    }
                }
                else
                {
                    lista = lista->prox; // só avança se não removeu
                }
            }
        }
    }
}

public void removerImpar3(Matriz primeira)
{
    for (CelulaMat i = primeira.inicio; i != NULL; i = i.prox)
    {
        for (CelulaMat j = i; j != NULL; j = j.inf)
        {
            Celula lista = j.primeiro;
            while (lista.prox != NULL)
            {
                if (lista.prox.numero % 2 != 0)
                {
                    // Caso 1: só um elemento na lista
                    if (j.primeiro.prox == j.ultimo)
                    {
                        j.primeiro.prox = NULL;
                        j.ultimo = j.primeiro;
                        lista = lista.prox;
                    }
                    // Caso 2: último elemento é ímpar
                    else if (lista.prox == j.ultimo)
                    {
                        j.ultimo = lista;
                        lista.prox = NULL;
                        lista = lista.prox;
                    }
                    // Caso 3: elemento no meio
                    else
                    {
                        lista.prox = lista.prox.prox;
                    }
                }
                else
                {
                    lista = lista.prox; // só avança se não removeu
                }
            }
        }
    }
}