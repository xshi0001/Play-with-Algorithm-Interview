package reverse92;

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1 <= left <= right <= n
        // base case
        if (left == 1) {
            //转为为反转以head为头结点，前right区间结点
            return reverseN(head, right);
        }
        //子问题，反转以head.next为根节点，反转[left-1,right-1]
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * 第n+1个结点，用以连接原来的head结点
     */
    private ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        // head不可能为null
        if (n == 1) {
            successor = head.next;
            return head;
        }
        // 子问题：反转以head.next为根节点，[1.n-1]结点
        ListNode last = reverseN(head.next, n - 1);
        // 处理与结点head的连接问题
        head.next.next = head;
        head.next = successor;

        return last;
    }
}


























