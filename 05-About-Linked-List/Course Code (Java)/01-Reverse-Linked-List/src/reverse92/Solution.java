package reverse92;

/**
 * 非递归算法
 *
 * @author JClearLove
 * @date 2021/04/01 20:48
 */

public class Solution {
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
        int pos = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && pos < left) {
            pre = pre.next;
            cur = cur.next;
            pos++;
        }
        ListNode tailNode = cur;
        while (cur != null && pos <= right) {
            ListNode nxt = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            tailNode.next = nxt;
            cur = nxt;
            pos++;
        }
        return dummy.next;
    }
}




