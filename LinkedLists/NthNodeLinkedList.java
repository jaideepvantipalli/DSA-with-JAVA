import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NthNodeLinkedList {

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

    void findNthFromBeginning(int n) {

        Node temp = head;
        int count = 1;

        while (temp != null) {

            if (count == n) {
                System.out.println("Nth node from beginning = " + temp.data);
                return;
            }

            count++;
            temp = temp.next;
        }

        System.out.println("Position exceeds linked list length.");
    }

    void findNthFromEnd(int n) {

        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++) {

            if (first == null) {
                System.out.println("Position exceeds linked list length.");
                return;
            }

            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println("Nth node from end = " + second.data);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        NthNodeLinkedList list = new NthNodeLinkedList();

        System.out.println("Enter numbers (-1 to stop):");

        while (true) {

            int value = sc.nextInt();

            if (value == -1)
                break;

            list.insert(value);
        }

        System.out.println("\nLinked List:");
        list.display();

        System.out.print("\nEnter value of n: ");
        int n = sc.nextInt();

        list.findNthFromBeginning(n);
        list.findNthFromEnd(n);
    }
}