import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }
}

public class LengthOfLLIteration {

    static int length(Node head){
        int count=0;
        Node temp=head;

        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
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

        System.out.println("Length of Linked List = "+length(head));
    }
}