import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SearchLinkedList {

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

    void searchIteration(int key) {

        Node temp = head;
        int position = 1;

        while (temp != null) {

            if (temp.data == key) {
                System.out.println("Element found at position (Iteration): " + position);
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println("Element not found (Iteration).");
    }

    boolean searchRecursion(Node node, int key) {

        if (node == null)
            return false;

        if (node.data == key)
            return true;

        return searchRecursion(node.next, key);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SearchLinkedList list = new SearchLinkedList();

        System.out.println("Enter elements (-1 to stop):");

        while (true) {

            int value = sc.nextInt();

            if (value == -1)
                break;

            list.insert(value);
        }

        System.out.println("\nLinked List:");
        list.display();

        System.out.print("\nEnter element to search: ");
        int key = sc.nextInt();

        list.searchIteration(key);

        boolean found = list.searchRecursion(list.head, key);

        if (found)
            System.out.println("Element found (Recursion).");
        else
            System.out.println("Element not found (Recursion).");
    }
}