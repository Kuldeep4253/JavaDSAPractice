package LinkedList;

class InsertNode extends Node {

    InsertNode(int value) {
        super(value);
    }

    static Node Insert(Node head, Node Insert, int pos){
        Node temp=head;
        int count=1;
        while(count!=pos-1){
            temp=temp.next;
            count++;
        }
        // Linking node
        Insert.next=temp.next;
        temp.next=Insert;
        return head;
    }

    static Node DeleteNode(Node head, int value){
        Node temp=head;
        while(temp.next.value!=value){
            temp=temp.next;
        }
        // De-Linking node
        Node delete=temp.next;
       temp.next=temp.next.next;
       delete.next=null;
        return head;
    }

    static Node Reverse(Node head){

        Node curr=head;
        Node prev=null;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
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
         10-->20-->30-->40-->50-->60;
          */

        // 60 node insert at postion 4 after 3rd node (after 30)

        Node ad6=new Node(60);
        int pos=4;
        Insert(head,ad6,pos);
        PrintLinkedList(head);
        DeleteNode(head,40);
        PrintLinkedList(head);
        Node temp=Reverse(head);
        PrintLinkedList(temp);

    }
}

