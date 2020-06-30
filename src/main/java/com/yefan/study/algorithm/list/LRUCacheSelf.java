package com.yefan.study.algorithm.list;

import java.util.Hashtable;

public class LRUCacheSelf {

    //create a LinkedNode class
    class DLinkedNode {
        /**
         * 节点 key
         */
        private int key;
        /**
         * 节点 val
         */
        private int val;
        /**
         * prev
         */
        private DLinkedNode prev;
        /**
         * next
         */
        private DLinkedNode next;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    /**
     * 容量
     */
    private int capacity;

    /**
     * current exist node size
     */
    private int size;
    /**
     * 收尾哨兵
     */
    private DLinkedNode head, tail;

    public LRUCacheSelf(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    /**
     * 双向链表添加到头节点
     * @param node
     */
    public void addNode(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除节点
     * @param node
     */
    public void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val){
        //判断当前 key 是否存在
        DLinkedNode node = cache.get(key);
        if(node == null){
            //不存在，则插入,1容量满了
            node = new DLinkedNode();
            node.val = val;
            node.key = key;

            cache.put(key,node);
            addNode(node);

            ++size;
            if(size > capacity){
                DLinkedNode dLinkedNode = popTail();
                cache.remove(dLinkedNode.key);
                --size;
            }
            //不存在，则插入,2容量未满
        }else{
            //存在则更新
            node.val = val;
            moveToHead(node);
        }

    }


}
