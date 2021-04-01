package deleteDuplicates82;

class SolutionR {
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

    public ListNode deleteDuplicates(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 子问题需要考虑头结点head是否是重复元素
        // head 不是重复元素
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            ListNode move = head.next;
            while (move != null && move.val == head.val) {
                move = move.next;
            }
            return deleteDuplicates(move);
        }
    }
}
