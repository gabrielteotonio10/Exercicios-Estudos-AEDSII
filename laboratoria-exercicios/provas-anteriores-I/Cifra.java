import java.util.Scanner;

public class Cifra {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        String palavra;
        palavra = scanner.nextLine();
        while (palavra.length()!=3 && palavra.charAt(0) != 'F' && palavra.charAt(0) != 'I' && palavra.charAt(0) != 'M') {
            String p1 = "", p2 = "";
            int x = 0;
            while (palavra.charAt(x) != ' ') {
                p1 += palavra.charAt(x);
                x++;
            }
            x += 3;
            while (x < palavra.length()) {
                p2 += palavra.charAt(x);
                x++;
            }

            int qnt = 0;
            if (p1.length() == p2.length()) {
                for (int i = 0; i < p1.length(); i++) {
                    char c = p1.charAt(i);
                    for (int j = 0; j < p1.length(); j++) {
                        if (Character.toUpperCase(c) == Character.toUpperCase(p2.charAt(j))) {
                            qnt++;
                            j = p1.length();
                        }
                    }
                }
            }
            if (qnt == p1.length())
                System.out.println("SIM");
            else
                System.out.println("NÃO");

            palavra = scanner.nextLine();
        }
        scanner.close();
    }
}
