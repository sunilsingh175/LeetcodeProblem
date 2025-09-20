import java.util.*;

public class SumRootToLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        current = current * 10 + node.val;


        if (node.left == null && node.right == null) {
            return current;
        }


        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = sumNumbers(root);
        System.out.println(result);  


        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);

        int result2 = sumNumbers(root2);
        System.out.println(result2);  
    }
}
