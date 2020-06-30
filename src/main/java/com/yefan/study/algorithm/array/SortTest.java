package com.yefan.study.algorithm.array;

import org.junit.Test;

public class SortTest {


    @Test
    public void testBubbleSort() {
        int[] a = new int[]{4,2,5,6,7,3};
        bubbleSort(a,6);
    }

    /**
     *
     * 魔炮排序
     * @param a 数组容器
     * @param n 数组大小
     */
    public void bubbleSort(int[] a , int n) {
        //判断数组和n 的合法性
        if(a == null || n <= 1){
            return;
        }
        //开始遍历
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }

        for(int i = 0 ; i< n; i++){
            System.out.println(a[i]);
        }
    }


    @Test
    public void testInsertSort() {
        int[] a = new int[]{4,2,5,6,7,3};
        insertSort(a,6);
    }
    public void insertSort(int[] a , int n){
        //判断数组和n 的合法性
        if(a == null || n <= 1){
            return;
        }
        for(int i = 1;i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }
                else {
                    break;
                }
            }
            a[j+1] = value;
        }

        for(int i = 0 ; i< n; i++){
            System.out.println(a[i]);
        }
    }

    @Test
    public void testSelectSort() {
        int[] a = new int[]{4,2,5,6,7,3};
        selectSort(a,6);
    }

    public void selectSort(int[] a , int n) {
        //判断数组和n 的合法性
        if(a == null || n <= 1){
            return;
        }

        for(int i=0;i<n;i++){
            //初始化
            int tmp = a[i];
            int minIndex = i;
            for(int j = i +1;j < n; j++){
                //找出最小值和位置
                if(a[j] < tmp){
                    tmp = a[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex]= temp;
            }
        }

        for(int i = 0 ; i< n; i++){
            System.out.println(a[i]);
        }

    }
}
