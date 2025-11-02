#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
    char qntE[50];
    fgets(qntE, 50, stdin);
    qntE[strcspn(qntE, "\n")] = '\0';
    int tam1= 0;
    int tam2= 0;
    int x=0;
    while(qntE[x]!=' '){
        tam1= (tam1*10) + (qntE[x] - '0');
        x++;
    }
    x++;
    while(qntE[x]!='\0'){
        tam2= (tam2*10) + (qntE[x] - '0');
        x++;
    }

    char saE[50];
    fgets(saE, 50, stdin);
    saE[strcspn(saE, "\n")] = '\0';
    int sa[tam1];
    x= 0;
    int num=0;
    for (int i = 0; saE[i] != '\0'; i++) {
        if (saE[i] >= '0' && saE[i] <= '9') {
            num = (num * 10) + (saE[i] - '0');
        } else if (saE[i] == ' ') {
            sa[x++] = num;
            num = 0;
        }
    }
    sa[x++] = num;

    char sbE[50];
    fgets(sbE, 50, stdin);
    sbE[strcspn(sbE, "\n")] = '\0';
    int sb[tam2];
    x= 0;
    num=0;
    for (int i = 0; sbE[i] != '\0'; i++) {
        if (sbE[i] >= '0' && sbE[i] <= '9') {
            num = (num * 10) + (sbE[i] - '0');
        } else if (sbE[i] == ' ') {
            sb[x++] = num;
            num = 0;
        }
    }
    sb[x++] = num;

    bool teste = true;
    int aux = -1;
    for(int i = 0; i < tam2; i++) {
        bool achou = false;
        for(int j = aux+1; j < tam1; j++) {
            if(sb[i] == sa[j]) {
                aux = j;
                achou = true;
                break;
            }
        }
        if(!achou) {
            teste = false;
            break;
        }
    }

    if(teste) printf("S\n");
    else printf("N\n");
}

