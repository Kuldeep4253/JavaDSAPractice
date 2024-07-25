package CollectionFramework;

import java.util.*;


public class MapImpl {

    public static void main(String[] arg){

        HashMap<String,Integer> course=new HashMap<>();
        course.put("Core Java",4000);
        course.put("Basic Python",3000);
        course.put("Spring",6000);
        course.put("Spring",5000);
        System.out.println(course);


        //For Each Method

        course.forEach((e1,e2)->{
            System.out.println(e1+"==>"+e2);
        });
    }
}
