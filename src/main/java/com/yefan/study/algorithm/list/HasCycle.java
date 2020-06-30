package com.yefan.study.algorithm.list;

/**
 * 链表是否有环
 * @author yefan
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        //valid param
        if(head == null) {
            return false;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * node
     */
    class ListNode {
        private int val;
        private ListNode next;
    }
}
