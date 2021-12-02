package com.heming.learn.leetcode.list.link;

import java.util.List;

public class LeetCode_023 {
    public static void main(String[] args) {
        System.out.println(3>>1);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListByBin(lists,0,lists.length-1);
    }
    private ListNode mergeKListByBin(ListNode[] lists,int start,int end){
        if (start>end){
            return null;
        }
        if (start==end){
            return lists[start];
        }
        if (end-start==1){
            return mergeTowList(lists[start],lists[end]);
        }
        int mid=(start+end+1)>>1;
        ListNode pre= mergeKListByBin(lists,start,mid);
        ListNode after =mergeKListByBin(lists,mid+1,end);
        ListNode result = mergeTowList(pre,after);
        return result;
    }
    private ListNode mergeTowList(ListNode first,ListNode second){
        if (first==null){
            return second;
        }
        if (second== null){
            return first;
        }
        ListNode head=null,tail=null;
        while (first!=null && second!= null){
            ListNode tmp;
            if (first.val<second.val){
                tmp=first;
                first=first.next;
            }else {
                tmp=second;
                second=second.next;
            }
            if (tail==null){
                tail=tmp;
            }else {
                tail.next=tmp;
                tail=tail.next;
            }
            if (head== null){
                head=tail;
            }
        }
        if (first!=null){
            tail.next=first;
        }
        if (second!=null){
            tail.next=second;
        }
        return head;
    }
}
