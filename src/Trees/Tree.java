package Trees;

import com.sun.source.tree.Tree;

/**
 * Definition for binary tree */
   class TreeNode {
     int val;
    TreeNode left;
   TreeNode right;
   TreeNode(int x) {
    val = x;
     left=null;
      right=null;
     }

     public static TreeNode makeTree(){
       TreeNode parent=new TreeNode(10);
       TreeNode root=parent;
       TreeNode left=new TreeNode(20);
       TreeNode right=new TreeNode(30);
       parent.left=left;
       parent.right=right;
       TreeNode left1=new TreeNode(40);
       TreeNode right1=new TreeNode(50);
         left.left=left1;
         left.right=right1;
         TreeNode left2=new TreeNode(60);
         TreeNode right2=new TreeNode(70);
         right.left=left2;
         right.right=right2;
         TreeNode left3=new TreeNode(80);
         left1.left=left3;
         TreeNode left4=new TreeNode(90);
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
    public static TreeNode makeTree2(){
        TreeNode parent=new TreeNode(10);
        TreeNode root=parent;
        TreeNode left=new TreeNode(20);
        TreeNode right=new TreeNode(30);
        parent.left=left;
        parent.right=right;
        TreeNode left1=new TreeNode(40);
        TreeNode right1=new TreeNode(50);
        left.left=left1;
        left.right=right1;
        TreeNode left2=new TreeNode(60);
        TreeNode right2=new TreeNode(70);
        right.left=left2;
        right.right=right2;
        TreeNode left3=new TreeNode(80);
        left1.left=left3;
        TreeNode left4=new TreeNode(900);
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
 }

