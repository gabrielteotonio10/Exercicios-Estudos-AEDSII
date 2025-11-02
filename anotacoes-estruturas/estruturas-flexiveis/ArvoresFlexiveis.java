package anotacoes-estruturas.estruturas-flexiveis;

public class ArvoresFlexiveis {

}

class No {
    int elemento;
    No esq, dir;

    No(int elemento) {
        this(elemento, null, null);
    }

    No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    public No raiz;

    // Construtor
    public ArvoreBinaria() {
        raiz = null;
    }

    // Inserir
    public void inserir(int x) {
        raiz = inserir(x, raiz);
    }

    public No inserir(int x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (i.elemento > x)
            inserir(x, i.esq);
        else if (i.elemento < x)
            inserir(x, i.dir);
        return i;
    }

    // Inserir pai
    public void inserirPai(int x, No pai) throws Exception {
        raiz = inserirPai(x, raiz, pai);
    }

    public No inserirPai(int x, No i, No pai) throws Exception {
        if (i == null) {
            if (x < pai.elemento) {
                pai.esq = new No(x);
            } else {
                pai.dir = new No(x);
            }
        } else if (i.elemento > x)
            inserirPai(x, i.esq, i);
        else if (i.elemento < x)
            inserirPai(x, i.dir, i);
        else {
            throw new Exception("Erro!");
        }
        return i;
    }

    // Pesquisar
    public boolean pesquisar(int x) throws Exception {
        return pesquisar(x, raiz);
    }

    public boolean pesquisar(int x, No i) throws Exception {
        boolean teste = true;
        if (i == null) {
            teste = false;
        } else if (i.elemento == x)
            teste = true;
        else if (i.elemento > x)
            teste = pesquisar(x, i.esq);
        else if (i.elemento < x)
            teste = pesquisar(x, i.dir);
        else {
            throw new Exception("Erro !");
        }
        return teste;
    }

    // Pegando maior e menor
    public int getMaior(No i) throws Exception {
        if (i == null)
            throw new Exception("Erro !");
        int maior = i.elemento;
        if (i.dir != null)
            maior = getMaior(i.dir);
        System.out.println("Valor: " + maior);
        return maior;
    }

    public int getMaior() {
        int resp = -1;
        if (raiz != null) {
            No i;
            for (i = raiz; i.dir != null; i = i.dir) {
            }
            resp = i.elemento;
        }
        return resp;
    }

    public int getMenor() {
        int resp = -1;
        if (raiz != null) {
            No i;
            for (i = raiz; i.esq != null; i = i.esq) {
            }
            resp = i.elemento;
        }
        return resp;
    }

    // Remover
    public void remover(int x) throws Exception {
        raiz = remover(x, raiz);
    }

    public No remover(int x, No i) throws Exception {
        if (i == null)
            throw new Exception("Erro !");
        else if (x < i.elemento)
            i.esq = remover(x, i.esq);
        else if (x > i.elemento)
            i.dir = remover(x, i.dir);
        else if (i.dir == null)
            i = i.esq;
        else if (i.esq == null)
            i = i.dir;
        else
            i.esq = maiorEsq(i, i.esq);
        return i;
    }

    public No maiorEsq(No i, No iEsq) {
        if (iEsq.dir == null) {
            i.elemento = iEsq.elemento;
            iEsq = iEsq.esq;
        } else
            iEsq.dir = maiorEsq(i, iEsq.dir);
        return iEsq;
    }

    // Mostrar
    public void caminhaPre(No i) {
        if (i != null) {
            System.out.println(i.elemento + " ");
            caminhaPre(i.esq);
            caminhaPre(i.dir);
        }
    }

    public void caminhaCentral(No i) {
        if (i != null) {
            caminhaCentral(i.esq);
            System.out.println(i.elemento + " ");
            caminhaCentral(i.dir);
        }
    }

    public void caminhaPos(No i) {
        if (i != null) {
            caminhaPos(i.esq);
            caminhaPos(i.dir);
            System.out.println(i.elemento + " ");
        }
    }

    // Altura
    public int altura() {
        return altura(raiz, 0);
    }

    public int altura(No i, int tam) {
        if (i == null) {
            tam--;
        } else {
            int alturaEsq = altura(i.esq, tam + 1);
            int alturaDir = altura(i.dir, tam + 1);
            tam = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
        return tam;
    }

    // Inserindo 100.000 elementos de forma aleatória
    public void aleatorio(No i) {
        int tam = numeroElementos(i);
        System.out.println("Número de elementos: " + tam);
        for (int j = 0; j < 100000; j++) {
            int numero = (int) (Math.random() * Integer.MAX_VALUE);
            inserir(numero);
            System.out.println("Número de elementos: " + (++tam));
        }
    }

    // Quantidade de elementos na árvore
    public int numeroElementos(No i) {
        if (i == null)
            return 0;
        int tam = 1;
        if (i.esq != null) {
            tam += numeroElementos(i.esq);
        }
        if (i.dir != null) {
            tam += numeroElementos(i.dir);
        }
        return tam;
    }

    // Soma dos elementos da árvore
    public int soma() throws Exception {
        return soma(raiz);
    }

    public int soma(No i) throws Exception {
        if (i == null)
            throw new Exception("Erro !");
        int soma = i.elemento;
        if (i.esq != null)
            soma += soma(i.esq);
        if (i.dir != null)
            soma += soma(i.dir);
        return soma;
    }

    // Verificando se 2 árvores são iguais
    static boolean iguais(No i, No j) {
        boolean teste;
        if (i != null && j != null) {
            teste = (i.elemento == j.elemento) && iguais(i.esq, j.esq) && iguais(i.dir, j.dir);
        } else if (i == null && j == null) {
            teste = true;
        } else {
            teste = false;
        }
        return teste;
    }

    // Vendo se algum elemento é divisível por 11
    public boolean divizivel11(No i){
        boolean teste = true;
        if(i == null)
            teste = false;
        else if(i.elemento % 11 == 0){
            teste
        }
    }
}
