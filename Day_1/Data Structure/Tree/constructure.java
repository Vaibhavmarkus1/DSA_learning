import java.util.Stack;
public class constructure {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }  
    }

    public static void display(Node root){

        if(root==null){
            return;
        }

        String str = "";
        str+=root.left==null?".":root.left.data;
        str+="<--"+root.data+"-->";
        str+=root.right==null?".":root.right.data;

        System.out.println(str);

        display(root.left);
        display(root.right);



    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        int idx = 0;

        Node root = new Node(arr[idx],null, null);
        Pair RP = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(RP);

        while(st.size()>0){
          
            Pair top = st.peek();

            if(top.state == 1){
              idx++;
              if(arr[idx]!=null){
                Node lf = new Node(arr[idx], null, null);
                Pair lp = new Pair(lf, 1);
                top.node.left=lf;

                 st.push(lp);
              }
              else{
                   top.node.left=null;
              }
              top.state++;
            }
            else if(top.state == 2){
              idx++;
              if(arr[idx]!=null){
                Node rf = new Node(arr[idx], null, null);
                Pair rp = new Pair(rf, 1);
                top.node.right=rf;

                 st.push(rp);
              }
              else{
                   top.node.right=null;
              }
              top.state++;

            }
            else{
                st.pop();
            }


        }
        
        display(root);


    }
    
}
 