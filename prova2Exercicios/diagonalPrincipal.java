package prova2Exercicios;

public class diagonalPrincipal {

}

class Matriz {
    public CelulaMatriz inicio;
    public int linha, coluna;

    public CelulaDupla diagUnificada() {
        CelulaDupla cel = new CelulaDupla();
        CelulaDupla resposta = cel;
        for (CelulaMatriz x = inicio; x != null; x = x.inf.dir) {
            for (Celula lista = x.inicio.prox; lista != null; lista = lista.prox) {
                cel.prox = new CelulaDupla(lista.elemento);
                cel.prox.ant = cel;
                cel = cel.prox;
            }
        }
        return resposta;
    }
}

class CelulaMatriz {
    public CelulaMatriz esq, dir, inf, sup;
    public Celula inicio, fim;
}

class Celula {
    public int elemento;
    public Celula prox;
}

class CelulaDupla {
    public int elemento;
    public CelulaDupla prox, ant;

    CelulaDupla() {
        this(0);
    }

    CelulaDupla(int x) {
        this.elemento = x;
        prox = ant = null;
    }
}