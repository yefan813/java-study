package com.yefan.study.algorithm.list;

/**
 * @author yefan
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //set sentinal node
        ListNode dumy = new ListNode(-1);
        dumy.next = head;

        //find length of node
        int length = 0;
        ListNode first = head;
        while(first != null){
            length++;
            first = first.next;
        }

        //查找要删除元素的前一个元素
        //查找删除前一个元素需要遍历的长度
        length = length - n;
        first = dumy;
        while(length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dumy.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
