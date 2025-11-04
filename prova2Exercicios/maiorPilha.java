package prova2Exercicios;

public class maiorPilha {

}

class Lista{
    CelulaLista inicio;
    CelulaLista fim;


    public CelulaLista maiorPilha(){
        return maiorPilha(inicio);
    }

    public CelulaLista maiorPilha(CelulaLista i){
        CelulaLista maior = null;
        int m = 0;
        while (i != null) {
            CelulaPilha j = i.topo;
            int novoM = 0;
            while (j != null) {
                novoM ++;
                j = j.prox;
            }
            if(novoM > m){
                m = novoM;
                maior = i;
            }
            i = i.prox;
        }
        return maior;
    }
}

class CelulaLista{
    CelulaPilha topo;
    CelulaLista prox;
}

class CelulaPilha {
    int elemento;
    CelulaPilha prox;
}