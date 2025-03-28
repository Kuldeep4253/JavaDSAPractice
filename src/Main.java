import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String...k) {
        String[] name={"aankit", "jeetu", "kkitan", "tujee", "nkiita", "rram"};
        int length=name.length;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<length;i++){
            HashSet<Character> hs=new HashSet<>();
            char[] charArr=name[i].toCharArray();
            for(int j=0;j<charArr.length;j++){
               if(hs.add(charArr[j])){
                   if(hm.containsKey(charArr[j])){
                       hm.put(charArr[j],hm.get(charArr[j])+1);
                   }
                   else{
                       hm.put(charArr[j],1);
                   }
               }
            }
        }

        int max=-1;
        char t='w';
        for(char c: hm.keySet()){
            if(hm.get(c)>max){
                max=hm.get(c);
                t=c;
            }
        }
        System.out.println("character:" +t+" and frequency is:"+max);
        HashSet<Integer> hs=new HashSet<>();
        List<Integer> li= Arrays.asList(1,2,3,4,5,6,6,7,8,7,8,9);

        li.stream().filter(n->hs.add(n))
                .forEach(n->System.out.println(n));

        Map<Integer, Long> duplicates = li.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // Keep only duplicates
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

}
}