

public class EstruturasFlexiveis {

}

// Celula comum
class Celula {
    public int elemento;
    public Celula prox;

    // Construtores
    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

// Célula dupla
class CelulaDupla{
    public CelulaDupla prox;
    public CelulaDupla ant;
    public int elemento;
    public CelulaDupla(){
        this(0);
    }
    public CelulaDupla(int x){
        prox = null;
        ant = null;
        elemento = x;
    }
}

// Criação de uma fila
class Fila {
    private Celula primeiro, ultimo;

    Fila() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() {
        if (primeiro.prox == null)
            return 0;
        if (primeiro.prox == ultimo)
            ultimo = primeiro;
        int elemento = primeiro.prox.elemento;
        primeiro.prox = primeiro.prox.prox;
        return elemento;
    }

    public void mostrar() {
        System.out.println("[");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(" " + i.elemento);
        }
        System.out.print(" ]");
    }
}

// Criação de uma pilha
class Pilha {
    public Celula topo;

    public Pilha() {
        topo = null;
    }

    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public int remover() {
        if (topo == null)
            return 0;
        int elemento = topo.elemento;
        topo = topo.prox;
        return elemento;
    }

    public void mostrar() {
        System.out.println("[");
        for (Celula i = topo; i.prox != null; i = i.prox) {
            System.out.print(" " + i.elemento);
        }
        System.out.print(" ]");
    }
}

// Criação de uma lista
class Lista {
    private Celula primeiro, ultimo;

    Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo)
            ultimo = tmp;
        tmp = null;
    }

    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public void inserir(int x, int pos) {
        int tam = tamanho();
        if (pos > tam || pos < 1)
            return;
        else if (pos == tam)
            inserirFim(x);
        else if (pos == 1)
            inserirInicio(x);
        else {
            Celula i = primeiro.prox;
            for (int j = 1; j < pos; i = i.prox, j++) {
            }
            Celula tmp = i.prox;
            i.prox = new Celula(x);
            i.prox.prox = tmp;
            tmp = i = null;
        }
    }

    public int tamanho() {
        int tam = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            tam++;
        }
        return tam;
    }

    public int removerInicio() {
        if (primeiro == ultimo)
            return -1;
        int elemento = primeiro.prox.elemento;
        if (primeiro.prox == ultimo) {
            Celula tmp = primeiro.prox;
            primeiro.prox = null;
            ultimo = primeiro;
            tmp = null;
        } else {
            Celula tmp = primeiro.prox;
            primeiro.prox = primeiro.prox.prox;
            tmp.prox = null;
            tmp = null;
        }
        return elemento;
    }

    public int removerFim() {
        if (primeiro == ultimo)
            return -1;
        int elemento = ultimo.elemento;
        if (primeiro.prox == ultimo) {
            primeiro.prox = null;
            ultimo = primeiro;
        } else {
            Celula i;
            for (i = primeiro.prox; i.prox != ultimo; i = i.prox) {
            }
            ultimo = i;
            i = null;
        }
        return elemento;
    }

    public int remover(int pos) {
        if (ultimo == primeiro)
            return -1;
        int elemento = 0;
        if (pos > tamanho() || pos < 1)
            return -1;
        else if (pos == 1)
            elemento = removerInicio();
        else if (pos == tamanho())
            elemento = removerFim();
        else {
            Celula i = primeiro;
            for(int j = 1; j < pos; j++, i = i.prox){}
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox  = i.prox.prox;
            tmp.prox = tmp = i = null;
        }
        return elemento;
    }

}

// Lista dupla
class ListaDupla{
    private CelulaDupla primeiro, ultimo;
    public ListaDupla(){
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public void inserirInicio(int x){
        if(primeiro == ultimo){
            primeiro.prox = new CelulaDupla(x);
            ultimo = primeiro.prox;
            ultimo.ant = primeiro;
        }
        else{
            CelulaDupla tmp = new CelulaDupla(x);
            tmp.prox = primeiro.prox;
            primeiro.prox = tmp;
            tmp.prox.ant = tmp;
            tmp.ant = primeiro;
            tmp = null;
        }
    }

    public void inserirFim(int x){
        if(primeiro == ultimo){
            primeiro.prox = new CelulaDupla(x);
            ultimo = primeiro.prox;
            ultimo.ant = primeiro;
        }
        else{
            CelulaDupla tmp = new CelulaDupla(x);
            ultimo.prox = tmp;
            tmp.ant = ultimo;
            ultimo = tmp;
        }
    }

    public void inserir(int x, int pos){
        if(pos < 1 || pos > tamanho())
            return;
        if(pos == 1) inserirInicio(x);
        else if(pos == tamanho()) inserirFim(x);
        else{
            CelulaDupla i = primeiro;
            for(int j = 0; j < pos - 1; j++, i = i.prox){}
            CelulaDupla tmp = new CelulaDupla(x);
            tmp.prox = i.prox;
            i.prox= tmp;
            tmp.ant = i;
            tmp.prox.ant = tmp;
            i = tmp = null;
        }
    }

    public int tamanho() {
        int tam = 0;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            tam++;
        }
        return tam;
    }
}

