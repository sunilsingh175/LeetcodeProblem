import java.util.*;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();

            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}

public class InvertedTree {

        public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        System.out.print("[");
        boolean first = true;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!first) System.out.print(","); 
            System.out.print(node.val);
            first = false;

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution sol = new Solution();
        TreeNode inverted = sol.invertTree(root);

        System.out.print("Output: ");
        printLevelOrder(inverted); 
        System.out.println();
    }
}
