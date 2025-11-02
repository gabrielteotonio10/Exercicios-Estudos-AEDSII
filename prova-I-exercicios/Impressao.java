package exercicios;

public class Impressao {
    public String nome;
    public int numeroPag;
    static int ultimoFila = 0;

    Impressao() {
        ultimoFila++;
    }

    public static void main(String[] args) {
        int n = 10;
        Impressao imprimir[] = new Impressao[n];

        // Instancie e preencha o objeto para o índice 0
        imprimir[0] = new Impressao();
        imprimir[0].nome = "A Sombra do Vento";
        imprimir[0].numeroPag = 354;

        // Instancie e preencha o objeto para o índice 1
        imprimir[1] = new Impressao();
        imprimir[1].nome = "O Alquimista";
        imprimir[1].numeroPag = 208;

        // Instancie e preencha o objeto para o índice 2
        imprimir[2] = new Impressao();
        imprimir[2].nome = "Dom Quixote";
        imprimir[2].numeroPag = 992;

        // Instancie e preencha o objeto para o índice 3
        imprimir[3] = new Impressao();
        imprimir[3].nome = "Cem Anos de Solidão";
        imprimir[3].numeroPag = 417;

        // Instancie e preencha o objeto para o índice 4
        imprimir[4] = new Impressao();
        imprimir[4].nome = "1984";
        imprimir[4].numeroPag = 328;

        // Instancie e preencha o objeto para o índice 5
        imprimir[5] = new Impressao();
        imprimir[5].nome = "O Hobbit";
        imprimir[5].numeroPag = 310;

        // Instancie e preencha o objeto para o índice 6
        imprimir[6] = new Impressao();
        imprimir[6].nome = "O Pequeno Príncipe";
        imprimir[6].numeroPag = 96;

        // Instancie e preencha o objeto para o índice 7
        imprimir[7] = new Impressao();
        imprimir[7].nome = "A Metamorfose";
        imprimir[7].numeroPag = 78;

        // Instancie e preencha o objeto para o índice 8
        imprimir[8] = new Impressao();
        imprimir[8].nome = "Orgulho e Preconceito";
        imprimir[8].numeroPag = 432;

        // Instancie e preencha o objeto para o índice 9
        imprimir[9] = new Impressao();
        imprimir[9].nome = "Crime e Castigo";
        imprimir[9].numeroPag = 608;

        while (ultimoFila >= 0) {
            System.out.println("Imprimindo: " + imprimir[0].nome);
            System.out.println("Imprimindo: " + imprimir[0].numeroPag + "\n\n");
            for (int j = 0; j < ultimoFila - 1; j++) {
                imprimir[j].nome = imprimir[j+1].nome;
                imprimir[j].numeroPag = imprimir[j+1].numeroPag;
            }
            ultimoFila--;
            imprimir[ultimoFila] = null;
        }
    }
}


