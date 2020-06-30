package com.yefan.study.algorithm.stack;

import org.junit.Test;

public class StackTest {

    @Test
    public void test1() {
        ArrayStack stack = new ArrayStack(5);
        stack.push("123");
        System.out.println(stack.pop());

        stack.push("456");
        stack.push("1111");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    class ArrayStack {
        /**
         * 用于栈容器
         */
        private String[] items;
        /**
         * 当前栈内的数量
         */
        private int count;
        /**
         * 栈容量大小
         */
        private int n;

        public  ArrayStack(int n) {
            this.items = new String[n];
            this.n = n;
            this.count = 0;
        }

        /**
         * 入栈
         * @param item
         * @return
         */
        public boolean push(String item) {
            //栈满了，直接返回
            if(count == n){
                return false;
            }
            count ++;
            items[count - 1] = item;
            return true;
        }


        //出栈
        public String pop() {
            if(count == 0){
                return null;
            }
            String tmp = items[count - 1];
            count--;
            return  tmp;
        }
    }
}
