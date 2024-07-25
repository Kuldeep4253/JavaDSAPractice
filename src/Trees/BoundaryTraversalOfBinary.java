package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BoundaryTraversalOfBinary {

    static ArrayList<Integer> leaf=new ArrayList<>();
    static ArrayList<Integer> leftMostNode=new ArrayList<>();
    static ArrayList<Integer> rightMostNode=new ArrayList<>();

    private static void leafNode(TreeNode A){
        // If node is null, return
        if (A == null)
            return ;

        // If node is leaf node, print its data
        if (A.left == null &&
                A.right == null)
        {
            leaf.add(A.val);
            return ;
        }
        // If left child exists, check for leaf
        // recursively
        if (A.left != null)
            leafNode(A.left);
        // If right child exists, check for leaf
        // recursively
        if (A.right != null)
            leafNode(A.right);
    }
    private static void leftMostChild(TreeNode A){
        while (A != null) {
            leftMostNode.add(A.val);
            if (A.left != null)
                A = A.left;
            else
                A = A.right;
        }
    }
    private static void rightMostChild(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        while (A != null) {
            stack.push(A);
            if (A.right != null)
                A = A.right;
            else
                A = A.left;
        }
        while (!stack.isEmpty()) {
            rightMostNode.add(stack.peek().val);
            stack.pop();
        }
    }

    public static void main(String...k){
        TreeNode A= TreeNode.makeTree();
        TreeNode temp=A;
        leafNode(temp);
         temp=A;
        leftMostChild(temp);
        temp=A;
        rightMostChild(temp);
        System.out.println(leaf);
        System.out.println(leftMostNode);
        System.out.println(rightMostNode);
        rightMostNode.remove(0);
        ArrayList<Integer> rslt=new ArrayList<>();
        rslt.addAll(leftMostNode);
        rslt.addAll(leaf);
        Collections.reverse(rightMostNode);
        rslt.addAll(rightMostNode);

        System.out.println(rslt);

    }




}
