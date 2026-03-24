import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLinkedList {

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

    Node reverse(Node head) {

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

    boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);

        Node firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeLinkedList list = new PalindromeLinkedList();

        System.out.print("Enter a number: ");
        String number = sc.next();

        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0';
            list.insert(digit);
        }

        System.out.println("\nLinked List Representation:");
        list.display();

        if (list.isPalindrome())
            System.out.println("The number is a Palindrome.");
        else
            System.out.println("The number is NOT a Palindrome.");
    }
}