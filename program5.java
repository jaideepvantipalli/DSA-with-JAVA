import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}
public class program5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of nodes :");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter elements to insert : ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Node head=new Node(a[0]);
        for(int i=1;i<n;i++){
            head=insert(head,a[i]);
        }
        System.out.println("Enter the K value to rotate the list");
        int k=sc.nextInt();
        head=rotatelist(head,k,n);
        while (head != null) { 
            System.out.print(head.data+" - >");
            head=head.next;
        }
    }

    public static Node insert(Node head,int data){
        Node newnode= new Node(data);
        if(head == null) return newnode;
        if(head.next == null){
            head.next=newnode;
            return head;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        return head;
    }
    
    public static Node rotatelist(Node head,int k,int n){
        k=k%n;
        int s=n-k;
        Node temp=head,temp1=null,temp2=head;
        while (s-->0) { 
            temp1=temp2;
            temp2=temp2.next;
        }
        temp1.next=null;
        Node temp3=temp2;
        while(temp2.next !=null){
            temp2=temp2.next;
        }
        temp2.next=temp;
        head=temp3;
        return head;
    }
}
