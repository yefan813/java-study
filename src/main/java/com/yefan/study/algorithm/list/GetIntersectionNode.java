package com.yefan.study.algorithm.list;

public class GetIntersectionNode {

    /**
     * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表
     * B；同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表
     * A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点
     *
     * 如果不存在交点，那么 a + b = b + a，以下实现代码中 l1 和 l2 会同时为 null，从而退出循环
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;


        while(l1 != l2) {
            l1 = (l1 == null ) ? headB : l1.next;
            l2 = (l2 == null ) ? headA : l2.next;
        }
        //返回l1和返回l2 是一样的
        return l1;
    }

    public class ListNode {
        private int val;
        private ListNode next;
    }

}
