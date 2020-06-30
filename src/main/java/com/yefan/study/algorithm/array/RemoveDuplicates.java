package com.yefan.study.algorithm.array;

/**
 * remove duplicate
 * 前提是数据已经排好序了
 * 技巧：快慢指针 + 移动数据（将不同的数数据放到数组左侧）
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                //将不同的数据移动到数组左侧
                nums[p + 1] = nums[q];
                //慢指针后移一位，让下次遍历找到不同的数据得意继续 放到左边
                p++;
            }
            //快指针后移一位
            q++;
        }

        return p + 1;
    }
}
