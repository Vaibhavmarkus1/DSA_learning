public class rightside { 

public static void main(String[] args){
  System.out.println("First Pattern");
  for(int i=0;i<5;i++){
    for(int j=5;j>i;j--){
      System.out.print(" ");
    }
    for(int k=0;k<=i;k++){
      System.out.print("*");
    }
    System.out.println();
  }

}

}
