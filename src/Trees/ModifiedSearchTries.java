package Trees;

import java.util.ArrayList;

public class ModifiedSearchTries {
    /*
Given two arrays of strings A of size N and B of size M.
Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i],
Else C[i] = '0'.
NOTE: modification is defined as converting a character into another character.
A = [data, circle, cricket]
 B = [date, circel, crikket, data, circl]
 "10100"
     */

    public String solve(String[] A, String[] B) {
        int[] rslt=new int[B.length];
        StringBuilder ans = new StringBuilder();
        Node root=new Node();
        for(int i=0;i<A.length;i++){
            insert(A[i],root);
        }
        for (int i = 0; i < B.length; i++) ans.append(modifiedSearch(B[i], root, 0, 0) ? 1 : 0);
        return ans.toString();
    }
    public void insert(String word,Node root){
        Node temp=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            //This will execute when character is not present like first time then inser into tries
            if(temp.hm.containsKey(ch)){
                temp=root.hm.get(ch);
                temp.count+=1;

            }
            else{
                Node n1=new Node();
                temp.hm.put(ch,n1);
                temp.count=1;
                temp=n1;
            }
        }
        temp.isEnd=true;
    }

    public boolean modifiedSearch(String word,Node root,int index,int count){
        if (count > 1 || index == word.length() && count != 1) return false;
        if (index == word.length() && root.isEnd) return true;
        Node temp=root;
        boolean flag = false;
        char ch=word.charAt(index);
        for (char node: root.hm.keySet()) {
            if (node == ch) {
                flag = flag | modifiedSearch(word, root.hm.get(node), index + 1, count);
            } else {
                flag = flag | modifiedSearch(word, root.hm.get(node), index + 1, count + 1);
            }
        }
        return flag;
    }

    public static void main(String...k){
        String[] A= {"data", "circle", "cricket"};
        String[] B= {"date", "circel", "crikket", "data", "circl"};
        ModifiedSearchTries mst=new ModifiedSearchTries();
        System.out.println(mst.solve(A,B));

    }
}

