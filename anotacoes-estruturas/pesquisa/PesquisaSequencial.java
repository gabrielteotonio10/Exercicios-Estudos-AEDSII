package Pesquisa;
public class PesquisaSequencial {
    public static void main (String[] args)
    {
        int array[]= {6,9,7,3,2,1,10,4,5,8};
        int chave= 10;
        int posicao= -1;
        for (int i=0; i<array.length; i++)
        {
            if (array[i]==chave)
            {
                posicao= i+1;
                i=array.length;
            }
        }
        System.out.println("A posicao eh: " + posicao);
    }
}
