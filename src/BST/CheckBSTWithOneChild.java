package BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBSTWithOneChild {

    /***
     *
     * Given preorder traversal of a binary tree, check if it is possible that it is also a
     * preorder traversal of a Binary Search Tree (BST),
     * where each internal node (non-leaf nodes) have exactly one child.
     *
     * Return a string "YES" if true else "NO".
     *
     * A : [4, 10, 5, 8]
     * o/p:  "YES"
     * The possible BST is:
     *             4
     *              \
     *              10
     *              /
     *              5
     *               \
     *               8
     *
     * A : [1, 5, 6, 4]
     * o/p:  "NO"
     * There is no possible BST which have the above preorder traversal.
     */

    public String checkBST(int[] A) {

        return null;
    }

    public TreeNode makeTree(int[] A){
        int i=1;
        TreeNode root=new TreeNode(A[0]);
        TreeNode dummy=root;
        while(i!=A.length){
            TreeNode temp;
            temp=new TreeNode(A[i]);
            if(dummy.val>A[i]){
                dummy.left=temp;
                dummy=temp;
            }
            else{
                dummy.right=temp;
                dummy=temp;
            }
            i++;
        }
        return root;
    }

  static List<Integer> in=new ArrayList<>();

    public void inorder(TreeNode A){
        if(A==null){
            return;
        }
        // Left Root Right
        inorder(A.left);
        in.add(A.val);
        System.out.println(A.val);
        inorder(A.right);
    }

    public static void main(String...k){
        int[] arr={1, 5, 6};
        int b = 1;
        int c=6;
        CheckBSTWithOneChild checkBSTWithOneChild=new CheckBSTWithOneChild();
        TreeNode root=checkBSTWithOneChild.makeTree(arr);
        checkBSTWithOneChild.inorder(root);
        int first=0;
        for(int i=0;i<in.size();i++) {
            if (in.get(i)>=b && in.get(i)<=c ) {
                first++;
            }
        }
        System.out.println(first);
    }


}


