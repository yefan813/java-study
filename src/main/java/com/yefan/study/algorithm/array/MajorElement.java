package com.yefan.study.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class MajorElement {
    //计算数组中数字的数量
    public Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            if(countMap.get(num) != null){
                countMap.put(num, countMap.get(num) + 1);
            }else {
                countMap.put(num, 1);
            }
        }
        return countMap;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = countNums(nums);
        //设置数量最大的初始值
        Map.Entry<Integer, Integer> majorEntry = null;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(majorEntry == null || entry.getValue() > majorEntry.getValue()){
                majorEntry = entry;
            }
        }
        return majorEntry.getKey();
    }
}
