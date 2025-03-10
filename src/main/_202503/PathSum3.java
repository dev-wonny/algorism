package main._202503;

import static main._202502.LeafSimilarTrees.makeTreeNode;

import main._202502.LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-iii/description
public class PathSum3 {
    public static void main(String[] args) {
        LeafSimilarTrees.TreeNode treeNode1 = makeTreeNode(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println(treeNode1);
        PathSum3 pathSum3 = new PathSum3();
        System.out.println("Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8, Output: 3 -> " + pathSum3.pathSum(treeNode1, 8));
    }


    private int pathSum(LeafSimilarTrees.TreeNode root, int leftTarget) {
//        ArrayList<Integer> countList = new ArrayList<>();
//        DFS(root, targetSum, 0, countList);
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        startFrom(root, leftTarget, resultList, tempList);
        return resultList.size();
    }

    private void startFrom(LeafSimilarTrees.TreeNode curNode, int leftTarget, List<List<Integer>> resultList, List<Integer> tempList) {
        // 총 3개의 case가 존재한다
        // 나 존재함
        DFS2(curNode, leftTarget, resultList, new ArrayList<>(tempList));

        // 나 없음: 위에 싹다 지움, 자식부터 시작
        DFS2(curNode.left, leftTarget, resultList, new ArrayList<>());
        DFS2(curNode.right, leftTarget, resultList, new ArrayList<>());
    }


    private void DFS2(LeafSimilarTrees.TreeNode node, int leftTarget, List<List<Integer>> resultList, List<Integer> tempList) {
        // 나 존재 안하는 경우는 연산 안함
        if (node == null) {
            return;
        }
        //나 존재함
        tempList.add(node.val);
        leftTarget -= node.val;

        // 중간에 값이 일치하네? 담아라
        if (leftTarget == 0) {
            resultList.add(new ArrayList<>(tempList));
        }

        //왼쪽, 끝까지 가라, 존재함?
        if (node.left != null) {
            // 왼쪽 탐방하고 돌아왔어? 나 까지만 살리고 하위는 지워버려
            startFrom(node.left, leftTarget, resultList, new ArrayList<>(tempList));
        }

        //오쪽, 끝까지 가라, 존재함?
        if (node.right != null) {
            // 오른쪽 탐방하고 돌아왔어? 나 까지만 살리고 하위는 지워버려
            startFrom(node.right, leftTarget, resultList, new ArrayList<>(tempList));
        }
        // 내 자신 지우고, 위로 올라가
        tempList.remove(tempList.size() - 1);
    }//DFS end

    private void startChild(LeafSimilarTrees.TreeNode node, int target, int sum, ArrayList<Integer> countList) {
        if (node == null) {
            return;
        }

        // 자기자신이 존재한다는 전재로 아래로 쭈욱 내려간다
        DFS(node, target, sum, countList);
    }

    private void DFS(LeafSimilarTrees.TreeNode node, int target, int sum, ArrayList<Integer> countList) {
        if (node == null) {
            return;
        }
        // 내 자신이 안 존재, 존재로 구분하겠다

        // 1) 내 자신: 안 존재 -> 아래로 진행하지 않는다, but 시작점은 자식부터 시작해야함
        System.out.println("내 자신을 포함하지 않는 로직, 진행하지 않는다. 종료");
        startChild(node.left, target, sum, countList);
        startChild(node.right, target, sum, countList);

        // 2) 내 자신: 존재 -> 아래로 내려간다
        System.out.println("내 자신을 포함하는 로직, 아래로 진행");


        // (1) 나만 체크 -> count 증가
        if (sum != 0 && target == node.val) {
            countList.add(node.val);
        }

        // (2) 누적 값 체크 -> count 증가
        int nextSum = sum + node.val;
        if (nextSum - target == 0) {
            countList.add(node.val);
        }
        System.out.println("현재 count: " + countList.toString());

        // 2-2) 왼 존재하면, 왼쪽으로 내려간다
        DFS(node.left, target, nextSum, countList);

        // 2-3) 오 존재하면, 오른쪽으로 내려간다
        DFS(node.right, target, nextSum, countList);
    }

}
