package com.yefan.study.algorithm.array;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void test1(){
        int[] items = new int[]{1,3,4,5,6};
        int[] test1 = towSumTest1(items, 7);
        for (int a : test1) {
            System.out.println(a);
        }
    }

    /**
     * O(n)
     * @param items
     * @param targets
     * @return
     */
    public int[] towSumTest1(int[] items, int targets) {
        for(int i = 0; i<items.length; i++){
            for(int j = i + 1; j < items.length; j++) {
                //判断
                if(items[j] == targets - items[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }


}
