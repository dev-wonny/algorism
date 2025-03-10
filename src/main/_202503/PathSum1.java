package main._202503;

import static main._202502.LeafSimilarTrees.makeTreeNode;

import main._202502.LeafSimilarTrees;

//https://leetcode.com/problems/path-sum/description/
public class PathSum1 {
    public static void main(String[] args) {

        LeafSimilarTrees.TreeNode treeNode1 = makeTreeNode(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        LeafSimilarTrees.TreeNode treeNode2 = makeTreeNode(new Integer[] {1, 2, 3});
        LeafSimilarTrees.TreeNode treeNode3 = makeTreeNode(new Integer[] {});
        LeafSimilarTrees.TreeNode treeNode4 = makeTreeNode(new Integer[] {1, 2});

        PathSum1 pathSum1 = new PathSum1();
        System.out.println("Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22, Output: true, result:" + pathSum1.hasPathSum(treeNode1, 22));
//        System.out.println("Input: root = [1,2,3], targetSum = 5, Output: false, result:" + pathSum1.hasPathSum(treeNode2, 5));
//        System.out.println("Input: root = [], targetSum = 0, Output: false, result:" + pathSum1.hasPathSum(treeNode3, 0));
//        System.out.println("Input: root = [1,2], targetSum = 1, Output: false, result:" + pathSum1.hasPathSum(treeNode4, 1));

    }

    private boolean result = false;

    private boolean hasPathSum(LeafSimilarTrees.TreeNode root, int targetSum) {
        result = false;
        DFS(root, 0, targetSum);
        return result;
    }


    private void DFS(LeafSimilarTrees.TreeNode node, int sum, int target) {
        // 나 존재 안함
        if (node == null) {
            return;
        }

        //나 존재함
        sum += node.val;

        // 더 이상 진행 못함, 끝임
        if (node.left == null && node.right == null) {
            if (sum == target) {
                result = true;
            }
        }

        //왼쪽, 끝까지 존재함?
        if (node.left != null) {
            DFS(node.left, sum, target);
        }
        //오쪽, 끝까지 존재함?
        if (node.right != null) {
            DFS(node.right, sum, target);
        }
    }//DFS end
}
