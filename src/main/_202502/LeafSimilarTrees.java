package main._202502;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode treeNode1 = makeTreeNode(new Integer[] {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}, 0);
        System.out.println(treeNode1);
        TreeNode treeNode2 = makeTreeNode(new Integer[] {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}, 0);
        System.out.println(treeNode2);
        System.out.println("root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8] -> expect: true, result:" + leafSimilar(treeNode1, treeNode2));

        TreeNode treeNode3 = makeTreeNode(new Integer[] {1, 2, 3}, 0);
        System.out.println(treeNode3);
        TreeNode treeNode4 = makeTreeNode(new Integer[] {1, 3, 2}, 0);
        System.out.println(treeNode4);
        System.out.println("root1 = [1,2,3], root2 = [1,3,2] -> expect: false, result:" + leafSimilar(treeNode3, treeNode4));


        TreeNode treeNode5 = makeTreeNode(new Integer[] {1, 2, 200}, 0);
        System.out.println(treeNode5);
        TreeNode treeNode6 = makeTreeNode(new Integer[] {1, 2, 200}, 0);
        System.out.println(treeNode6);
        System.out.println("root1 = [1,2,200], root2 = [1,2,200] -> expect: true, result:" + leafSimilar(treeNode5, treeNode6));

    }

    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

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

        public void setVal(Integer val) {
            this.val = val;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static TreeNode makeTreeNode(Integer[] arr, int index) {
        TreeNode current = null;
        while (index < arr.length) {
            if (arr[index] == null) {
                return null;
            }
            current = new TreeNode(arr[index]);
            int nextIndex = index * 2;
            if (nextIndex + 1 <= arr.length) {
                current.left = makeTreeNode(arr, nextIndex + 1);
            }

            if (nextIndex + 2 < arr.length) {
                current.right = makeTreeNode(arr, nextIndex + 2);
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
