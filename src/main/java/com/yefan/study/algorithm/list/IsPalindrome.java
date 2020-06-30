package com.yefan.study.algorithm.list;

/**
 * 链表的值是否是回文
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if(null == head){
            return true;
        }
        boolean isPalin = true;
        ListNode middleNode = findMiddleOfList(head);
        ListNode tail = reverseList(middleNode.next);

        ListNode p1 = head;
        ListNode p2 = tail;
        while(p2 != null) {
            if(p1.val != p2.val){
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return isPalin;
    }

    /**
     * 链表反转
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 找到中间节点
     * @param head
     * @return
     */
    public ListNode findMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
