import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class Basic{

    public static void main(String[] args){
     
        Scanner scn = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
        HashSet<String> hs = new HashSet<String>();
        hs.add("Vaibhav");
        hs.add("Pandey");
        hs.add("Yukti");
        hs.add("Pandey");
        
        Iterator<String> it = hs.iterator();

        while(it.hasNext()){
           System.out.println(it.next());
        }

        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(1, "Vaibhav");
        hm.put(2, "Afzal");
        hm.put(3, "Karan");

        for(int i = 1; i<=hm.size();i++){
          System.out.println(hm.get(i));
        }
        

        System.out.println("Enter number of Cousions you have");
        int count = scn.nextInt();

        System.out.println("Enter there names");
        for(int i = 1; i <= count;i++){
            String a = scn.next();
            str.add(a);
            
        }

        for(String i : str){
            System.out.println("Cousions -: "+i);
        }
        scn.close();

    }
}