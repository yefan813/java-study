package com.yefan.study.algorithm.array;

import org.junit.Test;

import java.util.List;

public class MaxDistance {

    @Test
    public void test1() {

    }

    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        for(int i = 0; i < arrays.size() - 1; i++){
            for(int j = i + 1; j < arrays.size(); j++){
                res = Math.max(
                        res,
                        Math.abs(arrays.get(i).get(0) - arrays.get(j).get(arrays.get(j).size() - 1))
                );
                res = Math.max(
                        res,
                        Math.abs(arrays.get(j).get(0) - arrays.get(i).get(arrays.get(i).size() - 1))
                );
            }
        }
        return res;
    }
}
