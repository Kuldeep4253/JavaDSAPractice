package Trees;

import java.util.HashMap;

class Node{
    int count;
    HashMap<Character,Node> hm;
    boolean isEnd;
    Node(){
        this.isEnd=false;
        hm=new HashMap<>();
    }
}
