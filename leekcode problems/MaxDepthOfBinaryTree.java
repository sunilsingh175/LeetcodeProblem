class MaxDepthOfBinaryTree{

       public static void main(String[] args){


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.left = new TreeNode(9);
      
     

       MaxDepthOfBinaryTree sol = new MaxDepthOfBinaryTree();
       int height = sol.maxDepth(root);
      
 System.out.println("Max Depth : " + height);

}


        public int maxDepth(TreeNode root) {

        if (root == null) return 0;   

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


}



    