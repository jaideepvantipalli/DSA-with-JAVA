import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}

public class LinkedList {

    static Node head = null;

    static void insertBegin(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    static void insertEnd(int val){
        Node newNode = new Node(val);

        if(head==null){
            head=newNode;
            return;
        }

        Node temp=head;

        while(temp.next!=null)
            temp=temp.next;

        temp.next=newNode;
    }

    static void insertPos(int val,int pos){

        Node newNode=new Node(val);
        Node temp=head;

        for(int i=1;i<pos-1;i++)
            temp=temp.next;

        newNode.next=temp.next;
        temp.next=newNode;
    }

    static void deleteBegin(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        head=head.next;
    }

    static void deleteEnd(){

        if(head==null){
            System.out.println("List is empty!");
            return;
        }

        Node temp=head,prev=null;

        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }

        prev.next=null;
    }

    static void deletePos(int pos){

        if(head==null){
            System.out.println("List is empty!");
            return;
        }

        Node temp=head,prev=null;

        for(int i=1;i<pos;i++){
            prev=temp;
            temp=temp.next;
        }

        prev.next=temp.next;
    }

    static void display(){

        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        while(true){

            System.out.println("1.Insert Begin");
            System.out.println("2.Insert End");
            System.out.println("3.Insert Position");
            System.out.println("4.Delete Begin");
            System.out.println("5.Delete End");
            System.out.println("6.Delete Position");
            System.out.println("7.Display");
            System.out.println("8.Exit");

            int ch=sc.nextInt();

            switch(ch){

                case 1:
                    System.out.println("Enter value to insert at beginning: ");
                    insertBegin(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Enter value to insert at end: ");
                    insertEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.println("Enter value and position to insert: ");
                    insertPos(sc.nextInt(),sc.nextInt());
                    break;

                case 4:
                    System.out.println("Deleting from beginning...");
                    deleteBegin();
                    break;

                case 5:
                    System.out.println("Deleting from end...");
                    deleteEnd();
                    break;

                case 6:
                    System.out.println("Enter position to delete: ");
                    deletePos(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Displaying list...");
                    display();
                    break;

                case 8:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}