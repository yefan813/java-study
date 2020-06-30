package com.yefan.study.algorithm.string;

import java.util.List;

/**
 * 最长子序列串
 * @author yefan
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for(String target : d){
            int l1 = longestWord.length();
            int l2 = target.length();
            //l1 长度 大于l2 长度或者 l1 l2 长度相等，按照字典序排列小于longestWord，丢弃
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)){
                continue;
            }

            //判断是否是子序列,是则将当前 target 保存到longestWord
            if(isSubString(s,target)){
                longestWord = target;
            }
        }

        return longestWord;
    }


    /**
     *  target 是否是 s 的子串
     * @param s
     * @param target
     * @return
     */
    private boolean isSubString(String s, String target) {
        int i = 0;
        int j = 0;
        //双指针
        while(i < s.length() && j < target.length()) {
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        //如果 j 和target.length 相等说明 全部遍历完 j ；是字串
        return j == target.length();
    }


}
