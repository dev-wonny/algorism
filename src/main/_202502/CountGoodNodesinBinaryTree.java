package main._202502;

import static main._202502.LeafSimilarTrees.makeTreeNode;

import java.util.ArrayList;
import java.util.List;

// 알고리즘: https://pastebin.com/sTznQES4
// tree 만들기: https://pastebin.com/2mhYPa6n
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class CountGoodNodesinBinaryTree {
    public static void main(String[] args) {
        LeafSimilarTrees.TreeNode treeNode1 = makeTreeNode(new Integer[] {3, 1, 4, 3, null, 1, 5});
        System.out.println(treeNode1);
        System.out.println("Input: root = [3,1,4,3,null,1,5] Output: 4 -> " + goodNodes(treeNode1));

        LeafSimilarTrees.TreeNode treeNode2 = makeTreeNode(new Integer[] {3, 3, null, 4, 2});
        System.out.println(treeNode2);
        System.out.println("Input: root = [3,3,null,4,2] Output: 3 -> " + goodNodes(treeNode2));

        LeafSimilarTrees.TreeNode treeNode3 = makeTreeNode(new Integer[] {1});
        System.out.println(treeNode3);
        System.out.println("Input: root = [1] Output: 1 -> " + goodNodes(treeNode3));


        LeafSimilarTrees.TreeNode treeNode4 =
            makeTreeNode(new Integer[] {-1, 5, -2, 4, 4, 2, -2, null, null, -4, null, -2, 3, null, -2, 0, null, -1, null, -3, null, -4, -3, 3, null, null, null, null, null, null, null, 3, -3});
        System.out.println(treeNode4);
        System.out.println(
            "Input: root = [-1,5,-2,4,4,2,-2,null,null,-4,null,-2,3,null,-2,0,null,-1,null,-3,null,-4,-3,3,null,null,null,null,null,null,null,3,-3] Output: 5 -> " + goodNodes(treeNode4));

        LeafSimilarTrees.TreeNode treeNode5 = makeTreeNode(new Integer[] {-5, -1, -4, null, null, -5, 0, -5, null, -1, 2, null, null, null, -3, null, null, null, -5, null, -4});
        System.out.println(treeNode5.toString());
        System.out.println(
            "Input: root = [-5,-1,-4,null,null,-5,0,-5,null,-1,2,null,null,null,-3,null,null,null,-5,null,-4] Output: 5 -> " + goodNodes(treeNode5));
    }


    public static int goodNodes(LeafSimilarTrees.TreeNode root) {
        ArrayList<Integer> resultArr = new ArrayList<>();
        ArrayList<Integer> resultCount = new ArrayList<>();
        DFS(root, resultArr, 0, resultCount);
        return resultCount.size();
    }

    public static void DFS(LeafSimilarTrees.TreeNode cur, List<Integer> path, int idx, List resultCount) {
        // break point: reach end point
        if (cur == null) {
            return;
        }

        // compare one's value with relative value for getting count
        int max = cur.val;
        for (int ele : path) {
            max = Math.max(max, ele);
        }

        if (max <= cur.val) {
//            System.out.println(path);
            resultCount.add(cur.val);
        }

        // max 값 체크 후 현재값을 path에 추가
        path.add(cur.val);
        idx++;

        // 개선
//        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        if (cur.left == null && cur.right == null) {
            return;
        }


        if (cur.left != null) {
//            DFS(cur.left, (ArrayList<Integer>) List.copyOf(path));// 복제해서 전달
            DFS(cur.left, path.subList(0, idx), idx, resultCount);// 복제해서 전달
        }
        // back tracking
//        resultArr.removeRange(0, idx);


        if (cur.right != null) {
//            DFS(cur.right, (ArrayList<Integer>) List.copyOf(path));// 복제해서 전달
            DFS(cur.right, path.subList(0, idx), idx, resultCount);//  복제해서 전달
        }
        // back tracking
//        resultArr.removeRange(0, idx);
    }
}
