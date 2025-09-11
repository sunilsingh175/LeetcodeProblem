

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            return left.val == right.val &&
                   isMirror(left.left, right.right) &&
                   isMirror(left.right, right.left);
        }
        return false;
    }


    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();

        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("Example 1: " + sol.isSymmetric(root1));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("Example 2: " + sol.isSymmetric(root2)); 

       
        TreeNode root3 = new TreeNode(1);
        System.out.println("Example 3: " + sol.isSymmetric(root3)); 
    }
}
