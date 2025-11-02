#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    char palavra1[50];
    fgets(palavra1, 50, stdin);
    palavra1[strcspn(palavra1, "\n")] = '\0';

    char palavra2[50];
    fgets(palavra2, 50, stdin);
    palavra2[strcspn(palavra2, "\n")] = '\0';

    char palavra[100];
    int i = 0;
    int j = 0;
    bool teste = true;
    while (strlen(palavra1)>=i || strlen(palavra2)>=i)
    {
        if (palavra1[i] != '\0')
        {
            palavra[j] = palavra1[i];
            j++;
        }
        if (palavra1[i] != '\0')
        {
            palavra[j] = palavra2[i];
            j++;
        }
        i++;
    }
    printf("%s", palavra);
}