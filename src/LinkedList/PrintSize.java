package LinkedList;

 class PrintSize extends Node {

     PrintSize(int value) {
         super(value);
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

         /*
         Linked list should be like this
         10-->20-->30-->40-->50-->null;
          */
         PrintLinkedList(head);
     }
}
