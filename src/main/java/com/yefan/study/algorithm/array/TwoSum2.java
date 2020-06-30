package com.yefan.study.algorithm.array;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        //head point
        int head = 0;
        //tail point
        int tail = numbers.length - 1;
        while(head < tail) {
            //利用排序好的数组
            int sum = numbers[head] + numbers[tail];
            if(sum == target) {
                return new int[]{head + 1, tail + 1};
            }else if(sum > target) {
                tail--;
            }else {
                head++;
            }
        }
        return null;
    }
}
