import java.util.*;
public class RecoverBinarySearchTree {
    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();

        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        solution.recoverTree(root);
        System.out.println(levelOrder(root)); 
    }

    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result.add(null);
                continue;
            }
            result.add(node.val);
            if (node.left != null || node.right != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
        return result;
    }
}
