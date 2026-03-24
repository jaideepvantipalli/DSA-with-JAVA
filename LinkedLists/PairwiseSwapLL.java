import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PairwiseSwapLL {

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

    void pairwiseSwap() {

        Node temp = head;

        while (temp != null && temp.next != null) {

            int t = temp.data;
            temp.data = temp.next.data;
            temp.next.data = t;

            temp = temp.next.next;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PairwiseSwapLL list = new PairwiseSwapLL();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        System.out.println("\nOriginal Linked List:");
        list.display();

        list.pairwiseSwap();

        System.out.println("\nAfter Pairwise Swap:");
        list.display();
    }
}