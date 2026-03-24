import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleLinkedList {

    Node head = null;

    void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    void findMiddleTwoTraversal() {

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;

        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        System.out.println("Middle node (Two Traversal) = " + temp.data);
    }

    void findMiddleOnePass() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          
            fast = fast.next.next;     
        }

        System.out.println("Middle node (Slow-Fast Pointer) = " + slow.data);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MiddleLinkedList list = new MiddleLinkedList();

        int choice;

        System.out.println("Enter numbers (-1 to stop):");

        while (true) {

            int value = sc.nextInt();

            if (value == -1)
                break;

            list.insert(value);
        }

        System.out.println("\nLinked List:");
        list.display();

        list.findMiddleTwoTraversal();
        list.findMiddleOnePass();
    }
}