import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConvertBstToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.right);
        sum += node.val;
        node.val = sum;
        traverse(node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
            new TreeNode(1,
                new TreeNode(0),
                new TreeNode(2, null, new TreeNode(3))
            ),
            new TreeNode(6,
                new TreeNode(5),
                new TreeNode(7, null, new TreeNode(8))
            )
        );

        ConvertBstToGreaterTree sol = new ConvertBstToGreaterTree();
        TreeNode newRoot = sol.convertBST(root);

        printLevelOrder(newRoot);
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        System.out.println(result);
    }
}
