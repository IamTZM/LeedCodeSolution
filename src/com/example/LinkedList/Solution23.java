package com.example.LinkedList;

/**
 * 23. Merge k Sorted Lists
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeListsWithRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeListsWithRange(ListNode[] lists, int start, int end) {
        if (end == start) {
            return lists[start];
        } else if (end - start == 1) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        int mid = ((end - start) >> 1) + start;
        ListNode l1 = mergeListsWithRange(lists, start, mid);
        ListNode l2 = mergeListsWithRange(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, p = list;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        while (p1 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != null) {
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        return list.next;
    }
}
