package oddEvenList328;

//Given the head of a singly linked list, group all the nodes with odd indices t
//ogether followed by the nodes with even indices, and return the reordered list.
//
//
// The first node is considered odd, and the second node is even, and so on.
//
// Note that the relative order inside both the even and odd groups should remai
//n as it was in the input.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
//
//
// Example 2:
//
//
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
//
//
//
// Constraints:
//
//
// The number of nodes in the linked list is in the range [0, 104].
// -106 <= Node.val <= 106
//
//
//
//Follow up: Could you solve it in O(1) space complexity and O(nodes) time compl
//exity? Related Topics 链表
// 👍 404 👎 0
class Solution {

    private static class ListNode {
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

        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("arr can not be empty");
            }

            this.val = arr[0];
            ListNode curNode = this;
            for (int i = 1; i < arr.length; i++) {
                curNode.next = new ListNode(arr[i]);
                curNode = curNode.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(ints);
        ListNode listNode = new Solution().oddEvenList(head);
    }

    public ListNode oddEvenList(ListNode head) {
        // 1->2->3->4
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 定义变量
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //1
        ListNode prev = head;
        //2
        ListNode cur = head.next;
        //2 记录cur前一个元素
        ListNode nxt = head.next;

        // 奇数-前面插入，后面删除
        while (cur.next != null) {
            //3
            cur = cur.next;
            // 插入元素
            //1-3-2-3-4
            // 此时nxt-2
            prev.next = new ListNode(cur.val, prev.next);
            // 4!=null
            if (cur.next != null) {
                // 删除元素
                nxt.next = cur.next;
                // nxt-2
            }
            cur = cur.next;
            prev = prev.next;
        }
        return dummyHead.next;
    }
}
































