package Sort;

/**
 * 147. Insertion Sort List
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head, pre = newHead, post;
        while (cur != null) {
            if (pre.val > cur.val) {
                pre = newHead;
            }
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            post = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = post;
        }
        return newHead.next;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
