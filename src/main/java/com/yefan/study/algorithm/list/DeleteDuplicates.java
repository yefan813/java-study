package com.yefan.study.algorithm.list;

/**
 * 删除节点中重复的节点
 * @author yefan
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode  curr = head;
        while(curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }

    public class ListNode {
        private int val;
        private ListNode next;
    }
}
