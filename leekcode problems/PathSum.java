

public class PathSum {
    
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If tree is empty
        if (root == null) return false;

        
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

  
    public static void main(String[] args) {
  
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PathSum ps = new PathSum();
        
        int targetSum1 = 22;

        System.out.println("Has path sum : "  + ps.hasPathSum(root, targetSum1));

       
    }
}
