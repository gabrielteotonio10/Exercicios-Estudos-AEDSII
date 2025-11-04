typedef struct Celula
{
    int elemento;
    struct Celula *inf, *sup, *esq, *dir;
} Celula;

typedef struct
{
    int linhas, colunas;
    Celula *inicio;
} Matriz;

void removerUltimaColuna(Matriz *matriz)
{
    Celula *i = matriz->inicio;
    for (int k = 1; k < matriz->colunas - 1; i = i->dir, k++)
    {
    }
    Celula *j = i->dir;
    for(int k = 1; k <= matriz->linhas; i = i->inf, j = j->inf, k++){
        Celula *celula_a_remover = j;
        //i->dir = NULL;
        //j->esq = NULL;
        free(j);   
    }
    matriz->colunas--;
}