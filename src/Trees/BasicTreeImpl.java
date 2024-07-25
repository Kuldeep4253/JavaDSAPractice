package Trees;

import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.*;

public class BasicTreeImpl{
    TreeNode treeNode;
    ArrayList ar=new ArrayList<>();
    public int nodeCount(TreeNode A) {

        if(A==null){
            return 0;
        }
        int left=nodeCount(A.left);
        int right=nodeCount(A.right);
        return left+right+1;
    }
    public int height(TreeNode A) {

        if(A==null){
            return -1;
        }
        int left=height(A.left);
        int right=height(A.right);
        return 1+max(left,right);
    }
    public int sumNode(TreeNode A) {

        if(A==null){
            return 0;
        }
        int left=sumNode(A.left);
        int right=sumNode(A.right);
        return left+right+A.val;
    }
    public Object inorderTraversal(TreeNode A) {
        if(A==null){
            return 0;
        }
        inorderTraversal(A.left);
        ar.add(A.val);
        inorderTraversal(A.right);
        return ar;
    }
    public ArrayList<Integer> inorderTraversalUsingStack(TreeNode A) {

        ArrayList<Integer> rslt=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=A;
        while(st.size()>0 || curr!=null){
            st.push(curr);
            curr=curr.left;
            while(curr!=null){
                st.push(curr);
                curr= curr.left;
            }
            curr=st.peek();
            st.pop();
            System.out.println(curr.val);
            curr= curr.right;
        }

        return rslt;
    }

    ArrayList ans=new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A == null){
            return ans; // Return an empty ArrayList when input is null
        }
        ans.add(A.val);
        preorderTraversal(A.left);
        preorderTraversal(A.right);
        return ans;
    }
    public ArrayList<Integer> preorderTraversalUsingStack(TreeNode A) {

        ArrayList<Integer> rslt=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        st.push(A.left);
        while(st.size()>0){
            TreeNode curr=st.peek();
            System.out.println(curr.val);
            st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }

        }

        return rslt;
    }


    ArrayList postorder=new ArrayList<>();
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if(A == null){
            return postorder; // Return an empty ArrayList when input is null
        }
        postorderTraversal(A.left);
        postorderTraversal(A.right);
        postorder.add(A.val);
        return postorder;
    }
    public ArrayList<Integer> postOrderTraversalUsingStack(TreeNode A) {

        ArrayList<Integer> rslt=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=A;
        while(st.size()>0 || curr!=null){
            st.push(curr);
            curr=curr.left;
            while(curr!=null){
                st.push(curr);
                curr= curr.left;
            }
            curr=st.peek();
            st.pop();
            System.out.println(curr.val);
            curr= curr.right;
        }

        return rslt;
    }


    public TreeNode invertTree(TreeNode A) {
        if(A==null){
            return null;
        }
        TreeNode t=null;
        t=A.left;
        A.left=A.right;
        A.right=t;
        invertTree(A.left);
        invertTree(A.right);
        return A;
    }
    private int max(int a ,int b){
        if(a>=b){
            return a ;
        }
        else
            return b ;
    }

    public ArrayList<Integer> leftViewOfTree(TreeNode A) {

        ArrayList<Integer> rslt=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(A);
        while(queue.size()>0){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode curr=queue.peek();
                queue.remove();
                if(i==0){
                    System.out.println(curr.val);
                    rslt.add(curr.val);
                }

                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }

        return rslt;
    }

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {


        return null;
    }

    private TreeNode node(ArrayList<Integer> preorder,int s1,int e1, ArrayList<Integer> inorder,int s2,int e2){
        if(  s1>e1 || s2>e2) {
            return null;
        }
        TreeNode root =new TreeNode(preorder.get(s1));
        int ind=-1;
        for(int i=s2;i<=e2;i++){
            if(preorder.get(s1)==inorder.get(i)){
                ind=i;
                break;
            }
        }

        int c=ind-s2;        //ind-1-s2+1;
        root.left=node(preorder,s1+1,s1+c,inorder,s2,ind-1);
        root.right=node(preorder,s1+c+1,e1,inorder,ind+1,e2);
        return  root;
    }



    int max=Integer.MIN_VALUE;
    public int maxNodeTree(TreeNode A) {
        if(A==null){
            return 0;
        }
        if(max<A.val){
            max=A.val;
        }
        maxNodeTree(A.left);
        maxNodeTree(A.right);
        return max;

    }

    private ArrayList<ArrayList<Integer>> levelOrderTree(TreeNode A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        //Adding root node to Queue
        q.add(A);
        while(!q.isEmpty()){
            //the size varible gives the information about the no. of node present at level respectively
            int size = q.size();
            ArrayList<Integer> list = new ArrayList();
            //This loop will iterate for the levels with multiple nodes
            //it will remove the same level nodes one by one
            //and will add their respective childrens nodes to queue
            for(int i=0;i<size;i++){
                TreeNode f = q.peek();
                q.remove();
                //this line will add the removed front node from queue
                list.add(f.val);
                if(f.left!=null){
                    q.add(f.left);
                }
                if(f.right!=null){
                    q.add(f.right);
                }
            }
            //Adding the list of nodes present at the previous level
            ans.add(list);
        }
        return ans;
        }


    public int treeSame(TreeNode A, TreeNode B){
                return sameTree(A, B);
            }

    public int sameTree(TreeNode A, TreeNode B) {
                if (A == null && B == null)
                    return 1;
                if (A == null || B == null)
                    return 0;
                if (A.val != B.val)
                    return 0;

                int num = 1;
                num = num & sameTree(A.left, B.left) & sameTree(A.right, B.right);
                return num;
            }




    public static void main(String[] k){
        TreeNode A= TreeNode.makeTree();
        BasicTreeImpl bti=new BasicTreeImpl();
        System.out.println(bti.nodeCount(A));
        System.out.println("Height is :"+bti.height(A));
        System.out.println("Sum of Tree  is :"+bti.sumNode(A));
        System.out.println("Inorder of Tree  is :"+bti.inorderTraversal(A));
        System.out.println("PreOrder of Tree  is :"+bti.preorderTraversal(A));
        System.out.println("PostOrder of Tree  is :"+bti.postorderTraversal(A));
        System.out.println(" Invert of Tree  is :"+bti.invertTree(A));
        System.out.println(" Max Node of Tree  is :"+bti.maxNodeTree(A));
        System.out.println("Both Tree is Same:"+bti.treeSame(A,TreeNode.makeTree2()));
    }
}
