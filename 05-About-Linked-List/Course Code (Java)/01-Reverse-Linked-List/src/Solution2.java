// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
//
// 递归的方式反转链表
// 时间复杂度: O(n)
// 空间复杂度: O(n) - 注意，递归是占用空间的，占用空间的大小和递归深度成正比：）
public class Solution2 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode postReverseList(ListNode head) {

        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rhead = postReverseList(head.next);

        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;

        return rhead;
    }

    public ListNode reverseList2(ListNode head) {
        // 前序递归
        return preReverseList(head, null);
    }

    private ListNode preReverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        // 记录下一个节点信息
        ListNode next = head.next;
        //主要逻辑，指针修改
        head.next = prev;
        // 在进入后面节点的前面（由于前面的都已经处理好了，因此不会有环）
        head = preReverseList(next, head);
        return head;
    }
}
