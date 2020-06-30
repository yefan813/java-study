package com.yefan.study.algorithm.array;

import org.junit.Test;

/**
 * 最大子数组
 * @author yefan
 */
public class MaxSubArray {
    @Test
    public void test1() {

    }


    private int maxSubArray(int[] nums){
        //初始化，因为最小子数组可以为1 个元素
        int sum = nums[0];
        int ans = 0;
        for(int i = 0 ; i < nums.length; i++) {
            //如果 sum 大于 0，哪个当前的数字相加会产生增益效果
            if(sum > 0){
                sum = sum + nums[i];
            }else {
                //如果 sum < 0 则不会产生增益效果，把之前的 sum 丢弃，设置为当前值
                sum = nums[i];
            }
            //找出最大值
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
