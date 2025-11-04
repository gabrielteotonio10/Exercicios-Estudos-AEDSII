package prova2Exercicios;

public class palavraArvore {

}

class Celula {
    public String palavra;
    public Celula prox;

    Celula() {
        this("");
    }

    Celula(String palavra) {
        this.palavra = palavra;
        prox = null;
    }
}

class No {
    public char letra;
    public No esq;
    public No dir;
    public Celula primeiro, ultimo;

    No(char c) {
        this.letra = c;
        esq = dir = null;
        primeiro = ultimo = new Celula();
    }
}

class Dicionario {
    private No raiz;

    // Considerando que a Ceula/Lista possui uma celula cabeça
    public void inserir(String palavra) {
        char c = palavra.charAt(0);
        this.raiz = getNo(c, raiz);
        No i = this.raiz;
        while (i.letra != c) {
            if (c < i.letra) {
                i = i.esq;
            } else {
                i = i.dir;
            }
        }
        if (i.primeiro == i.ultimo) {
            i.primeiro.prox = new Celula(palavra);
            i.ultimo = i.primeiro.prox;
        } else {
            Celula j = i.primeiro;
            for (; j.prox != null && j.prox.palavra.compareTo(palavra) < 0; j = j.prox) {
            }
            Celula tmp = new Celula(palavra);
            tmp.prox = j.prox;
            j.prox = tmp;
            if (tmp.prox == null) {
                i.ultimo = tmp; 
            }
            tmp = null;
        }
    }

    public No getNo(char c, No i) {
        if (i == null)
            return new No(c);
        if (c > i.letra){
            i.dir = getNo(c, i.dir);
        } else if (c < i.letra){
            i.esq = getNo(c, i.esq);
        }
        return i;
    }
}
