package reverse206;

class Solution2 {
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
        //1 确定需要几个指针来完成整个链路的反转
        // 显然是返回头节点
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 获取下一个节点信息
            ListNode next = cur.next;
            // 修改指针
            cur.next = prev;
            // 继续下个节点
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
