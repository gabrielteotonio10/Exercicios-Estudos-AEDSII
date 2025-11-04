package prova2Exercicios;

public class contarPalavra {
    
}

class Arvore {
    No raiz;

    public int contarPalavra(char primeiro, char ultimo){
        return contarPalavra(primeiro, ultimo, raiz);
    }

    public int contarPalavra(char p, char u, No i){
        if(i == null)
            return 0;
        if(i.letra == p)
            return quantidade(u, i.raiz);
        if(i.letra > p)
            return contarPalavra(p, u, i.esq);
        if(i.letra < p)
            return contarPalavra(p, u, i.dir);
        return 0;
    }

    public int quantidade(char u, No2 i){
        int qnt = 0;
        if(i != null){
            int p = i.palavra.length() - 1;
            if(u == i.palavra.charAt(p))
                qnt++;
            qnt += quantidade(u, i.dir);
            qnt += quantidade(u, i.esq);
        }
        return qnt;
    }
}

class No {
    char letra;
    No esq;
    No dir;
    No2 raiz;

    No(char c) {
        this.letra = c;
        this.esq = null;
        this.dir = null;
    }
}

class No2 {
    String palavra;
    No2 esq, dir;

    No2(String s) {
        this.palavra = s;
        this.esq = this.dir = null;
    }
}