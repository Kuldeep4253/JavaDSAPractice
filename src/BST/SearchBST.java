package BST;

import com.sun.source.tree.Tree;

public class SearchBST {




    public int searchBST(TreeNode A, int B) {

       while(A!=null){
           if(A.val==B){
               return 1;
           }
           if(A.val<B){
               A=A.right;
           }
           else{
               A=A.left;
           }
       }
        return 0;
    }


    TreeNode prev=null;
    int flag=0;
    public int solveBST(TreeNode A) {
        flag=1;
        prev=null;
        isValidBST(A);
         return flag;
    }

    public int isValidBST(TreeNode A){
        if(A==null){
            return 1;
        }
        isValidBST(A.left);
        if(prev!=null && prev.val>A.val){
            return 0;
        }
        prev=A;
        isValidBST(A.right);
        return 0;
    }


    TreeNode root;
    public TreeNode sortedArrayToBST(int[] num,int start,int end){
        /* Base Case */
        if (start > end) {
            return null;
        }
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(num[mid]);
        node.left=sortedArrayToBST(num,start,mid-1);
        node.right=sortedArrayToBST(num,mid+1,end);
        return node;
    }

    public static void main(String...k){
        SearchBST sbt=new SearchBST();
        TreeNode A=TreeNode.makeTree();
        System.out.println(sbt.searchBST(A,700));
        System.out.println(sbt.solveBST(A));

    }
}
