import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    private int cameras;

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        if (dfs(root) == 0) cameras++;
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 2;
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;
        return 0;
    }
}

public class BinaryTreeCameras {
    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input1 = {"0","0","null","0","0"};
        TreeNode root1 = buildTree(input1);
        System.out.println("Minimum cameras needed (Example 1): " + sol.minCameraCover(root1));

        String[] input2 = {"0","0","null","0","null","0","null","null","0"};
        TreeNode root2 = buildTree(input2);
        System.out.println("Minimum cameras needed (Example 2): " + sol.minCameraCover(root2));
    }
}
