package LinkedList;

public class CycleDetection extends Node{

    CycleDetection(int value) {
        super(value);
    }

    public static Node NodeCycleDetection(Node node) {
        Node slow=node;
        Node fast=node;
        if(node==null) {
             return null;
        }
        boolean iscycle=false;
        while(fast.next!=null  && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                iscycle=true;
                break;
            }
        }
        if(iscycle) {
            slow=node;
            while (slow != fast) {

                slow=slow.next;
                fast=fast.next;
            }
            System.out.println(slow.value);
             return slow;
        }
      return null;
    }

    public static void main(String...k){
        Node ad1=new Node(10);     // first node
        Node head=ad1;                   //  pointing head to the first node ad1
        Node ad2=new Node(20);    // second node
        ad1.next=ad2;                   //  pointing first node  to the second node  ad2
        Node ad3=new Node(30);    // third node
        ad2.next=ad3;
        Node ad4=new Node(40);    // fourth node
        ad3.next=ad4;
        Node ad5=new Node(50);    // fifth node
        ad4.next=ad5;
        Node ad6=new Node(60);    // sixth node
        ad5.next=ad6;
        Node ad7=new Node(70);    // seven node
        ad6.next=ad7;
        Node ad8=new Node(80);    // eight node
        ad7.next=ad8;
        ad8.next=ad5;                   // cycle create from here

        System.out.println(NodeCycleDetection(head));

        /*
         Linked list should be like this
         10-->20-->30-->40-->50-->60-->70-->80
                              |               |
                              |               |
                              |---------------|
          */
    }
}
