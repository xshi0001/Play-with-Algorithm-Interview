package deleteDuplicates82;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/01 16:05
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

    // 注意 [1,1]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 返回头结点的问题，设置虚拟头结点，解决边界问题
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // 通过改变cur的指向，为dummyHead添加下一个结点、下下个、下下下个结点
        cur.next = head;

        // 因为cur dummy
        // 如果存在两个结点
        while (cur.next != null && cur.next.next != null) {
            // 如果这连个结点值相等
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                // 注意[1,1]
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                //继续迭代下一个
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }


}

