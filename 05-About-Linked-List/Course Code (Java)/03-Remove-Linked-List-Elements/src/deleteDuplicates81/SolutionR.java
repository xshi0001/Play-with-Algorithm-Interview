package deleteDuplicates81;

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
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            int tmp = head.val;
            ListNode move = head.next;
            while (move.next != null && move.next.val == tmp) {
                move = move.next;
            }
            return deleteDuplicates(move);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
