package Java8;


import java.util.*;
import java.util.stream.Collectors;

class Test{
    public int i;
    public String name;

    public Test(int i, String a) {
        this.i=i;
        this.name=a  ;
    }

    @Override
    public String toString() {
        return "Test{" +
                "i=" + i +
                ", name='" + name + '\'' +
                '}';
    }

}
public class StreamEx1 {
   public static void main(String...k){
       Test t1=new Test(1,"a");
       Test t2=new Test(2,"b");
       Test t3=new Test(3,"c");
       Test t4=new Test(3,"c");
       Test t5=t1;
       System.out.println(t1.hashCode()+" & "+t2.hashCode()+" & "+t3.hashCode()+" & "+t4.hashCode());
       ArrayList<Test> ar=new ArrayList<>();
       ar.add(t1);
       ar.add(t2);
       ar.add(t3);
       ar.add(t4);
       ar.add(t4);
       Set<Test> setUniques = new HashSet<Test>();
       List<Test> setDups = ar.stream().filter(s -> !setUniques.add(s))
               .collect(Collectors.toList());
       System.out.println("using set: " + setDups);

       System.out.println(t1.equals(t5));



   }
}