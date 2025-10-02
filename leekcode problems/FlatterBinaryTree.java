import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = temp;
    }
}

public class FlatterBinaryTree {
    public static void printFlattened(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.right;
            if (curr != null) System.out.print(",null,");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        sol.flatten(root1);
        printFlattened(root1);

        TreeNode root2 = null;
        sol.flatten(root2);
        printFlattened(root2);

        TreeNode root3 = new TreeNode(0);
        sol.flatten(root3);
        printFlattened(root3);
    }
}
