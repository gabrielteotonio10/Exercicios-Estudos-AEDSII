#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool verificacaoMercosulPadrao(char placa[]){
    int i=0;

    if(strlen(placa) != 7) return false;

    while(i<3)
    {
        if(placa[i] < 'A' || placa[i] > 'Z') return false;
        i++;
    }

    if(!isdigit(placa[i])) return false;
    else i++;

    if(placa[i] < 'A' || placa[i] > 'Z') return false;
    else i++;

    while(i<7)
    {
        if(!isdigit(placa[i])) return false;
        i++;
    }

    return true;
}

bool verificacaoAntigoPadrao(char placa[]){
    int i=0;

    if(strlen(placa) != 8) return false;

    while(i<3)
    {
        if(placa[i] < 'A' || placa[i] > 'Z') return false;
        i++;
    }

    if(placa[i]!='-') return false;
    else i++;

    while(i<8)
    {
        if(!isdigit(placa[i])) return false;
        i++;
    }

    return true;
}

int main()
{
    char placa[50];
    fgets(placa, 50, stdin);
    placa[strcspn(placa, "\n")]= '\0';

    bool teste1, teste2;
    teste1= verificacaoAntigoPadrao(placa);
    if(!teste1) teste2= verificacaoMercosulPadrao(placa);

    if(teste1) printf("1\n");
    else if(teste2) printf("2\n");
    else printf("0\n");
}

