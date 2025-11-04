

public class intercalacaoReversa {
    CelulaDupla intercalarReverso(CelulaDupla c1, CelulaDupla c2){
        CelulaDupla intercalada = new CelulaDupla(0);
        CelulaDupla resposta = intercalada;
        for(; c1.prox != null; c1 = c1.prox);
        for(; c2.prox != null; c2 = c2.prox);
        while (c1 != null || c2 != null) {
            if(c1 != null){
                CelulaDupla nova = new CelulaDupla(c1.elemento);
                intercalada.prox = nova;
                nova.ant = intercalada;
                intercalada = intercalada.prox;
                c1 = c1.ant;
            }
            if(c2 != null){
                CelulaDupla nova = new CelulaDupla(c2.elemento);
                intercalada.prox = nova;
                nova.ant = intercalada;
                intercalada = intercalada.prox;
                c2 = c2.ant;
            }
        }
        return resposta.prox;
    }
}

class CelulaDupla {
    int elemento;
    CelulaDupla ant;
    CelulaDupla prox;

    CelulaDupla(int elemento) {
        this.elemento = elemento;
        this.ant = null;
        this.prox = null;
    }
}
