#include <stdlib.h>
#include <string.h>

typedef struct Celula
{
    char nome[50];
    int elemento;
} Celula;

typedef struct Fila
{
    struct Celula primeiro;

}Fila;

Celula *criandoCelula(char n[], int e){
    Celula *c = (Celula*) malloc(sizeof(Celula));
    c->elemento = e;
    strcpy(c->nome, n);
    return c;
}

Fila *criandoFila(Celula p){
    Fila *f = (Fila*) malloc(sizeof(Fila));
    f->primeiro = p;
    return f;
}

Celula *primeiro = NULL;

int main()
{
    int n;
    scanf("%i", n);
    for (int h = 0; h < n; h++)
    {
        char entrada[50];
        scanf("%s", entrada);
        entrada[strcspn(entrada, "\n")] = '\0';

        char nome[50];
        int distancia = 0;

        int count = 0;
        while (count < strlen(entrada) && entrada[count] != ' ')
        {
            strcat(nome, entrada[count]);
            count++;
        }
        nome[strcspn(nome, "\n")] = '\0';
        while (!isDigit(entrada[count]))
        {
            strcat(nome, entrada[count]);
            count++;
        }
        while (count < strlen(entrada) && entrada[count] != ' ')
        {
            distancia = distancia * 10 + (entrada[count] - '0');
            count++;
        }
        Celula *c = criandoCelula(nome, distancia);
    }
}