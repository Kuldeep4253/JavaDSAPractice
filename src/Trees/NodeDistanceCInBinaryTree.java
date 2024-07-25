package Trees;

import java.util.ArrayList;

/*
A =      1
         / \
        2   3
       / \ / \
      4  5 6  7
     /
    8

 B = 3
 C = 3

 Return an array of integers, consisting all the nodes that are C distance from node containing value B.
 o/p: [4, 5]
 */
public class NodeDistanceCInBinaryTree {

    TreeNode treeNode;
    ArrayList<Integer> result;

    int height=0;

    public TreeNode findSpecificNode(TreeNode treeNode,int nodeValue){
        if(treeNode==null){
            return null;
        }

        if(treeNode.val==nodeValue){
            return treeNode;
        }


        // Traverse left subtree
        TreeNode leftTemp=findSpecificNode(treeNode.left,nodeValue);

        if(leftTemp!=null) return leftTemp;
        //Traverse Right Subtree
        TreeNode righttemp=findSpecificNode(treeNode.right,nodeValue);
        return righttemp;
    }

    public ArrayList<Integer> findNodeFromSourceWithDistanceD(TreeNode treeNode, int dis){
        TreeNode temp=treeNode;
        Kdown(temp,dis);
        return result;
    }

    //finding node
    public void Kdown(TreeNode node, int C){
        if (node == null || C< 0)
            return;

        // If we reach a k distant node, print it
        if (C == 0)
        {
            result.add(node.val);
            return;
        }

        // Recur for left and right subtrees
        Kdown(node.left, C - 1);
        Kdown(node.right, C - 1);
    }
    // Prints all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.This function
    // Returns distance of root from target node, it returns -1
    // if target node is not present in tree rooted with root.
    int printkdistanceNode(TreeNode node, int target, int k)
    {
        // Base Case 1: If tree is empty, return -1
        if (node == null)
            return -1;

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (node.val == target)
        {
            Kdown(node, k);
            return 0;
        }

        // Recur for left subtree
        int dl = printkdistanceNode(node.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1)
        {

            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
            if (dl + 1 == k)
            {
                System.out.print(node.val);
                System.out.println("");
            }

            // Else go to right subtree and print all k-dl-2 distant nodes
            // Note that the right child is 2 edges away from left child
            else
                Kdown(node.right, k - dl - 2);

            // Add 1 to the distance and return value for parent calls
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left
        // subtree
        int dr = printkdistanceNode(node.right, target, k);
        if (dr != -1)
        {
            if (dr + 1 == k)
            {
                System.out.print(node.val);
                System.out.println("");
            }
            else
                Kdown(node.left, k - dr - 2);
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }



    public static void main(String...k) {
        TreeNode A= TreeNode.makeTree();
        NodeDistanceCInBinaryTree nb=new NodeDistanceCInBinaryTree();
        nb.result=new ArrayList<>();
        nb.height=0;
        int dist=1;
        System.out.println(nb.height);
        //traverse the same side where element found treat as root  node and find the node
        nb.printkdistanceNode(A,30,4);
        System.out.println(nb.result);
    }

}
