package com.yefan.study.algorithm.array;

/**
 * 从后向前遍历
 * 三个指针
 * 1，len1保存 nums1有数字的尾部
 * 2,len2保存 nums2有数字的尾部
 * 3,len 指向要插入数据的位置
 *
 * 最后有可能遍历完nums2中还有数据未插入到 nums1 中，使用System.arraycopy拷贝
 * @author yefan
 */
public class MergeTwoArray {
    /**
     *
     * @param nums1
     * @param m length of nums1
     * @param nums2
     * @param n length of nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //point to nums1
        int len1 = m - 1;
        //point to nums2
        int len2 = n - 1;
        //插入数据的位置
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0){
            //将大的数字插入到 nums1 右边
            //注意--操作只有当前数字比较大的指针指向的数组 len才做--操作
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }

        System.arraycopy(nums2,0,nums1,0,len2 + 1);
    }
}
