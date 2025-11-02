package Pesquisa;
public class PesquisaBinaria {
    public static void main (String[] args)
    {
        int array[]= {1,2,3,4,5,6,7,8,9,10};
        int chave= 10;
        int posicao= -1;
        int dir= array.length-1, esq= 0, meio=-1, diferenca=-1;
        while (esq<=dir) 
        {
            meio= (dir+esq)/2;
            diferenca= chave-array[meio];    
            if(diferenca==0)
            {
                posicao= meio;
                esq= array.length;
            }
            else if(diferenca>0) esq= meio+1;
            else dir= meio-1;
        }
        System.out.println("A posicao eh: " + posicao+1);
    }
}
