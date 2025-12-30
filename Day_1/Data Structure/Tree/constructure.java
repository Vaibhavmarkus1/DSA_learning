import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
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

    public static class DiaPair {
    
        int ht;
        int dia;
        
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

    //State wise decision -- 1>pre, 2>in, 3>post
    public static void IterativePreOrder(Node head){

        String prestr = "";
        String posStr = "";
        String inStr = "";
        
        Pair rp = new Pair(head, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rp);

        while(st.size()>0){

            Pair tp = st.peek();
            if(tp.state==1){
                prestr+=tp.node.data+" ";
                 tp.state++;

                if(tp.node.left!=null){    
                    Pair np = new Pair(tp.node.left, 1);
                    st.push(np);
                    
                }
               
            }
            else if (tp.state == 2){
                inStr+=tp.node.data+" ";
                tp.state++;

                if(tp.node.right!=null){
                    Pair np = new Pair(tp.node.right, 1);
                    st.push(np);
                    
                }
                
            }
            else{
                    posStr+=tp.node.data+" ";
                    st.pop();
                

            }
        }
        System.out.println(prestr);
        System.out.println(inStr);
        System.out.println(posStr);

    }


    public static  ArrayList<Node> al =new ArrayList<>();

    public static boolean nodeToRoot(Node head, int target){
        if(head == null){
            return false;
        }

        if(head.data == target){
            al.add(head);
            return true;
        }

        boolean lf = nodeToRoot(head.left, target);
        if(lf){
            al.add(head);
            return true;
        }

        boolean rf = nodeToRoot(head.right, target);
        if(rf){
            al.add(head);
            return true;
        }
        return false;
    }

    public static void printKLevelDown(Node head, int k, Node blocker){
        
        if(head==null || k<0 || head==blocker){
            return;
        }
        if(k==0){
            System.out.println(head.data);
        }

        printKLevelDown(head.left,k-1,blocker);
        printKLevelDown(head.right,k-1,blocker);
    }
    
   public static void kDistanceFar(Node head, int data, int k){

     nodeToRoot(head, data);
     ArrayList<Node> ntp = al;

    for(int i = 0; i<ntp.size();i++){
        printKLevelDown(ntp.get(i), k-i, i==0?null:ntp.get(i-1));
    }

   }

   public static void pathToLeafFromNode(Node head, String path, int sum, int hi, int lo){
   
    if(head==null){
        return;
    }

    if(head.left ==null && head.right == null){

        sum +=head.data;
        path+=head.data;
        if(sum<=hi && sum>=lo){
            System.out.println(sum);
            System.out.println(path);
        }
        return;
    }


    pathToLeafFromNode(head.left, path + head.data + " ", sum+head.data, hi,lo);
    pathToLeafFromNode(head.right, path + head.data + " ", sum+head.data, hi,lo);

   }
    
   public static Node createLeftCloneTree(Node head){

    if(head == null ){
        return null;
    }

    Node lcr = createLeftCloneTree(head.left);
    Node rcr = createLeftCloneTree(head.right);

    Node nn = new Node(head.data,lcr,null);
    head.left = nn;
    head.right = rcr;
    
     return head;
   }

   public static void printSingleChildNode(Node child, Node parent){

    if(child == null){
        return;
    }
    if(parent!=null && parent.left == child && parent.right == null){
        System.out.println(child.data);
    }
    else if(parent!=null && parent.right==child && parent.left ==null){
        System.out.println(child.data);
    }
    printSingleChildNode(child.left, child);
    printSingleChildNode(child.right, child);

   }

   public static Node removeLeaves(Node node){

    if(node == null){
        return null;
    }

    if(node.left == null && node.right == null){
        return null;
    }

    node.left = removeLeaves(node.left);
    node.right = removeLeaves(node.right);
    return node;
   }


   public static DiaPair Diameter(Node node){
     
    if(node ==null){
        DiaPair bp = new DiaPair();
        bp.ht=-1;
        bp.dia = 0;
        return bp;
    }
    DiaPair lp = Diameter(node.left);
    DiaPair rp = Diameter(node.right);

    DiaPair mp = new DiaPair();

    mp.ht = Math.max(lp.ht,rp.ht) +1;

    int fes = lp.ht + rp.ht +2;
    mp.dia = Math.max(fes,Math.max(lp.dia, rp.dia));

    return mp;

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
        //levelOrder(root);
        //IterativePreOrder(root);
        //nodeToRoot(root, 30);
        //System.out.println(al);
        // printKLevelDown(root, 2);
        //kDistanceFar(root,25, 1);
        //pathToLeafFromNode(root,"",0,200,20);
        //Node cn = createLeftCloneTree(root);
        //display(cn);
        //printSingleChildNode(root, null);
        //display(root);
        //Node testNode = removeLeaves(root);
        //display(testNode);

        DiaPair dp = Diameter(root);
        System.out.println(dp.dia);
    }
    
}
 