package LinkedList;

public class removeNthFromEnd extends Node{

    removeNthFromEnd(int value) {
        super(value);
    }

    public static Node removeNthFromEnd(Node A, int B) {
        int n;
        Node node;
        if (A == null)
            return null;
        n = 0;
        node = A;
        // calculates the size of the linked list
        while (node != null) {
            n++;
            node = node.next;
        }
        if (B >= n) {
            return A.next;
        }
        node = A;
        for (int i = 0; i < n - B - 1; i++)
            node = node.next;
        node.next = node.next.next;
        return A;
    }

    public static void main(String...k){
        Node ad1=new Node(1);     // first node
        Node head=ad1;                   //  pointing head to the first node ad1
        Node ad2=new Node(1);    // second node
        ad1.next=ad2;                   //  pointing first node  to the second node  ad2
        Node ad3=new Node(2);    // third node
        ad2.next=ad3;
        Node ad4=new Node(3);    // fourth node
        ad3.next=ad4;
        Node ad5=new Node(3);    // fifth node
        ad4.next=ad5;
        Node ad6=new Node(60);    // sixth node
        ad5.next=ad6;
        Node ad7=new Node(60);    // seven node
        ad6.next=ad7;
        Node ad8=new Node(80);    // eight node
        ad7.next=ad8;

        /*
         Linked list should be like this
         1-->1-->2-->3-->3-->60-->60-->80
          */

        removeNthFromEnd(ad1,5);
        PrintLinkedList(ad1);
    }
}
