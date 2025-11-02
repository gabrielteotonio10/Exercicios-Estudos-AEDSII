package exercicios;
public class pilhaInverteString {
    static void atendendo(int clientes[]){
        int count= 0;
        int n= clientes.length;
        int x= 0;
        while(x<n){
            System.out.println("Atendendo cliente: "+ clientes[0]);
            for(int j=0; j<n-(x+1); j++){
                clientes[j]= clientes[j+1];
            }
            count++;
            System.out.println(count + " clientes atendidos");
            x++;
        }
    }
    public static void main(String[] args) {
        int clientes[]={3,5,2,3,12,3,4,6,4,3};
        atendendo(clientes);
        for(int i=0; i<clientes.length; i++){
            System.out.println(clientes[i]);
        }
    }   
}
