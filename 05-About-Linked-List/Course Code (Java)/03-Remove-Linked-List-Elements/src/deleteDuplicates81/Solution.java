package deleteDuplicates81;

class Solution {
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
        // 定义指针变量
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // 通过改变cur的指向，为dummyHead添加下一个结点、下下个、下下下个结点
        cur.next = head;
        // 遍历终止条件
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                // 遍历相同元素终止条件
                while (cur.next.next != null && cur.next.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                // 移动下次遍历元素
                cur = cur.next;
            }
        }

        return dummyHead.next;

    }
}
