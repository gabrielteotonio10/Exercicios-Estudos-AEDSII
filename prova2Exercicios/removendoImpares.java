package prova2Exercicios;

public class removendoImpares {
    // Errado
    public void removerImpar(Matriz primeira) {
        for (CelulaMat i = primeira.inicio; i != null; i = i.prox) {
            for (CelulaMat j = i; j != null; j = j.inf) {
                for (Celula lista = j.primeiro; lista.prox != null; lista = lista.prox) {
                    if (lista.prox.numero % 2 != 0) {
                        if (j.primeiro.prox == j.ultimo) {
                            j.primeiro.prox = null;
                            j.ultimo = j.primeiro;
                        } else if (lista.prox == j.ultimo) {
                            j.ultimo = lista;
                            lista.prox = null;
                        } else {
                            Celula tmp = lista.prox;
                            lista.prox = lista.prox.prox;
                            tmp.prox = tmp = null;
                        }
                    }
                }
            }
        }
    }

    // Certo
    public void removerImpar3(Matriz primeira) {
        for (CelulaMat i = primeira.inicio; i != null; i = i.prox) {
            for (CelulaMat j = i; j != null; j = j.inf) {
                Celula lista = j.primeiro;
                while (lista.prox != null) {
                    if (lista.prox.numero % 2 != 0) {
                        // Caso 1: só um elemento na lista
                        if (j.primeiro.prox == j.ultimo) {
                            j.primeiro.prox = null;
                            j.ultimo = j.primeiro;
                        }
                        // Caso 2: último elemento é ímpar
                        else if (lista.prox == j.ultimo) {
                            j.ultimo = lista;
                            lista.prox = null;
                        }
                        // Caso 3: elemento no meio
                        else {
                            lista.prox = lista.prox.prox;
                        }
                    } else {
                        lista = lista.prox; // só avança se não removeu
                    }
                }
            }
        }
    }

}

class Celula {
    int numero;
    Celula prox;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.numero = elemento;
        prox = null;
    }
}

class CelulaMat {
    CelulaMat prox, ant, sup, inf;
    Celula primeiro, ultimo;

    public CelulaMat() {
        prox = ant = sup = inf = null;
        ultimo = new Celula();
        primeiro = ultimo;
    }

}

class Matriz {
    CelulaMat inicio;
}
