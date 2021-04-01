package reverse206;

class Solution1 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 前序递归
        return reverseListR(head, null);
    }

    private ListNode reverseListR(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        ListNode next = head.next;
        //主要逻辑
        head.next = prev;
        head = reverseListR(next, head);
        return head;
    }





}
