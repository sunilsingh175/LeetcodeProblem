import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class MaxWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));

        while (!q.isEmpty()) {
            int size = q.size();
            long first = q.peek().index;
            long last = first; 

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                long idx = p.index - first; 

                last = p.index;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }

    static class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        MaxWidthBinaryTree solution = new MaxWidthBinaryTree();

        // Example: root = [1,3,2,5,3,null,9]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(solution.widthOfBinaryTree(root)); // Expected: 4
    }
}
