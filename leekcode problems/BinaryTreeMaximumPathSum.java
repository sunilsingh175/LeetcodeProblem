import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);
        int currentPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}

public class BinaryTreeMaximumPathSum {
    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].trim().equals("null") || nodes[0].trim().isEmpty())
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && !nodes[i].trim().equals("null") && !nodes[i].trim().isEmpty()) {
                current.left = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].trim().equals("null") && !nodes[i].trim().isEmpty()) {
                current.right = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String input1 = "[1,2,3]";
        String[] parts1 = input1.replaceAll("[\\[\\]]", "").split(",");
        TreeNode root1 = buildTree(parts1);

        Solution sol = new Solution();
        System.out.println("Max Path Sum (Example 1): " + sol.maxPathSum(root1));

        String input2 = "[-10,9,20,null,null,15,7]";
        String[] parts2 = input2.replaceAll("[\\[\\]]", "").split(",");
        TreeNode root2 = buildTree(parts2);

        System.out.println("Max Path Sum (Example 2): " + sol.maxPathSum(root2));
    }
}
