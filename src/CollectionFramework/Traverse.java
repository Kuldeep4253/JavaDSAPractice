package CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Traverse {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<String> arrlist = new ArrayList<String>();
        arrlist.add("Kuldeep");
        arrlist.add("Mohit");
        arrlist.add("sumit");
        arrlist.add("sumit");

        System.out.println(arrlist);

        for(String str: arrlist){
            System.out.print(str+"\t Length is "+str.length());
            StringBuffer sb=new StringBuffer(str);
            System.out.println("\t and Reverser string is "+sb.reverse());

        }

        System.out.println("************************************************");
        //Traverse via Iterator

        Iterator<String> itr=arrlist.iterator();

        while(itr.hasNext()){
            String next=itr.next();
            System.out.println(next);
        }


        // Enumration


        // For each Method
        arrlist.forEach(e->{
            System.out.println("Enumration "+ e);
        });

    }
}