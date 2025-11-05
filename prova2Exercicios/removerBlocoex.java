package prova2Exercicios;

class CelulaDupla<T> {
    T elemento;
    CelulaDupla<T> prox; // Ponteiro para a próxima célula
    CelulaDupla<T> ant; // Ponteiro para a célula anterior
    // Construtores omitidos
}

class ListaDupla<T> {
    CelulaDupla<T> primeiro; // Célula Cabeça (pode ser dummy)
    CelulaDupla<T> ultimo; // Ponteiro para o último elemento (ou célula)
    // Demais métodos omitidos

    public void removerBloco(T valor) {
        CelulaDupla<T> i = primeiro;
        while (i != null) {
            if (i.elemento.equals(valor)) {
                if (i == ultimo && i == primeiro) {
                    primeiro = ultimo = null;
                } else if (i == ultimo) {
                    ultimo = i.ant;
                    ultimo.prox = null;
                    i.ant = i = null;
                } else if (i == primeiro) {
                    primeiro = i.prox;
                    if (primeiro != null)
                        primeiro.ant = null;
                    i = primeiro;
                } else {
                    i = i.prox;
                    i.ant.prox = i.ant.ant = null;
                    i.ant = i.ant.ant;
                    i.ant.prox = i;
                }
            } else {
                i = i.prox;
            }
        }
    }
}

public class removerBlocoex {

}
