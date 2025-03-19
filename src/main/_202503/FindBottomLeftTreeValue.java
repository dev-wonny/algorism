package main._202503;

import static main._202502.LeafSimilarTrees.makeTreeNode;

import main._202502.LeafSimilarTrees;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        LeafSimilarTrees.TreeNode treeNode1 = makeTreeNode(new Integer[] {2, 1, 3});
        LeafSimilarTrees.TreeNode treeNode2 = makeTreeNode(new Integer[] {1, 2, 3, 4, null, 5, 6, null, null, 7});
        FindBottomLeftTreeValue o = new FindBottomLeftTreeValue();
        System.out.println("expect: 1, result: " + o.findBottomLeftValue(treeNode1));
        System.out.println("expect: 7, result: " + o.findBottomLeftValue(treeNode2));
    }

    private class ResultPoint implements Comparable<ResultPoint> {
        private int depthKey;
        private int value;

        public ResultPoint(int depthKey, int value) {
            this.depthKey = depthKey;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ResultPoint that)) {
                return false;
            }
            return depthKey == that.depthKey && value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(depthKey, value);
        }

        @Override
        public int compareTo(ResultPoint o) {
            return Integer.compare(this.depthKey, o.depthKey);
        }
    }

    private int findBottomLeftValue(LeafSimilarTrees.TreeNode root) {
        Queue<ResultPoint> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        DFS(root, 0, maxHeap);

        // 예외 방지: maxHeap이 비어있는 경우 기본값을 반환하도록 처리
        if (maxHeap.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty or DFS did not add any nodes.");
        }

        return maxHeap.poll().value;
    }


    private void DFS(LeafSimilarTrees.TreeNode node, int dept, Queue<ResultPoint> queue) {
        LeafSimilarTrees.TreeNode curNode = node;

        if (node.left != null) {
            queue.add(new ResultPoint(dept + 1, curNode.left.val));
            DFS(curNode.left, dept + 1, queue);
        }

        if (node.right != null) {
//            queue.add(new ResultPoint(dept + 1, curNode.right.val));
            DFS(curNode.right, dept + 1, queue);
        }

        // 제일 바닥에 옴

    }//DFS end
}
