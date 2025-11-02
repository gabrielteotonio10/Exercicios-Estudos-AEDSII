package exercicios;
import java.util.Scanner;

public class TorneioTenis {
    private static final Scanner sc= new Scanner(System.in);
    public static void main(String args[]){
        String jogo;
        int ganhos= 0;
        for (int i=0; i<6; i++){
            jogo= sc.nextLine();
            if(jogo.charAt(0)=='V') ganhos++;
        }
        if(ganhos==5 || ganhos==6) System.out.println("1");
        else if(ganhos==3 || ganhos==4) System.out.println("2");
        else if(ganhos==1 || ganhos==2) System.out.println("3");
        else System.out.println("-1");
    }
}
