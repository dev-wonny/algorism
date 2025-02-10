package main._202502;

import java.util.ArrayList;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        System.out.println("head = [5,4,2,1], expect: 6, result: " + pairSum(makeListNodeExample(new int[] {5, 4, 2, 1})));
        System.out.println("head = [4,2,2,3], expect: 7, result: " + pairSum(makeListNodeExample(new int[] {4, 2, 2, 3})));
        System.out.println("head = [1,100000], expect: 100001, result: " + pairSum(makeListNodeExample(new int[] {1, 100000})));
    }

    public static ListNode makeListNodeExample(int[] arr) {
        if (arr.length == 0) {
            return null;
        } else if (arr.length == 1) {
            return new ListNode(arr[0]);
        } else {
            ListNode before = new ListNode(arr[0]);
            ListNode start = before;

            int i = 1;
            while (i < arr.length) {
                ListNode next = new ListNode(arr[i]);
                before.setNext(next);
                before = next;
                i += 1;
            }// while end

            return start;
        }// else end
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
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
