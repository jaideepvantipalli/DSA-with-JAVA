import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class program3{
    static ArrayList<Integer> al=new ArrayList<>();
    static int floor=-1,ceil=-1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of nodes in BST : ");
        int n=sc.nextInt();
        int a[]=new int[n];
        Node root=new Node(a[0]);
        System.out.println("Enter the nodes to insert : ");
        for(int i=1;i<n;i++){
            a[i]=sc.nextInt();
        }

        for(int i=1;i<n;i++) insert(root,a[i]);
        System.out.println("Enter the key to find the Floor and Ceil : ");
        sc.nextLine();
        int key=sc.nextInt();
        inorder(root);
        /*int floor=-1,ceil=-1;
        for(int val : al){
            if(val<=key) floor=val;
        }
        for(int val : al){
            if(val>=key){
                ceil=val;
            break;
            }
        }
        System.out.println("Floor is : "+floor+"Ceil is : "+ceil);*/
    }
    /*static void floorandceil(Node root,int data){
        int floor=-1,ceil=-1;
        while(root!=null){
            
        }
    }*/
   static void findFloorCeil(Node root,int key){
    while(curr!=null){
        if(root.data==key){
            floor=root.data;
            ceil=root.data;
        }
        if(root.data>key){
            ceil=root.data;
            root.right, key);
        }
        if(root.data,key){
            floor=root.data;
            findFloorCeil(root.left, key);
        }
    }

   }
     static void inorder(Node root){
        if(root==null) return al.add(-1);
        inorder(root.left);
        al.add(root.data);
        inorder(root.right);
    }

    public static void insert(Node root,int data){
        Node newnode=new Node(data);
        Node parent=null,curr=root;
        while(curr!=null){
            if(data < curr.data){
                parent=curr;
                curr=curr.left;
            }else{
                parent=curr;
                curr=curr.right;
            }
        }
        if(data<parent.data){
            parent.left=newnode;
        }else{
            parent.right=newnode;
        }
    }
}