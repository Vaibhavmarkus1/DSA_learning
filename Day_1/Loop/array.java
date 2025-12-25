package DSA_learning.Day_1.Loop;
import java.util.Scanner; 

public class array {

    public static void main(String[] args) {
        


        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the array length");
        int n = scn.nextInt();


        int[] arr = new int[n];
        for(int i=0;i<n;i++){
          System.out.println("Enter the values");  
          int p = scn.nextInt();
          

          arr[i] =p;

        }

        for(int i:arr){
          
          System.out.println("Printing the values:->" +i);

        }

        scn.close();
    }
    
}
 