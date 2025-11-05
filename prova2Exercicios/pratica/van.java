package prova2Exercicios.pratica;
import java.util.Scanner;

class Celula{
    public String nome;
    public int distancia;
    public Celula prox;

    public Celula(){
        nome = "";
        distancia = 0;
    }

    public Celula(String nome, int distancia){
        this.nome = nome;
        this.distancia = distancia;
    }
}

class Lista{
    public Celula primeiro;
    
    public Lista(){
        primeiro = new Celula();
    }
}

public class van {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // Capturando quantidade de alunos
        int n = sc.nextInt();
        sc.nextLine();
        Lista lista = new Lista();
        for(int i = 0; i < n; i++){
            String entrada = sc.nextLine();
            String nome = "";
            int distancia = 0;
            int j = 0;
            while (entrada.charAt(j) != ' ') {
                nome += entrada.charAt(j);
                j++;
            }
            while (!Character.isDigit(entrada.charAt(j))) {
                j++;
            }
            while (j != entrada.length()) {
                distancia = distancia * 10 + (entrada.charAt(j) - '0');
                j++;
            }
            // Colocando na lista
            Celula novo = new Celula(nome, distancia);
            Celula tmp = lista.primeiro;
            boolean teste = false;
            while(!teste && tmp != null){
                if(tmp.prox == null){
                    tmp.prox = novo;
                    teste = true;
                }
                else if(tmp.prox.distancia >= novo.distancia){
                    if(tmp.prox.distancia == novo.distancia){
                        while (tmp.prox.distancia == novo.distancia && tmp.prox.nome.compareTo(novo.nome) < 0) {
                            tmp = tmp.prox;
                        }
                    }
                    novo.prox = tmp.prox;
                    tmp.prox = novo;
                    teste = true;
                }
                tmp = tmp.prox;
            }
        }
        Celula j = lista.primeiro.prox;
        for(int i = 0; i < n; i++, j = j.prox){
            System.out.println(j.nome);
        }
    }
}
