import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;
import java.math.*;
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

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        int lf = size(node.left);
        int rf = size(node.right);

        int sum = lf + rf + 1;
        return sum;

    }

    public static int sum(Node head){
        if(head == null){
            return 0;
        }

        int lf = sum(head.left);
        int rf = sum(head.right);

        int sum = lf + rf  + head.data;
        return sum;
    }
    
    public static int max(Node head){
        if(head == null){
            return Integer.MIN_VALUE;
        }
        int lf = max(head.left);
        int rf = max(head.right);

        int max = Math.max(head.data, Math.max(lf, rf));
        
        return max;
    }

    public static int height(Node head){

        if(head == null){
            return -1;
        }    
         int lf = height(head.left);
         int rf = height(head.right);

         int ht = Math.max(lf,rf) + 1;



        return ht;
    }

    public static void preOrder(Node head){

        if(head == null){
            return;
        }

        
        preOrder(head.left);
        preOrder(head.right);
        System.out.println(head.data);
    }

    //rpa -- remove, print and add children in Queue
    public static void levelOrder(Node node){

        Queue<Node> que = new ArrayDeque<>();
        que.add(node);

        while(que.size()>0){
            
            int size = que.size();
            for(int i=0;i<size;i++){
                node= que.remove();
                System.out.print(node.data+",");
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
            System.out.println();
        }

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
        
        //display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(height(root));

       // preOrder(root);
        levelOrder(root);

    }
    
}
 