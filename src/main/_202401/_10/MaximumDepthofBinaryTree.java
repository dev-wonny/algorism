package main._202401._10;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class MaximumDepthofBinaryTree {
    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode a2 = new TreeNode(15);
        TreeNode b2 = new TreeNode(17);

        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20, a2, b2);

        TreeNode root = new TreeNode(3, a, b);

        System.out.println("expect: , result:" + maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {


        return 0;
    }
}
