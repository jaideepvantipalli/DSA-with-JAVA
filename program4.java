import java.util.HashSet;
import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}
public class program4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of nodes to insert : ");
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        Node head=new Node(a[0]);
        for(int i=1;i<n;i++){
            head=insert(head,a[i]);
        }
        System.out.println("Do You want to create a cycle (0/1) : ");
        int res=sc.nextInt();
        if( res==0 ){
            System.out.println("Enter the position to create cycle : ");
            int pos=sc.nextInt();
            Node temp=head,temp2=null;
            while(pos-- > 1){
                temp=temp.next;
            }
            temp2=temp;
            temp=head;
            while(temp.next != null){
                temp=temp.next;
            }
            temp.next=temp2;
        }
        findcycle(head);
    }
    public static Node insert(Node head,int data){
        Node newnode=new Node(data);
        Node temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=newnode;
        return head;
    }
    private static void findcycle(Node head){
        HashSet<Node> hs=new HashSet<>();
        while(head != null){
            if(!hs.contains(head))
                hs.add(head);
            else{
                System.out.println("Loop detected.Starting Node is : "+head.data);
                break;
            }
            head=head.next;
        }
    }
}
