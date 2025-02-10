package main._202501._23;

import static java.lang.System.out;

import java.util.function.Supplier;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        ListNode test1 = makeNodeFromArr(new int[] {1, 3, 4, 7, 1, 2, 6});
        ListNode test12 = makeNodeFromArr(new int[] {1, 3, 4, 7, 1, 2, 6});
        ListNode test11 = makeNodeFromArr(new int[] {1, 3, 4, 7, 1, 2, 6});
        ListNode test111 = makeNodeFromArr(new int[] {1, 3, 4, 7, 1, 2, 6});
        out.println("{1, 3, 4, 7, 1, 2, 6}-> expect:[1,3,4,1,2,6] , result:" +
            measureExecutionTime("Slow & Fast Pointer", () -> deleteMiddle(test1).toString()));
        out.println("{1, 3, 4, 7, 1, 2, 6}-> expect:[1,3,4,1,2,6] , result:" +
            measureExecutionTime("Slow & Fast Pointer", () -> deleteMiddle(test12).toString()));
        out.println("{1, 3, 4, 7, 1, 2, 6}-> expect:[1,3,4,1,2,6] , result:"
            + measureExecutionTime("origin", () -> deleteMiddle2(test11).toString()));
        out.println("{1, 3, 4, 7, 1, 2, 6}-> expect:[1,3,4,1,2,6] , result:"
            + measureExecutionTime("improve", () -> deleteMiddle2_개선(test111).toString()));

        out.println();
        ListNode test2 = makeNodeFromArr(new int[] {1, 2, 3, 4});
        ListNode test22 = makeNodeFromArr(new int[] {1, 2, 3, 4});
        ListNode test222 = makeNodeFromArr(new int[] {1, 2, 3, 4});

        out.println("{1, 2, 3, 4}-> expect:[1,2,4] , result:"
            + measureExecutionTime("Slow & Fast Pointer", () -> deleteMiddle(test2).toString()));
        out.println("{1, 2, 3, 4}-> expect:[1,2,4] , result:"
            + measureExecutionTime("origin", () -> deleteMiddle2(test22).toString()));
        out.println("{1, 2, 3, 4}-> expect:[1,2,4] , result:"
            + measureExecutionTime("improve", () -> deleteMiddle2_개선(test222).toString()));

        out.println();
        ListNode test3 = makeNodeFromArr(new int[] {2, 1});
        ListNode test33 = makeNodeFromArr(new int[] {2, 1});
        ListNode test333 = makeNodeFromArr(new int[] {2, 1});
        out.println("{2, 1}-> expect:[2] , result:"
            + measureExecutionTime("Slow & Fast Pointer", () -> deleteMiddle(test3).toString()));
        out.println("{2, 1}-> expect:[2] , result:"
            + measureExecutionTime("origin", () -> deleteMiddle2(test33).toString()));
        out.println("{2, 1}-> expect:[2] , result:"
            + measureExecutionTime("improve", () -> deleteMiddle2_개선(test333).toString()));
    }

    // 실행 시간 측정 함수 (공통 사용)
    private static <T> T measureExecutionTime(String methodName, Supplier<T> function) {
        long startTimeNs = System.nanoTime();
        T result = function.get();
        long stopTimeNs = System.nanoTime();
        double elapsedTimeMs = stopTimeNs - startTimeNs;
        System.out.println(methodName + " Execution Time: " + elapsedTimeMs + " ms");
        return result;
    }

    // 그냥 내가 커스텀하게 만듦, 추가만 함
    private static ListNode makeNodeFromArr(int[] arr) {
        // 입력이 null이거나 노드가 하나뿐인 경우를 처리하지 않았습니다.
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode prevNode = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode curNode = new ListNode(arr[i]);
            prevNode.next = curNode;

            // prevNode를 curNode로 세팅
            prevNode = curNode;
        }
        return head;
    }


    // 주어진 조건
    public static class ListNode {
        private int val;
        private ListNode next;

        // 나라면 여기에 size넣음

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
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


    public static ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode slow = prev;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return prev.next;
    }

    //제출할 함수
    public static ListNode deleteMiddle2(ListNode head) {
        // 입력이 null이거나 노드가 하나뿐인 경우를 처리하지 않았습니다.
        if (head == null || head.next == null) {
            return null;
        }

        // size 구하기
        int size = 1;
        ListNode curNode = head;
        // head가 계속 업데이트되지 않기 때문에 무한 루프가 발생
        while (curNode.next != null) {
            size++;
            curNode = curNode.next;

        }// while end

        // 중간 index 구하기
        int middleIndex = size / 2;

        // 2개 일때 종료
        if (size <= 2) {
            head.next = null;
            return head;
        }

        int moveIndex = 1;
        ListNode beforeNode = head;// index: 0
        ListNode curNode2 = beforeNode.next;// index: 1

        while (curNode2.next != null) {// 컴파일 오류
            // index일치하면 현재 node제거
            if (moveIndex == middleIndex) {
                // before node<-->next node 연결
                ListNode nextNode = curNode2.next;
                beforeNode.next = nextNode;

                // 현재 노드 제거
                curNode2 = null;

                return head;
            }// 제거후 return

            // 일치안하면 오른쪽으로 움직임
            ListNode temp = curNode2.next;
            beforeNode = curNode2;
            curNode2 = temp;
            moveIndex++;
        }// for end

        return head;
    }// end


    public static ListNode deleteMiddle2_개선(ListNode head) {
        // 입력이 null이거나 노드가 하나뿐인 경우를 처리하지 않았습니다.
        if (head == null || head.next == null) {
            return null;
        }

        // size 구하기
        int size = 1;
        ListNode curNode = head;
        // head가 계속 업데이트되지 않기 때문에 무한 루프가 발생
        while (curNode.next != null) {
            size++;
            curNode = curNode.next;

        }// while end

        // 중간 index 구하기
        int middleIndex = size / 2;

        // 2개 일때 종료
        if (size <= 2) {
            head.next = null;
            return head;
        }

        int moveIndex = 1;
        ListNode beforeNode = head;// index: 0
        ListNode curNode2 = beforeNode.next;// index: 1

        while (moveIndex < middleIndex) {
            beforeNode = curNode2;
            curNode2 = curNode2.next;
            moveIndex++;
        }

        beforeNode.next = curNode2.next; // 중간 노드 삭제
        return head;
    }// end
}
