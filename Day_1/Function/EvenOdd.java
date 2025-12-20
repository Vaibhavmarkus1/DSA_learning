public class EvenOdd {
    
public static boolean evenOddChecker(int x){
    
    if (x%2==0){
        return true;
    }

    return false;

}    
    public static void main(String[]  args){
        System.out.println("This is odd and Even Checker");

        boolean x=evenOddChecker(5);
        System.out.println(x);

    }
}
