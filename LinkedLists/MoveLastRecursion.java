import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }
}

public class MoveLastRecursion {

    static Node moveLast(Node head){

        if(head==null || head.next==null)
            return head;

        if(head.next.next==null){
            Node last=head.next;
            head.next=null;
            last.next=head;
            return last;
        }

        Node newHead=moveLast(head.next);
        return newHead;
    }

    static void display(Node head){

        while(head!=null){
            System.out.print(head.data+" -> ");
            head=head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        Node head=null,temp=null;
        int choice;

        do{
            System.out.print("Enter number: ");
            int data=sc.nextInt();

            Node newNode=new Node(data);

            if(head==null)
                head=temp=newNode;
            else{
                temp.next=newNode;
                temp=newNode;
            }

            System.out.print("Add another node? (1=Yes 0=Exit): ");
            choice=sc.nextInt();

        }while(choice==1);

        System.out.println("Original List:");
        display(head);

        head=moveLast(head);

        System.out.println("After Moving Last Node to Front:");
        display(head);
    }
}