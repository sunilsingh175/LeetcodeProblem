class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeColoringGame {
    private int leftCount = 0, rightCount = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNodes(root, x);
        int parentCount = n - (leftCount + rightCount + 1);
        int maxRegion = Math.max(parentCount, Math.max(leftCount, rightCount));
        return maxRegion > n / 2;
    }

    private int countNodes(TreeNode node, int x) {
        if (node == null) return 0;
        int left = countNodes(node.left, x);
        int right = countNodes(node.right, x);

        if (node.val == x) {
            leftCount = left;
            rightCount = right;
        }

        return left + right + 1;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        BinaryTreeColoringGame sol = new BinaryTreeColoringGame();
        System.out.println(sol.btreeGameWinningMove(root, 11, 3)); 

        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(sol.btreeGameWinningMove(root2, 3, 1)); 
    }
}
