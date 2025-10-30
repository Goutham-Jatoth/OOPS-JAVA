import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedListDemo {
    Node head;

    // Insert at end
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
        newNode.prev = temp;
    }

    // Delete a node with a given key
    void delete(int key) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        Node temp = head;

        // Traverse until we find the key
        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Element " + key + " not found in the list.");
            return;
        }

        // If node to be deleted is head
        if (temp == head)
            head = temp.next;

        // Change next only if node to be deleted is NOT the last node
        if (temp.next != null)
            temp.next.prev = temp.prev;

        // Change prev only if node to be deleted is NOT the first node
        if (temp.prev != null)
            temp.prev.next = temp.next;

        System.out.println("Element " + key + " deleted successfully.");
    }

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("List elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedListDemo list = new DoublyLinkedListDemo();

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.insert(val);
        }

        System.out.println("\nBefore deletion:");
        list.display();

        System.out.print("\nEnter element to delete: ");
        int key = sc.nextInt();
        list.delete(key);

        System.out.println("\nAfter deletion:");
        list.display();

        sc.close();
    }
}