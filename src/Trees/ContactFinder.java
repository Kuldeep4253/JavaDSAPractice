package Trees;

/*
Problem Description

We want to make a custom contacts finder applications as part of our college project.
The application must perform two types of operations:
Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name.
This must store B[i] as a new contact in the application.
Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial
name to search the application for.
It must count the number of contacts starting with B[i].
You have been given sequential add and find operations. You need to perform each operation in order.
And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .




Input 1:
A = [0, 0, 1, 1]
B = ["hack", "hacker", "hac", "hak"]
Input 2:
A = [0, 1]
B = ["abcde", "abc"]
Example Output
Output 1:[2, 0]
Output 2: [1]
Example Explanation
Explanation 1:
We perform the following sequence of operations:
Add a contact named "hack".
Add a contact named "hacker".
Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.
Explanation 2:
Add "abcde"
Find words with prefix "abc". We have answer as 1.
 */



public class ContactFinder {
    public int[] solve(int[] A, String[] B) {
        int len=A.length;
        int queryCount=0;

        Node root=new Node();
        for(int i=0;i<len;i++){
            // Create the word because A[i]==0 is word
            if(A[i]==0){
                insert(root,B[i]);
            }
            // Create the word because A[i]==0 is query
            else{
                queryCount++;
            }
        }
        int[] rst=new int[queryCount];
        int c=0;
        for(int i=0;i<len;i++){
            // Create the word because A[i]==0 is word
            if(A[i]==1){
                rst[c++]= findPrefixcount(root,B[i]);
                System.out.println(rst[c-1]);
            }
        }

        return rst;
    }

    public int[] solve(String[] A, String[] B) {
        int[] rslt=new int[B.length];
        Node root=new Node();
        for(int i=0;i<A.length;i++){
                insert(root,A[i]);
            }
        for(int i=0;i<B.length;i++){
            boolean ans=searchQuery(root,B[i]);
            if(ans==true){
                rslt[i]=1;
            }
            else{
                rslt[i]=0;
            }
        }
        return rslt;
    }

    public String[] prefix(String[] A) {
        String[] rslt=new String[A.length];
        Node root=new Node();
        for(int i=0;i<A.length;i++){
            insert(root,A[i]);
        }
        for(int i=0;i<A.length;i++){
            rslt[i]=findUniquePrefixcount(root,A[i]);
        }
        return rslt;
    }

    private void insert(Node root,String word){
        Node t=root;
        t.count+=1;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(t.hm.containsKey(ch)){
                t=t.hm.get(ch);
                t.count+=1;
            }
            else{
                Node temp=new Node();
                t.hm.put(ch,temp);
                t=temp;
                t.count=1;
            }

        }
        t.isEnd=true;
    }
    private int findPrefixcount(Node root, String query){
        Node t=root;
        int count=0;
        for(int i=0;i<query.length();i++){
            char ch=query.charAt(i);
            if(t.hm.containsKey(ch)){
                t=t.hm.get(ch);
                count=t.count;;
            }
            else{
                 return 0;
            }

        }
        return count;
    }

    private String findUniquePrefixcount(Node root, String query){
        Node t=root;
        String s="";
        for(int i=0;i<query.length();i++){
            char ch=query.charAt(i);
            if(t.hm.containsKey(ch)){
                t=t.hm.get(ch);
                s=s+ch;
                if(t.count==1){
                    return s;
                }
            }
        }
        return s;
    }
    private boolean searchQuery(Node root, String query){
        Node t=root;
        for(int i=0;i<query.length();i++){
            char ch=query.charAt(i);
            if(t.hm.containsKey(ch)){
                t=t.hm.get(ch);
            }
            else{
                return false;
            }
        }
        return t.isEnd;
    }

    public static void main(String...k){
        int[] A = {0,0,0,0,0,1,1,1,1,1,1};
        String[] B= {"s","ss","sss","ssss","sssss","s","ss","sss","ssss","sssss","ssssss"};
        String[] t= {"zebra", "dog", "duck", "dove"};
        String[] p= {"cat", "ball"};
        ContactFinder cf=new ContactFinder();
        //System.out.println(cf.prefix(t));
        cf.solve(A,B);
    }
}

