package LinkedList;

public class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }

    static void PrintLinkedList(Node head){
        // Printing Linked List
        Node temp=head;
        int count=0;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
            count++;
        }

        System.out.println("Linked List size is :"+count);
    }
}
