package prova2Exercicios;

public class BST {

}

class NoBSt {
    public int elemento;
    public NoBSt esq, dir;
    public int vezesInserido;

    NoBSt(int x) {
        this.elemento = x;
        esq = dir = null;
        vezesInserido = 1;
    }
}

class ArvoreBSt {
    private NoBSt raiz;

    public void inserir(int x) {
        raiz = inserirRec(x, raiz);
    }

    public NoBSt inserirRec(int x, NoBSt i) {
        if (i == null) {
            i = new NoBSt(x);
        } else if (x == i.elemento) {
            i.vezesInserido ++;
        } else if (x > i.elemento) {
            i.dir = inserirRec(x, i.dir);
        } else {
            i.esq = inserirRec(x, i.esq);
        }
        return i;
    }
}
