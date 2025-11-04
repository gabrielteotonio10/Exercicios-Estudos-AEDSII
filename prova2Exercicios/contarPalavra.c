int contarPalavra(char primeiro, char ultimo, No *i)
{
    if (i == NULL)
        return 0;
    if (i->letra == primeiro)
        return quantidade(ultimo, i->raiz);
    if (i->letra > primeiro)
        return contarPalavra(primeiro, ultimo, i->esq);
    if (i->letra < primeiro)
        return contarPalavra(primeiro, ultimo, i->dir);
    return 0;
}

int quantidade(char u, No2 i)
{
    int qnt = 0;
    if (i != NULL)
    {
        int p = strlen(i->palavra) - 1;
        char c = i->palvra[p];
        if (u == i)
            qnt++;
        qnt += quantidade(u, i->dir);
        qnt += quantidade(u, i->esq);
    }
    return qnt;
}





