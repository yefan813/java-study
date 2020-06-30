package com.yefan.study.algorithm.list;

/**
 * 反转链表
 * @author yefan
 */
public class ListTest {

    public static void main(String[] args) {


    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode tmpNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNode;
        }
        return prev;
    }


    class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
