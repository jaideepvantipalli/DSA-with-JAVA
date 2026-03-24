import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SegregationLL {

    Node head = null;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    void display(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    Node evenValueFirst(Node head) {

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        Node current = head;

        while (current != null) {

            if (current.data % 2 == 0) {

                if (evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }

            } else {

                if (oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }

            current = current.next;
        }

        if (evenStart == null)
            return oddStart;

        evenEnd.next = oddStart;

        if (oddEnd != null)
            oddEnd.next = null;

        return evenStart;
    }

    Node oddValueFirst(Node head) {

        Node oddStart = null, oddEnd = null;
        Node evenStart = null, evenEnd = null;

        Node current = head;

        while (current != null) {

            if (current.data % 2 != 0) {

                if (oddStart == null)
                    oddStart = oddEnd = current;
                else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }

            } else {

                if (evenStart == null)
                    evenStart = evenEnd = current;
                else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            }

            current = current.next;
        }

        if (oddStart == null)
            return evenStart;

        oddEnd.next = evenStart;

        if (evenEnd != null)
            evenEnd.next = null;

        return oddStart;
    }

    Node evenPositionFirst(Node head) {

        if (head == null)
            return null;

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        Node temp = head;
        int pos = 1;

        while (temp != null) {

            if (pos % 2 == 0) {

                if (evenStart == null)
                    evenStart = evenEnd = temp;
                else {
                    evenEnd.next = temp;
                    evenEnd = evenEnd.next;
                }

            } else {

                if (oddStart == null)
                    oddStart = oddEnd = temp;
                else {
                    oddEnd.next = temp;
                    oddEnd = oddEnd.next;
                }
            }

            temp = temp.next;
            pos++;
        }

        if (evenStart == null)
            return oddStart;

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }

    Node oddPositionFirst(Node head) {

        if (head == null)
            return null;

        Node odd = head;
        Node even = head.next;
        Node evenStart = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SegregationLL list = new SegregationLL();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
            list.insert(sc.nextInt());

        System.out.println("\nOriginal Linked List:");
        list.display(list.head);

        Node h1 = list.evenValueFirst(list.head);
        System.out.println("\nEven valued nodes first:");
        list.display(h1);

        Node h2 = list.oddValueFirst(h1);
        System.out.println("\nOdd valued nodes first:");
        list.display(h2);

        Node h3 = list.evenPositionFirst(h2);
        System.out.println("\nEven position nodes first:");
        list.display(h3);

        Node h4 = list.oddPositionFirst(h3);
        System.out.println("\nOdd position nodes first:");
        list.display(h4);
        sc.close();
    }
}