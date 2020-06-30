package com.yefan.study.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

    public int[] set_interception(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] out = new int[set1.size()];
        int idx = 0;
        for(Integer s : set1) {
            if(set2.contains(s)){
                out[idx] = s;
                idx++;
            }
        }
        return Arrays.copyOf(out,idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        //将两个数组放入 set
        HashSet<Integer> set1 = new HashSet<>();
        for(int num : nums1) set1.add(num);

        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums2) set2.add(num);

        //遍历数量小的 set 判断数量大的是否包含
        if(set1.size() < set2.size()){
            return set_interception(set1,set2);
        }else {
            return   set_interception(set2,set1);
        }
    }
}
