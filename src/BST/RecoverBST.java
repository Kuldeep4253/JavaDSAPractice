package BST;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class RecoverBST {

    TreeNode prev=null;
    TreeNode first=null;
    TreeNode second=null;
    public  int[] recoverTree(TreeNode A) {
        int[] rslt=new int[2];
        searchRecoverElement(A);
        if(first!=null && second!=null) {
            rslt[1]=first.val;
            rslt[0]=second.val;
            System.out.println(first.val+" --"+ second.val);
        }
        else {
            return null;
        }
        return rslt;
    }

    public void searchRecoverElement(TreeNode A){

        if(A==null){
            return;
        }

        searchRecoverElement(A.left);
        if(prev!=null && prev.val>A.val){
            if(first==null){
                first=prev;
                second=A;
            }
            else{
                second=A;
            }
        }
        prev=A;
        searchRecoverElement(A.right);

    }

    public static void main(String...k){
        RecoverBST recoverBST=new RecoverBST();
        System.out.println(recoverBST.recoverTree(TreeNode.makeTreeBST()));
    }

}
