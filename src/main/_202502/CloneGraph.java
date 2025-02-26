package main._202502;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        System.out.println(cloneGraph(cloneGraph.makeNode(new int[][] {})));
        System.out.println(cloneGraph(cloneGraph.makeNode(new int[][] {{}})));
    }

    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //adjList = [[2],[1,3],[2]]

    private Node makeNode(int[][] list) {
//        int size = list.length;
//        for (int k = 1; k <= size; k++) {
//            new Node(k);
//        }
        if (list.length == 0) {
            return null;
        }

        if (list.length == 1) {
            return new Node(1, null);
        }

        Map<Integer, Node> nodeMap = new HashMap();
        for (int i = 0; i < list.length; i++) {
            ArrayList<Node> neighborsList = new ArrayList<>();

            for (int j = 0; j < list[i].length; j++) {
                int key = list[i][j];
                Node node = new Node(key);
                neighborsList.add(node);
                nodeMap.put(key, node);
            }// j for end

            Node curNode = new Node(i + 1, neighborsList);
        }// i for end
        return nodeMap.get(1);
    }

    private static Node cloneGraph(Node node) {

        return null;
    }
}
