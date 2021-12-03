package com.heming.learn.leetcode.list.link;
//k 2k k-m
public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
        if (null==head|| head.next==null){
            return null;
        }
        ListNode slow =head.next;
        ListNode fast=head.next.next;
        while (slow!=null &&fast!=null){
            if (slow==fast){
                break;
            }
            slow=slow.next;
           if (fast.next==null){
               break;
           }
           fast=fast.next.next;

        }
        if (slow==null || fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}

