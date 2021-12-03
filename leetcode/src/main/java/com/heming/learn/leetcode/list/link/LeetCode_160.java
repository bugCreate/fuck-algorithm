package com.heming.learn.leetcode.list.link;

public class LeetCode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode leftA=headA;
        ListNode leftB=headB;
        ListNode rightA=headB;
        ListNode rightB=headA;
        while (!(leftA==null && leftB==null&& rightA==null&&rightB==null)){
            ListNode left =leftA==null?leftB:leftA;
            ListNode right= rightA==null?rightB:rightA;
            if (left==right){
                return left;
            }
            if (leftA ==null){
                leftB=leftB.next;
            }else {
                leftA=leftA.next;
            }
            if (rightA==null)
            {
                rightB=rightB.next;
            }else {
                rightA=rightA.next;
            }
        }
        return null;
    }
}
