#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool validadando(char c, char entrada[], int x)
{
    for (int i = x + 1; i < strlen(entrada) - 3; i++)
    {
        if (entrada[i] == '<' && entrada[i + 1] == '/' && entrada[i + 2] == c && entrada[i + 3] == '>')
        {
            return true;
        }
    }
    return false;
}

int main()
{
    // Capturando
    char entrada[500];
    scanf("%s", &entrada);
    entrada[strcspn(entrada, "\n")] = '\0';
    //
    bool teste = true;
    for (int i = 0; i < strlen(entrada) - 1 && teste; i++)
    {
        if (entrada[i] == '<' && entrada[i + 1] != '/')
        {
            if (entrada[i + 2] == '>')
            {
                i++;
                char c = entrada[i];
                teste = validando(c, entrada, i);
            }
        }
    }
    if(teste)
        printf("VALIDO");
    else   
        printf("INVALIDO");
}