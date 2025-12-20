import java.util.Scanner;

public class Prime {

public static boolean primechecker(int x){

    if ( x==1){
        System.out.println("Neither Prime nor composite");
        return false;
    }

    for(int i=2; i*i<=x; i++){
       if(x%i==0){
        return false;
       }
    }
    return true;
}    

    public static void main(String[] args) {
        System.out.println("Prime number Checker");

        Scanner scn = new Scanner(System.in);     
        int a = scn.nextInt();  
        Boolean x= primechecker(a);  
        if(x == true){
           System.out.println("Prime");
        }
        else{
           System.out.println("Not Prime");
        }

        scn.close();
    }
    
}
