import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedListMethods{

    Node head;
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

    Node reverseIteration(Node head) {

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    Node reverseRecursion(Node head) {

        if (head == null || head.next == null)
            return head;

        Node rest = reverseRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return rest;
    }

    Node reverseStack(Node head) {

        Stack<Node> stack = new Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        head = stack.pop();
        temp = head;

        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    Node reverseArrayList(Node head) {

        ArrayList<Node> list = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }

        list.get(0).next = null;

        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ReverseLinkedListMethods list = new ReverseLinkedListMethods();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        System.out.println("\nOriginal Linked List:");
        list.display(list.head);

        Node rev1 = list.reverseIteration(list.head);
        System.out.println("\nReversed using Iteration:");
        list.display(rev1);

        Node rev2 = list.reverseRecursion(rev1);
        System.out.println("\nReversed using Recursion:");
        list.display(rev2);

        Node rev3 = list.reverseStack(rev2);
        System.out.println("\nReversed using Stack:");
        list.display(rev3);

        Node rev4 = list.reverseArrayList(rev3);
        System.out.println("\nReversed using ArrayList:");
        list.display(rev4);
    }
}