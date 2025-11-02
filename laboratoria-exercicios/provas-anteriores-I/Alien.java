import java.util.Scanner;

public class Alien {

    private static final Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        //Variaveis de tamanho
        int K=0, N=0;
        String entrada= sc.nextLine();
        int x= 0;
        //Captura o K
        while(x < entrada.length() && entrada.charAt(x)!=' '){
            K= K * 10 + (entrada.charAt(x) - '0');  
            x++;
        }
        //Remove os espaços
        while(x < entrada.length() && entrada.charAt(x)==' ') x++;
      
        //Captura o N
        while(x < entrada.length()){
            N= N * 10 + (entrada.charAt(x) - '0');
            x++;
        }
        //Pega o valor do alfabeto e do codigo
        String alfabeto= sc.nextLine();
        String codigo= sc.nextLine();
        boolean teste= true;
        //Confere se o codigo está presente no alfabeto
        for(int i=0; i<N; i++){
            boolean contem= false;
            for(int j=0; j<K; j++){
                if(alfabeto.charAt(j) == codigo.charAt(i)){
                    contem= true;
                    j= K;
                }
            }
            //Se o caracter da posição i do codigo nao está presente no alfabeto o teste fica falso e sai do loop
            if(!contem){
                teste= false;
                break;
            }
        }
        //Mostra o resultado 
        if(teste) System.out.println("S");
        else System.out.println("N");

        sc.close();
    }
}
