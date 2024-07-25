package Trees;

import java.util.*;

public class ZigZaglevelOrder {
    /*
    Given a binary tree, return the zigzag level order traversal of its nodes values.
    (ie, from left to right, then right to left for the next level and alternate between).

    3
   / \
  9  20
    /  \
   15   7


    [
   [3],     root      even
   [20, 9],    right left   odd
   [15, 7]      left right    even
 ]
     */

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);
        int levelCount = 0;
        int oddsum=0;
        int evensum=0;
        while (q.size() > 0) {
            levelCount++;
            ArrayList<Integer> list = new ArrayList();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek();
                q.remove();
                list.add(node.val);
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if(levelCount%2!=0){
                    oddsum=oddsum+node.val;
                }
                if(levelCount%2==0){
                    evensum=evensum+node.val;
                }
            }


            ans.add(list);
        }
       
        return ans;
    }

    public static void main(String...k){
        TreeNode A= TreeNode.makeTree();
        System.out.println(zigzagLevelOrder(A));
    }


}
