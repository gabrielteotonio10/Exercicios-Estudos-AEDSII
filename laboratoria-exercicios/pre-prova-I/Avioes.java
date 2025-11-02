package exercicios;

import java.util.Scanner;

class Voos {
    String numero;
    String tipo;

    Voos() {
        numero = "";
        tipo = "";
    }

    Voos(String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }
}

public class Avioes {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        sc.nextLine();

        Voos v[] = new Voos[N];

        // Leitura dos voos
        for (int i = 0; i < N; i++) {
            String linha = sc.nextLine();
            String numero = "", tipo = "";
            int x = 0;

            // Pega o número do voo até o espaço
            while (x < linha.length() && linha.charAt(x) != ' ') {
                numero = numero + linha.charAt(x);
                x++;
            }

            // Ignora espaços
            while (x < linha.length() && linha.charAt(x) == ' ')
                x++;

            // Pega o tipo (direção)
            while (x < linha.length()) {
                tipo = tipo + linha.charAt(x);
                x++;
            }

            v[i] = new Voos(numero, tipo);
        }

        // Fila final
        Voos fila[] = new Voos[N];
        int pos = 0;

        // 1) Primeiro todos os do Oeste
        for (int i = 0; i < N; i++) {
            if (v[i].tipo.equalsIgnoreCase("Oeste")) {
                fila[pos++] = v[i];
            }
        }

        // 2) Alternância entre Norte e Sul
        int norteIndex = 0, sulIndex = 0;
        while (true) {
            // Pega 1 Norte
            while (norteIndex < N && !v[norteIndex].tipo.equalsIgnoreCase("Norte"))
                norteIndex++;
            if (norteIndex < N) {
                fila[pos++] = v[norteIndex++];
            }

            // Pega 1 Sul
            while (sulIndex < N && !v[sulIndex].tipo.equalsIgnoreCase("Sul"))
                sulIndex++;
            if (sulIndex < N) {
                fila[pos++] = v[sulIndex++];
            }

            // Sai do loop quando não tiver mais nenhum dos dois
            if (norteIndex >= N && sulIndex >= N)
                break;
        }

        // 3) Por último, os do Leste
        for (int i = 0; i < N; i++) {
            if (v[i].tipo.equalsIgnoreCase("Leste")) {
                fila[pos++] = v[i];
            }
        }

        // Saída final: imprime a fila organizada
        for (int i = 0; i < pos; i++) {
            System.out.println(fila[i].numero + " (" + fila[i].tipo + ")");
        }
    }
}
