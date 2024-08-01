package Trees;

import Graph.Prims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopLevelViewBinaryTree {
    public ArrayList<Integer> result =new ArrayList<>();
    public ArrayList<Integer> topview(TreeNode A){
        Map<Integer,Pair> mp=new HashMap<>();
        inorder(A,0,0,mp);
        for (int key : mp.keySet()) {
            result.add(mp.get(key).data);
        }
        return result;
        //leftmostTreeNode(A);
        //rightmostTreeNode(A.right);
       // return result;
    }

    public void leftmostTreeNode(TreeNode A){
        if(A==null)
            return;
        leftmostTreeNode(A.left);
        result.add(A.val);
    }

    public void rightmostTreeNode(TreeNode A){
        if(A==null)
            return;
        result.add(A.val);
        leftmostTreeNode(A.right);
    }

    public void inorder(TreeNode A,int width,int height,Map<Integer,Pair> mp){
        if(A==null)
            return;
        /* If the current horizontal level has not been visited yet
       then we insert it into the map */
        if(mp.containsKey(width) == false){
            mp.put(width,new Pair(A.val,height));
        }
        else{
            if(mp.get(width).verticleHeight>height){
                mp.put(width,new Pair(A.val,height));
            }

        }
        inorder(A.left,width-1,height+1,mp);
        inorder(A.right,width+1,height+1,mp);
    }
    public static void main(String...k){
        TreeNode root=TreeNode.makeTree2();
        TopLevelViewBinaryTree topLevelViewBinaryTree =new TopLevelViewBinaryTree();
        System.out.println(topLevelViewBinaryTree.topview(root));

    }
}
class Pair {
    int data;
    int verticleHeight;

    public Pair(int val, int height) {
        this.data=val;
        this.verticleHeight=height;
    }
}
