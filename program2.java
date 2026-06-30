import java.util.Scanner;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class program2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of nodes to insert : ");
        int n=sc.nextInt();
        int a[]=new int [n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        Node root=new Node(a[0]);
        for(int i=1;i<n;i++){
            insert(root,a[i]);
        }
        inoder(root);
        System.out.println();
        System.out.println("Enter n1 and n2 : ");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        Node temp;
        temp=LowestCommonAncestor(root,n1,n2);
        System.out.println("Ancestor : "+temp.data);
    }
    public static Node LowestCommonAncestor(Node root,int n1,int n2){
        if(root==null) return null;
        if(root.data>n1 && root.data>n2)
            return LowestCommonAncestor(root.left,n1,n2);
        if(root.data<n1 && root.data<n2)
            return LowestCommonAncestor(root.right,n1,n2);
        return root;
    }
    public static void inoder(Node root){
        if(root==null) return;
        inoder(root.left);
        System.out.print(root.data+" ");
        inoder(root.right);
    }

    public static void insert(Node root,int data){
        Node newnNode=new Node(data);
        Node parent=null,curr=root;
        while(curr!=null){
        if(data<curr.data){
            parent=curr;
            curr=curr.left;
        }
        else{
            parent=curr;
            curr=curr.right;
        }
        }
        if(data<parent.data){
            parent.left=newnNode;
        }
        else{
            parent.right=newnNode;
        }
    }
}