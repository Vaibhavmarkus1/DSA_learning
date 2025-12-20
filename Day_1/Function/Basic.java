public class Basic{

public static void myFunction(){
    System.out.println("Inside Function");
}   

public static char myFunction2(String txt){
    System.out.println("Inside Function of return integer");
    return txt.charAt(9);
}   

public static void main(String[] args){
    
    System.out.println("Printing the this");
    String txt = "Please locate where 'locate' occurs!";
    myFunction();
    char len1 = myFunction2(txt);
    System.out.println(len1);
}
    
}