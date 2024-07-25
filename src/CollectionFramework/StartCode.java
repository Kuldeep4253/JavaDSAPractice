package CollectionFramework;

import java.util.*;

public class StartCode {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /* Creating Collection

        1. Type Safe Collection (Same type of elements(Objects) are added into collection)
        ArrayList<String> arrlist=new ArrayList<String>();


        2. Not type Collection (Diff type of elements(Objects) are added into collection)
         */

        //Type Safe Collection
        ArrayList<String> arrlist=new ArrayList<String>();
        arrlist.add("Kuldeep");
        arrlist.add("Mohit");
        arrlist.add("sumit");
        arrlist.add("sumit");

        System.out.println(arrlist);
       // System.out.println(arrlist.get(3));
        arrlist.remove("Kuldeep");
        System.out.println(arrlist);
        System.out.println(arrlist.contains("kuldeep"));
        arrlist.set(1,"lllll");
        arrlist.add(1,"Ramm");
       // arrlist.clear();
        System.out.println(arrlist);

        Vector<String> vc=new Vector<>();
        vc.addAll(arrlist);
        System.out.println("Vector:"+vc);

        //UnType Safe Collection
        LinkedList linkedlist=new LinkedList();
        linkedlist.add(101);
        linkedlist.add("Sachin");
        linkedlist.add(120.03);
        linkedlist.add(true);
        //System.out.println(linkedlist);

    }
}

