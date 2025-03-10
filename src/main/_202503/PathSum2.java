package main._202503;

import static main._202502.LeafSimilarTrees.makeTreeNode;
import static main._202502.LeafSimilarTrees.printDoubleLinkedList;

import main._202502.LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
public class PathSum2 {
    public static void main(String[] args) {
        LeafSimilarTrees.TreeNode treeNode1 = makeTreeNode(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        LeafSimilarTrees.TreeNode treeNode2 = makeTreeNode(new Integer[] {1, 2, 3});
        LeafSimilarTrees.TreeNode treeNode3 = makeTreeNode(new Integer[] {});
        LeafSimilarTrees.TreeNode treeNode4 = makeTreeNode(new Integer[] {1, 2});

        PathSum2 ps = new PathSum2();
        System.out.println("Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22, Output: [[5,4,11,2],[5,8,4,5]], result:");
        printDoubleLinkedList(ps.pathSum(treeNode1, 22));

        System.out.println("Input: root = [1,2,3], targetSum = 5, Output: [], result:");
        printDoubleLinkedList(ps.pathSum(treeNode2, 5));

        System.out.println("Input: root = [], targetSum = 0, Output: [], result:");
        printDoubleLinkedList(ps.pathSum(treeNode3, 0));

        System.out.println("Input: root = [1,2], targetSum = 1, Output: [], result:");
        printDoubleLinkedList(ps.pathSum(treeNode4, 1));

    }
    private List<List<Integer>> pathSum(LeafSimilarTrees.TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        DFS(root, 0, targetSum, resultList, tempList, 0);
        return resultList;
    }

    private void DFS(LeafSimilarTrees.TreeNode node, int sum, int target, List<List<Integer>> resultList, List<Integer> tempList, int dept) {
        // 나 존재 안함
        if (node == null) {
            return;
        }

        //나 존재함
        sum += node.val;
        tempList.add(node.val);

        // 더 이상 진행 못함, 끝임
        if (node.left == null && node.right == null) {
            if (sum == target) {
                // 담아라
                resultList.add(new ArrayList<>(tempList));
            }
        }

        //왼쪽, 끝까지 존재함?
        DFS(node.left, sum, target, resultList, new ArrayList<>(tempList), dept + 1);
        // 왼쪽 탐방하고 돌아왔어? 나 까지만 살리고 하위는 지워버려

        //오쪽, 끝까지 존재함?
        DFS(node.right, sum, target, resultList, new ArrayList<>(tempList), dept + 1);
        // 돌아왔어? 나랑, 하위 다 지워

        tempList.remove(dept);
    }//DFS end
}
