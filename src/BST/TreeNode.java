package BST;

public class TreeNode {
      int val;
    TreeNode left;
    TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
    }
     public static BST.TreeNode makeTree(){
         BST.TreeNode parent=new BST.TreeNode(10);
         BST.TreeNode root=parent;
         BST.TreeNode left=new BST.TreeNode(20);
         BST.TreeNode right=new BST.TreeNode(30);
         parent.left=left;
         parent.right=right;
         BST.TreeNode left1=new BST.TreeNode(40);
         BST.TreeNode right1=new BST.TreeNode(50);
         left.left=left1;
         left.right=right1;
         BST.TreeNode left2=new BST.TreeNode(60);
         BST.TreeNode right2=new BST.TreeNode(70);
         right.left=left2;
         right.right=right2;
         BST.TreeNode left3=new BST.TreeNode(80);
         left1.left=left3;
         BST.TreeNode left4=new BST.TreeNode(90);
         left3.left=left4;
         return root;

         /***
          *                                  10
          *                         20                        30
          *                    40         50              60          70
          *               80
          *         90
          *
          */
     }
     public static BST.TreeNode makeTree1(){
         BST.TreeNode parent=new BST.TreeNode(10);
         BST.TreeNode root=parent;
         BST.TreeNode left=new BST.TreeNode(20);
         BST.TreeNode right=new BST.TreeNode(30);
         parent.left=left;
         parent.right=right;
         BST.TreeNode left1=new BST.TreeNode(40);
         BST.TreeNode right1=new BST.TreeNode(50);
         left.left=left1;
         left.right=right1;
         BST.TreeNode left2=new BST.TreeNode(60);
         BST.TreeNode right2=new BST.TreeNode(70);
         right.left=left2;
         right.right=right2;
         BST.TreeNode left3=new BST.TreeNode(80);
         left1.left=left3;
         BST.TreeNode left4=new BST.TreeNode(90);
         left3.left=left4;
         return root;

         /***
          *                                  10
          *                         20                        30
          *                    40         50              60          70
          *               80
          *         90
          *
          */
     }

    public static BST.TreeNode makeTreeBST(){
        BST.TreeNode parent=new BST.TreeNode(50);
        BST.TreeNode root=parent;
        BST.TreeNode left=new BST.TreeNode(40);
        BST.TreeNode right=new BST.TreeNode(60);
        parent.left=left;
        parent.right=right;
        BST.TreeNode left1=new BST.TreeNode(43);
        BST.TreeNode right1=new BST.TreeNode(35);
        left.left=left1;
        left.right=right1;
        BST.TreeNode left2=new BST.TreeNode(55);
        BST.TreeNode right2=new BST.TreeNode(65);
        return root;
    }
 }


