package com.heming.learn.leetcode.list.link;

public class Leetcode_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2== null){
            return list1;
        }
        ListNode head=null,tail=null;
        while (list1!=null || list2!=null){
            ListNode cur;
            if (list1.val<list2.val){
                cur=list1;
                list1=list1.next;
            }else {
                cur=list2;
                list2=list2.next;
            }
            if (tail==null){
                tail=cur;
            }else {
                tail.next=cur;
                tail=tail.next;
            }
            if (head==null){
                head=tail;
            }
        }
        if (list1!=null){
            tail.next=list1;
        }
        if (list2!=null){
            tail.next=list2;
        }
        return head;
    }
}
