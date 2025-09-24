import java.util.*;
public class PathSumIII {

    static int pathFromNode(TreeNode node, long targetSum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == targetSum) count++;
        count += pathFromNode(node.left, targetSum - node.val);
        count += pathFromNode(node.right, targetSum - node.val);
        return count;
    }

    static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathFromNode(root, targetSum) 
             + pathSum(root.left, targetSum) 
             + pathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        System.out.println(pathSum(root, targetSum));
    }
}
