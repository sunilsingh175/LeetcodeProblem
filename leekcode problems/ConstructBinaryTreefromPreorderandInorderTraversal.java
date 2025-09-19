import java.util.*;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

  
    // Build tree from preorder & inorder
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) return null;

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    // Recursive helper
    private static TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
                                      int rootIndex, int left, int right) {
        if (left > right || rootIndex >= preOrder.length) return null;

        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);

        // Build left subtree
        if (mid > left) {
            root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        }

        // Build right subtree
        if (mid < right) {
            int rightRootIndex = rootIndex + (mid - left) + 1;
            root.right = splitTree(preOrder, inOrderIndexMap, rightRootIndex, mid + 1, right);
        }

        return root;
    }

    // Print tree in level-order with nulls (LeetCode format)
    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            }
        }

        // Trim trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            i--;
        }
        System.out.println(result.subList(0, i + 1));
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder  = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preOrder, inOrder);

        System.out.println(" ");
        printLevelOrder(root);  // Expected: [3, 9, 20, null, null, 15, 7]
    }
}
