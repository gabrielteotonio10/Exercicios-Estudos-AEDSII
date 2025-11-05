package prova2Exercicios.pratica;

import java.util.Scanner;
import java.util.Stack; // Importação essencial para a pilha

public class posFixaChat {

    static final Scanner sc = new Scanner(System.in);

    // Método auxiliar para verificar se um caractere é um operador
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Método auxiliar para definir a precedência dos operadores
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; // Maior precedência para exponenciação
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha após o int

        for (int x = 0; x < n; x++) {
            String entrada = sc.nextLine().replaceAll("\\s+", ""); // Remove todos os espaços
            
            // StringBuilder é mais eficiente para concatenar a saída
            StringBuilder posFixo = new StringBuilder();
            
            // Pilha para armazenar os operadores
            Stack<Character> operadores = new Stack<>();

            // A lógica de Infixa para Posfixa deve ser baseada em Stack!
            for (int j = 0; j < entrada.length(); j++) {
                char c = entrada.charAt(j);

                // 1. É um operando (letra/número)? -> Adiciona diretamente à saída.
                if (Character.isLetterOrDigit(c)) {
                    posFixo.append(c);
                }
                // 2. É um parêntese de abertura? -> Empilha.
                else if (c == '(') {
                    operadores.push(c);
                }
                // 3. É um parêntese de fechamento? -> Desempilha e move operadores para a saída
                //    até encontrar o parêntese de abertura correspondente.
                else if (c == ')') {
                    while (!operadores.isEmpty() && operadores.peek() != '(') {
                        posFixo.append(operadores.pop());
                    }
                    if (!operadores.isEmpty() && operadores.peek() == '(') {
                        operadores.pop(); // Remove o '(' da pilha
                    }
                }
                // 4. É um operador? -> Segue a regra de precedência.
                else if (isOperator(c)) {
                    // Desempilha operadores com precedência maior ou igual (e não '(')
                    // (Regra de associatividade à esquerda para +, -, *, /)
                    // O '^' é associativo à direita, então é só maior (>)
                    while (!operadores.isEmpty() && 
                           precedence(operadores.peek()) >= precedence(c) &&
                           operadores.peek() != '(') 
                    {
                         // Regra especial para associatividade à direita de ^
                         if (c == '^' && operadores.peek() == '^') break;
                         
                         posFixo.append(operadores.pop());
                    }
                    operadores.push(c); // Empilha o novo operador
                }
            }

            // 5. Após varrer a string, desempilha todos os operadores restantes
            while (!operadores.isEmpty()) {
                posFixo.append(operadores.pop());
            }

            System.out.println(posFixo.toString());
        }
    }
}