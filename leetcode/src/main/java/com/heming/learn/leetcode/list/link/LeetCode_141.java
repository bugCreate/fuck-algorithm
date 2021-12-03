package com.heming.learn.leetcode.list.link;

import java.util.List;

public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        if (head==null|| head.next==null){
            return false;
        }
        if (head==head.next)
        {
            return true;
        }
        ListNode slow=head;
        ListNode fast =head;
        while (slow!=null &&fast!=null){
            if (slow==fast && slow!=head){
                return true;
            }
            slow=slow.next;
            if (fast.next==null){
                return false;
            }
            fast=fast.next.next;
        }
        return false;
    }
}
