import java.util.*;

public class RightSideView {

    // BFS Solution
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;

            for (int i = 0; i < size; i++) {
                node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // last node in this level
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1: root = [1,2,3,null,5,null,4]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        System.out.println(rightSideView(root1));
        // Output: [1, 3, 4]

        // Example 2: root = [1,2,3,4,null,null,null,5]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(5);

        System.out.println(rightSideView(root2));
        // Output: [1, 3, 4, 5]
    }
}
