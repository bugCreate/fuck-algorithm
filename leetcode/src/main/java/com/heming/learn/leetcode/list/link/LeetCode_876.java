package com.heming.learn.leetcode.list.link;

public class LeetCode_876 {
    public ListNode middleNode(ListNode head) {
        if (head==null|| head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (slow!=null && fast!=null){
            if (fast.next==null){
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
