package partitionList86;

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
        int[] arr = new int[]{1, 4, 3, 2, 5};
        ListNode head = new ListNode(arr);
        Solution solution = new Solution();
        solution.partition(head, 3);
    }

    public ListNode partition(ListNode head, int x) {
        // 定义变量
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = head;
        // step1  找到x之前第一个大于x活这等于x的分界点，比如4，并记录
        while (cur != null && cur.val < x) {
            //cur= 4
            cur = cur.next;
            // prev =1
            prev = prev.next;
        }
        // 记录前一个指针-被删元素
        //4
        ListNode nxt = cur;
        while (cur != null && cur.next != null) {
            // STEP2:对从4开始，比3小的元素，要执行前面新建一个结点，
            // 2
            // 一定要在条件判断之后执行
            cur = cur.next;
            if (cur.val < x) {
                //向前面插入新结点
                // 1->2->4
                prev.next = new ListNode(cur.val, prev.next);
                // 2
                prev = prev.next;

                //STEP3 删除该结点
                nxt.next = cur.next;
                // delNode.next = null;

            } else {
                //3
                nxt = nxt.next;
            }
        }
        return dummyHead.next;
    }

}


