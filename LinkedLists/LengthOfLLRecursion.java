import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }
}

public class LengthOfLLRecursion {

    static int length(Node head){

        if(head==null)
            return 0;

        return 1 + length(head.next);
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

        System.out.println("Length = "+length(head));
    }
}