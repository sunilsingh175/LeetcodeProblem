
class ValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }


    public static void main(String[] args) {
        ValidBinaryTree sol = new ValidBinaryTree();

    
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Is Valid BST: " + sol.isValidBST(root1)); 
      
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Is Valid BST: " + sol.isValidBST(root2)); 
    }
}
