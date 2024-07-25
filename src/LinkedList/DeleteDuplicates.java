package LinkedList;

/*Given a sorted linked list, delete all duplicates such that each element appears only once.*/
public class DeleteDuplicates extends Node{


    DeleteDuplicates(int value) {
        super(value);
    }

    static public Node deleteDuplicateNode(Node A){
        Node temp=A.next;
        Node prevNode=A;
        int x=temp.value;
        while(temp!=null ){
            if(x==temp.value)
            {
                prevNode.next=temp.next;
            }
            else{
                prevNode=temp;
                x=temp.value;
            }
            temp=temp.next;
        }
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

        deleteDuplicateNode(ad1);
        PrintLinkedList(ad1);
    }
}
