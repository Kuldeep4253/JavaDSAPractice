package LinkedList;

public class RevLinkedListPostional extends Node{
    RevLinkedListPostional(int value) {
        super(value);
    }

    public static Node reve(Node A){
        Node prev=null;
        Node curr=A;
        Node next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;

    }
    public static Node reverseBetween(Node A, int B, int C) {
        Node temp=A;
        Node startNode=A;
        Node endNode=A;
        Node revNode=A;
        int count=1;
/* This while loop to find the starting point of linked list when we need to rever it and fine the just beofre
node address of starting point of node reverse
 */

        while(count!=B && temp!=null ){
            revNode=temp;
            temp=temp.next;
            startNode=temp;
            count++;
        }

        /* This while loop to find the end point of linked list when we need to revert it and fine the just after
node address of end point of node reverse
 */
        while(count!=C && temp!=null ){
            temp=temp.next;
            count++;
        }
// After node address when reverse node address
        endNode=temp.next;
        temp.next=null;   // making last node of null linked list 20-->30-->40-->null
        Node rslt=reve(startNode);
        revNode.next=rslt;
        Node temp1=revNode;
        while(temp1.next!=null){
            temp1=temp1.next;
        }
        temp1.next=endNode;
        return revNode;
    }

    public static void main(String...k){

        Node ad1=new Node(10);     // first node
        Node head=ad1;                   //  pointing head to the first node ad1
        Node ad2=new Node(20);    // second node
        ad1.next=ad2;                   //  pointing first node  to the second node  ad2
        Node ad3=new Node(30);    // third node
        ad2.next=ad3;
      /*  Node ad4=new Node(40);    // fourth node
        ad3.next=ad4;
        Node ad5=new Node(50);    // fifth node
        ad4.next=ad5;*/

         /*
         Linked list should be like this
         10-->20-->30-->40-->50-->60;
          */
        Node a=reverseBetween(ad1,1,2);
        PrintLinkedList(a);

    }
}
