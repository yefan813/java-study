package com.yefan.study.algorithm.array;

import org.junit.Test;

/**
 * @author yefan
 */
public class ArrayTest {
    public static void main(String[] args) {
        int res = cal(5);
        System.out.println(res);
    }

    static int cal(int n) {
        int sum = 0;
        int i = 1;
        for(;i <= n; ++i) {
            sum += i;
        }
        return sum;
    }

    @Test
    public void test1() {
        char[] array =   {'4', '2', '3', '5', '9','6'};
        int index = find(array, 6, '6');
        System.out.println(index);
    }

    private int find(char[] a, int n, char key) {
        //数据为空 或者 n<=0直接返回
        if(a == null || n <= 0){
            return -1;
        }
        int i = 0;
        while(i < n) {
            if(a[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
