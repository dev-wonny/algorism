package main._202502;


import static main.ListNode.makeListNodeExample;

import main.ListNode;

// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class ReverseLinkedList {
    public static void main(String[] args) {

        System.out.println("head = [1,2,3,4,5], expect: [5,4,3,2,1], result: " + reverseList(makeListNodeExample(new int[] {5, 4, 3, 2, 1})));
        System.out.println("head = [1,2], expect: [2,1], result: " + reverseList(makeListNodeExample(new int[] {2, 1})));
        System.out.println("head = [], expect: [], result: " + reverseList(null));

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode before = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // 다음 노드 저장
            curr.next = before; // 현재 노드의 방향 변경
            before = curr;// 현재를 과거로 설정
            curr = next;// 미래를 현재로 설정
        }// while end
        return before;
    }
}
