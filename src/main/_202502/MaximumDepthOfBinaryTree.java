package main._202502;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        System.out.println("root = [3,9,20,null,null,15,7] -> expect: 3, result:" + maxDepth(treeNode3));

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        System.out.println("root = [1,null,2] -> expect: 2, result:" + maxDepth(treeNode1));
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // dfs
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        return dfs(root, depth);
    }

    private static int dfs(TreeNode cur, int dept) {
        int left = 0, right = 0;
        if (cur.left != null) {
            left = dfs(cur.left, dept + 1);
        }

        if (cur.right != null) {
            right = dfs(cur.right, dept + 1);
        }

        int max = Math.max(left, right);
        return Math.max(dept, max);
    }


}
