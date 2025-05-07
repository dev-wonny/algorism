package main._202502;


import static main.ListNode.makeListNodeExample;

import main.ListNode;

import java.util.ArrayList;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        System.out.println("head = [5,4,2,1], expect: 6, result: " + pairSum(makeListNodeExample(new int[] {5, 4, 2, 1})));
        System.out.println("head = [4,2,2,3], expect: 7, result: " + pairSum(makeListNodeExample(new int[] {4, 2, 2, 3})));
        System.out.println("head = [1,100000], expect: 100001, result: " + pairSum(makeListNodeExample(new int[] {1, 100000})));
    }

    public static int pairSum(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> list = new ArrayList();
        list.add(curr.val);
        while (curr.next != null) {
            list.add(curr.next.val);
            curr = curr.next;
        }

        int size = list.size();
        int mod = size / 2;
        int max = -1;

        for (int i = 0; i < mod; i++) {
            max = Math.max(max, list.get(i) + list.get(size - i - 1));
        }

        return max;
    }
}
