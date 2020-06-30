package com.yefan.study.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yefan
 */
public class ReverseVowels {
    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        //param valid
        if (s == null) return null;

        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while(i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            //ci不是元音直接放入 res
            if(!vowels.contains(ci)){
                result[i++] = ci;
            }else if(!vowels.contains(cj)){
                //cj不是元音直接放入 res
                result[j--] = cj;
            }else {
                //两边都是元音在做交换
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
