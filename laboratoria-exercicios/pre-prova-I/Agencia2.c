#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int main()
{
    char inteiros[10];
    fgets(inteiros, 10, stdin);
    inteiros[strcspn(inteiros, "\n")] = '\0';

    int tam1 = 0, tam2 = 0;
    int x = 0;
    while (isdigit(inteiros[x]))
    {
        tam1 = tam1 * 10 + (inteiros[x] - '0');
        x++;
    }
    while (inteiros[x] == ' ')
        x++;
    while (x < strlen(inteiros))
    {
        tam2 = tam2 * 10 + (inteiros[x] - '0');
        x++;
    }

    char sa[50];
    fgets(sa, 50, stdin);
    sa[strcspn(sa, "\n")] = '\0'; 
    int SA[tam1];
    int i = 0;
    x = 0;
    while (sa[i] == '[' || sa[i] == ',')
    {
        i++;
        SA[x] = 0;
        while (sa[i] != ']' && sa[i] != ',')
        {
            SA[x] = SA[x] * 10 + (sa[i] - '0');
            i++;
        }
        x++;
    }

    char sb[50];
    fgets(sb, 50, stdin);
    sb[strcspn(sb, "\n")] = '\0';
    int SB[tam2];
    i = 0, x = 0;
    while (sb[i] == '[' || sb[i] == ',')
    {
        i++;
        SB[x] = 0;
        while (sb[i] != ']' && sb[i] != ',')
        {
            SB[x] = SB[x] * 10 + (sb[i] - '0');
            i++;
        }
        x++;
    }

    x = -1;
    i = -1;
    bool teste = true;
    for (int a = 0; a < tam2; a++)
    {
        for (int j = 0; j < tam1; j++)
        {
            if (SB[a] == SA[j])
            {
                x = j;
            }
        }
        if (x < i)
        {
            teste = false;
            break;
        }
        i = x;
    }
    if (teste)
        printf("S\n");
    else
        printf("N\n");
}
