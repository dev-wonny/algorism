package main._202502;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

// https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode treeNode1 = makeTreeNode(new Integer[] {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        System.out.println(treeNode1);
        TreeNode treeNode2 = makeTreeNode(new Integer[] {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        System.out.println(treeNode2);
        System.out.println("root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8] -> expect: true, result:" + leafSimilar(treeNode1, treeNode2));

        TreeNode treeNode3 = makeTreeNode(new Integer[] {1, 2, 3});
        System.out.println(treeNode3);
        TreeNode treeNode4 = makeTreeNode(new Integer[] {1, 3, 2});
        System.out.println(treeNode4);
        System.out.println("root1 = [1,2,3], root2 = [1,3,2] -> expect: false, result:" + leafSimilar(treeNode3, treeNode4));


        TreeNode treeNode5 = makeTreeNode(new Integer[] {1, 2, 200});
        System.out.println(treeNode5);
        TreeNode treeNode6 = makeTreeNode(new Integer[] {1, 2, 200});
        System.out.println(treeNode6);
        System.out.println("root1 = [1,2,200], root2 = [1,2,200] -> expect: true, result:" + leafSimilar(treeNode5, treeNode6));

    }

    public static class State {
        TreeNode node;
        int max;

        public State(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }

    public static void printDoubleLinkedList(List<List<Integer>> result) {
        for (List<Integer> rowList : result) {
            for (Integer col : rowList) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }

    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }

    public static TreeNode makeTreeNode(Integer[] arr) {
        //BFS 사용, queue 사용
        if (arr == null || arr.length == 0) {
            return null;
        }
        int i = 0;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[i]);

        treeQueue.offer(root);//offer(E): linkLast

        // BFS 시작
        while (!treeQueue.isEmpty() && i < arr.length) {
            //꺼내기
            TreeNode current = treeQueue.poll();// poll(): unlinkFirst, return null

            if (i + 1 < arr.length) {
                Integer valueL = arr[++i];
                if (valueL != null) {
                    current.left = new TreeNode(valueL);
                    treeQueue.offer(current.left);// 재귀 사용 안함, queue 사용
                } else {
                    current.left = null;
                }

            }

            if (i + 1 < arr.length) {
                Integer valueR = arr[++i];
                if (valueR != null) {
                    current.right = new TreeNode(valueR);
                    treeQueue.offer(current.right);// 재귀 사용 안함, queue 사용
                } else {
                    current.right = null;
                }

            }
        }// while end
        return root;
    }

    public static TreeNode makeTreeNode_sample(Integer[] arr) {
        //BFS 사용
        if (arr == null || arr.length == 0) {
            return null;
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>(Arrays.asList(arr));// null 값을 안 넣음
        System.out.println(valueQueue);

        return null;
    }

    public static TreeNode makeTreeNode3(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Queue<String> queue = new ArrayDeque();
        for (Integer i : arr) {
            queue.offer(String.valueOf(i));// element에 null 추가 안됨
        }

        Integer currentValue = Integer.valueOf(Objects.requireNonNull(queue.poll()));
        return recursiveMakeTreeNode(queue, currentValue);
    }

    public static TreeNode recursiveMakeTreeNode(Queue<String> queue, Integer currentValue) {
        if (currentValue == null) {
            return null;
        }
        TreeNode current = new TreeNode(Integer.valueOf(currentValue));

        String leftVal = queue.poll();// remove(): nullPointException 발생
        String rightVal = queue.poll();// poll(): unlinkFirst, null 반환

        if (leftVal != null) {
            if (leftVal.equals("null")) {
                current.left = null;
            } else {
                current.left = recursiveMakeTreeNode(queue, Integer.valueOf(leftVal));
            }
        }

        if (rightVal != null) {
            if (rightVal.equals("null")) {
                current.right = null;
            } else {
                current.right = recursiveMakeTreeNode(queue, Integer.valueOf(rightVal));
            }
        }
        return current;
    }

    public static TreeNode makeTreeNode2(Integer[] arr, int index) {
        TreeNode current = null;
        while (index < arr.length) {
            if (arr[index] == null) {
                return null;
            }
            current = new TreeNode(arr[index]);
            int nextIndex = index * 2;
            if (nextIndex + 1 <= arr.length) {
                current.left = makeTreeNode2(arr, nextIndex + 1);
            }

            if (nextIndex + 2 < arr.length) {
                current.right = makeTreeNode2(arr, nextIndex + 2);
            }
            return current;
        }
        return current;
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> resultArr = new ArrayList<>();
        List<Integer> resultArr2 = new ArrayList<>();
        dfs(root1, resultArr);
        dfs(root2, resultArr2);

        // 길이 체크
        if (resultArr.size() != resultArr2.size()) {
            return false;
        }

        for (int i = 0; i < resultArr.size(); i++) {
            if (!resultArr.get(i).equals(resultArr2.get(i))) {
                // == 주소값 일치 여부, equals 값 일치 여부
                return false;
            }
        }

        return true;
    }

    public static void dfs(TreeNode currentNode, List<Integer> resultArr) {
        if (currentNode == null) {
            return;
        }

        if (currentNode.left != null) {
            dfs(currentNode.left, resultArr);
        }

        if (currentNode.right != null) {
            dfs(currentNode.right, resultArr);
        }

        if (currentNode.left == null && currentNode.right == null) {
            resultArr.add(currentNode.val);
        }
    }
}
