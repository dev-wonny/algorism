package main._202505.twopointer;

import main.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
public class RemoveDuplicatesfromSortedList2 {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList2 o = new RemoveDuplicatesfromSortedList2();
        System.out.println(o.deleteDuplicates(ListNode.makeListNodeExample(new int[] {1, 2, 3, 3, 4, 4, 5})));//[1,2,5]
//        System.out.println(o.deleteDuplicates(ListNode.makeListNodeExample(new int[] {1, 1, 1, 2, 3})));//[2,3]

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);// 더미는 고정값
        dummy.next = head;

        ListNode prev = dummy;// 과거 시점: 이동한다
        ListNode current = head;// 현재 시점: 이동한다

        while (current != null) {
            boolean isDuplicate = false;

            while (current.next != null && current.val == current.next.val) {
                isDuplicate = true;
                current = current.next; // 같은 값 스킵, current만 계속해서 update
            }

            if (isDuplicate) {
                // prev와 current.next 연결 (중복값 다 스킵)
                // 과거와 미래의 연결
                prev.next = current.next;
            } else {
                prev = prev.next; // 과거 시점: 오른쪽으로 이동
            }

            current = current.next;// 현재 시점: 오른쪽으로 이동
        }

        return dummy.next;// 처음 값은 제거 후 리턴
    }
}
