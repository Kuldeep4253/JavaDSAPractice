package LinkedList;

public class MergeLinkList extends Node{

    MergeLinkList(int value) {
        super(value);
    }

    public static Node merge(Node A,Node B){

        if(A==null & B!=null){
            return B;
        }
        else if(B==null && A!=null){
            return A;
        }

        Node l1=A;
        Node l2=B;
        Node head=null;
        Node temp=null;
        if(l1.value> l2.value){
            head=l2;
            temp=head;
            l2=l2.next;
        }
        else{
            head=l1;
            temp=head;
            l1=l1.next;
        }

        while(l1!=null || l2!=null){
            if(l1.value> l2.value){
                temp.next=l2;
                l2=l2.next;
            }
            else {
                temp.next=l1;
                l1=l1.next;
            }

        }


        return head;
    }
}
