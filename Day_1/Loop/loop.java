package DSA_learning.Day_1.Loop;
import java.util.Scanner;

public class loop{
    
    public static void main(String[] args){

        Scanner scn= new Scanner(System.in);
        int x = scn.nextInt();
        int i=1;

        while(i<=10){
            System.out.println("x "+"*"+" i" +" = "+ x*i);
            System.out.println();
            i++;
        }

    }
}
