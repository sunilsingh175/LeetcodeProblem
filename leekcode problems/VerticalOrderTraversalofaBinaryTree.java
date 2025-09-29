import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    class NodeInfo {
        TreeNode node;
        int col, row;
        NodeInfo(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, TreeMap<Integer, List<Integer>>> columnMap = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            TreeNode node = current.node;
            int col = current.col, row = current.row;

            columnMap
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new ArrayList<>())
                .add(node.val);

            if (node.left != null) queue.offer(new NodeInfo(node.left, col - 1, row + 1));
            if (node.right != null) queue.offer(new NodeInfo(node.right, col + 1, row + 1));
        }

        for (TreeMap<Integer, List<Integer>> rowMap : columnMap.values()) {
            List<Integer> currentColumn = new ArrayList<>();
            for (List<Integer> nodesAtRow : rowMap.values()) {
                Collections.sort(nodesAtRow); // sort nodes at same row & col
                currentColumn.addAll(nodesAtRow);
            }
            result.add(currentColumn);
        }
        return result;
    }
}

public class VerticalOrderTraversalofaBinaryTree {
    // Utility: build tree from array (like LeetCode input format)
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
        // Hardcoded test case
        String input = "[3,9,20,null,null,15,7]";
        input = input.replaceAll("[\\[\\]]", "");
        String[] parts = input.split(",");

        TreeNode root = buildTree(parts);

        Solution sol = new Solution();
        List<List<Integer>> ans = sol.verticalTraversal(root);

        System.out.println(ans);
    }
}
